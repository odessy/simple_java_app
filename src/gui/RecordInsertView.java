package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RecordInsertView extends View {	
	protected RecordController studentController;
	protected JLabel nameLb;
	protected JLabel gradeLb;
	protected JLabel studentIdLb;
	protected JLabel assignmentIdLb;
	
	protected JTextField nameTF;
	protected JTextField gradeTF;
	protected JTextField studentIdTF;
	protected JTextField assignmentIdTF;
	
	protected JButton submitBtn;
	protected JButton clearBtn;
	
	protected final static String submitBtnAction = "submitAction";
	protected final static String clearBtnAction = "clearAction";
	
	public RecordInsertView(RecordController studentController) {
		super("Add View");
		this.studentController = studentController;
	}

	public RecordInsertView(String title, RecordController studentController) {
		super(title);
		this.studentController = studentController;
	}
	
	@Override
	protected void initializeComponents() {
		studentIdLb = new JLabel("Student Id:");
		nameLb = new JLabel("Student Name:");
		assignmentIdLb = new JLabel("Assignment Id:");
		gradeLb = new JLabel("Assignment Grade:");
		
		studentIdTF = new JTextField(textFieldSize);
		nameTF = new JTextField(textFieldSize);
		gradeTF = new JTextField(textFieldSize);
		assignmentIdTF = new JTextField(textFieldSize);
		
		submitBtn = new JButton("Submit");
		clearBtn = new JButton("Clear");
	}

	@Override
	protected void setLayout() {
		setLayout(new FlowLayout());
	}

	@Override
	protected void addComponentToPanel() {
		getContentPane().add(studentIdLb);
		getContentPane().add(studentIdTF);		
		
		getContentPane().add(nameLb);
		getContentPane().add(nameTF);
		
		getContentPane().add(assignmentIdLb);
		getContentPane().add(assignmentIdTF);
		
		getContentPane().add(gradeLb);
		getContentPane().add(gradeTF);
		
		getContentPane().add(submitBtn);
		getContentPane().add(clearBtn);
	}

	@Override
	protected void addComponentToWindow() {

	}

	@Override
	protected void setWindowProperties() {
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	protected void registerActionListeners() {
		clearBtn.addActionListener(this);
		clearBtn.setActionCommand(clearBtnAction);
		submitBtn.addActionListener(this);
		submitBtn.setActionCommand(submitBtnAction);
	}
	
	public void clear(){
		studentIdTF.setText("");
		nameTF.setText("");
		gradeTF.setText("");
		assignmentIdTF.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action == clearBtnAction) {
			clear();
		} else if(action == submitBtnAction) {
			studentController.addRecord(studentIdTF.getText(), nameTF.getText(), assignmentIdTF.getText(), gradeTF.getText());
			clear();
		}
	}
}
