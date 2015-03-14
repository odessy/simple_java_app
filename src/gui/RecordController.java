package gui;

import javax.swing.JOptionPane;

public class RecordController {
	private RecordModel recordModel;
	private RecordTableView view;
	
	public RecordController(){
		view = new RecordTableView(this);
		addTableDataToView();
	}
	
	public static void main(String [] args) {
		new RecordController();
	}
	
	public void addTableDataToView() {
		recordModel = new RecordModel();
		Object [] objs = recordModel.selectAll();
		view.setTableModel(objs);
	}

	public void addRecord(String studentId, String name, String assignmentId, String grade) {
		recordModel = new RecordModel(new StudentModel(Integer.parseInt(studentId), name), new AssignmentModel(assignmentId,grade));
		if(recordModel.save()) {
			JOptionPane.showMessageDialog(view, "Record Saved", "Result", JOptionPane.INFORMATION_MESSAGE);
			addTableDataToView();
		}
		else {
			JOptionPane.showMessageDialog(view, "Record Not Saved", "Result", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateRecord(String id, String studentId, String name, String assignmentId, String grade) {
		recordModel = new RecordModel(id, new StudentModel(Integer.parseInt(studentId), name), new AssignmentModel(assignmentId,grade));
		if(recordModel.save()) {
			JOptionPane.showMessageDialog(view, "Record Updated", "Result", JOptionPane.INFORMATION_MESSAGE);
			addTableDataToView();
		}
		else {
			JOptionPane.showMessageDialog(view, "Record Not Updated", "Result", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void updateRecord(String id) {
		recordModel = new RecordModel();
		Object [] obj = recordModel.select(id);
		if(obj != null) {
			Object [] values = obj;
			RecordUpdateView updateView = new RecordUpdateView(this);
			updateView.setValues(values[0].toString(), values[1].toString(), 
					values[2].toString(), values[3].toString(), values[4].toString());
		} else {
			JOptionPane.showMessageDialog(view, "Record Not Found", "Result", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteRecord(String id) {
		recordModel = new RecordModel();
		if(recordModel.delete(id)) {
			JOptionPane.showMessageDialog(view, "Record Deleted", "Result", JOptionPane.INFORMATION_MESSAGE);
			addTableDataToView();
		}
		else {
			JOptionPane.showMessageDialog(view, "Record Not Deleted", "Result", JOptionPane.ERROR_MESSAGE);
		}	
	}
}
