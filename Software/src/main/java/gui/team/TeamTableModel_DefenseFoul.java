package gui.team;

import gui.util.GUIUtility;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vo.TeamDefensiveFoulsVO;

public class TeamTableModel_DefenseFoul extends AbstractTableModel {

	private static final long serialVersionUID = 6864903079434462186L;
	private String[] header = new String[]{"球队名称","比赛场数","进攻篮板数","防守篮板数","篮板数","抢断数","盖帽数","失误数","犯规数"};
	private ArrayList<TeamDefensiveFoulsVO> data;
	
	public TeamTableModel_DefenseFoul(ArrayList<TeamDefensiveFoulsVO> data) {
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
	
	public void updateData(ArrayList<TeamDefensiveFoulsVO> data){
		this.data = data;
		this.fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {
		TeamDefensiveFoulsVO vo = data.get(row);

		Object result = null;
		switch(col){
		case 0:
			result = vo.getTeam().toString();
			break;
		case 1:
			result = String.valueOf(vo.getGames());
			break;
		case 2:
			result = GUIUtility.formatDouble(vo.getOffensiveRebounds());
			break;
		case 3:
			result = GUIUtility.formatDouble(vo.getDefensiveRebounds());
			break;
		case 4:
			result = GUIUtility.formatDouble(vo.getRebounds());
			break;
		case 5:
			result = GUIUtility.formatDouble(vo.getSteals());
			break;
		case 6:
			result = GUIUtility.formatDouble(vo.getBlocks());
			break;
		case 7:
			result = GUIUtility.formatDouble(vo.getTurnovers());
			break;
		case 8:
			result = GUIUtility.formatDouble(vo.getFouls());
			break;
		}
		if(result == null)
			return "数据缺失";
		return result;
	}

}
