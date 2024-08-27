/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.spring.event;

import jp.onehr.elegantapi.bpm.engine.core.FlowCreator;
import jp.onehr.elegantapi.bpm.engine.core.enums.EventType;
import jp.onehr.elegantapi.bpm.engine.entity.FlwHisInstance;
import jp.onehr.elegantapi.bpm.engine.listener.InstanceListener;
import jp.onehr.elegantapi.bpm.engine.model.NodeModel;
import org.springframework.context.ApplicationEventPublisher;

import java.util.function.Supplier;

/**
 * Spring boot Event 异步实例监听处理器
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public class EventInstanceListener implements InstanceListener {
    private final ApplicationEventPublisher eventPublisher;

    public EventInstanceListener(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public boolean notify(EventType eventType, Supplier<FlwHisInstance> supplier, NodeModel nodeModel, FlowCreator flowCreator) {
        InstanceEvent instanceEvent = new InstanceEvent();
        instanceEvent.setEventType(eventType);
        instanceEvent.setFlwInstance(supplier.get());
        instanceEvent.setNodeModel(nodeModel);
        instanceEvent.setFlowCreator(flowCreator);
        eventPublisher.publishEvent(instanceEvent);
        return true;
    }
}
