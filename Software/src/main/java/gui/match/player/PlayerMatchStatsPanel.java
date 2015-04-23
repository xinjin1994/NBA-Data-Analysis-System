package gui.match.player;

import enums.Terminology;
import exceptions.MatchNotFound;
import exceptions.PlayerNotFound;
import exceptions.TermNotFound;
import gui.MainFrame;
import gui.match.MatchChangeable;
import gui.player.detail.PlayerStatsPanel;
import gui.util.NamedLabel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.EnumMap;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import vo.MatchVO;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import businessLogicService.matchesBLService.MatchesBLService;
import businessLogicService.playersBLService.PlayersBLService_new;

public class PlayerMatchStatsPanel extends PlayerStatsPanel implements MatchChangeable{
	private static final long serialVersionUID = 6034767373557740775L;
	private PlayersBLService_new playerService;
	private String name;
	private static final String BASIC = "BASIC";
	private static final String ADVANCED = "ADVANCED";
	private static final String NO_MATCH = "NO_MATCH";
	protected EnumMap<Terminology,NamedLabel> labelMap_basic;
	protected EnumMap<Terminology,NamedLabel> labelMap_advanced;
	private JPanel pnl_stats;
	private String season;
	private Date date;
	private JRadioButton rdibtn_basic;
	private JRadioButton rdibtn_advanced;

	public PlayerMatchStatsPanel(PlayersBLService_new playerService,String name) {
		super(playerService,name);
		
		this.playerService = playerService;
		this.name = name;
		{
			JPanel pnl_seaStats = new JPanel(new BorderLayout());
			add(pnl_seaStats);
			
			JPanel pnl_seaTitle = new JPanel();
			pnl_seaTitle.setLayout(new FlowLayout(FlowLayout.LEADING));
			pnl_seaTitle.add(new JLabel("比赛数据"));
			
			rdibtn_basic = new JRadioButton("基础数据");
			rdibtn_basic.setActionCommand(BASIC);
			rdibtn_basic.addActionListener(new StatsRadioButtonListener());
			pnl_seaTitle.add(rdibtn_basic);
			
			rdibtn_advanced = new JRadioButton("进阶数据");
			rdibtn_advanced.setActionCommand(ADVANCED);
			rdibtn_advanced.addActionListener(new StatsRadioButtonListener());
			pnl_seaTitle.add(rdibtn_advanced);
			
			ButtonGroup btngrp_stats = new ButtonGroup();
			btngrp_stats.add(rdibtn_basic);
			btngrp_stats.add(rdibtn_advanced);
			btngrp_stats.setSelected(rdibtn_basic.getModel(), true);
			
			
			pnl_seaStats.add(pnl_seaTitle,BorderLayout.NORTH);
			
			pnl_stats = new JPanel(new CardLayout());
			pnl_seaStats.add(pnl_stats);
			{
				JPanel pnl_basic = new JPanel();
				pnl_stats.add(pnl_basic,BASIC);
				GridBagLayout gbl_pnl_tech = new GridBagLayout();
				pnl_basic.setLayout(gbl_pnl_tech);
				
				labelMap_basic = new EnumMap<Terminology,NamedLabel>(Terminology.class);
				int i = 0;
				for(Terminology[] term = Terminology.getPlayerMatchBasic();i < term.length;i++){
					String unit = "";
					if(term[i] == Terminology.FGP||term[i] == Terminology.TPP||term[i] == Terminology.FTP)
						unit = "%";
					NamedLabel labelPanel = new NamedLabel(term[i].toString(),unit);
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = i%2;
					gbc_labelPanel.gridy = i/2;
					pnl_basic.add(labelPanel, gbc_labelPanel);
					labelMap_basic.put(term[i], labelPanel);
				}
				
			}
			{
				JPanel pnl_advanced = new JPanel();
				pnl_stats.add(pnl_advanced,ADVANCED);
				GridBagLayout gbl_pnl_advanced = new GridBagLayout();
				pnl_advanced.setLayout(gbl_pnl_advanced);
				
				labelMap_advanced = new EnumMap<Terminology,NamedLabel>(Terminology.class);
				int i = 0;
				for(Terminology[] term = Terminology.getPlayerAdvanced();i < term.length;i++){
					NamedLabel labelPanel = new NamedLabel(term[i].toString(),"%");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = i%2;
					gbc_labelPanel.gridy = i/2;
					pnl_advanced.add(labelPanel, gbc_labelPanel);
					labelMap_advanced.put(term[i], labelPanel);
				}
			}
			JLabel lbl_no_match = new JLabel("无比赛数据");
			lbl_no_match.setHorizontalAlignment(SwingConstants.CENTER);
			pnl_stats.add(lbl_no_match,NO_MATCH);
			
			noMatch();
		}
	}
	public PlayerMatchStatsPanel(PlayersBLService_new playerService,String name,String season, Date date) {
		this(playerService,name);
		setMatch(season,date);
	}
	public PlayerMatchStatsPanel(PlayersBLService_new playerService,String name,String season, Date date,Terminology term) {
		this(playerService,name,season,date);
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
	
	private void setBasicStats(){
		try {
			PlayerBasicStatsVO bs = playerService.getBasicStats(season, date, name);
			
			for(Terminology term:Terminology.getPlayerMatchBasic()){
				labelMap_basic.get(term).setText(bs.getProperty(term));
			}
		} catch (PlayerNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		} catch (TermNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		}
	}
	

	private void setAdvancedStats(){
		try {
			PlayerAdvancedStatsVO bs = playerService.getAdvancedPlayerStats(MainFrame.season.season,name);

			for(Terminology term:Terminology.getPlayerAdvanced()){
				labelMap_advanced.get(term).setText(bs.getProperty(term));
			}
		} catch (PlayerNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
		} catch (TermNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		}
		
	}

	private class StatsRadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, ae.getActionCommand());
		}
	}

	@Override
	public void setMatch(String season, Date date){
		this.season = season;
		this.date = date;
		
		rdibtn_basic.setEnabled(true);
		rdibtn_advanced.setEnabled(true);
		if(rdibtn_basic.isSelected())
			((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, BASIC);
		else if(rdibtn_advanced.isSelected())
			((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, ADVANCED);
		setBasicStats();
		setAdvancedStats();
	}

	@Override
	public void noMatch() {
		rdibtn_basic.setEnabled(false);
		rdibtn_advanced.setEnabled(false);
		((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, NO_MATCH);
	}
	@Override
	public MatchVO getMatch(MatchesBLService matchbl, String season, Date date)
			throws MatchNotFound {
		return matchbl.getMatch(season, date, name);
	}


}
