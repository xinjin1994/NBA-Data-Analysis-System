package gui.match;

import gui.util.ShortDate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class DateChooser extends JPanel {

	private static final long serialVersionUID = -2519704173559653943L;
	public static final String PREV = "PREV";
	public static final String JUMP = "JUMP";
	public static final String NEXT = "NEXT";
	private JComboBox<ShortDate> cbbx_date;
	private JButton btn_prev;
	private JButton btn_next;
	private DateChangeable dc;
	
	public DateChooser(ShortDate[] dates,DateChangeable dc){
		this.dc = dc;
		
		
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		btn_prev = new JButton("◀");
		if(dates.length == 1)
			btn_prev.setEnabled(false);
		this.add(btn_prev);
		this.add(Box.createHorizontalGlue());
		this.add(Box.createHorizontalStrut(80));
		cbbx_date = new JComboBox<ShortDate>(dates);
		this.add(cbbx_date);
		this.add(Box.createHorizontalStrut(80));
		this.add(Box.createHorizontalGlue());
		btn_next = new JButton("▶");
		btn_next.setEnabled(false);
		this.add(btn_next);
		

		
		btn_prev.setActionCommand(PREV);
		cbbx_date.setActionCommand(JUMP);
		btn_next.setActionCommand(NEXT);
		
		btn_prev.addActionListener(new DateChangeListener());
		cbbx_date.addActionListener(new DateChangeListener());
		btn_next.addActionListener(new DateChangeListener());
		
		cbbx_date.setSelectedIndex(0);
	}
	
	private class DateChangeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			switch(ae.getActionCommand()){
			case PREV:
				cbbx_date.setSelectedIndex(cbbx_date.getSelectedIndex()+1);
				break;
			case NEXT:
				cbbx_date.setSelectedIndex(cbbx_date.getSelectedIndex()-1);
				break;
			default:
				if(cbbx_date.getSelectedIndex() == -1){
					dc.invalidDate();
					return;
				}
			}
			if(cbbx_date.getSelectedIndex() == cbbx_date.getItemCount()-1)
				btn_prev.setEnabled(false);
			else
				btn_prev.setEnabled(true);
			if(cbbx_date.getSelectedIndex() == 0)
				btn_next.setEnabled(false);
			else
				btn_next.setEnabled(true);
			
			Date date = cbbx_date.getItemAt(cbbx_date.getSelectedIndex()).date;
			dc.dateChange(date);
		}
	}
}
