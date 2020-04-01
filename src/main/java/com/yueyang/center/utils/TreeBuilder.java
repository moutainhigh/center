package com.yueyang.center.utils;

import com.google.common.collect.Lists;

import com.yueyang.center.annotation.TreeProperty;
import com.yueyang.center.domain.model.Tree;
import com.yueyang.center.enums.TreePropertyEnum;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TreeBuilder {

    /**
     * 从列表转换为树形结构
     *
     * @param source 源数据列表
     * @param <T>    数据类型，必须继承自TreeBaseEntity
     * @return
     */
    public static <T> Tree<T> buildTree(List<T> source) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }
        Class<T> clazz = (Class<T>) source.get(0).getClass();
        PropertyDescriptor idDescriptor = BeanUtils.getPropertyDescriptor(clazz, "id");
        PropertyDescriptor parentIdDescriptor = BeanUtils.getPropertyDescriptor(clazz, "parentId");

        if (ObjectUtils.isEmpty(idDescriptor) || ObjectUtils.isEmpty(parentIdDescriptor)) {
            throw new RuntimeException("参数非树形结构数据");
        }
        Tree<T> result = new Tree<>();
        // 找出列表中的根节点，判断依据：元素的parentId不等于列表中所有其他元素的id
        List<Long> sourceIds = source.stream()
                .map(x -> {
                    try {
                        return (Long) idDescriptor.getReadMethod().invoke(x);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
        List<T> roots = source.stream()
                .filter(x -> {
                    try {
                        return !sourceIds.contains(parentIdDescriptor.getReadMethod().invoke(x));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());

        result.setNodes(buildTreeNodes(roots, source));

        return result;
    }

    /**
     * 生成树的节点
     *
     * @param roots  将转化为树的根节点
     * @param source 源数据列表
     * @param <T>    数据类型，必须继承自TreeBaseEntity
     * @return
     */
    private static <T> List<Tree.Node<T>> buildTreeNodes(List<T> roots, List<T> source) {
        List<Tree.Node<T>> nodes = Lists.newArrayList();

        if (CollectionUtils.isEmpty(roots)) {
            return nodes;
        }

        Class<T> clazzSource = (Class<T>) source.get(0).getClass();
        Class<T> clazzRoot = (Class<T>) roots.get(0).getClass();
        PropertyDescriptor idDescriptor = BeanUtils.getPropertyDescriptor(clazzRoot, "id");
        PropertyDescriptor parentIdDescriptor = BeanUtils.getPropertyDescriptor(clazzSource, "parentId");

        if (ObjectUtils.isEmpty(idDescriptor) || ObjectUtils.isEmpty(parentIdDescriptor)) {
            throw new RuntimeException("参数非属性结构数据");
        }
        for (T root : roots) {
            Tree.Node<T> node = new Tree.Node<>();
            node.setData(root);
            List<T> children = source.stream().filter(t -> {
                try {
                    return Objects.equals(parentIdDescriptor.getReadMethod().invoke(t), idDescriptor.getReadMethod().invoke(root));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                return false;
            }).collect(Collectors.toList());
            node.setChildren(buildTreeNodes(children, source));
            nodes.add(node);
        }

        return nodes;
    }

    /**
     * 从列表转换为树形列表结构
     *
     * @param source 源数据列表 T
     * @return
     */
    public static <T> List<T> build(List<T> source) {
        if (CollectionUtils.isEmpty(source)) {
            return null;
        }
        Class<T> clazz = (Class<T>) source.get(0).getClass();


        Method[] methods = ReflectionUtils.getAllDeclaredMethods(clazz);
        for (Method method : methods) {
            BeanUtils.findPropertyForMethod(method);
        }

        PropertyDescriptor idDescriptor = null;
        PropertyDescriptor parentIdDescriptor = null;
        PropertyDescriptor childrenDescriptor = null;
        PropertyDescriptor directChildrenCountDescriptor = null;
        Class aClass = clazz;
        do {
            for (Field declaredField : aClass.getDeclaredFields()) {
                TreeProperty noahTreeParamParam = declaredField.getAnnotation(TreeProperty.class);
                if (!ObjectUtils.isEmpty(noahTreeParamParam)) {
                    TreePropertyEnum type = noahTreeParamParam.value();
                    switch (type) {
                        case ID:
                            idDescriptor = BeanUtils.getPropertyDescriptor(clazz, declaredField.getName());
                            break;
                        case PARENTID:
                            parentIdDescriptor = BeanUtils.getPropertyDescriptor(clazz, declaredField.getName());
                            break;
                        case CHILDREN:
                            childrenDescriptor = BeanUtils.getPropertyDescriptor(clazz, declaredField.getName());
                            break;
                        default:
                            break;
                    }
                }
            }
        }while (!(aClass=aClass.getSuperclass()).equals(Object.class));


        if (idDescriptor == null) {
            idDescriptor = BeanUtils.getPropertyDescriptor(clazz, "id");
        }
        if (parentIdDescriptor == null) {
            parentIdDescriptor = BeanUtils.getPropertyDescriptor(clazz, "parentId");
        }
        if (childrenDescriptor == null) {
            childrenDescriptor = BeanUtils.getPropertyDescriptor(clazz, "children");
        }
        if (directChildrenCountDescriptor == null) {
            directChildrenCountDescriptor = BeanUtils.getPropertyDescriptor(clazz, "directChildrenCount");
        }


        if (ObjectUtils.isEmpty(idDescriptor) || ObjectUtils.isEmpty(parentIdDescriptor)) {
            throw new RuntimeException("参数非树形结构数据");
        }

        // 找出列表中的根节点，判断依据：元素的parentId不等于列表中所有其他元素的id
        PropertyDescriptor finalIdDescriptor = idDescriptor;
        List<Long> sourceIds = source.stream()
                .map(x -> {
                    try {
                        return (Long) finalIdDescriptor.getReadMethod().invoke(x);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
        PropertyDescriptor finalParentIdDescriptor = parentIdDescriptor;
        List<T> roots = source.stream()
                .filter(x -> {
                    try {
                        return !sourceIds.contains(finalParentIdDescriptor.getReadMethod().invoke(x));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());

        List<T> results = buildNodes(roots, source, idDescriptor, parentIdDescriptor, childrenDescriptor, directChildrenCountDescriptor);
        return results;
    }

    /**
     * 生成树的节点
     *
     * @param roots  将转化为树的根节点
     * @param source 源数据列表
     * @param <T>    数据类型，必须继承自TreeBaseEntity
     * @return
     */
    private static <T> List<T> buildNodes(List<T> roots, List<T> source,
                                          PropertyDescriptor idDescriptor,
                                          PropertyDescriptor parentIdDescriptor,
                                          PropertyDescriptor childrenDescriptor,
                                          PropertyDescriptor directChildrenCountDescriptor
    ) {
        if (CollectionUtils.isEmpty(roots)) {
            return Lists.newArrayList();
        }

        if (ObjectUtils.isEmpty(idDescriptor) || ObjectUtils.isEmpty(parentIdDescriptor)) {
            throw new RuntimeException("参数非树形结构数据");
        }
        for (T root : roots) {
            try {
                Long rootId = (Long) idDescriptor.getReadMethod().invoke(root);
                List<T> children = source.stream()
                        .filter(t -> {
                            try {
                                return Objects.equals(parentIdDescriptor.getReadMethod().invoke(t), rootId);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                            return false;
                        })
                        .collect(Collectors.toList());
                try {
                    childrenDescriptor.getWriteMethod().invoke(root, buildNodes(children, source, idDescriptor, parentIdDescriptor, childrenDescriptor, directChildrenCountDescriptor));
                    if (!ObjectUtils.isEmpty(directChildrenCountDescriptor)) {
                        directChildrenCountDescriptor.getWriteMethod().invoke(root, children.size());
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


        }
        return roots;
    }


}