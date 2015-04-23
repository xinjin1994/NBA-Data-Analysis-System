package gui.team;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import vo.TeamVO;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.match.RecentMatchPanel;
import businessLogicService.teamsBLService.TeamsBLService_new;

public class TeamDetailPanel extends JPanel {
	private static final long serialVersionUID = -6532991967501331579L;
	private static TeamsBLService_new teambl = new ObjectCreator().teamsBLService();

	public TeamDetailPanel(TeamVO infovo) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setBorder(new EmptyBorder(5,5,5,5));
		
		JPanel pnl_row1 = new JPanel();
		add(pnl_row1);
		JLabel lbl_icon = new JLabel(infovo.getImage());
		pnl_row1.add(lbl_icon);
		
		pnl_row1.add(new TeamBasicInfoPanel(infovo));
		
		add(new TeamSeasonStatsPanel(teambl,infovo.getTeam()));
		add(Box.createVerticalStrut(10));
		
		JPanel pnl_row34 = new JPanel();
		pnl_row34.setLayout(new BoxLayout(pnl_row34,BoxLayout.Y_AXIS));
		add(pnl_row34);
		pnl_row34.setBorder(new LineBorder(Color.BLACK));
		ArrayList<Date> datelist = teambl.getAvailableDays(MainFrame.season.season, infovo.getTeam());
		TeamMatchStatsPanel pnl_match = new TeamMatchStatsPanel(teambl, infovo.getTeam());
		JPanel boxPanel = new JPanel();
		boxPanel.add(new RecentMatchPanel(datelist,pnl_match));
		pnl_row34.add(boxPanel);
		pnl_row34.add(pnl_match);
	}
}
