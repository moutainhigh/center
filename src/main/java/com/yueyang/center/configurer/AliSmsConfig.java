package com.yueyang.center.configurer;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.yueyang.center.contant.Constant;
import com.yueyang.center.domain.properties.OssProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wxy
 * @date 2019/10/12 2:40 下午
 */
@Configuration
public class AliSmsConfig {

    @Autowired
    private OssProperties ossProperties;

    @Bean
    public IAcsClient acsClient() throws ClientException {

        /** AK **/
        String accessKeyId = ossProperties.getAccessKeyId();
        String accessKeySecret = ossProperties.getSecretAccessKey();
        String regionId = ossProperties.getRegion();

        // 初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint(regionId, regionId, Constant.PRODUCT, Constant.DOMAIN);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        return acsClient;
    }
}
