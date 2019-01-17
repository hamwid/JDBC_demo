import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class JDBC_demo{

  /*
  This demo connects to a database namned 'jdbc_demo' in a SQL server
  located on localhost. It requires a user 'super@localhost' identified
  by 'admin' with permissions to be present. See SQL code below:
      CREATE USER super@localhost IDENTIFIED BY 'admin';
      GRANT ALL ON jdbc_demo.* TO super@localhost;
  The database contain a table namned 'people', which hold entries
  that have two VarChar; 'firstname' and 'lastname'.
  */

  public static Connection getConnection() throws Exception{
    try{
      String url = "jdbc:mysql://localhost:3306/jdbc_demo";
      String username = "super";
      String password = "admin";

      Connection conn = DriverManager.getConnection(url,username,password);
      System.out.println("Connected to database!");
      return conn;
    } catch(Exception e){System.out.println(e);}


    return null;
  }

  public static void main(String[] args) throws Exception{
    //Get Connection
    Connection conn = getConnection();

    //Create statement
    Statement statement = conn.createStatement();

    //Execute SQL Query
    ResultSet res = statement.executeQuery("select * from people");

    // Process ResultSet
    while(res.next()){
      System.out.println(res.getString("firstname")+" "+
                         res.getString("lastname"));
    }
  }
}
