package gui;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RecordUpdateView extends RecordInsertView{
	
	private JTextField idTF;
	
	public RecordUpdateView(RecordController studentController) {
		super("Update View",studentController);
	}
	
	@Override
	protected void initializeComponents() {
		super.initializeComponents();
		idTF = new JTextField();
		idTF.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action == clearBtnAction) {
			clear();
		} else if(action == submitBtnAction) {
			studentController.updateRecord(idTF.getText(), studentIdTF.getText(), nameTF.getText(), assignmentIdTF.getText(), gradeTF.getText());
		}
	}

	public void setValues(String id, String studentId, String name, String assignmentId, String grade) {
		idTF.setText(id);
		studentIdTF.setText(studentId);
		nameTF.setText(name);
		gradeTF.setText(grade);
		assignmentIdTF.setText(assignmentId);
	}

}
