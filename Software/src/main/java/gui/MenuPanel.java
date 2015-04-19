package gui;

import gui.enums.PanelType;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuPanel extends SelfAdjustPanel {

	private static final long serialVersionUID = 8475751505006519027L;

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		GridBagLayout gbl_pnl_menu = new GridBagLayout();
		gbl_pnl_menu.columnWidths = new int[]{pWidth/6, pWidth/3, pWidth/3,pWidth/6};
		gbl_pnl_menu.rowHeights = new int[]{pHeight/6, pHeight/3, pHeight/3,pHeight/6};
		gbl_pnl_menu.columnWeights = new double[]{1, 0.0, 0.0, 1};
		gbl_pnl_menu.rowWeights = new double[]{1, 0.0, 0.0, 1};
		setLayout(gbl_pnl_menu);
		
		JButton btn_player = new JButton("球员");
		btn_player.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.mf.gotoPanel(PanelType.PLAYER);
			}
		});
		GridBagConstraints gbc_btn_player = new GridBagConstraints();
		gbc_btn_player.gridx = 1;
		gbc_btn_player.gridy = 1;
		add(btn_player, gbc_btn_player);
		
		JButton btn_team = new JButton("球队");
		btn_team.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.mf.gotoPanel(PanelType.TEAM);
			}
		});
		GridBagConstraints gbc_btn_team = new GridBagConstraints();
		gbc_btn_team.gridx = 2;
		gbc_btn_team.gridy = 1;
		add(btn_team, gbc_btn_team);
		
		JButton btn_game = new JButton("比赛");
		btn_game.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.mf.gotoPanel(PanelType.GAME);
			}
		});
		GridBagConstraints gbc_btn_game = new GridBagConstraints();
		gbc_btn_game.gridx = 1;
		gbc_btn_game.gridy = 2;
		add(btn_game, gbc_btn_game);
		
		JButton btn_statistic = new JButton("统计");
		btn_statistic.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.mf.gotoPanel(PanelType.HOT);
			}
		});
		GridBagConstraints gbc_btn_statistic = new GridBagConstraints();
		gbc_btn_statistic.gridx = 2;
		gbc_btn_statistic.gridy = 2;
		add(btn_statistic, gbc_btn_statistic);
		
	}

}
