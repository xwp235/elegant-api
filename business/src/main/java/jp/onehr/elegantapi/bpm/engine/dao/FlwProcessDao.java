/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.engine.dao;


import jp.onehr.elegantapi.bpm.engine.entity.FlwProcess;

import java.util.List;

/**
 * 流程定义数据访问层接口
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface FlwProcessDao {

    boolean insert(FlwProcess process);

    boolean deleteById(Long id);

    boolean updateById(FlwProcess process);

    boolean updateByProcessKey(FlwProcess process, String tenantId, String processKey);

    FlwProcess selectById(Long id);

    List<FlwProcess> selectListByProcessKeyAndVersion(String tenantId, String processKey, Integer version);
}
