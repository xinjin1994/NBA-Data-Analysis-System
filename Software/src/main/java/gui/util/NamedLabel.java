package gui.util;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import enums.Terminology;

public class NamedLabel extends JLabel {
	private static final long serialVersionUID = -7726946355631726343L;
	private String value;
	private String name;
	private String unit;

	/**
	 * Create the panel.
	 */
	public NamedLabel(String name) {
		this(name,"","");
	}
	public NamedLabel(String name,String unit) {
		this(name,"",unit);
	}
	public NamedLabel(Terminology term,boolean average) {
		this(term,"",average);
	}
	public NamedLabel(Terminology term, String value,boolean average) {
		this((average?"场均":"")+term.toString(),value,Terminology.getUnit(term));
	}
	public NamedLabel(String name,String value,String unit) {
		this.name = name+" : ";
		this.value = value;
		this.unit = " "+unit;
		super.setText(this.name+this.value+this.unit);
		this.setAlignmentX(0);
		this.setFont(new Font(this.getFont().getName(),Font.PLAIN,this.getFont().getSize()));
		this.setHorizontalAlignment(SwingConstants.LEADING);
	}
	
	@Override
	public void setText(String value){
		super.setText(name+value+unit);
		this.value = value;
	}
	
	
	public void setFontSize(int size){
		this.setFont(new Font(this.getFont().getName(),Font.BOLD,size));
	}
	
}
