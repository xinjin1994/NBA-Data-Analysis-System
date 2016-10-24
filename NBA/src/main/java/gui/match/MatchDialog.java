package gui.match;

import gui.FrameRefreshable;

import java.awt.Dimension;

import vo.MatchVO;

public class MatchDialog extends FrameRefreshable {
	private static final long serialVersionUID = -6180266678801351408L;
	
	public MatchDialog(MatchVO vo){
		super("比赛详情");
		
		setMinimumSize(new Dimension(1300,700));
		setMaximumSize(new Dimension(1600,730));

		this.setContentPane(new MatchStatsPanel(vo));
	}

	@Override
	public void refresh() {
		//do nothing
	}
}
