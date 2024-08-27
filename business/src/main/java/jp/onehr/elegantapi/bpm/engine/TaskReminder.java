/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.engine;


import jp.onehr.elegantapi.bpm.engine.core.FlowLongContext;
import jp.onehr.elegantapi.bpm.engine.entity.FlwTask;

import java.util.Date;

/**
 * 任务提醒接口
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface TaskReminder {

    /**
     * 提醒操作
     *
     * @param context     流程引擎上下文
     * @param instanceId  流程实例ID
     * @param currentTask 当前待处理任务
     * @return 返回下次提醒时间，如果返回 null 当前任务将不再提醒，非 null 会更新下次提醒日期
     */
    Date remind(FlowLongContext context, Long instanceId, FlwTask currentTask);
}
