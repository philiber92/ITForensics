import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Philipp Bergt and Jan Schneck on 06.07.15.
 */
public class Database {

    private Connection _c;

    public Database(String host, String username, String password) throws Exception {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        _c = DriverManager.getConnection("jdbc:hsqldb" + host, usernamem, password);
    }


    public void query(String sql) throws SQLException {
        Statement statement = _c.createStatement();
        statement.executeQuery(sql);
    }

    public void close() throws SQLException {
        _c.close();
    }

}
