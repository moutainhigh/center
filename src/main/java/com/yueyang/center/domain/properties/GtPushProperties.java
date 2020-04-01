package com.yueyang.center.domain.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties("push.getui")
@Component
@Data
public class GtPushProperties {

    private static final String DEFAULT_BADGE = "+1";
    private static final Long OFFLINE_EXPIRE_TIME = 24 * 3600 * 1000L;

    /**
     * 个推host
     */
    private String host;

    /**
     * 个推appId
     */
    private String appId;

    /**
     * 个推AppKey
     */
    private String appKey;

    /**
     * 个推masterSecret
     */
    private String masterSecret;

    /**
     * 设置角标，还可以实现显示数字的自动增减，如"+1"、"-1"、"1"等。默认为 +1
     */
    private String badge = DEFAULT_BADGE;

    /**
     * 离线缓存时间。默认为 24小时
     */
    private Long offlineExpireTime = OFFLINE_EXPIRE_TIME;
}
