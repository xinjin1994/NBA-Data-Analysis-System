package gui.util.AdjustableTable;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CheckComboBox<T> extends JComboBox<SelectionPair<T>> {
	private static final long serialVersionUID = 7621156045104740356L;
	private CheckListModel<T> model;
	
	public CheckComboBox(T[] data){
		{
			ArrayList<T> list = new ArrayList<T>(data.length);
			for(int i = 0;i < data.length;i++)
				list.add(data[i]);
			model = new CheckListModel<T>(list);
		}
		this.setModel(model);
		this.setRenderer(new CheckBoxListRenderer());
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent me) {
				if(me.getClickCount() == 1)
					model.changeSelected(CheckComboBox.this.getSelectedIndex());
			}
		});
	}
	
	class CheckBoxListRenderer implements ListCellRenderer<SelectionPair<T>>{
		@Override
		public Component getListCellRendererComponent(
				JList<? extends SelectionPair<T>> list, SelectionPair<T> value,
				int index, boolean isSelected, boolean cellHasFocus) {
			return new JCheckBox(value.toString(),value.selected);
		}
	}

}

