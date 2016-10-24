package gui.util.AdjustableTable;

class SelectionPair<T>{
	T value;
	boolean selected;
	SelectionPair(T value){
		this(value,false);
	}
	SelectionPair(T value,boolean selected){
		this.value = value;
		this.selected = selected;
	}
	
	@Override
	public String toString(){
		if(value!=null)
			return value.toString();
		return "";
	}
}
