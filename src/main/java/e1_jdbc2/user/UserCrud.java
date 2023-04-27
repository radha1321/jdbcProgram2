package e1_jdbc2.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserCrud {

	// creating a method for saving user object
	public void saveUser(User user) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb1", "root", "root");
		PreparedStatement statement = connection.prepareStatement("insert into user values(?,?,?,?,?)");
		statement.setInt(1, user.getId());
		statement.setString(2, user.getName());
		statement.setString(3, user.getEmail());
		statement.setString(4, user.getPhone());
		statement.setString(5, user.getPwd());

		statement.execute();
		connection.close();

	}

	// creating a method for update user phone and email
	public void updateUser(User user) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb1", "root", "root");
		PreparedStatement statement = connection.prepareStatement("update user set email=?,phone=? where id=?");
		statement.setString(1, user.getEmail());
		statement.setString(2, user.getPhone());
		statement.setInt(3, user.getId());

		statement.execute();
		connection.close();

	}

	public void deleteUser(User user) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb1", "root", "root");
		PreparedStatement statement = connection.prepareStatement("delete from user where id=?");
		statement.setInt(1, user.getId());
		statement.execute();
		connection.close();

	}

	public void retrieveUser() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb1", "root", "root");
		PreparedStatement statement = connection.prepareStatement("select * from user");
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			System.out.println(result.getInt(1) + "=======" + result.getString(2) + "=========" + result.getString(3)
					+ "=======" + result.getString(4));
		}
		statement.execute();
		connection.close();

	}

}
