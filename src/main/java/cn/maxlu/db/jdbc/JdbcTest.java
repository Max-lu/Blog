package cn.maxlu.db.jdbc;


import java.beans.PropertyVetoException;

/**
 * Created by max.lu on 2016/2/26.
 */
public class JdbcTest {
    public static void main(String[] args) throws PropertyVetoException {
        query();
    }

    private static void query() throws PropertyVetoException {
//        JdbcAccess jdbcAccess = new JdbcAccess();
//        String sql = "select * from tmp.test where id>?";
//        List<Test> query = jdbcAccess.query(sql, new SimpleRowMapper<Test>() {
//            @Override
//            public Test mapRow(ResultSet resultSet, int i) throws SQLException {
//                Test test = new Test();
//                test.setId(resultSet.getInt("id"));
//                test.setName(resultSet.getString("name"));
//                test.setAge(resultSet.getInt("age"));
//                return test;
//            }
//        }, 20);
//        for (Test test : query) {
//            System.out.println(test.getName());
//        }
    }

    private static void update() throws PropertyVetoException {
        JdbcAccess jdbcAccess = new JdbcAccess();
        String sql = "update tmp.test set age=? where name=?";
        jdbcAccess.execute(sql, 2, "max7");
    }

    private static void insert() throws PropertyVetoException {
        JdbcAccess jdbcAccess = new JdbcAccess();
        String sql = "INSERT INTO tmp.test(NAME, age) VALUES(?,?)";
        jdbcAccess.execute(sql, "max7", 1);
    }

    private static void execute() throws PropertyVetoException {
        JdbcAccess jdbcAccess = new JdbcAccess();
        String sql = "INSERT INTO tmp.test(NAME, age) VALUES('max6',6)";
        jdbcAccess.execute(sql);
    }


}
