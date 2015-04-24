package gui.match;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vo.MatchVO;

public class MatchPanel extends JPanel implements MatchVOChangeable{
	private static final long serialVersionUID = 1626371137475494976L;
	private static final String MATCH = "MATCH";
	private static final String NO_MATCH = "NO_MATCH";

	public MatchPanel(){
		setLayout(new GridLayout(1,2));
		
		MatchListPanel pnl_list = new MatchListPanel(this);
		add(pnl_list);
		
		JPanel pnl_stats = new JPanel(new CardLayout());
		pnl_stats.setLayout(new CardLayout());
		pnl_stats.add(new JLabel("请选择比赛",SwingConstants.CENTER),NO_MATCH);
	}

	@Override
	public void changeMatch(MatchVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void noMatch() {
		// TODO Auto-generated method stub
		
	}
}
