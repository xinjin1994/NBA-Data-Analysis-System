package gui.util.AdjustableTable;

import gui.MainFrame;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Component;

import javax.swing.Box;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import java.awt.Dimension;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdjustableTablePanel<T> extends JPanel {
	private static final long serialVersionUID = 3551612901989278341L;
	private Map<T,Boolean>[] attributes;
	private String[] tags;

	public AdjustableTablePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 8, 0, 0));
		
		JRadioButton rdibtn_average = new JRadioButton("平均");
		panel.add(rdibtn_average);
		
		JRadioButton rdibtn_total = new JRadioButton("总计");
		panel.add(rdibtn_total);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_1);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_2);
		
		JButton btn_basic = new JButton("基础数据");
		panel.add(btn_basic);
		
		JButton btn_advanced = new JButton("进阶数据");
		panel.add(btn_advanced);
		
		JButton btn_custom = new JButton("自定义数据");
		btn_custom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panel.add(btn_custom);
		
		
		
	}
	
}
