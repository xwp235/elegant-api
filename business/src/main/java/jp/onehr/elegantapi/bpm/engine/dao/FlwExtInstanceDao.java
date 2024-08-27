/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.engine.dao;


import jp.onehr.elegantapi.bpm.engine.entity.FlwExtInstance;

/**
 * 扩展流程实例数据访问层接口
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface FlwExtInstanceDao {

    boolean insert(FlwExtInstance extInstance);

    boolean deleteByProcessId(Long processId);

    boolean updateById(FlwExtInstance extInstance);

    FlwExtInstance selectById(Long id);

}
