package gui;

import gui.match.Season;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.init.DataInit;
import enums.PanelType;

import java.awt.CardLayout;

public class MainFrame extends JFrame implements Refreshable{

	private static final long serialVersionUID = 2292455670620751734L;
	private JPanel contentPane;
	
	//用来保存屏幕的大小
	public static Dimension screen;
	//保留cardlayout中panel与对应字符串的配对关系
	//未来可能有有新的窗口
	public static Frame currentFrame;
	public static MainFrame mf;
	public static Season season;
	private JPanel pnl_main;
	private CardLayout cardlayout;
	private ToolsPanel  pnl_tools;
	

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
		
		pnl_main = new JPanel();
		contentPane.add(pnl_main, BorderLayout.CENTER);
		//cardlayout用来切换不同的版面
		cardlayout = new CardLayout();
		pnl_main.setLayout(cardlayout);
		
		//JPanel pnl_menu = new MenuPanel();
		//pnl_main.add(pnl_menu,PanelType.MENU.toString());

		pnl_tools = new ToolsPanel(pnl_main);
		contentPane.add(pnl_tools,BorderLayout.NORTH);
		
		gotoPanel(PanelType.MENU);
	}

	//通过枚举类型来切换版面的集中式控制
	public void gotoPanel(PanelType type){
		pnl_tools.addPanel(type);
		pnl_tools.pushPanel(type);
		pnl_tools.showPanel(type);
	}
	
	static public int getPanelWidth(){
		return mf.getWidth();
	}
	static public int getPanelHeight(){
		return mf.getHeight();
	}

	@Override
	public void refresh() {
		pnl_tools.refresh();
	}

}
