package gui.statistic;

import gui.util.GUIUtility;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vo.PlayerAdvancedStatsVO;

public class PlayerTableModel_Advanced extends AbstractTableModel {

	private static final long serialVersionUID = 6864903079434462186L;
	private String[] header = new String[]{"姓名","效率/%","GmSc效率值/%","真实命中率/%","投篮效率/%","篮板率/%","进攻篮板率/%","防守篮板率/%","助攻率/%","抢断率/%","盖帽率/%","失误率/%","使用率/%"};
	private ArrayList<PlayerAdvancedStatsVO> data;

	public PlayerTableModel_Advanced(ArrayList<PlayerAdvancedStatsVO> data) {
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
		return Object.class; 
	}
	
	public void updateData(ArrayList<PlayerAdvancedStatsVO> data){
		this.data = data;
		this.fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {
		PlayerAdvancedStatsVO pl = data.get(row);

		Object result = null;
		switch(col){
		case 0:
			result = pl.getName();
			break;
		case 1:
			result = GUIUtility.formatDouble(pl.getEfficiency());
			break;
		case 2:
			result = GUIUtility.formatDouble(pl.getGmSc());
			break;
		case 3:
			result = GUIUtility.formatDouble(pl.getTrueScorePercent());
			break;
		case 4:
			result = GUIUtility.formatDouble(pl.getFieldGoalEfficiency());
			break;
		case 5:
			result = GUIUtility.formatDouble(pl.getReboundsPercent());
			break;
		case 6:
			result = GUIUtility.formatDouble(pl.getOffensiveReboundsPercent());
			break;
		case 7:
			result = GUIUtility.formatDouble(pl.getDefensiveReboundsPercent());
			break;
		case 8:
			result = GUIUtility.formatDouble(pl.getAssistsPercent());
			break;
		case 9:
			result = GUIUtility.formatDouble(pl.getStealsPercent());
			break;
		case 10:
			result = GUIUtility.formatDouble(pl.getBlocksPercent());
			break;
		case 11:
			result = GUIUtility.formatDouble(pl.getTurnoversPercent());
			break;
		case 12:
			result = GUIUtility.formatDouble(pl.getUsagePercent());
			break;
		}
		if(result == null)
			return "数据缺失";
		return result;
	}

}
