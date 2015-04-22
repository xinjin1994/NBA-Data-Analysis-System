package gui.hot;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vo.PlayerExtraStatsVO;
import enums.Terminology;

public class PlayerCompareDialog extends JDialog {
	private static final long serialVersionUID = -7104843675263001222L;
	private ArrayList<PlayerCompareItemPanel> panels = new ArrayList<PlayerCompareItemPanel>(5);

	
	private void construct(String title) {
		
		getContentPane().setLayout(new BorderLayout());
		JPanel pnl_title = new JPanel(new FlowLayout(FlowLayout.LEADING));
		getContentPane().add(pnl_title,BorderLayout.NORTH);
		JLabel lbl_title = new JLabel(title);
		lbl_title.setFont(new Font(lbl_title.getFont().getName(),Font.BOLD,20));
		pnl_title.add(lbl_title);
		
		JPanel pnl_main = new JPanel();
		pnl_main.setLayout(new BoxLayout(pnl_main,BoxLayout.X_AXIS));
		pnl_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnl_main, BorderLayout.CENTER);
		
		for(PlayerCompareItemPanel panel:panels)
			pnl_main.add(panel);
		
		pack();
	}
	
	public PlayerCompareDialog(String title,String season,Date date,Terminology term, ArrayList<PlayerExtraStatsVO> players) {
		int i = 1;
		for(PlayerExtraStatsVO vo:players)
			panels.add(new PlayerCompareItemPanel(i++,season,date,term,vo.getName(),vo.getTeam(),vo.getPosition()));
		construct(title);
	}
	public PlayerCompareDialog(String title,String season,Terminology term, ArrayList<PlayerExtraStatsVO> players) {
		int i = 1;
		for(PlayerExtraStatsVO vo:players)
			panels.add(new PlayerCompareItemPanel(i++,season,term,vo.getName(),vo.getTeam(),vo.getPosition()));
		construct(title);
	}
}
