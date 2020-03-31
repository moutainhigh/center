package com.yueyang.center.utils;

/**
 * 用户上下文对象(登陆后通过拦截器写入)
 */
public class AdminContext {

    private static final ThreadLocal<AdminInfo> adminInfo = new ThreadLocal<>();

    public static AdminInfo getAdminInfo() {
//        return adminInfo.get();
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAdminId(1L);
        adminInfo.setMainTenantId(1L);
        adminInfo.setCurrentTenantId(1L);
        adminInfo.setWebsiteId(1L);
        adminInfo.setSuperAdmin(true);
        return adminInfo;
    }

    public static void remove() {
        adminInfo.remove();
    }

    public static void put(AdminInfo info) {
        AdminContext.put(info);
    }

    /**
     * 判断当前用户是否是超级管理员
     *
     * @return
     */
    public static boolean isSuperAdmin() {
       // return adminInfo.get().isSuperAdmin();
        return true;
    }
}
