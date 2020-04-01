package com.yueyang.center.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("aliyun.oss")
@Component
@Data
public class OssProperties {

    private String endpoint;

    private String accessKeyId;

    private String secretAccessKey;

    private String bucket;

    private String host;

    private String region;
    
    private String videoHost;
    
    private String bucketHost;
}
