package gui.statistic;

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
		return getValueAt(0,col).getClass(); 
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
			result = pl.getEfficiency();
			break;
		case 2:
			result = pl.getGmSc();
			break;
		case 3:
			result = pl.getTrueScorePercent();
			break;
		case 4:
			result = pl.getFieldGoalEfficiency();
			break;
		case 5:
			result = pl.getReboundsPercent();
			break;
		case 6:
			result = pl.getOffensiveReboundsPercent();
			break;
		case 7:
			result = pl.getDefensiveReboundsPercent();
			break;
		case 8:
			result = pl.getAssistsPercent();
			break;
		case 9:
			result = pl.getStealsPercent();
			break;
		case 10:
			result = pl.getBlocksPercent();
			break;
		case 11:
			result = pl.getTurnoversPercent();
			break;
		case 12:
			result = pl.getUsagePercent();
			break;
		}
		if(result == null)
			return "数据缺失";
		return result;
	}

}
