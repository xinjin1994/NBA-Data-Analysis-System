package gui.team;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import vo.MatchVO;
import vo.TeamDefensiveFoulsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;
import businessLogicService.matchesBLService.MatchesBLService;
import businessLogicService.teamsBLService.TeamsBLService_new;
import enums.Teams;
import enums.Terminology;
import exceptions.MatchNotFound;
import exceptions.TeamNotFound;
import exceptions.TermNotFound;
import gui.MainFrame;
import gui.match.MatchChangeable;
import gui.util.NamedLabel;
import gui.util.StatsPanel;

public class TeamMatchStatsPanel extends TeamStatsPanel implements MatchChangeable{
	private static final long serialVersionUID = 9047422515279489625L;
	private static final String DAY = "DAY";
	private static final String NO_MATCH = "NO_MATCH";
	private JPanel pnl_stats;

	public TeamMatchStatsPanel(TeamsBLService_new teambl, Teams team) {
		super(teambl, team);

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0,5,0,5));
		{
			JPanel pnl_title = new JPanel();
			pnl_title.setLayout(new BoxLayout(pnl_title,BoxLayout.X_AXIS));
			add(pnl_title,BorderLayout.NORTH);
			
			JLabel lbl_title = new JLabel("比赛数据:   ");
			pnl_title.add(lbl_title);
		}
		
		pnl_stats = new JPanel(new CardLayout());
		add(pnl_stats);
		{// average stats
			
			
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
		
		
	}

	@Override
	public void setMatch(String season, Date date) {
		try {
			TeamOffensiveStatsVO offvo = teambl.getOffensiveStats(MainFrame.season.season, date, team);
			TeamDefensiveFoulsVO deffovo = teambl.getDefensiveStats(MainFrame.season.season, date, team);
			TeamRatioGeneralVO ragevo = teambl.getRatioStats(MainFrame.season.season, date, team);
			
			pnl_stats.add(StatsPanel.createTeamStatsPanel(offvo, deffovo, ragevo),DAY);
		} catch (TeamNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		}
		
		((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, DAY);
	}

	@Override
	public void noMatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MatchVO getMatch(MatchesBLService matchbl, String season, Date date)
			throws MatchNotFound {
		return matchbl.getMatch(season, date, team);
	}

}
