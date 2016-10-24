package gui.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class LeftAlignTableRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = -2523889612380403370L;

	@Override
	public
	Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus, int row, int column){
		JLabel label = new JLabel();
		label.setBackground(Color.WHITE);
		label.setHorizontalTextPosition(SwingConstants.LEADING);
		label.setFont(new Font(label.getFont().getName(),Font.PLAIN,label.getFont().getSize()));
		if(table.getModel().getColumnClass(column) == int.class || table.getModel().getColumnClass(column) == Integer.class){
			label.setText(String.valueOf((int)value));
			return label;
		}
		else if(table.getModel().getColumnClass(column) == double.class || table.getModel().getColumnClass(column) == Double.class){
			label.setText(GUIUtility.formatDouble((double)value));
			return label;
		}
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}

}
