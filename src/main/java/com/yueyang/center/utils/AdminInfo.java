package com.yueyang.center.utils;

import lombok.Data;

/**
 * @author yangyongping
 */
@Data
public class AdminInfo {
    /**
     * 租户id
     */
    private Long websiteId;

    /**
     * 用户id
     */
    private Long adminId;

    /**
     * 登录用户的主租户id
     */
    private Long mainTenantId;

    /**
     * 当前租户id
     */
    private Long currentTenantId;

    /**
     * 是否是超管
     */
    private boolean isSuperAdmin;
}
