/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.spring.autoconfigure;

import jp.onehr.elegantapi.bpm.engine.scheduling.RemindParam;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * 配置属性
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
@ConfigurationProperties(prefix = "flowlong")
public class FlowLongProperties {
    /**
     * 提醒时间
     */
    @NestedConfigurationProperty
    private RemindParam remind;

    /**
     * 事件监听配置
     */
    @NestedConfigurationProperty
    private EventingParam eventing;

}
