package gui;

public class AssignmentModel {
	
	private int id;
	private double grade;
	
	public AssignmentModel(int id, double grade) {
		this.setId(id);
		this.setGrade(grade);
	}

	public AssignmentModel(String id, String grade) {
		setId(Integer.parseInt(id));
		setGrade(Double.parseDouble(grade));
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
}
