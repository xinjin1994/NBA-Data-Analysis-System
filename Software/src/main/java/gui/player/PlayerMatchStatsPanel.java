package gui.player;

import enums.Terminology;
import exceptions.MatchNotFound;
import exceptions.PlayerNotFound;
import exceptions.TermNotFound;
import gui.MainFrame;
import gui.match.MatchChangeable;
import gui.util.NamedLabel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.EnumMap;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import vo.MatchVO;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import businessLogicService.matchesBLService.MatchesBLService;
import businessLogicService.playersBLService.PlayersBLService_new;

public class PlayerMatchStatsPanel extends PlayerStatsPanel implements MatchChangeable{
	private static final long serialVersionUID = 6034767373557740775L;
	//private static final String NO_MATCH = "NO_MATCH";
	private Terminology[] term_basic;
	private String season;
	private Date date;

	public PlayerMatchStatsPanel(PlayersBLService_new playerService,String name) {
		this(playerService,name,Terminology.getPlayerMatchBasic(),15,new Insets(2,5,2,5),new Insets(5,5,5,5));
	}
	public PlayerMatchStatsPanel(PlayersBLService_new playerService,String name,Terminology[] term_basic
			,int fontSize,Insets insets_basic,Insets insets_advanced) {
		super(playerService,name);
		this.term_basic = term_basic;
		
		{
			JPanel pnl_seaStats = new JPanel(new BorderLayout());
			add(pnl_seaStats);
			
			JPanel pnl_seaTitle = new JPanel();
			pnl_seaTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
			//pnl_seaTitle.add(new JLabel("比赛数据"));
			
			rdibtn_basic = new JRadioButton("基础数据");
			rdibtn_basic.setFont(new Font("黑体",Font.BOLD,fontSize));
			rdibtn_basic.setActionCommand(BASIC);
			rdibtn_basic.addActionListener(new StatsRadioButtonListener());
			pnl_seaTitle.add(rdibtn_basic);
			
			rdibtn_advanced = new JRadioButton("进阶数据");
			rdibtn_advanced.setFont(new Font("黑体",Font.BOLD,fontSize));
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
				for(Terminology[] term = term_basic;i < term.length;i++){
					String unit = Terminology.getUnit(term[i]);
					NamedLabel labelPanel;
					labelPanel = new NamedLabel(term[i].toString(),unit);
					labelPanel.setFont(new Font("黑体",Font.BOLD,fontSize));
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.anchor = GridBagConstraints.LINE_START;
					gbc_labelPanel.insets = insets_basic;
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
					String unit = Terminology.getUnit(term[i]);
					NamedLabel labelPanel = new NamedLabel(term[i].toString(),unit);
					labelPanel.setFont(new Font("黑体",Font.BOLD,fontSize-2));
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.anchor = GridBagConstraints.LINE_START;
					gbc_labelPanel.insets = insets_advanced;
					gbc_labelPanel.gridx = i%2;
					gbc_labelPanel.gridy = i/2;
					pnl_advanced.add(labelPanel, gbc_labelPanel);
					labelMap_advanced.put(term[i], labelPanel);
				}
			}
			/*
			JLabel lbl_no_match = new JLabel("无比赛数据");
			lbl_no_match.setHorizontalAlignment(SwingConstants.CENTER);
			pnl_stats.add(lbl_no_match,NO_MATCH);
			*/
			
		}
	}
	
	private void setBasicStats(){
		try {
			PlayerBasicStatsVO bs = playerbl.getBasicStats(season, date, name);
			
			for(Terminology term:term_basic){
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
			PlayerAdvancedStatsVO bs = playerbl.getAdvancedPlayerStats(MainFrame.season.season,name);

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
	/*
	@Override
	public void noMatch() {
		rdibtn_basic.setEnabled(false);
		rdibtn_advanced.setEnabled(false);
		((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, NO_MATCH);
	}
	*/
	@Override
	public MatchVO getMatch(MatchesBLService matchbl, String season, Date date)
			throws MatchNotFound {
		return matchbl.getMatch(season, date, name);
	}


}
