package gui.statistic;

import enums.Conference;
import enums.Division;
import exceptions.TeamNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.SelfAdjustPanel;
import gui.team.TeamTableModel_DefenseFoul;
import gui.team.TeamTableModel_GeneralRatio;
import gui.team.TeamTableModel_Offence;

import java.awt.BorderLayout;
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

import businessLogicService.teamsBLService.TeamsBLService_new;
import vo.TeamDefensiveFoulsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;

public class TeamStatisticPanel extends SelfAdjustPanel{

	private static final long serialVersionUID = 9090035509234357424L;
	private ArrayList<TeamOffensiveStatsVO> offenceList_average;
	private ArrayList<TeamOffensiveStatsVO> offenceList_total;
	private ArrayList<TeamDefensiveFoulsVO> defenseList_average;
	private ArrayList<TeamDefensiveFoulsVO> defenseList_total;
	private ArrayList<TeamRatioGeneralVO> ratioList_average;
	private ArrayList<TeamRatioGeneralVO> ratioList_total;
	private JTable tbl_defensefoulList;
	private JTable tbl_offenceList;
	private JTable tbl_generalratioList;
	private ButtonGroup btngrp;
	
	private TeamsBLService_new teamService;

	public TeamStatisticPanel() {
		teamService = new ObjectCreator().teamsBLService();
		
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
		
		tbl_defensefoulList = new JTable(new TeamTableModel_DefenseFoul(defenseList_average));
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

		tbl_generalratioList = new JTable(new TeamTableModel_GeneralRatio(ratioList_average));
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
		JScrollPane pane_generalratioList = new JScrollPane(tbl_generalratioList);
		pane_generalratioList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JTabbedPane pane_lists = new JTabbedPane();
		pane_lists.add("球队进攻数据",pane_offenceList);
		pane_lists.add("球队防守犯规数据",pane_defensefoulList);
		pane_lists.add("球队综合比率数据",pane_generalratioList);
		add(pane_lists);
		
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
			offenceList_average = teamService.getTeamOffensiveStatsAverage(MainFrame.season.season,Conference.NATIONAL, Division.NATIONAL);
			offenceList_total = teamService.getTeamOffensiveStatsTotal(MainFrame.season.season,Conference.NATIONAL, Division.NATIONAL);
		} catch (TeamNotFound e) {
			offenceList_average = new ArrayList<TeamOffensiveStatsVO>();
			offenceList_total = new ArrayList<TeamOffensiveStatsVO>();
		}
		try {
			defenseList_average = teamService.getTeamDefensiveFoulsStatsAverage(MainFrame.season.season,Conference.NATIONAL, Division.NATIONAL);
			defenseList_total = teamService.getTeamDefensiveFoulsStatsTotal(MainFrame.season.season,Conference.NATIONAL, Division.NATIONAL);
		} catch (TeamNotFound e) {
			defenseList_average = new ArrayList<TeamDefensiveFoulsVO>();
			defenseList_total = new ArrayList<TeamDefensiveFoulsVO>();
		}
		try {
			ratioList_average = teamService.getTeamRatioGeneralStatsAverage(MainFrame.season.season,Conference.NATIONAL, Division.NATIONAL);
			ratioList_total = teamService.getTeamRatioGeneralStatsTotal(MainFrame.season.season,Conference.NATIONAL, Division.NATIONAL);
		} catch (TeamNotFound e) {
			ratioList_average = new ArrayList<TeamRatioGeneralVO>();
			ratioList_total = new ArrayList<TeamRatioGeneralVO>();
		}
	}
	private void setList(){
		switch(btngrp.getSelection().getActionCommand()){
		case "AVERAGE":
			((TeamTableModel_Offence)tbl_offenceList.getModel()).updateData(offenceList_average);
			((TeamTableModel_DefenseFoul)tbl_defensefoulList.getModel()).updateData(defenseList_average);
			((TeamTableModel_GeneralRatio)tbl_generalratioList.getModel()).updateData(ratioList_average);
			break;
		case "TOTAL":
			((TeamTableModel_Offence)tbl_offenceList.getModel()).updateData(offenceList_total);
			((TeamTableModel_DefenseFoul)tbl_defensefoulList.getModel()).updateData(defenseList_total);
			((TeamTableModel_GeneralRatio)tbl_generalratioList.getModel()).updateData(ratioList_total);
			break;
		}
	}

}
