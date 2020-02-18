import java.sql.*;

class mysql_con {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Using the jdbc driver for mysql
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "saptarshi", "gametweet123");
            Statement st = con.createStatement();
            st.executeUpdate("DROP TABLE IF EXISTS jdbcTable"); 
            st.executeUpdate("CREATE TABLE jdbcTable (id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(20) UNIQUE)");
            ResultSet rs = st.executeQuery("SELECT * FROM users2");
            while(rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            con.close();
        }

        catch(Exception e) {
            System.out.println(e);
        }
    }
}