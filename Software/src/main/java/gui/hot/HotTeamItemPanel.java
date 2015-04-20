package gui.hot;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.TeamHotStatsVO;
import vo.TeamVO;
import businessLogicService.teamsBLService.TeamsBLService_new;
import enums.Terminology;
import exceptions.TeamNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.player.PortraitPanel;
import gui.util.GUIUtility;
import gui.util.LabelPanel;

public class HotTeamItemPanel extends JPanel {
	private static final long serialVersionUID = -8038316105498505686L;
	private static final int RANK_NUMBER = 5;
	private static TeamsBLService_new teambl = new ObjectCreator().teamsBLService();
	private ArrayList<TeamHotStatsVO> teams;

	public HotTeamItemPanel(Terminology term) {
		teams = teambl.getHotTeams(MainFrame.season.season, term, RANK_NUMBER);
		
		if(teams.size() == 0){
			setLayout(new BorderLayout());
			add(new JLabel("该排名无数据"));
		}
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		LabelPanel lbl_stat = new LabelPanel(term,GUIUtility.formatDouble(teams.get(0).getStats()),true);
		lbl_stat.setAlignmentX(0.5f);
		add(lbl_stat);
		
		try {
			TeamVO vo = teambl.getTeamInfo(teams.get(0).getTeam());
			add(new PortraitPanel(vo.getImage(),vo.getName().toString(),0.5));
		} catch (TeamNotFound e) {
			add(new PortraitPanel(teams.get(0).getTeam().toString(),0.5));
		}
		
		JLabel lbl_team = new JLabel(teams.get(0).getConference().toString());
		lbl_team.setAlignmentX(0.5f);
		add(lbl_team);
		
		JButton btn_rank = new JButton("查看前5名");
		btn_rank.setAlignmentX(0.5f);
		add(btn_rank);
		btn_rank.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		add(Box.createVerticalGlue());
	}

}
