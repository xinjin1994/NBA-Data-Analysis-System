package gui.match;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vo.MatchVO;

public class MatchPanel extends JPanel implements MatchVOChangeable{
	private static final long serialVersionUID = 1626371137475494976L;
	private static final String MATCH = "MATCH";
	private static final String NO_MATCH = "NO_MATCH";
	private JPanel pnl_stats;

	public MatchPanel(){
		setLayout(new GridLayout(1,2));
		
		MatchListPanel pnl_list = new MatchListPanel(this);
		add(pnl_list);
		
		pnl_stats = new JPanel(new CardLayout());
		//add(pnl_stats);
		pnl_stats.setLayout(new CardLayout());
		pnl_stats.add(new JLabel("请选择比赛",SwingConstants.CENTER),NO_MATCH);
	}

	@Override
	public void changeMatch(MatchVO vo) {
		JDialog dia = new MatchDialog(vo);
		dia.setVisible(true);
		//pnl_stats.add(new MatchStatsPanel(vo),MATCH);
		//((CardLayout)pnl_stats.getLayout()).show(pnl_stats, MATCH);
	}

	@Override
	public void noMatch() {
		((CardLayout)pnl_stats.getLayout()).show(pnl_stats, NO_MATCH);
	}
}
