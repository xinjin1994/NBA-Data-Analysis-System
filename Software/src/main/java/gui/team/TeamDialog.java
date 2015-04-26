package gui.team;

import java.awt.Dimension;

import javax.swing.WindowConstants;

import enums.Teams;
import exceptions.TeamNotFound;
import factory.ObjectCreator;
import gui.FrameRefreshable;
import vo.TeamVO;

public class TeamDialog extends FrameRefreshable {
	private static final long serialVersionUID = -3909088125338475578L;
	private TeamVO vo;

	public TeamDialog(TeamVO vo) {
		super("球队详情");
		this.vo = vo;
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		refresh();
		setSize(new Dimension(1000,760));
		
	}

	public TeamDialog(Teams team) throws TeamNotFound {
		this(new ObjectCreator().teamsBLService().getTeamInfo(team));
	}

	@Override
	public void refresh() {
		TeamDetailPanel pnl = new TeamDetailPanel(vo);
		setContentPane(pnl);

		this.repaint();
		this.validate();
	}

}
