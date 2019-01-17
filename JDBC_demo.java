import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_demo{

  //This demo connects to a database namned 'jdbc_demo' in a SQL server
  //located on localhost. It requires a user 'super@localhost' identified
  //by 'admin' with permissions to be present. See SQL code below:
  //    CREATE USER super@localhost IDENTIFIED BY 'admin';
  //    GRANT ALL ON jdbc_demo.* TO super@localhost;
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

  public static void main(String[] args) {
    //Get Connection
    Connection conn = getConnection();
  }
}
