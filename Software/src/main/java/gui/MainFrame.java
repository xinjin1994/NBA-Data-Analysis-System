package gui;

import gui.enums.PanelType;
import gui.game.GamePanel;
import gui.hot.HotPanel;
import gui.match.Season;
import gui.player.PlayerPanel;
import gui.statistic.PlayerStatisticPanel;
import gui.statistic.StatisticPanel;
import gui.statistic.TeamStatisticPanel;
import gui.team.TeamPanel;
import gui.util.GUIUtility;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.matchesBL.MatchesBL;
import businessLogic.matchesBL.MatchesBL_new;
import businessLogicService.matchesBLService.MatchesBLService;
import data.init.DataInit;
import exceptions.StatsNotFound;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 2292455670620751734L;
	private JPanel contentPane;
	
	//用来保存屏幕的大小
	public static Dimension screen;
	//保留cardlayout中panel与对应字符串的配对关系
	private static Map<PanelType,JPanel> panels = new EnumMap<PanelType,JPanel>(PanelType.class);
	//未来可能有有新的窗口
	public static Frame currentFrame;
	public static MainFrame mf;
	public static Season season;
	private JPanel pnl_main;
	private CardLayout cardlayout;
	private JLabel lbl_season;
	private JComboBox<Season> cbbx_season;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		new DataInit().init();
		
		currentFrame = mf = this;
		screen = new Dimension(1280,720);

		//和屏幕一样大
		this.setSize(screen);//固定窗口大小
		this.setLocationRelativeTo(null);
		
		setTitle("NBA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 640));
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnl_season = new JPanel(new FlowLayout(FlowLayout.LEADING));
		lbl_season = new JLabel();
		pnl_season.add(lbl_season);
		pnl_season.add(Box.createHorizontalStrut(20));
		pnl_season.add(new JLabel("切换赛季："));
		cbbx_season = new JComboBox<Season>();
		cbbx_season.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				season = cbbx_season.getItemAt(cbbx_season.getSelectedIndex());
				lbl_season.setText(season.toString());
			}
		});
		pnl_season.add(cbbx_season);
		MatchesBLService matchbl = new MatchesBL_new();
		
		try {
			ArrayList<String> seasons = matchbl.getAvailableSeasons();
			for(String s:seasons)
				cbbx_season.addItem(new Season(s));
			cbbx_season.setSelectedIndex(0);
		} catch (StatsNotFound e) {
			JOptionPane.showMessageDialog(this, "无可用数据！程序退出！");
			dispose();
		}
		contentPane.add(pnl_season,BorderLayout.NORTH);
		
		pnl_main = new JPanel();
		contentPane.add(pnl_main, BorderLayout.CENTER);
		//cardlayout用来切换不同的版面
		cardlayout = new CardLayout(0, 0);
		pnl_main.setLayout(cardlayout);
		
		JPanel pnl_menu = new MenuPanel();
		pnl_main.add(pnl_menu,PanelType.MENU.toString());

		
	}

	//通过枚举类型来切换版面的集中式控制
	//新的配对在这里添加
	public void gotoPanel(PanelType type){
		if(!panels.containsKey(type)){
			JPanel panel = null;
			switch(type){
			case STATISTIC:
				panel = new StatisticPanel();
				break;
			case MENU:
				panel = new MenuPanel();
				break;
			case GAME:
				panel=new GamePanel();
				break;
			case PLAYER:
				panel = new PlayerPanel();
				break;
			case TEAM:
				panel = new TeamPanel();
				break;
			case PLAYER_STATISTIC:
				panel = new PlayerStatisticPanel();
				break;
			case TEAM_STATISTIC:
				panel = new TeamStatisticPanel();
				break;
			case HOT:
				panel = new HotPanel();
				break;
			}
			panels.put(type, panel);
			pnl_main.add(panel, type.toString());
		}
		cardlayout.show(pnl_main, type.toString());
	}
	
	static public int getPanelWidth(){
		return mf.getWidth();
	}
	static public int getPanelHeight(){
		return mf.getHeight();
	}
}
