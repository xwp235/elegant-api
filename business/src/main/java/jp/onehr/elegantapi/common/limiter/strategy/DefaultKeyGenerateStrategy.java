package jp.onehr.elegantapi.common.limiter.strategy;

import jp.onehr.elegantapi.common.SymbolConstants;
import jp.onehr.elegantapi.common.limiter.metadata.MethodMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 默认key策略
 */
@Component
public class DefaultKeyGenerateStrategy implements IKeyGenerateStrategy {

    private final static String TYPE = "key-generate-default";

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getKey(MethodMetadata methodMetadata, String parseKey) {
        String result = methodMetadata.getClassMethodName();
        if (StringUtils.hasLength(parseKey)) {
            result += SymbolConstants.COLON + parseKey;
        }
        return result;
    }

}
