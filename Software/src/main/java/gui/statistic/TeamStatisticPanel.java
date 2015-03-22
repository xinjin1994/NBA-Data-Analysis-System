package gui.statistic;

import enums.Conference;
import enums.Division;
import exceptions.TeamNotFound;
import gui.MainFrame;
import gui.SelfAdjustPanel;
import gui.enums.PanelType;
import gui.team.TeamTableModel_DefenseFoul;
import gui.team.TeamTableModel_GeneralRatio;
import gui.team.TeamTableModel_Offence;
import gui.util.ReturnButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import businessLogic.teamsBL.TeamsBL;
import vo.TeamDefensiveStatsVO;
import vo.TeamFoulsStatsVO;
import vo.TeamGeneralStatsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioStatsVO;

public class TeamStatisticPanel extends SelfAdjustPanel{

	private static final long serialVersionUID = 9090035509234357424L;
	private ArrayList<TeamOffensiveStatsVO> offenceList_average;
	private ArrayList<TeamOffensiveStatsVO> offenceList_total;
	private ArrayList<TeamDefensiveStatsVO> defenseList_average;
	private ArrayList<TeamDefensiveStatsVO> defenseList_total;
	private ArrayList<TeamFoulsStatsVO> foulList_average;
	private ArrayList<TeamFoulsStatsVO> foulList_total;
	private ArrayList<TeamRatioStatsVO> ratioList_average;
	private ArrayList<TeamRatioStatsVO> ratioList_total;
	private ArrayList<TeamGeneralStatsVO> generalList_average;
	private ArrayList<TeamGeneralStatsVO> generalList_total;
	private JTable tbl_defensefoulList;
	private JTable tbl_offenceList;
	private JTable tbl_generalratioList;
	private ButtonGroup btngrp;

	public TeamStatisticPanel() {
		setLayout(new BorderLayout());
		
		buildList();

		tbl_offenceList = new JTable(new TeamTableModel_Offence(offenceList_average));
		tbl_offenceList.setFillsViewportHeight(true);
		tbl_offenceList.setAutoCreateRowSorter(true);
		tbl_offenceList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_offenceList.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent me) {
				if(me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1){
					
				}
			}
		});
		
		tbl_defensefoulList = new JTable(new TeamTableModel_DefenseFoul(defenseList_average,foulList_average));
		tbl_defensefoulList.setFillsViewportHeight(true);
		tbl_defensefoulList.setAutoCreateRowSorter(true);
		tbl_defensefoulList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_defensefoulList.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent me) {
				if(me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1){
					
				}
			}
		});

		tbl_generalratioList = new JTable(new TeamTableModel_GeneralRatio(ratioList_average,generalList_average));
		tbl_generalratioList.setFillsViewportHeight(true);
		tbl_generalratioList.setAutoCreateRowSorter(true);
		tbl_generalratioList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_generalratioList.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent me) {
				if(me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1){
					
				}
			}
		});
		
		JScrollPane pane_offenceList = new JScrollPane(tbl_offenceList);
		pane_offenceList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane pane_defensefoulList = new JScrollPane(tbl_defensefoulList);
		pane_defensefoulList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane pane_generalratioList = new JScrollPane(tbl_defensefoulList);
		pane_generalratioList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JTabbedPane pane_lists = new JTabbedPane();
		pane_lists.add("球队进攻数据",pane_offenceList);
		pane_lists.add("球队防守犯规数据",pane_defensefoulList);
		pane_lists.add("球队综合比率数据",pane_generalratioList);
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
			setList();
		}
	}
 
	public void buildList() {
		try {
			offenceList_average = new TeamsBL().getTeamsOffensiveStatsAverage(Conference.NATIONAL, Division.NATIONAL);
			offenceList_total = new TeamsBL().getTeamsOffensiveStatsTotal(Conference.NATIONAL, Division.NATIONAL);
		} catch (TeamNotFound e) {
			offenceList_average = new ArrayList<TeamOffensiveStatsVO>();
			offenceList_total = new ArrayList<TeamOffensiveStatsVO>();
		}
		try {
			defenseList_average = new TeamsBL().getTeamsDefensiveStatsAverage(Conference.NATIONAL, Division.NATIONAL);
			defenseList_total = new TeamsBL().getTeamsDefensiveStatsTotal(Conference.NATIONAL, Division.NATIONAL);
		} catch (TeamNotFound e) {
			defenseList_average = new ArrayList<TeamDefensiveStatsVO>();
			defenseList_total = new ArrayList<TeamDefensiveStatsVO>();
		}
		try {
			foulList_average = new TeamsBL().getTeamsFoulsStatsAverage(Conference.NATIONAL, Division.NATIONAL);
			foulList_total = new TeamsBL().getTeamsFoulsStatsTotal(Conference.NATIONAL, Division.NATIONAL);
		} catch (TeamNotFound e) {
			foulList_average = new ArrayList<TeamFoulsStatsVO>();
			foulList_total = new ArrayList<TeamFoulsStatsVO>();
		}
		try {
			ratioList_average = new TeamsBL().getTeamsRatioStatsAverage(Conference.NATIONAL, Division.NATIONAL);
			ratioList_total = new TeamsBL().getTeamsRatioStatsTotal(Conference.NATIONAL, Division.NATIONAL);
		} catch (TeamNotFound e) {
			ratioList_average = new ArrayList<TeamRatioStatsVO>();
			ratioList_total = new ArrayList<TeamRatioStatsVO>();
		}
		try {
			generalList_average = new TeamsBL().getTeamsGeneralStatsAverage(Conference.NATIONAL, Division.NATIONAL);
			generalList_total = new TeamsBL().getTeamsGeneralStatsTotal(Conference.NATIONAL, Division.NATIONAL);
		} catch (TeamNotFound e) {
			generalList_average = new ArrayList<TeamGeneralStatsVO>();
			generalList_total = new ArrayList<TeamGeneralStatsVO>();
		}
	}
	private void setList(){
		switch(btngrp.getSelection().getActionCommand()){
		case "AVERAGE":
			((TeamTableModel_Offence)tbl_offenceList.getModel()).updateData(offenceList_average);
			((TeamTableModel_DefenseFoul)tbl_defensefoulList.getModel()).updateData(defenseList_average,foulList_average);
			((TeamTableModel_GeneralRatio)tbl_generalratioList.getModel()).updateData(ratioList_average,generalList_average);
			break;
		case "TOTAL":
			((TeamTableModel_Offence)tbl_offenceList.getModel()).updateData(offenceList_total);
			((TeamTableModel_DefenseFoul)tbl_defensefoulList.getModel()).updateData(defenseList_total,foulList_total);
			((TeamTableModel_GeneralRatio)tbl_generalratioList.getModel()).updateData(ratioList_total,generalList_total);
			break;
		}
	}

}
