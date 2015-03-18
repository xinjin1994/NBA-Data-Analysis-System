package gui.statistic;

import enums.Conference;
import enums.Division;
import enums.Position;
import exceptions.PlayerNotFound;
import gui.SelfAdjustPanel;
import gui.player.PlayerDetailDialog;
import gui.player.PlayerSearch;
import gui.player.PlayerTableModel_Simple;
import gui.player.PortraitPanel_Stub;
import gui.player.SearchPlayerPanel;
import gui.util.ReturnButton;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableRowSorter;

import businessLogic.playersBL.PlayersBL;
import vo.PlayerVO;

public class PlayerStatisticPanel extends SelfAdjustPanel implements PlayerSearch{

	private static final long serialVersionUID = 9090035509234357424L;

	public PlayerStatisticPanel() {
		GridBagLayout gbl_pnl_menu = new GridBagLayout();
		gbl_pnl_menu.columnWidths = new int[]{pWidth/10, (int) (pWidth/(10/8.0)), pWidth/10};
		gbl_pnl_menu.rowHeights = new int[]{pHeight/10,pHeight/10, pHeight/10, (int) (pHeight*(6/10.0)), pHeight/10};
		gbl_pnl_menu.columnWeights = new double[]{1,1,1};
		gbl_pnl_menu.rowWeights = new double[]{1,1,1,1,1};
		setLayout(gbl_pnl_menu);
		
		ArrayList<PlayerVO> list;
		try {
			list = new PlayersBL().getAllPlayersInfo();
		} catch (PlayerNotFound e) {
			//TODO
			list = new ArrayList<PlayerVO>();
		}
		
		JScrollPane pane_list = new JScrollPane();
		pane_list.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JTable tbl_list = new JTable(new PlayerTableModel_Simple(null));// TODO
		tbl_list.setFillsViewportHeight(true);
		tbl_list.setRowSorter(new TableRowSorter<PlayerTableModel_Simple>());
		tbl_list.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_list.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent me) {
				if(me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1){
					
				}
			}
		});
		pane_list.add(tbl_list);
		GridBagConstraints gbc_pane_list = new GridBagConstraints();
		gbc_pane_list.gridx = 1;
		gbc_pane_list.gridy = 3;
		gbc_pane_list.fill = GridBagConstraints.BOTH;
		add(pane_list, gbc_pane_list);
		
		SearchPlayerPanel pnl_search = new SearchPlayerPanel(null);//TODO
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

	@Override
	public void buildList(Conference c, Division d, Position p, String name) {
		// TODO Auto-generated method stub
		
	}

}
