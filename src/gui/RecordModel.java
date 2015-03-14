package gui;

import java.sql.SQLException;

import database.DatabaseManager;

public class RecordModel {
	private String id;
	private StudentModel studentModel;
	private AssignmentModel assignmentModel;
	private DatabaseManager dbManager;

	public RecordModel(StudentModel studentModel, AssignmentModel assignmentModel) {
		dbManager = new DatabaseManager();
		this.setId(null);
		this.setStudentModel(studentModel);
		this.setAssignmentModel(assignmentModel);
	}

	public RecordModel(String id, StudentModel studentModel, AssignmentModel assignmentModel) {
		dbManager = new DatabaseManager();
		this.setId(id);
		this.setStudentModel(studentModel);
		this.setAssignmentModel(assignmentModel);
	}
	
	public RecordModel() {
		dbManager = new DatabaseManager();
		this.setId(null);
		this.setStudentModel(null);
		this.setAssignmentModel(null);
	}

	public boolean delete(String id) {
		try {
			dbManager.delete(id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Object[] select(String id) {
		try {
			return dbManager.read(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object[] selectAll() {
		Object [] objs = null;
		try {
			objs = dbManager.readAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objs;
	}
	
	public boolean save() {
		if(id == null) {
			return create();
		} else {
			return update();
		}
	}
	
	private boolean update() {
		String student_id = studentModel.getId()+"";
		String student_name = studentModel.getName();
		String assignment_id = assignmentModel.getId()+"";
		String assignment_grade = assignmentModel.getGrade()+"";
		try {
			dbManager.update(id, student_id, student_name, assignment_id, assignment_grade);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean create() {
		String student_id = studentModel.getId()+"";
		String student_name = studentModel.getName();
		String assignment_id = assignmentModel.getId()+"";
		String assignment_grade = assignmentModel.getGrade()+"";
		
		System.out.println(student_id+ student_name+ assignment_id+ assignment_grade);
		
		try {
			dbManager.insert(student_id, student_name, assignment_id, assignment_grade);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public StudentModel getStudentModel() {
		return studentModel;
	}

	public void setStudentModel(StudentModel studentModel) {
		this.studentModel = studentModel;
	}

	public AssignmentModel getAssignmentModel() {
		return assignmentModel;
	}

	public void setAssignmentModel(AssignmentModel assignmentModel) {
		this.assignmentModel = assignmentModel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id2) {
		this.id = id2;
	}

}
