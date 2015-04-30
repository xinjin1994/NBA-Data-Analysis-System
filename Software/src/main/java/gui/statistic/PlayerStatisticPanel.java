package gui.statistic;

import enums.Conference;
import enums.Division;
import enums.Position;
import exceptions.PlayerNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.SelfAdjustPanel;
import gui.player.PlayerSearch;
import gui.player.SearchPlayerPanel;
import gui.util.LeftAlignTableRenderer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;

import businessLogicService.playersBLService.PlayersBLService_new;
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
	private ButtonGroup btngrp;
	
	private PlayersBLService_new playerService;

	public void paintComponent(Graphics gs) {  
        Graphics2D g = (Graphics2D) gs;  
        super.paintComponent(g);  
        //画背景图片  
        String imagePath="image\\main_menu\\01.jpg";
//        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));  
        ImageIcon img = new ImageIcon(imagePath);
        img.setImage(img.getImage().getScaledInstance(pWidth,pHeight,Image.SCALE_DEFAULT));
        g.drawImage(img.getImage(), 0, 0,pWidth,pHeight, this);  
    }
	public PlayerStatisticPanel() {
		playerService = new ObjectCreator().playersBLService();
		
		GridBagLayout gbl_pnl_menu = new GridBagLayout();
		gbl_pnl_menu.columnWidths = new int[]{pWidth/20, (int) (pWidth/(20/18.0)), pWidth/20};
		gbl_pnl_menu.rowHeights = new int[]{pHeight/10,pHeight/10, pHeight/10, (int) (pHeight*(6/10.0)), pHeight/10};
		gbl_pnl_menu.columnWeights = new double[]{1,1,1};
		gbl_pnl_menu.rowWeights = new double[]{1,1,1,1,1};
		setLayout(gbl_pnl_menu);
		
		getList(Conference.NATIONAL,Division.NATIONAL,Position.ALL);

		tbl_basicList = new JTable(new PlayerTableModel_Basic(basicList_average));
		tbl_basicList.setDefaultRenderer(int.class, new LeftAlignTableRenderer());
		tbl_basicList.setDefaultRenderer(Integer.class, new LeftAlignTableRenderer());
		tbl_basicList.setDefaultRenderer(Double.class, new LeftAlignTableRenderer());
		tbl_basicList.setDefaultRenderer(double.class, new LeftAlignTableRenderer());
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
		
		tbl_advancedList = new JTable(new PlayerTableModel_Advanced(advancedList_average));
		tbl_advancedList.setDefaultRenderer(int.class, new LeftAlignTableRenderer());
		tbl_advancedList.setDefaultRenderer(Integer.class, new LeftAlignTableRenderer());
		tbl_advancedList.setDefaultRenderer(Double.class, new LeftAlignTableRenderer());
		tbl_advancedList.setDefaultRenderer(double.class, new LeftAlignTableRenderer());
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
		
		JScrollPane pane_basicList = new JScrollPane(tbl_basicList);
		pane_basicList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane pane_advancedList = new JScrollPane(tbl_advancedList);
		pane_advancedList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
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
		
		JRadioButton rdibtn_average = new JRadioButton("平均");
		rdibtn_average.setBackground(new Color(214,226,242,100));
		rdibtn_average.setActionCommand("AVERAGE");
		rdibtn_average.addActionListener(new RadioButtonListener());
		JRadioButton rdibtn_total = new JRadioButton("总计");
		rdibtn_total.setBackground(new Color(214,226,242,100));
		rdibtn_total.setActionCommand("TOTAL");
		rdibtn_total.addActionListener(new RadioButtonListener());
		btngrp = new ButtonGroup();
		btngrp.add(rdibtn_average);
		btngrp.add(rdibtn_total);
		rdibtn_average.setSelected(true);
		
		JPanel pnl_selection = new JPanel(){
			public void paintComponent(Graphics gs) {  
		        Graphics2D g = (Graphics2D) gs;  
		        super.paintComponent(g);  
		        //画背景图片  
		        String imagePath="image\\main_menu\\05.png";
//		        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));  
		        ImageIcon img = new ImageIcon(imagePath);
		        img.setImage(img.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));
		        g.drawImage(img.getImage(), 0, 0,getWidth(),getHeight(), this);  
		    }
		};
		GridBagConstraints gbc_pnl_selection = new GridBagConstraints();
		gbc_pnl_selection.gridx = 1;
		gbc_pnl_selection.gridy = 2;
		pnl_selection.add(rdibtn_average);
		pnl_selection.add(rdibtn_total);
		add(pnl_selection, gbc_pnl_selection);
		
	}
	
	class RadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			setList(btngrp.getSelection().getActionCommand());
		}
	}

	public void getList(Conference c, Division d, Position p) {
		try {
			basicList_average = playerService.getBasicPlayersStatsAverage(MainFrame.season.season,c,d,p);
			basicList_total = playerService.getBasicPlayersStatsTotal(MainFrame.season.season,c,d,p);
		} catch (PlayerNotFound e) {
			basicList_average = new ArrayList<PlayerBasicStatsVO>();
			basicList_total = new ArrayList<PlayerBasicStatsVO>();
		}
		try {
			advancedList_average = playerService.getAdvancedPlayersStatsAverage(MainFrame.season.season,c,d,p);
			advancedList_total = playerService.getAdvancedPlayersStatsTotal(MainFrame.season.season,c,d,p);
		} catch (PlayerNotFound e) {
			advancedList_average = new ArrayList<PlayerAdvancedStatsVO>();
			advancedList_total = new ArrayList<PlayerAdvancedStatsVO>();
		}
	}
	@Override
	public void buildList(Conference c, Division d, Position p) {
		getList(c,d,p);
		setList(btngrp.getSelection().getActionCommand());
	}
	private void setList(String str){
		switch(str){
		case "AVERAGE":
			((PlayerTableModel_Basic)tbl_basicList.getModel()).updateData(basicList_average);
			((PlayerTableModel_Advanced)tbl_advancedList.getModel()).updateData(advancedList_average);
			break;
		case "TOTAL":
			((PlayerTableModel_Basic)tbl_basicList.getModel()).updateData(basicList_total);
			((PlayerTableModel_Advanced)tbl_advancedList.getModel()).updateData(advancedList_total);
			break;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public void filterList(String name) {
		((DefaultRowSorter<PlayerTableModel_Basic,Object>)tbl_basicList.getRowSorter()).setRowFilter(RowFilter.regexFilter(name, 0));
		((DefaultRowSorter<PlayerTableModel_Advanced,Object>)tbl_advancedList.getRowSorter()).setRowFilter(RowFilter.regexFilter(name, 0));
	}

}
