
import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection
{
     public static Connection connect()
    {
        Connection conn=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");/*creates driver class object registered 
                                                   with drivermanger service automatically*/
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/periodtracking?","root","");
            return conn;
            
        }
        catch(Exception e)
        {
            System.out.println("Inter.dbconnect.connect()");
            return null;
        }
       
    }
     public static void main(String args[])
     {
     }
    
}
