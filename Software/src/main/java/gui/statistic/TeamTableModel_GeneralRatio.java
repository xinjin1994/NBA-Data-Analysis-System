package gui.statistic;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vo.TeamRatioGeneralVO;

public class TeamTableModel_GeneralRatio extends AbstractTableModel {

	private static final long serialVersionUID = 6864903079434462186L;
	private String[] header = new String[]{"球队名称","比赛场数","投篮命中率","三分命中率","罚球命中率","胜率","助攻率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率"};
	private ArrayList<TeamRatioGeneralVO> data;
	
	public TeamTableModel_GeneralRatio(ArrayList<TeamRatioGeneralVO> data) {
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
		return data.size();
	}
	
	@Override
	public Class<?> getColumnClass(int col){
		return Object.class; 
	}
	
	public void updateData(ArrayList<TeamRatioGeneralVO> data){
		this.data = data;
		this.fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {
		TeamRatioGeneralVO vo = data.get(row);

		Object result = null;
		switch(col){
		case 0:
			result = vo.getTeam();
			break;
		case 1:
			result = vo.getGames();
			break;
		case 2:
			result = vo.getFieldGoalsPercentage();
			break;
		case 3:
			result = vo.getThreePointFieldGoalsPercentage();
			break;
		case 4:
			result = vo.getFreeThrowsPercentage();
			break;
		case 5:
			result = vo.getWinningRating();
			break;
		case 6:
			result = vo.getAssistsEfficiency();
			break;
		case 7:
			result = vo.getOffensiveRounds();
			break;
		case 8:
			result = vo.getOffensiveEfficiency();
			break;
		case 9:
			result = vo.getDefensiveEfficiency();
			break;
		case 10:
			result = vo.getOffensiveReboundsEfficiency();
			break;
		case 11:
			result = vo.getDefensiveReboundsEfficiency();
			break;
		case 12:
			result = vo.getStealsEfficiency();
			break;
		}
		if(result == null)
			return "数据缺失";
		return result;
	}

}
