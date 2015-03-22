package gui.team;

import gui.util.GUIUtility;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vo.TeamDefensiveStatsVO;
import vo.TeamFoulsStatsVO;

public class TeamTableModel_DefenseFoul extends AbstractTableModel {

	private static final long serialVersionUID = 6864903079434462186L;
	private String[] header = new String[]{"球队名称","比赛场数","进攻篮板数","防守篮板数","篮板数","抢断数","盖帽数","失误数","犯规数"};
	private ArrayList<TeamDefensiveStatsVO> data1;
	private ArrayList<TeamFoulsStatsVO> data2;
	
	public TeamTableModel_DefenseFoul(ArrayList<TeamDefensiveStatsVO> data1,ArrayList<TeamFoulsStatsVO> data2) {
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
	
	public void updateData(ArrayList<TeamDefensiveStatsVO> data1,ArrayList<TeamFoulsStatsVO> data2){
		this.data1 = data1;
		this.data2 = data2;
		this.fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {
		TeamDefensiveStatsVO td = data1.get(row);
		TeamFoulsStatsVO tf = data2.get(row);

		Object result = null;
		switch(col){
		case 0:
			result = td.getTeam().toString();
			break;
		case 1:
			result = String.valueOf(td.getGames());
			break;
		case 2:
			result = GUIUtility.formatDouble(td.getOffensiveRebounds());
			break;
		case 3:
			result = GUIUtility.formatDouble(td.getDefensiveRebounds());
			break;
		case 4:
			result = GUIUtility.formatDouble(td.getRebounds());
			break;
		case 5:
			result = GUIUtility.formatDouble(td.getSteals());
			break;
		case 6:
			result = GUIUtility.formatDouble(td.getBlocks());
			break;
		case 7:
			result = GUIUtility.formatDouble(tf.getTurnovers());
			break;
		case 8:
			result = GUIUtility.formatDouble(tf.getFouls());
			break;
		}
		if(result == null)
			return "数据缺失";
		return result;
	}

}
