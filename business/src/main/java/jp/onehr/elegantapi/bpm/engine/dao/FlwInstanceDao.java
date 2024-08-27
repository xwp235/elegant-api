/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.engine.dao;

import jp.onehr.elegantapi.bpm.engine.entity.FlwInstance;

import java.util.List;
import java.util.Optional;

/**
 * 流程实例数据访问层接口
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface FlwInstanceDao {

    boolean insert(FlwInstance flwInstance);

    boolean deleteById(Long id);

    boolean deleteByProcessId(Long processId);

    boolean updateById(FlwInstance instance);

    FlwInstance selectById(Long id);

    Optional<List<FlwInstance>> selectListByParentInstanceId(Long parentInstanceId);
}
