package gui.team;

import javax.swing.JPanel;

import enums.Teams;
import businessLogicService.teamsBLService.TeamsBLService_new;

public class TeamStatsPanel extends JPanel {
	private static final long serialVersionUID = 2507703507260759989L;
	protected TeamsBLService_new teambl;
	protected Teams team;

	public TeamStatsPanel(TeamsBLService_new teambl,Teams team) {
		this.teambl = teambl;
		this.team = team;
	}

}
