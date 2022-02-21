import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {

//    declare a connection & initialize -> null
    private static Connection connect = null;

//    declare DB
    private static String db;

//    declare URL and initiate
    private static String url = "jdbc:mysql://localhost:3306/company";

//    declare user name
    private static String usr;

//    declare password
    private static String pswrd;

    

//    method to connect to DB
    public static Connection connect(String usr, String pswrd) {
        System.out.println(ANSI_RED + "\n--Connecting to MySQL JDBC--" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\n--Connecting to MySQL DBMS--" + ANSI_RESET);
        try{
            connect = DriverManager.getConnection(url, usr, pswrd);
            System.out.println(ANSI_GREEN + "\n--Connection successful--" + ANSI_RESET);
        } catch(SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        return connect;
    }

}
