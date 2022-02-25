import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Statements {

//    Declare a connection
    private static Connection connect = null;

//    Create an SQL statement set -> null
    private static Statement stmt = null;

//    Declare a ResultSet set -> null
    private static ResultSet rs = null;

//    Declare a query
    private static String query;

    public static void connect(String usr, String pswrd) {
        connect = DB_Connector.connect(usr, pswrd);
    }

    private static void executeQuery(String query) {
        try {
            stmt = connect.createStatement();
            stmt.executeUpdate(query);
            System.out.println(TextColor.ANSI_GREEN + "\n--Query " +
                    TextColor.ANSI_YELLOW + query + TextColor.ANSI_GREEN + " executed successfully--");
        } catch (SQLException e) {
            System.out.println(TextColor.ANSI_RED + "\n--Query " + TextColor.ANSI_YELLOW + query + TextColor.ANSI_RED + " did not execute--");
            e.printStackTrace();
        }
    }

    public static void createTable(String tblName, String column2, String column3) {
        query = "create table if not exists " + tblName +
                "(id int not null auto_increment primary key, " +
                column2 + " varchar(32), " +
                column3 + " varchar(32))";

        executeQuery(query);
    }

    public static void insertInto(String tblName, String column2, String column3) {
        query = "insert into " + tblName +
                "(name, address) values" + "('" +
                    column2 + "', " + "'" + column3 + "')";

        executeQuery(query);
    }

    public static void deleteEmployee(String tbl, String employee) {
        query = "delete from " + tbl + " where name = '" + employee + "';";

        executeQuery(query);
    }

    public static void  showData(String tbl) {
        query = "select * from " + tbl + ";";

        int empID;
        String name;
        String address;

        try {
            stmt = connect.createStatement();
            rs = stmt.executeQuery(query);
            System.out.printf(TextColor.ANSI_GREEN + " %n%-9s| %-20s| %-20s%n", "empID", "name", "address");
            System.out.println("---------|---------------------|-------------------");
            while (rs.next()) {
                empID = rs.getInt(1);
                name = rs.getString("name");
                address = rs.getString("address");
                System.out.printf(TextColor.ANSI_RESET + "%-9s| %-20s| %-20s%n", empID, name, address);
                System.out.println("---------|---------------------|-------------------");
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println(TextColor.ANSI_RED + "\n-- Query " + query + " did not execute--");
        }
    }

    public static void showDataByName(String tbl, String byName) {
        query = "select * from " + tbl +
                " where name like '" +
                byName + "%';";

        int empID;
        String name;
        String address;

        try {
            stmt = connect.createStatement();
            rs = stmt.executeQuery(query);
            System.out.printf(TextColor.ANSI_GREEN + " %n%-9s| %-20s| %-20s%n", "empID", "name", "address");
            System.out.println("---------|---------------------|-------------------");
            while (rs.next()) {
                empID = rs.getInt(1);
                name = rs.getString("name");
                address = rs.getString("address");
                System.out.printf(TextColor.ANSI_RESET + "%-9s| %-20s| %-20s%n", empID, name, address);
                System.out.println("---------|---------------------|-------------------");
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println(TextColor.ANSI_RED + "\n-- Query " + query + " did not execute--");
        }
    }

    public static boolean checkLogin(String name, String password) {
        boolean check = false;
        query = "select * from users " +
                "where usrName = '" + name + "' and password = '" + password + "';";

        try {
            stmt = connect.createStatement();
            rs = stmt.executeQuery(query);

            while(rs.next()) {
                check = true;
                System.out.println("YOOOOHOOOO!!!!");
            }

            if(check == false) {
                System.out.println("BOOHOOO!!!");
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return check;
        }
        return check;
    }

}
