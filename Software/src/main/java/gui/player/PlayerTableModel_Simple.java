package gui.player;

import gui.util.GUIUtility;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vo.PlayerVO;


public class PlayerTableModel_Simple extends AbstractTableModel {

	private static final long serialVersionUID = 6864903079434462186L;
	private String[] header = new String[]{"头像","姓名","编号","位置","身高（英尺/英寸）","体重（磅）","生日","年龄","球龄","毕业学校"};
	private ArrayList<PlayerVO> data;

	public PlayerTableModel_Simple(ArrayList<PlayerVO> data) {
		this.data = data;
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}
	
	@Override
	public String getColumnName(int col){
		return header[col];
	}

	@Override
	public int getRowCount() {
		return data==null?0:data.size();
	}
	
	@Override
	public Class<?> getColumnClass(int col){
		if(col == 0) return Image.class;
		return Object.class; 
	}

	@Override
	public Object getValueAt(int row, int col) {
		PlayerVO pl = data.get(row);
		Object result = null;
		switch(col){
		case 0:
			break;
		case 1:
			result = pl.name;
			break;
		case 2:
			result = pl.number;
			break;
		case 3:
			result = pl.position.toString();
			break;
		case 4:
			result = GUIUtility.formatDouble(pl.height_Foot)+"/"+GUIUtility.formatDouble(pl.height_Inch);
			break;
		case 5:
			result = GUIUtility.formatDouble(pl.weight_Pounds);
			break;
		case 6:
			result = pl.birthday;
			break;
		case 7:
			result = String.valueOf(pl.age);
			break;
		case 8:
			result = String.valueOf(pl.exp);
			break;
		case 9:
			result = pl.school;
			break;
		}
		if(result == null)
			return "数据缺失";
		return result;
	}

}
