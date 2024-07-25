package jp.onehr.elegantapi.common.limiter.strategy;

import jakarta.servlet.http.HttpServletRequest;
import jp.onehr.elegantapi.common.utils.RequestUtil;
import jp.onehr.elegantapi.common.limiter.metadata.MethodMetadata;

/**
 * key生成策略接口
 */
public interface IKeyGenerateStrategy {

    /**
     * 策略类型
     *
     * @return 限流策略类型
     */
    String getType();

    /**
     * 唯一标示 key
     *
     * @param methodMetadata {@link MethodMetadata}
     * @param parseKey       解析spEL得到的Key
     * @return 包装的key
     */
    String getKey(MethodMetadata methodMetadata, String parseKey);

    /**
     * 当前请求
     *
     * @return 当前请求
     */
    default HttpServletRequest getRequest() {
        return RequestUtil.getServletRequest();
    }
}
