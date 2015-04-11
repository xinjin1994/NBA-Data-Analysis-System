package gui.util.AdjustableTable;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class CheckListModel<T> extends AbstractListModel<SelectionPair<T>>
	implements ComboBoxModel<SelectionPair<T>> {
	
	private static final long serialVersionUID = -7705703401981958633L;
	ArrayList<SelectionPair<T>> data;
	
	public CheckListModel(ArrayList<? extends T> data) {
		if(data!=null){
			this.data = new ArrayList<SelectionPair<T>>(data.size());
			for(T item:data)
				this.data.add(new SelectionPair<T>(item));
		}
		else this.data = new ArrayList<SelectionPair<T>>();
	}

	@Override
	public int getSize() {
		return data.size();
	}

	@Override
	public SelectionPair<T> getElementAt(int index) {
		return data.get(index);
	}

	public void changeSelected(int index){
		data.get(index).selected = !data.get(index).selected;
		this.fireContentsChanged(this, index, index);
	}
	
	public ArrayList<T> getSelected(){
		ArrayList<T> result = new ArrayList<T>(data.size()/2);
		for(SelectionPair<T> sp:data)
			if(sp.selected) result.add(sp.value);
		return result;
	}
	
	@Override
	public Object getSelectedItem() {
		for(SelectionPair<T> sp:data)
			if(sp.selected) return sp;
		return new SelectionPair<T>(null);
	}
	
	@Override
	public void setSelectedItem(Object anItem) {
		//do nothing
	}
	
}
