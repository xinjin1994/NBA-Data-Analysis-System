package gui.statistic;

import gui.MainFrame;
import gui.SelfAdjustPanel;
import gui.enums.PanelType;
import gui.util.ReturnButton;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticPanel extends SelfAdjustPanel {

	private static final long serialVersionUID = 8475751505006519027L;

	/**
	 * Create the panel.
	 */
	public StatisticPanel() {
		GridBagLayout gbl_pnl_menu = new GridBagLayout();
		gbl_pnl_menu.columnWidths = new int[]{pWidth/4, pWidth/4, pWidth/4,pWidth/4};
		gbl_pnl_menu.rowHeights = new int[]{pHeight/4, pHeight/2, pHeight/4};
		gbl_pnl_menu.columnWeights = new double[]{1, 0.0, 0.0, 1};
		gbl_pnl_menu.rowWeights = new double[]{1, 0.0, 0.0, 1};
		setLayout(gbl_pnl_menu);
		
		JButton btn_player = new JButton("球员数据分析");
		btn_player.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.mf.gotoPanel(PanelType.PLAYER_STATISTIC);
			}
		});
		GridBagConstraints gbc_btn_player = new GridBagConstraints();
		gbc_btn_player.gridx = 1;
		gbc_btn_player.gridy = 1;
		add(btn_player, gbc_btn_player);
		
		JButton btn_team = new JButton("球队数据分析");
		btn_team.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.mf.gotoPanel(PanelType.TEAM_STATISTIC);
			}
		});
		GridBagConstraints gbc_btn_team = new GridBagConstraints();
		gbc_btn_team.gridx = 2;
		gbc_btn_team.gridy = 1;
		add(btn_team, gbc_btn_team);
		
		JButton btnNewButton = new ReturnButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.mf.gotoPanel(PanelType.MENU);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnNewButton.insets = new Insets(0, 10, 10, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);

	}

}
