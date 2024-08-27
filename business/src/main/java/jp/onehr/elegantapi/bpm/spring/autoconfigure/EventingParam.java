/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.spring.autoconfigure;

import lombok.Getter;
import lombok.Setter;


/**
 * Spring Boot EventListener 配置参数对象
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
public class EventingParam {

    /**
     * 是否开启任务事件监听
     */
    private boolean task;

}
