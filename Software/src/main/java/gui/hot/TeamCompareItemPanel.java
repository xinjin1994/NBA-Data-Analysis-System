package gui.hot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vo.TeamDefensiveFoulsVO;
import vo.TeamHotStatsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;
import vo.TeamVO;
import businessLogicService.teamsBLService.TeamsBLService_new;
import enums.Terminology;
import exceptions.TeamNotFound;
import exceptions.TermNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.player.PortraitPanel;
import gui.team.TeamDialog;
import gui.util.NamedLabel;
import gui.util.StatsPanel;

public class TeamCompareItemPanel extends JPanel {
	private static final long serialVersionUID = -8038316105498505686L;
	private static TeamsBLService_new teambl = new ObjectCreator().teamsBLService();
	private TeamVO vo;

//	public void paintComponent(Graphics gs) {  
//        Graphics2D g = (Graphics2D) gs;  
////        super.paintComponent(g);  
//        Paint p = new Color(0,0,0,0);
//        g.setPaint(p);
//        g.fillRect(0, 0, getWidth(), getHeight());
//	}
	public TeamCompareItemPanel(int rank,String season,Terminology term,TeamHotStatsVO hotvo){
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		
		JLabel lbl_rank = new JLabel(String.valueOf(rank));
		lbl_rank.setFont(new Font(lbl_rank.getFont().getName(),Font.BOLD,20));
		lbl_rank.setAlignmentX(0.5f);
		add(lbl_rank);
		
		Box box_portrait = Box.createVerticalBox();
		add(box_portrait);
		try {
			vo = teambl.getTeamInfo(hotvo.getTeam());
			box_portrait.add(new PortraitPanel(vo.getImage(),hotvo.getTeam().toString(),0.4));
		} catch (TeamNotFound e) {
			box_portrait.add(new PortraitPanel(hotvo.getTeam().toString(),0.4));
		}
		
		JLabel lbl_team = new JLabel(hotvo.getConference().toString()+"  "+hotvo.getDivision().toString());
		lbl_team.setAlignmentX(0.5f);
		box_portrait.add(lbl_team);
		
		Box box_stats = Box.createVerticalBox();
		add(box_stats);
		try {
			TeamRatioGeneralVO ragevo_avg = teambl.getTeamRatioGeneralStatsAverage(MainFrame.season.season, hotvo.getTeam());
			NamedLabel lbl_games = new NamedLabel("比赛场数",String.valueOf(ragevo_avg.getGames()));
			lbl_games.setAlignmentX(0.5f);
			box_stats.add(lbl_games);
			NamedLabel lbl_wins = new NamedLabel("获胜场数",ragevo_avg.getProperty(Terminology.GMWIN));
			lbl_wins.setAlignmentX(0.5f);
			box_stats.add(lbl_wins);
			NamedLabel lbl_winr = new NamedLabel("胜率",ragevo_avg.getProperty(Terminology.WINR));
			lbl_winr.setAlignmentX(0.5f);
			box_stats.add(lbl_winr);
		} catch (TeamNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		} catch (TermNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		}

		try {
			TeamOffensiveStatsVO offvo = teambl.getTeamOffensiveStatsAverage(MainFrame.season.season, hotvo.getTeam());
			TeamDefensiveFoulsVO deffovo = teambl.getTeamDefensiveFoulsStatsAverage(MainFrame.season.season, hotvo.getTeam());
			TeamRatioGeneralVO ragevo = teambl.getTeamRatioGeneralStatsAverage(MainFrame.season.season, hotvo.getTeam());
			
			StatsPanel pnl_stats = StatsPanel.createTeamStatsPanel(offvo, deffovo, ragevo);
			pnl_stats.setAlignmentX(0.5f);
			pnl_stats.setKeyProperty(term, Color.RED);
			add(pnl_stats);
		} catch (TeamNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		}
		
		JButton btn_rank = new JButton("查看球队详情");
		btn_rank.setAlignmentX(0.5f);
		box_stats.add(btn_rank);
		btn_rank.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.showDialog(new TeamDialog(vo));
			}
		});
	}

}
