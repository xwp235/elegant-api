/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.spring.event;

import jp.onehr.elegantapi.bpm.engine.core.FlowCreator;
import jp.onehr.elegantapi.bpm.engine.core.enums.EventType;
import jp.onehr.elegantapi.bpm.engine.entity.FlwInstance;
import jp.onehr.elegantapi.bpm.engine.model.NodeModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 流程实例事件对象
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
public class InstanceEvent implements Serializable {
    private EventType eventType;
    /**
     * EventType.complete 完成时，实例对象实际为子类 FlwHisInstance 对象
     * <p>
     * FlwHisInstance hisInstance = (FlwHisInstance) flwInstance;
     * </p>
     */
    private FlwInstance flwInstance;
    private NodeModel nodeModel;
    private FlowCreator flowCreator;

}
