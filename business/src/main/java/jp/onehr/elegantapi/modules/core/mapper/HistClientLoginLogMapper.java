package jp.onehr.elegantapi.modules.core.mapper;

import java.util.List;
import jp.onehr.elegantapi.modules.core.domain.entity.HistClientLoginLog;
import jp.onehr.elegantapi.modules.core.domain.entity.HistClientLoginLogExample;
import org.apache.ibatis.annotations.Param;

public interface HistClientLoginLogMapper {
    long countByExample(HistClientLoginLogExample example);

    int deleteByExample(HistClientLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HistClientLoginLog row);

    int insertSelective(HistClientLoginLog row);

    List<HistClientLoginLog> selectByExample(HistClientLoginLogExample example);

    HistClientLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") HistClientLoginLog row, @Param("example") HistClientLoginLogExample example);

    int updateByExample(@Param("row") HistClientLoginLog row, @Param("example") HistClientLoginLogExample example);

    int updateByPrimaryKeySelective(HistClientLoginLog row);

    int updateByPrimaryKey(HistClientLoginLog row);
}