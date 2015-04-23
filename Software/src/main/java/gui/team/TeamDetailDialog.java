package gui.team;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.WindowConstants;

import enums.Teams;
import exceptions.TeamNotFound;
import factory.ObjectCreator;
import vo.TeamVO;

public class TeamDetailDialog extends JDialog {
	private static final long serialVersionUID = -3909088125338475578L;

	public TeamDetailDialog(TeamVO vo) {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().add(new TeamDetailPanel(vo));
		setSize(new Dimension(1000,760));
	}

	public TeamDetailDialog(Teams team) throws TeamNotFound {
		this(new ObjectCreator().teamsBLService().getTeamInfo(team));
	}

}
