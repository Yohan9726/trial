import java.sql.*;

class mysql_con {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Using the jdbc driver for mysql
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "saptarshi", "gametweet123");
            Statement st = con.createStatement();
            st.executeUpdate("DROP TABLE IF EXISTS jdbcTable"); 
            st.executeUpdate("CREATE TABLE jdbcTable (id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(20) UNIQUE)");
            ResultSet rs = st.executeQuery("SELECT id,name FROM users2");
            while(rs.next()) {
                System.out.println(rs.getString("id") + " " + rs.getString("name"));
            }

            //Prepared statement to execute queries with parameters
            PreparedStatement ps = con.prepareStatement("INSERT INTO jdbcTable VALUES(?,?)");
            ps.setInt(1,1); //First argument is the index. Second argument is the value.
            ps.setString(2,"Saptarshi"); //First argument : index. Second argument : value.
            ps.executeUpdate(); //Executes the query

            ResultSet rs2 = ps.executeQuery("SELECT * FROM jdbcTable");
            System.out.println("Prepared Statement : -------------------");
            while(rs2.next()) {
                System.out.println(rs2.getInt(1) + " " + rs2.getString(2));
            }



            // DatabaseMetaData dbmd=con.getMetaData();  
            // String table[]={"TABLE"};  
            // ResultSet rs3=dbmd.getTables(null,null,null,table);
            // int x = 0;
            // String tableName = "";
            // while(rs3.next() && x == 0){  
            //     tableName = (rs3.getString(3));
            //     x++;
            // }
            // System.out.println(tableName);
            con.close();
        }

        catch(Exception e) {
            System.out.println(e);
        }
    }
}