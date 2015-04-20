package gui.hot;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.CardLayout;

public class HotPanel extends JPanel {
	private static final long serialVersionUID = 27172124389622473L;

	public HotPanel() {
		setLayout(new CardLayout(0, 0));
		
		JPanel pnl_main = new JPanel();
		pnl_main.setLayout(new GridLayout(3, 0, 0, 0));
		add(pnl_main);
		
		pnl_main.add(new HotPlayerPanel());
		
		pnl_main.add(new ProgressPlayerPanel());
		
		pnl_main.add(new HotTeamPanel());
		
		

	}

}
