package gui.player;

import enums.Terminology;
import gui.util.NamedLabel;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.EnumMap;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import businessLogicService.playersBLService.PlayersBLService_new;

public abstract class PlayerStatsPanel extends JPanel {
	private static final long serialVersionUID = -3249125400249374154L;
	protected static final String BASIC = "BASIC";
	protected static final String ADVANCED = "ADVANCED";
	protected PlayersBLService_new playerbl;
	protected String name;
	protected EnumMap<Terminology,NamedLabel> labelMap_basic;
	protected EnumMap<Terminology,NamedLabel> labelMap_advanced;
	protected JRadioButton rdibtn_basic;
	protected JRadioButton rdibtn_advanced;
	protected JPanel pnl_stats;
	
	public PlayerStatsPanel(PlayersBLService_new playerService,String name) {
		this.playerbl = playerService;
		this.name = name;
	}

	public void setKeyTerm(Terminology term) {
		NamedLabel lbl = null;
		if(labelMap_basic.containsKey(term)){
			lbl = labelMap_basic.get(term);
			rdibtn_basic.setEnabled(true);
			((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, BASIC);
		}
		else if(labelMap_advanced.containsKey(term)){
			lbl = labelMap_advanced.get(term);
			rdibtn_advanced.setEnabled(true);
			((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, ADVANCED);
		}
		else return;
		lbl.setForeground(Color.RED);
	}
	
}
