package gui.team;

import gui.util.GUIUtility;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vo.TeamGeneralStatsVO;
import vo.TeamRatioStatsVO;

public class TeamTableModel_GeneralRatio extends AbstractTableModel {

	private static final long serialVersionUID = 6864903079434462186L;
	private String[] header = new String[]{"球队名称","比赛场数","投篮命中率","三分命中率","罚球命中率","胜率","助攻率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率"};
	private ArrayList<TeamRatioStatsVO> data1;
	private ArrayList<TeamGeneralStatsVO> data2;
	
	public TeamTableModel_GeneralRatio(ArrayList<TeamRatioStatsVO> data1,ArrayList<TeamGeneralStatsVO> data2) {
		this.data1 = data1;
		this.data2 = data2;
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
		return data1.size()>data2.size()?data1.size():data2.size();
	}
	
	@Override
	public Class<?> getColumnClass(int col){
		return Object.class; 
	}
	
	public void updateData(ArrayList<TeamRatioStatsVO> data1,ArrayList<TeamGeneralStatsVO> data2){
		this.data1 = data1;
		this.data2 = data2;
		this.fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {
		TeamRatioStatsVO tr = data1.get(row);
		TeamGeneralStatsVO tg = data2.get(row);

		Object result = null;
		switch(col){
		case 0:
			result = tr.getTeam().toString();
			break;
		case 1:
			result = String.valueOf(tr.getGames());
			break;
		case 2:
			result = GUIUtility.formatDouble(tr.getFieldGoalsPercentage());
			break;
		case 3:
			result = GUIUtility.formatDouble(tr.getThreePointFieldGoalsPercentage());
			break;
		case 4:
			result = GUIUtility.formatDouble(tr.getFreeThrowsPercentage());
			break;
		case 5:
			result = GUIUtility.formatDouble(tr.getWinningRating());
			break;
		case 6:
			result = GUIUtility.formatDouble(tg.getAssistsEfficiency());
			break;
		case 7:
			result = GUIUtility.formatDouble(tg.getOffensiveRounds());
			break;
		case 8:
			result = GUIUtility.formatDouble(tg.getOffensiveEfficiency());
			break;
		case 9:
			result = GUIUtility.formatDouble(tg.getOffensiveReboundsEfficiency());
			break;
		case 10:
			result = GUIUtility.formatDouble(tg.getDefensiveReboundsEfficiency());
			break;
		case 11:
			result = GUIUtility.formatDouble(tg.getStealsEfficiency());
			break;
		}
		if(result == null)
			return "数据缺失";
		return result;
	}

}
