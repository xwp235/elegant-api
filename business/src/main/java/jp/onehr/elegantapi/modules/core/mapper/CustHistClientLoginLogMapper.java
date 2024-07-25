package jp.onehr.elegantapi.modules.core.mapper;

import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CustHistClientLoginLogMapper {

    @Update("""
        <script>
            UPDATE hist_client_login_log 
            <set>
              logout_time = CURRENT_TIMESTAMP
            </set>
            WHERE id IN
            <foreach collection="list" item="itemId" open="(" separator="," close=")">
              #{itemId}
            </foreach>
        </script>  
    """)
    int updateLogoutTime(List<Long> list);

}
