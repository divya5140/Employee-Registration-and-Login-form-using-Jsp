
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//import net.javaguides.jsp.jdbc.bean.Employee;

public class EmployeeDao {

    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee1" +
            "  (id, firstname, lastname, username, password, address, contact) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/database1", "root", "Divya@514");

            // Step 2:Create a statement using connection object
            PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getUsername());
            ps.setString(5, employee.getPassword());
            ps.setString(6, employee.getAddress());
            ps.setString(7, employee.getContact());

            System.out.println(ps);
            // Step 3: Execute the query or update query
            result = ps.executeUpdate();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
            

//        } catch (SQLException e) {
//            // process sql exception
//            printSQLException(e);
//        }
       
    }
		return result;

//    private void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
      //  }
    }
}
