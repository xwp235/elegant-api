/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.spring.event;

import jp.onehr.elegantapi.bpm.engine.core.FlowCreator;
import jp.onehr.elegantapi.bpm.engine.core.enums.EventType;
import jp.onehr.elegantapi.bpm.engine.entity.FlwTask;
import jp.onehr.elegantapi.bpm.engine.model.NodeModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 流程任务事件对象
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
@Getter
@Setter
public class TaskEvent implements Serializable {
    private EventType eventType;
    private FlwTask flwTask;
    private NodeModel nodeModel;
    private FlowCreator flowCreator;

}
