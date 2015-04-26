package gui.statistic;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class StatisticPanel extends JPanel {

	private static final long serialVersionUID = 8475751505006519027L;

	/**
	 * Create the panel.
	 */
	public StatisticPanel() {
		setLayout(new BorderLayout());
		
		JTabbedPane pane = new JTabbedPane();
		pane.add(new PlayerStatisticPanel(),"球员统计数据");
		pane.add(new TeamStatisticPanel(),"球队统计数据");

		add(pane);
	}

}
