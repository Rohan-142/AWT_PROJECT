import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchCtrl {

	public static void main(String[] args, String SQL) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3360/test", "root", "root");
			con.setAutoCommit(false);
			st = con.createStatement();
			st.execute("insert into login (id,userid,password,type) values (35,'Sridev','12345','employee')",
					Statement.RETURN_GENERATED_KEYS);
			st.addBatch(SQL);
			ResultSet keys = st.getGeneratedKeys();
			int id = 1;
			while (keys.next()) {
				id = keys.getInt(1);
			}
			java.sql.PreparedStatement ps = con
					.prepareStatement("select username,pass from student where userName=? and pass=?");
			ps.setString(1, "Rohan");
			ps.setString(2, "Das");

			ResultSet rs = ps.executeQuery();
			con.commit();
			System.out.println("Transaction Commit.");
		} catch (SQLException | ClassNotFoundException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			System.out.println("Connection Rollback.");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}