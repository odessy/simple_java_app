package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class RecordTableView extends View implements MouseListener {
	protected RecordController controller;
	protected JTable recordTable;
	
	protected JTextField updateRecordTxt;
	
	protected JButton updateRecordBtn;
	protected JButton addRecordBtn;
	protected JButton deleteRecordBtn;
	
	protected JPanel panel;
	
	public RecordTableView(RecordController controller) {
		super("Table View");
		this.controller = controller;
	}
	
	public void setTableModel(Object[] objs) {
		DefaultTableModel model = new DefaultTableModel(null,new Object [] 
				{"Id", "Student Id", "Student Name", "Assignment Id", "Assignment Grade"});
		recordTable.setModel(model);
		for(Object obj : objs) {
			model.addRow((Object[])obj);
		}
	}

	@Override
	protected void initializeComponents() {
		recordTable = new JTable();
		panel = new JPanel();
		
		updateRecordTxt = new JTextField(10);
		
		updateRecordBtn = new JButton("Update Record");
		addRecordBtn = new JButton("Add Record");
		deleteRecordBtn = new JButton("Delete Record");
	}

	@Override
	protected void setLayout() {
		setLayout(new BorderLayout());
		
	}

	@Override
	protected void addComponentToPanel() {
		panel.add(addRecordBtn);
		panel.add(updateRecordBtn);
		panel.add(updateRecordTxt);
		panel.add(deleteRecordBtn);
	}

	@Override
	protected void addComponentToWindow() {
		getContentPane().add(new JScrollPane(recordTable), BorderLayout.CENTER);	
		getContentPane().add(panel, BorderLayout.PAGE_END);
		
	}

	@Override
	protected void registerActionListeners() {
		addRecordBtn.addActionListener(this);
		updateRecordBtn.addActionListener(this);
		deleteRecordBtn.addActionListener(this);
		recordTable.addMouseListener(this);
	}

	@Override
	protected void setWindowProperties() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(addRecordBtn)) {
			new RecordInsertView(controller);
		} else if(event.getSource().equals(updateRecordBtn)) {
			if(Integer.parseInt(updateRecordTxt.getText()) > 0) {
				controller.updateRecord(updateRecordTxt.getText());
			}
		} else if(event.getSource().equals(deleteRecordBtn)) {
			if(Integer.parseInt(updateRecordTxt.getText()) > 0) {
				controller.deleteRecord(updateRecordTxt.getText());
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) {
        JTable target = (JTable)event.getSource();
        int row = target.getSelectedRow();
        //int column = target.getSelectedColumn();
        updateRecordTxt.setText(target.getValueAt(row, 0).toString());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
