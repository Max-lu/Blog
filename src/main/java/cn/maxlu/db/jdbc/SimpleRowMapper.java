package cn.maxlu.db.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by max.lu on 2016/2/26.
 */
public interface SimpleRowMapper<T> extends RowMapper<T> {

}
