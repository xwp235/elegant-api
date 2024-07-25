package jp.onehr.elegantapi.modules.core.mapper;

import java.util.List;
import jp.onehr.elegantapi.modules.core.domain.entity.MastUser;
import jp.onehr.elegantapi.modules.core.domain.entity.MastUserExample;
import org.apache.ibatis.annotations.Param;

public interface MastUserMapper {
    long countByExample(MastUserExample example);

    int deleteByExample(MastUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MastUser row);

    int insertSelective(MastUser row);

    List<MastUser> selectByExample(MastUserExample example);

    MastUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") MastUser row, @Param("example") MastUserExample example);

    int updateByExample(@Param("row") MastUser row, @Param("example") MastUserExample example);

    int updateByPrimaryKeySelective(MastUser row);

    int updateByPrimaryKey(MastUser row);
}
