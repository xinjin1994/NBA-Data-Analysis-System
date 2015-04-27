package gui.statistic;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vo.TeamOffensiveStatsVO;

public class TeamTableModel_Offence extends AbstractTableModel {

	private static final long serialVersionUID = 6864903079434462186L;
	private String[] header = new String[]{"球队名称","比赛场数","比赛得分","投篮命中数","投篮出手数","罚球出手数","罚球命中数","三分出手数","三分命中数","助攻数"};
	private ArrayList<TeamOffensiveStatsVO> data;

	public TeamTableModel_Offence(ArrayList<TeamOffensiveStatsVO> data) {
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
	
	public void updateData(ArrayList<TeamOffensiveStatsVO> data){
		this.data = data;
		this.fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {
		TeamOffensiveStatsVO t = data.get(row);

		Object result = null;
		switch(col){
		case 0:
			result = t.getTeam();
			break;
		case 1:
			result = t.getGames();
			break;
		case 2:
			result = t.getPoints();
			break;
		case 3:
			result = t.getFieldGoalsMade();
			break;
		case 4:
			result = t.getFieldGoalsAttempted();
			break;
		case 5:
			result = t.getFreeThrowsMade();
			break;
		case 6:
			result = t.getFreeThrowsAttempted();
			break;
		case 7:
			result = t.getThreePointFieldGoalsMade();
			break;
		case 8:
			result = t.getThreePointFieldGoalsAttempted();
			break;
		case 9:
			result = t.getAssists();
			break;
		}
		if(result == null)
			return "数据缺失";
		return result;
	}

}
