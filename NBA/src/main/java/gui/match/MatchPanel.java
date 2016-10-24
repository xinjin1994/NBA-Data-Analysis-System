package gui.match;

import gui.MainFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import vo.MatchVO;

public class MatchPanel extends JPanel implements MatchVOChangeable{
	private static final long serialVersionUID = 1626371137475494976L;

	public MatchPanel(){
		setLayout(new BorderLayout());
		
		MatchListPanel pnl_list = new MatchListPanel(this);
		add(pnl_list);
	}

	@Override
	public void changeMatch(MatchVO vo) {
		MainFrame.showDialog(new MatchDialog(vo));
	}

	@Override
	public void noMatch() {
		//
	}
}
