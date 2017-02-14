package cn.maxlu.db.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.List;


@PropertySource({"classpath:jdbc.properties"})
public class JdbcAccess {
    private Environment env = new StandardEnvironment();
    private JdbcTemplate jdbcTemplate;

    public JdbcAccess() throws PropertyVetoException {
        this.jdbcTemplate = new JdbcTemplate(getDataSource());
    }

    private DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://devmysql.hopscotch.in:3306/tmp");
        dataSource.setUser("dev");
        dataSource.setPassword("dev");
        dataSource.setMaxIdleTime(120);
        dataSource.setMaxPoolSize(50);
        dataSource.setUnreturnedConnectionTimeout(150);
        dataSource.setDebugUnreturnedConnectionStackTraces(true);
//        dataSource.setConnectionCustomizerClassName("");
        return dataSource;
    }

    public void execute(String sql) {
        jdbcTemplate.execute(sql);
    }

    public <T> List<T> query(String sql, SimpleRowMapper<T> rowMapper, Object... params) {
        return jdbcTemplate.query(sql, rowMapper, params);
    }

    public void execute(String sql, Object... params) {
        jdbcTemplate.update(sql, params);
    }

}
