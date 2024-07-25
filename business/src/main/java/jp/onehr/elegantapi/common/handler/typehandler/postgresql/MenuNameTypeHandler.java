package jp.onehr.elegantapi.common.handler.typehandler.postgresql;

import jp.onehr.elegantapi.common.handler.typehandler.types.MenuName;
import jp.onehr.elegantapi.common.utils.JsonUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MenuNameTypeHandler extends BaseTypeHandler<MenuName> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, MenuName parameter, JdbcType jdbcType) throws SQLException {
      ps.setString(i, JsonUtil.obj2Json(parameter));
    }

    @Override
    public MenuName getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getMenuName(rs.getString(columnName));
    }

    @Override
    public MenuName getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getMenuName(rs.getString(columnIndex));
    }

    @Override
    public MenuName getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getMenuName(cs.getString(columnIndex));
    }

    private MenuName getMenuName(String jsonString) {
        if (jsonString == null) {
            return null;
        }
        return JsonUtil.json2Obj(jsonString, MenuName.class);
    }
}
