import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDBConnection {
    private static SingletonDBConnection INSTANCE;
    private Connection con;

    private SingletonDBConnection() {
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost3306/DATABASE", "user", "password");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Connection getConnection(){return con;}

    public static SingletonDBConnection getInstance() throws SQLException {
        if(INSTANCE == null){
            INSTANCE = new SingletonDBConnection();
        }
        else if (INSTANCE.getConnection().isClosed()){
            INSTANCE = new SingletonDBConnection();
        }
        return INSTANCE;
    }
}
