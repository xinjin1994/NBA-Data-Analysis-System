package gui.statistic;

import enums.Conference;
import enums.Division;
import enums.Position;
import exceptions.PlayerNotFound;
import gui.MainFrame;
import gui.SelfAdjustPanel;
import gui.enums.PanelType;
import gui.player.PlayerSearch;
import gui.player.SearchPlayerPanel;
import gui.statistic.PlayerStatisticPanel.RadioButtonListener;
import gui.util.ReturnButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultRowSorter;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;

import businessLogic.playersBL.PlayersBL;
import businessLogic.teamsBL.TeamsBL;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import vo.TeamGeneralStatsVO;
import vo.TeamOffensiveStatsVO;

public class TeamStatisticPanel extends SelfAdjustPanel{

	private static final long serialVersionUID = 9090035509234357424L;
	private ArrayList<TeamOffensiveStatsVO> basicList_average;
	private ArrayList<PlayerBasicStatsVO> basicList_total;
	private ArrayList<PlayerAdvancedStatsVO> advancedList_average;
	private ArrayList<PlayerAdvancedStatsVO> advancedList_total;
	private JTable tbl_advancedList;
	private JTable tbl_basicList;
	private ButtonGroup btngrp;

	public TeamStatisticPanel() {
		setLayout(new BorderLayout());
		
		//buildList();

		JScrollPane pane_basicList = new JScrollPane();
		pane_basicList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tbl_basicList = new JTable();//TODO
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
		tbl_advancedList = new JTable();//TODO
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
		pane_lists.add("球队基本数据",pane_basicList);
		pane_lists.add("球队进阶数据",pane_advancedList);
		add(pane_lists);
		
		JPanel pnl_button = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ReturnButton btn_return = new ReturnButton();
		btn_return.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.mf.gotoPanel(PanelType.STATISTIC);
			}
		});
		pnl_button.add(btn_return);
		add(pnl_button, BorderLayout.SOUTH);
		
		JRadioButton rdibtn_average = new JRadioButton("平均");
		rdibtn_average.setActionCommand("AVERAGE");
		rdibtn_average.addActionListener(new RadioButtonListener());
		JRadioButton rdibtn_total = new JRadioButton("总计");
		rdibtn_total.setActionCommand("TOTAL");
		rdibtn_total.addActionListener(new RadioButtonListener());
		btngrp = new ButtonGroup();
		btngrp.add(rdibtn_average);
		btngrp.add(rdibtn_total);
		rdibtn_average.setSelected(true);
		
		JPanel pnl_selection = new JPanel();
		pnl_selection.add(rdibtn_average);
		pnl_selection.add(rdibtn_total);
		add(pnl_selection,BorderLayout.NORTH);
	}
	
	class RadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			
		}
	}
 
	public void buildList() {
		/*
		try {
			basicList_average = new TeamsBL().getTeamsOffensiveStatsAverage(Conference.NATIONAL, Division.NATIONAL);
			basicList_total = new TeamsBL().getTeamsOffensiveStatsTotal(Conference.NATIONAL, Division.NATIONAL)
		} catch (PlayerNotFound e) {
			basicList_average = new ArrayList<PlayerBasicStatsVO>();
			basicList_total = new ArrayList<PlayerBasicStatsVO>();
		}
		try {
			advancedList_average;
			advancedList_total;
		} catch (PlayerNotFound e) {
			advancedList_average = new ArrayList<PlayerAdvancedStatsVO>();
			advancedList_total = new ArrayList<PlayerAdvancedStatsVO>();
		}
		*/
	}

}
