package gui.hot;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vo.TeamHotStatsVO;
import enums.Terminology;

public class TeamCompareDialog extends JDialog {
	private static final long serialVersionUID = -7104843675263001222L;
	private ArrayList<TeamCompareItemPanel> panels = new ArrayList<TeamCompareItemPanel>(5);

	
	private void construct(String title) {
		
		getContentPane().setLayout(new BorderLayout());
		JPanel pnl_title = new JPanel(new FlowLayout(FlowLayout.LEADING));
		getContentPane().add(pnl_title,BorderLayout.NORTH);
		JLabel lbl_title = new JLabel(title);
		lbl_title.setFont(new Font(lbl_title.getFont().getName(),Font.BOLD,20));
		pnl_title.add(lbl_title);
		
		JPanel pnl_main = new JPanel();
		pnl_main.setLayout(new BoxLayout(pnl_main,BoxLayout.Y_AXIS));
		pnl_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnl_main, BorderLayout.CENTER);
		
		for(TeamCompareItemPanel panel:panels){
			pnl_main.add(panel);
			pnl_main.add(Box.createVerticalStrut(5));
		}
		
		pack();
	}
	
	public TeamCompareDialog(String title,String season,Terminology term, ArrayList<TeamHotStatsVO> teams) {
		int i = 1;
		for(TeamHotStatsVO vo:teams)
			panels.add(new TeamCompareItemPanel(i++, season, term, vo));
		construct(title);
	}
}
