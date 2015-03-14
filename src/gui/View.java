package gui;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class View extends JFrame implements ActionListener {
	
	protected static final int textFieldSize = 23;
	
	public View(String name){
		super(name);
		initializeComponents();
		setLayout();
		addComponentToPanel();
		addComponentToWindow();
		registerActionListeners();
		setWindowProperties();
	}
	
	protected abstract void initializeComponents();
	protected abstract void setLayout();
	protected abstract void addComponentToPanel();
	protected abstract void addComponentToWindow();
	protected abstract void registerActionListeners();
	protected abstract void setWindowProperties();
	
}
