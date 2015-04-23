package gui.util;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.util.EnumMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import enums.Terminology;
import exceptions.TermNotFound;
import gui.MainFrame;
import vo.StatsVO;
import vo.TeamDefensiveFoulsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;

public class StatsPanel extends JPanel{
	private static final long serialVersionUID = -4899327756987205969L;
	private Map<Terminology,NamedLabel> map = new EnumMap<Terminology,NamedLabel>(Terminology.class);
	
	public StatsPanel(){
		super();
	}
	public StatsPanel(LayoutManager l){
		super(l);
	}
	
	public void setKeyProperty(Terminology term,Color c){
		NamedLabel nl = map.get(term);
		if(nl != null)
			nl.setForeground(c);
	}

	public static StatsPanel createTeamStatsPanel(TeamOffensiveStatsVO offvo,TeamDefensiveFoulsVO deffovo,TeamRatioGeneralVO ragevo){
		StatsPanel pnl_stats = new StatsPanel();
		pnl_stats.setLayout(new BoxLayout(pnl_stats,BoxLayout.X_AXIS));
		
		StatsPanel pnl = buildStatsPanel("进攻数据：",Terminology.getTeamOffensive(),offvo,2);
		pnl_stats.map.putAll(pnl.map);
		pnl_stats.add(pnl);
		pnl = buildStatsPanel("防守数据：",Terminology.getTeamDefensive(),deffovo,2);
		pnl_stats.map.putAll(pnl.map);
		pnl_stats.add(pnl);
		pnl = buildStatsPanel("犯规数据：",Terminology.getTeamFouls(),deffovo,1);
		pnl_stats.map.putAll(pnl.map);
		pnl_stats.add(pnl);
		pnl = buildStatsPanel("比率：",Terminology.getTeamRatio(),ragevo,1);
		pnl_stats.map.putAll(pnl.map);
		pnl_stats.add(pnl);
		pnl = buildStatsPanel("综合数据：",Terminology.getTeamGeneral(),ragevo,2);
		pnl_stats.map.putAll(pnl.map);
		pnl_stats.add(pnl);
		
		return pnl_stats;
	}
	
	public static StatsPanel buildStatsPanel(String title,Terminology[] terms,StatsVO vo,int col){
		GridLayout gridlay = new GridLayout((int)Math.ceil(terms.length/(double)col)+1,col,10,10);
		StatsPanel pnl_stats = new StatsPanel(gridlay);
		
		JLabel lbl_title = new JLabel(title);
		pnl_stats.add(lbl_title);
		for(int i = 0;i < col-1;i++)
			pnl_stats.add(Box.createHorizontalStrut(1));
		
		for(Terminology term:terms){
			try {
				NamedLabel lbl = new NamedLabel(term,vo.getProperty(term),false);
				
				lbl.setAlignmentX(0);
				pnl_stats.add(lbl);
				pnl_stats.map.put(term, lbl);
			} catch (TermNotFound e) {
				JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
				e.printStackTrace();
			}
		}
		
		pnl_stats.setBorder(new CompoundBorder(new LineBorder(Color.BLACK),new EmptyBorder(0,5,0,5)));
		return pnl_stats;
	}

}
