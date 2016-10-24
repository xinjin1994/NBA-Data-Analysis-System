package gui.statistic;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vo.PlayerBasicStatsVO;

public class PlayerTableModel_Basic extends AbstractTableModel {

	private static final long serialVersionUID = 6864903079434462186L;
	private String[] header = new String[]{"姓名","参赛场数","先发场数","篮板数","助攻数","在场时间","投篮命中率/%","三分命中率/%","罚球命中率/%","进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","得分/篮板/助攻","两双"};
	private ArrayList<PlayerBasicStatsVO> data;

	public PlayerTableModel_Basic(ArrayList<PlayerBasicStatsVO> data) {
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
		return getValueAt(1,col).getClass(); 
	}
	
	public void updateData(ArrayList<PlayerBasicStatsVO> data){
		this.data = data;
		this.fireTableDataChanged();
	}

	@Override
	public Object getValueAt(int row, int col) {
		PlayerBasicStatsVO pl = data.get(row);

		Object result = null;
		switch(col){
		case 0:
			result = pl.getName();
			break;
		case 1:
			result = pl.getGames();
			break;
		case 2:
			result = pl.getGamesStarting();
			break;
		case 3:
			result = pl.getRebounds();
			break;
		case 4:
			result = pl.getAssists();
			break;
		case 5:
			result = pl.getMinutes();
			break;
		case 6:
			result = pl.getFieldGoalPercentage();
			break;
		case 7:
			result = pl.getThreePointFieldGoalPercentage();
			break;
		case 8:
			result = pl.getFreeThrowPercentage();
			break;
		case 9:
			result = pl.getOffensiveRebounds();
			break;
		case 10:
			result = pl.getDefensiveRebounds();
			break;
		case 11:
			result = pl.getSteals();
			break;
		case 12:
			result = pl.getBlocks();
			break;
		case 13:
			result = pl.getTurnovers();
			break;
		case 14:
			result = pl.getPersonalFouls();
			break;
		case 15:
			result = pl.getPoints();
			break;
		case 16:
			result = pl.getPoints()+pl.getRebounds()+pl.getAssists();
			break;
		case 17:
			result = pl.getDoubleDoubles();
			/*int doubledouble = 0;
			if(pl.getRebounds() >= 10)
				doubledouble++;
			if(pl.getAssists() >= 10)
				doubledouble++;
			if(pl.getPoints() >= 10)
				doubledouble++;
			if(pl.getBlocks() >= 10)
				doubledouble++;
			if(pl.getSteals() >= 10)
				doubledouble++;
			result = String.valueOf(doubledouble);
			*/
			break;
		}
		if(result == null)
			return "数据缺失";
		return result;
	}

}
