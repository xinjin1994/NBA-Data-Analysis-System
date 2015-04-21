package gui.util;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import enums.Terminology;

public class LabelPanel extends JPanel {
	private static final long serialVersionUID = -7726946355631726343L;
	private JLabel lbl_value;
	private JLabel lbl_name;
	private JLabel lbl_unit;

	/**
	 * Create the panel.
	 */
	public LabelPanel(String name) {
		this(name,"","");
	}
	public LabelPanel(String name,String unit) {
		this(name,"",unit);
	}
	public LabelPanel(Terminology term,boolean average) {
		this(term,"",average);
	}
	public LabelPanel(Terminology term, String value,boolean average) {
		this((average?"场均":"")+term.toString(),value,Terminology.getUnit(term));
	}
	public LabelPanel(String name,String value,String unit) {
		
		lbl_name = new JLabel(name+":");
		add(lbl_name);
		
		lbl_value = new JLabel(value);
		add(lbl_value);
		
		lbl_unit = new JLabel(unit);
		add(lbl_unit);
	}
	
	public void setValue(String value){
		lbl_value.setText(value);
	}
	public String getvalue() {
		return lbl_value.getText();
	}
	
	public void setColor(Color c){
		lbl_name.setForeground(c);
		lbl_value.setForeground(c);
		lbl_unit.setForeground(c);
	}
}
