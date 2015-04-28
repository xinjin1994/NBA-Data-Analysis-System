package gui.match;

import javax.swing.JPanel;

import vo.MatchVO;

public abstract class MatchItemPanel extends JPanel {
	private static final long serialVersionUID = 6462447726188934575L;

	public abstract void setMatchVO(MatchVO vo);
}
