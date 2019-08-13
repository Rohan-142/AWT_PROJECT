import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcess {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String SQL;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3360/test", "root", "root");
			con.setAutoCommit(false);
			st = con.createStatement();
			SQL ="insert into login (id,userid,password,type)"  +"values(23,'Rohan','12345','employee')";
			st.addBatch(SQL);
			SQL = "insert into login (id,userid,password,type)"  +"values(30,'Sridev','568975','student')";
			st.addBatch(SQL);
			SQL = "update login set type='Student'" +"where id=23";
			st.addBatch(SQL);
			int[] count = st.executeBatch();
			con.commit();
			System.out.println("Commit.");
		}catch (SQLException | ClassNotFoundException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
			e1.printStackTrace();
			}
			e.printStackTrace();
			System.out.println("Rollback.");
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}