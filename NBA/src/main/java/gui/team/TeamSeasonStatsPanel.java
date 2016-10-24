package gui.team;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import vo.TeamDefensiveFoulsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;
import businessLogicService.teamsBLService.TeamsBLService_new;
import enums.Teams;
import enums.Terminology;
import exceptions.TeamNotFound;
import exceptions.TermNotFound;
import gui.MainFrame;
import gui.util.NamedLabel;
import gui.util.StatsPanel;

public class TeamSeasonStatsPanel extends TeamStatsPanel {
	private static final long serialVersionUID = 9047422515279489675L;
	private static final String AVERAGE = "AVERAGE";
	private static final String TOTAL = "TOTAL";
	private JPanel pnl_stats;

	public TeamSeasonStatsPanel(TeamsBLService_new teambl, Teams team) {
		super(teambl, team);

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0,5,0,5));
		{
			JPanel pnl_title = new JPanel();
			pnl_title.setLayout(new BoxLayout(pnl_title,BoxLayout.X_AXIS));
			add(pnl_title,BorderLayout.NORTH);
			
			JLabel lbl_title = new JLabel("赛季数据:   ");
			pnl_title.add(lbl_title);
			try {
				TeamRatioGeneralVO ragevo_avg = teambl.getTeamRatioGeneralStatsAverage(MainFrame.season.season, team);
				NamedLabel lbl_games = new NamedLabel("比赛场数",String.valueOf(ragevo_avg.getGames()));
				pnl_title.add(lbl_games);
				pnl_title.add(Box.createHorizontalStrut(10));
				NamedLabel lbl_wins = new NamedLabel("获胜场数",ragevo_avg.getProperty(Terminology.GMWIN));
				pnl_title.add(lbl_wins);
				pnl_title.add(Box.createHorizontalStrut(10));
				NamedLabel lbl_winr = new NamedLabel("胜率",ragevo_avg.getProperty(Terminology.WINR),"%");
				pnl_title.add(lbl_winr);
			} catch (TeamNotFound e) {
				JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
				e.printStackTrace();
			} catch (TermNotFound e) {
				JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
				e.printStackTrace();
			}
			pnl_title.add(Box.createHorizontalGlue());
			
			JRadioButton rdibtn_average = new JRadioButton("平均");
			rdibtn_average.setActionCommand(AVERAGE);
			rdibtn_average.addActionListener(new TypeRadioButtonListener());
			rdibtn_average.setSelected(true);
			pnl_title.add(rdibtn_average);
			
			JRadioButton rdibtn_total = new JRadioButton("总计");
			rdibtn_total.setActionCommand(TOTAL);
			rdibtn_total.addActionListener(new TypeRadioButtonListener());
			pnl_title.add(rdibtn_total);
			
			ButtonGroup btngrp_type = new ButtonGroup();
			btngrp_type.add(rdibtn_average);
			btngrp_type.add(rdibtn_total);
		}
		
		pnl_stats = new JPanel(new CardLayout());
		add(pnl_stats);
		{// average stats
			try {
				TeamOffensiveStatsVO offvo = teambl.getTeamOffensiveStatsAverage(MainFrame.season.season, team);
				TeamDefensiveFoulsVO deffovo = teambl.getTeamDefensiveFoulsStatsAverage(MainFrame.season.season, team);
				TeamRatioGeneralVO ragevo = teambl.getTeamRatioGeneralStatsAverage(MainFrame.season.season, team);
				
				pnl_stats.add(StatsPanel.createTeamStatsPanel(offvo, deffovo, ragevo),AVERAGE);
			} catch (TeamNotFound e) {
				JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
				e.printStackTrace();
			}
			
		}
		{// total stats
			try {
				TeamOffensiveStatsVO offvo = teambl.getTeamOffensiveStatsTotal(MainFrame.season.season, team);
				TeamDefensiveFoulsVO deffovo = teambl.getTeamDefensiveFoulsStatsTotal(MainFrame.season.season, team);
				TeamRatioGeneralVO ragevo = teambl.getTeamRatioGeneralStatsTotal(MainFrame.season.season, team);
				
				pnl_stats.add(StatsPanel.createTeamStatsPanel(offvo, deffovo, ragevo),TOTAL);
			} catch (TeamNotFound e) {
				JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
				e.printStackTrace();
			}
		}
		
		((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, AVERAGE);
	}
	
	class TypeRadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, ae.getActionCommand());
		}
	}

}
