package gui.team;

import javax.swing.JOptionPane;

import vo.TeamDefensiveFoulsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;
import businessLogicService.teamsBLService.TeamsBLService_new;
import enums.Teams;
import exceptions.TeamNotFound;
import gui.MainFrame;

public class TeamMatchStatsPanel extends TeamStatsPanel {
	private static final long serialVersionUID = 3315089309002336343L;

	public TeamMatchStatsPanel(TeamsBLService_new teambl, Teams team) {
		super(teambl, team);
		
		try {
			TeamOffensiveStatsVO offvo = teambl.getTeamOffensiveStatsAverage(MainFrame.season.season, team);
			TeamDefensiveFoulsVO deffovo = teambl.getTeamDefensiveFoulsStatsAverage(MainFrame.season.season, team);
			TeamRatioGeneralVO ragevo = teambl.getTeamRatioGeneralStatsAverage(MainFrame.season.season, team);
		} catch (TeamNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		}
	}

}
