package gui.statistic;

import enums.Conference;
import enums.Division;
import enums.Position;
import exceptions.MatchNotFound;
import exceptions.PlayerNotFound;
import exceptions.TeamNotFound;
import gui.SelfAdjustPanel;
import gui.player.PlayerSearch;
import gui.player.SearchPlayerPanel;
import gui.util.ReturnButton;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultRowSorter;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;

import businessLogic.playersBL.PlayersBL;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;

public class PlayerStatisticPanel extends SelfAdjustPanel implements PlayerSearch{

	private static final long serialVersionUID = 9090035509234357424L;
	private ArrayList<PlayerBasicStatsVO> basicList_average;
	private ArrayList<PlayerBasicStatsVO> basicList_total;
	private ArrayList<PlayerAdvancedStatsVO> advancedList_average;
	private ArrayList<PlayerAdvancedStatsVO> advancedList_total;
	private JTable tbl_advancedList;
	private JTable tbl_basicList;

	public PlayerStatisticPanel() {
		GridBagLayout gbl_pnl_menu = new GridBagLayout();
		gbl_pnl_menu.columnWidths = new int[]{pWidth/10, (int) (pWidth/(10/8.0)), pWidth/10};
		gbl_pnl_menu.rowHeights = new int[]{pHeight/10,pHeight/10, pHeight/10, (int) (pHeight*(6/10.0)), pHeight/10};
		gbl_pnl_menu.columnWeights = new double[]{1,1,1};
		gbl_pnl_menu.rowWeights = new double[]{1,1,1,1,1};
		setLayout(gbl_pnl_menu);
		
		buildList(Conference.NATIONAL,Division.NATIONAL,Position.ALL);

		JScrollPane pane_basicList = new JScrollPane();
		pane_basicList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tbl_basicList = new JTable(new PlayerTableModel_Basic(basicList_average));
		tbl_basicList.setFillsViewportHeight(true);
		tbl_basicList.setAutoCreateRowSorter(true);
		tbl_basicList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_basicList.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent me) {
				if(me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1){
					
				}
			}
		});
		pane_basicList.add(tbl_basicList);
		
		JScrollPane pane_advancedList = new JScrollPane();
		pane_advancedList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tbl_advancedList = new JTable(new PlayerTableModel_Advanced(advancedList_average));
		tbl_advancedList.setFillsViewportHeight(true);
		tbl_advancedList.setAutoCreateRowSorter(true);
		tbl_advancedList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_advancedList.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent me) {
				if(me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1){
					
				}
			}
		});
		pane_advancedList.add(tbl_advancedList);
		
		JTabbedPane pane_lists = new JTabbedPane();
		GridBagConstraints gbc_pane_list = new GridBagConstraints();
		gbc_pane_list.gridx = 1;
		gbc_pane_list.gridy = 3;
		gbc_pane_list.fill = GridBagConstraints.BOTH;
		pane_lists.add("球员基本数据",pane_basicList);
		pane_lists.add("球员进阶数据",pane_advancedList);
		add(pane_lists, gbc_pane_list);
		
		SearchPlayerPanel pnl_search = new SearchPlayerPanel(this);
		GridBagConstraints gbc_pnl_search = new GridBagConstraints();
		gbc_pnl_search.gridx = 1;
		gbc_pnl_search.gridy = 1;
		gbc_pnl_search.fill = GridBagConstraints.HORIZONTAL;
		add(pnl_search, gbc_pnl_search);
		
		JPanel pnl_selection = new JPanel();
		GridBagConstraints gbc_pnl_selection = new GridBagConstraints();
		gbc_pnl_selection.gridx = 1;
		gbc_pnl_selection.gridy = 2;
		//TODO
		add(pnl_selection, gbc_pnl_selection);
		
		ReturnButton btn_return = new ReturnButton();
		GridBagConstraints gbc_btn_return = new GridBagConstraints();
		gbc_btn_return.gridx = 1;
		gbc_btn_return.gridy = 4;
		gbc_btn_return.anchor = GridBagConstraints.SOUTHWEST;
		add(btn_return,gbc_btn_return);
	}

	@Override
	public void buildList(Conference c, Division d, Position p) {
		try {
			basicList_average = new PlayersBL().getBasicPlayersStatsAverage(c,d,p);
			basicList_total = new PlayersBL().getBasicPlayersStatsTotal(c,d,p);
		} catch (PlayerNotFound e) {
			basicList_average = new ArrayList<PlayerBasicStatsVO>();
			basicList_total = new ArrayList<PlayerBasicStatsVO>();
		} catch (TeamNotFound e) {
			e.printStackTrace();
		} catch (MatchNotFound e) {
			e.printStackTrace();
		}
		
		try {
			advancedList_average = new PlayersBL().getAdvancedPlayersStatsAverage(c,d,p);
			advancedList_total = new PlayersBL().getAdvancedPlayersStatsTotal(c,d,p);
		} catch (PlayerNotFound e) {
			advancedList_average = new ArrayList<PlayerAdvancedStatsVO>();
			advancedList_total = new ArrayList<PlayerAdvancedStatsVO>();
		} catch (TeamNotFound e) {
			e.printStackTrace();
		} catch (MatchNotFound e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public void filterList(String name) {
		((DefaultRowSorter<PlayerTableModel_Basic,Object>)tbl_basicList.getRowSorter()).setRowFilter(RowFilter.regexFilter(name, 0));
		((DefaultRowSorter<PlayerTableModel_Advanced,Object>)tbl_advancedList.getRowSorter()).setRowFilter(RowFilter.regexFilter(name, 0));
	}

}
