package jp.onehr.elegantapi.common.limiter.strategy;


import jp.onehr.elegantapi.common.limiter.metadata.MethodMetadata;
import jp.onehr.elegantapi.common.utils.RequestUtil;
import org.springframework.stereotype.Component;

/**
 * IP 速率限制策略
 */
@Component
public class IpKeyGenerateStrategy implements IKeyGenerateStrategy {

    public final static String TYPE = "key-generate-ip";

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getKey(MethodMetadata methodMetadata, String parseKey) {
        return RequestUtil.getClientIP(this.getRequest());
    }

}
