public class DB_Test {

    public static void main(String[] args) {
        DB_Statements.connect("root", "12345678");
//        DB_Statements.createTable("employee", "name", "address");
        DB_Statements.insertInto("employee", "Bob Bobby", "Bob Street 37");
    }

}
