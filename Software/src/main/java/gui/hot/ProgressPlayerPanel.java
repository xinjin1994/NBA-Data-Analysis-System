package gui.hot;

import enums.Terminology;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProgressPlayerPanel extends JPanel {
	
	private static final long serialVersionUID = -464887637378876171L;

	public ProgressPlayerPanel() {
		setLayout(new BorderLayout());
		
		JPanel pnl_title = new JPanel();
		add(pnl_title, BorderLayout.NORTH);
		pnl_title.setLayout(new BoxLayout(pnl_title, BoxLayout.X_AXIS));
		JLabel lbl_title = new JLabel("进步球员");
		pnl_title.add(lbl_title);
		
		JPanel pnl_progress = new JPanel(new FlowLayout(FlowLayout.CENTER));
		for(Terminology term:Terminology.getPlayerSeasonProgress()){
			pnl_progress.add(new ProgressPlayerItemPanel(term));
		}
	}
	
	

}
