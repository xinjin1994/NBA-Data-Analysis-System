package gui.util.AdjustableTable;

import gui.MainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChooseAttributeDialog<T> extends JDialog {
	private static final long serialVersionUID = -9035422960469472058L;
	private final JPanel contentPanel = new JPanel();
	private final int COLUMNS = 5;
	private ArrayList<JCheckBox> boxes;
	private ArrayList<T> items;
	private final AttributesAdjustable<T> owner;

	public ChooseAttributeDialog(ArrayList<Map<T,Boolean>> groups,String[] tags,AttributesAdjustable<T> owner) {
		super(MainFrame.currentFrame, "自定义数据",true);

		this.owner = owner;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().setLayout(new BorderLayout());
		int cells = 0;
		int rows = 0;
		for(Map<T,Boolean> group:groups){
			rows += 1+Math.ceil(group.size()/(double)COLUMNS);
			cells += group.size();
		}
		contentPanel.setLayout(new GridLayout(rows,COLUMNS,5,5));
		
		boxes = new ArrayList<JCheckBox>(cells);
		items = new ArrayList<T>(cells);
		for(int i = 0;i < groups.size();i++){
			//add tag
			contentPanel.add(new JLabel(tags[i]+":"));
			//fill the row
			for(int j = 0;j < COLUMNS-1;j++)
				contentPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			// add check boxes
			for(Entry<T,Boolean> entry:groups.get(i).entrySet()){
				JCheckBox box = new JCheckBox(entry.getKey().toString());
				box.setSelected(entry.getValue());
				contentPanel.add(box);
				boxes.add(box);
				items.add(entry.getKey());
			}
			//fill the block
			for(int j = 0;j < (0-groups.get(i).size())%COLUMNS;j++)
				contentPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		}
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_confirm = new JButton("确定");
				btn_confirm.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<T> selected = new ArrayList<T>(boxes.size()/2);
						for(int i = 0;i < boxes.size();i++)
							if(boxes.get(i).isSelected())
								selected.add(items.get(i));
						ChooseAttributeDialog.this.owner.adjust(selected);
						dispose();
					}
				});
				buttonPane.add(btn_confirm);
				getRootPane().setDefaultButton(btn_confirm);
			}
			{
				JButton btn_cancel = new JButton("取消");
				btn_cancel.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btn_cancel);
			}
		}
		pack();
	}

}
