package gui.statistic;

import gui.SelfAdjustPanel;
import gui.player.SearchPlayerPanel;
import gui.util.ReturnButton;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class PlayerStatisticPanel extends SelfAdjustPanel {

	private static final long serialVersionUID = 9090035509234357424L;

	public PlayerStatisticPanel() {
		GridBagLayout gbl_pnl_menu = new GridBagLayout();
		gbl_pnl_menu.columnWidths = new int[]{pWidth/10, pWidth/(10/8), pWidth/10};
		gbl_pnl_menu.rowHeights = new int[]{pHeight/10, pHeight/5, pHeight/10, pHeight/2, pHeight/10};
		gbl_pnl_menu.columnWeights = new double[]{0,0,0};
		gbl_pnl_menu.rowWeights = new double[]{1,0,1,0,1};
		setLayout(gbl_pnl_menu);
		
		
		SearchPlayerPanel pnl_search = new SearchPlayerPanel();
		GridBagConstraints gbc_pnl_search = new GridBagConstraints();
		gbc_pnl_search.gridx = 1;
		gbc_pnl_search.gridy = 1;
		gbc_pnl_search.fill = GridBagConstraints.HORIZONTAL;
		add(pnl_search, gbc_pnl_search);
		
		ReturnButton btn_return = new ReturnButton();
		GridBagConstraints gbc_btn_return = new GridBagConstraints();
		gbc_btn_return.gridx = 1;
		gbc_btn_return.gridy = 4;
		gbc_btn_return.anchor = GridBagConstraints.SOUTHWEST;
		add(btn_return,gbc_btn_return);
	}

}
