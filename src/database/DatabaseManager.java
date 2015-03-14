package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseManager {
	private Connection connection;
	private ResultSet resultSet;
	private Statement statement;
	
	public DatabaseManager() {
		String connectionString ="jdbc:mysql://localhost:3306/advancejava?user=root&password=";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionString);
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String coats(String val) {
		return "'"+val+"'";
	}
	
	public void insert(String student_id, String student_name, String assignment_id, String  assignment_grade) throws SQLException {
		String sql = "INSERT INTO assignment (student_id, student_name, assignment_id, assignment_grade ) VALUES("+ 
					coats(student_id)+","+coats(student_name)+","+coats(assignment_id)+","+coats(assignment_grade)+
					");";
		statement.executeUpdate(sql);
	}
	
	public void update(String id, String student_id, String student_name, 
			String assignment_id, String  assignment_grade) throws SQLException {
		String sql = "UPDATE assignment SET "+
			"student_id="+coats(student_id)+", student_name="+coats(student_name)+", "+
			"assignment_id="+coats(assignment_id)+", assignment_grade="+coats(assignment_grade)+" WHERE id="+coats(id)+
			";";
		statement.executeUpdate(sql);
	}
	
	public void delete(String id) throws SQLException {
		String sql = "DELETE FROM assignment WHERE id="+coats(id)+";";
		statement.executeUpdate(sql);
	}
	
	public Object [] readOne(ResultSet resultSet) throws SQLException{
		Object [] objs = new Object[5];
		int id = resultSet.getInt("id");
		int student_id = resultSet.getInt("student_id");
		String student_name = resultSet.getString("student_name");
		int assignment_id = resultSet.getInt("assignment_id");
		double assignment_grade = resultSet.getDouble("assignment_grade");
		objs[0] = id;
		objs[1] = student_id;
		objs[2] = student_name;
		objs[3] = assignment_id;
		objs[4] = assignment_grade;
		return objs;	
	}
	
	public Object [] read(String id) throws SQLException {
		String sql = "SELECT * FROM assignment WHERE id="+coats(id)+";";
		resultSet = statement.executeQuery(sql);
		if(resultSet.next()) {
			return readOne(resultSet);
		}
		return null;
	}

	public Object[] readAll() throws SQLException {
		String sql = "SELECT * FROM assignment;";
		resultSet = statement.executeQuery(sql);
		ArrayList<Object[]> list = new ArrayList<Object[]>(0);
		while(resultSet.next()) {
			list.add(readOne(resultSet));
		}
		return list.toArray();
	}

}
