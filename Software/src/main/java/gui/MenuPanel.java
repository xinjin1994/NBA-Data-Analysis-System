package gui;

import enums.PanelType;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends SelfAdjustPanel {

	private static final long serialVersionUID = 8475751505006519027L;

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		GridBagLayout gbl_pnl_menu = new GridBagLayout();
		gbl_pnl_menu.columnWidths = new int[]{pWidth/6, (int)(pWidth*2.0/3.0),pWidth/6};
		gbl_pnl_menu.rowHeights = new int[]{pHeight/6, (int)(pHeight*2.0/3.0),pHeight/6};
		gbl_pnl_menu.columnWeights = new double[]{1, 0.0, 1};
		gbl_pnl_menu.rowWeights = new double[]{1, 0.0, 1};
		setLayout(gbl_pnl_menu);
		
		JPanel pnl_menu = new JPanel();
		GridBagConstraints gbc_menu = new GridBagConstraints();
		gbc_menu.gridx = 1;
		gbc_menu.gridy = 1;
		add(pnl_menu,gbc_menu);
		
		JButton btn_player = new JButton("球员");
		btn_player.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.mf.gotoPanel(PanelType.PLAYER);
			}
		});
		pnl_menu.add(btn_player);
		
		JButton btn_team = new JButton("球队");
		btn_team.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.mf.gotoPanel(PanelType.TEAM);
			}
		});
		pnl_menu.add(btn_team);
		
		JButton btn_match = new JButton("比赛");
		btn_match.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.mf.gotoPanel(PanelType.MATCH);
			}
		});
		pnl_menu.add(btn_match);
		
		JButton btn_statistic = new JButton("数据");
		btn_statistic.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.mf.gotoPanel(PanelType.STATISTIC);
			}
		});
		pnl_menu.add(btn_statistic);
		
		JButton btn_hot = new JButton("热点");
		btn_hot.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.mf.gotoPanel(PanelType.HOT);
			}
		});
		pnl_menu.add(btn_hot);
	}

}
