/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.engine;

import jp.onehr.elegantapi.bpm.engine.assist.Assert;
import jp.onehr.elegantapi.bpm.engine.core.FlowLongContext;
import jp.onehr.elegantapi.bpm.engine.model.ProcessModel;

/**
 * JSON BPM 模型缓存处理接口
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface ProcessModelCache {

    /**
     * 流程模型缓存KEY
     *
     * @return 缓存 KEY
     */
    String modelCacheKey();

    /**
     * 流程模型内容
     *
     * @return 缓存内容
     */
    String getModelContent();

    /**
     * JSON BPM 模型
     *
     * @return JSON BPM 模型
     */
    default ProcessModel model() {
        String modelContent = this.getModelContent();
        Assert.isEmpty(modelContent, "The process modelContent is Empty.");
        return FlowLongContext.parseProcessModel(modelContent, this.modelCacheKey(), false);
    }
}
