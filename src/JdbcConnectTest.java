import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcConnectTest {

   public static void main(String[] args) {

      Connection con = null;
      Statement stmt = null;
      ResultSet rs   =null;
      
      
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String sql = "select * from dept";
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         con=DriverManager.getConnection(url, "scott", "tiger");
         System.out.println("연결 성공");
         
         stmt = con.createStatement();
         rs = stmt.executeQuery("Select * from emp");
         
         while(rs.next() ) {
            int empno=rs.getInt(1);
            String ename=rs.getString(2);
            String job = rs.getString(3);
            int mgr=rs.getInt(4);
            Date hiredate=rs.getDate(5);
            int sal = rs.getInt(6);
            int comm = rs.getInt(7);
            int deptno = rs.getInt(8);
            
            
            System.out.println(empno + " : "+ename+" : "+ job
                  +" : "+mgr+" : "+hiredate+" : "+sal
                  +" : "+comm+" : "+deptno);
         }
         
         
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         
      } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
      }
         
      

   }

}