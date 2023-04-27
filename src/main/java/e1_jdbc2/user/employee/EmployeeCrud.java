package e1_jdbc2.user.employee;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;


public class EmployeeCrud {

	Scanner sc = new Scanner(System.in);

	public Connection getConnection() throws Exception {
		
		//load or register
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
		

		FileInputStream stream = new FileInputStream("file.properties");
	
		Properties properties = new Properties();
		properties.load(stream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("pwd"));

		return connection;
	}

	public void saveEmployee() throws Exception {
		System.out.println("enter your id");
		int id = sc.nextInt();
		System.out.println("enter your name");
		String name = sc.next();
		System.out.println("enter your lastname");
		String lastname = sc.next();
		System.out.println("enter your email");
		String email = sc.next();
		System.out.println("enter your password");
		String pwd = sc.next();
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setLastname(lastname);
		employee.setEmail(email);
		employee.setPwd(pwd);
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into employee values (?,?,?,?,?)");
		statement.setInt(1, id);
		statement.setString(2, name);
		statement.setString(3, lastname);
		statement.setString(4, email);
		statement.setString(5, pwd);
		statement.execute();
		connection.close();

	}

	public boolean loginUser() throws Exception {

		System.out.println("enter your email");
		String email = sc.next();
		System.out.println("enter your password");
		String pwd = sc.next();
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from employee where email = ?");
		statement.setString(1, email);

		ResultSet result = statement.executeQuery();
		String emppwd = null;
		String empemail = null;

		while (result.next()) {
			empemail = result.getString(4);
			emppwd = result.getString(5);
		}

		if (pwd.equals(emppwd) && email.equals(empemail)) {
			return true;
		} else {
			return false;
		}
	}

}
