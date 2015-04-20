package gui.hot;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
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
		
		JPanel panel = new JPanel();
		pnl_main.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JLabel label_2 = new JLabel("球队数据");
		panel_5.add(label_2);
		
		

	}

}
