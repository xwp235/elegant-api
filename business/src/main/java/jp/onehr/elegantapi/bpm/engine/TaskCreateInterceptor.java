/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.engine;

import jp.onehr.elegantapi.bpm.engine.core.Execution;
import jp.onehr.elegantapi.bpm.engine.core.FlowLongContext;

/**
 * 流程任务创建拦截器
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface TaskCreateInterceptor {

    /**
     * 拦截前置处理方法
     *
     * @param flowLongContext 流程引擎上下文
     * @param execution       执行对象
     */
    default void before(FlowLongContext flowLongContext, Execution execution) {
        // 默认不处理
    }

    /**
     * 拦截后置处理方法
     *
     * @param flowLongContext 流程引擎上下文
     * @param execution       执行对象
     */
    void after(FlowLongContext flowLongContext, Execution execution);
}
