
package gui;

import gui.match.Season;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.init.DataInit;
import enums.PanelType;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainFrame extends FrameRefreshable{

	private static final long serialVersionUID = 2292455670620751734L;
	private static ArrayList<FrameRefreshable> refreshList = new ArrayList<FrameRefreshable>();
	//用来保存屏幕的大小
	public static Dimension screen;
	public static FrameRefreshable currentFrame;
	private static MainFrame mf;
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
		super("NBA数据查询系统");
		new DataInit().init();
		
		currentFrame = mf = this;
		screen = new Dimension(1280,720);

		//和屏幕一样大
		this.setSize(screen);//固定窗口大小
		this.setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 640));
		//this.setResizable(false);
		JPanel contentPane = new JPanel();
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
		
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowOpened(WindowEvent arg0) {
				screen = pnl_main.getSize();
			}
		});
	}

	//通过枚举类型来切换版面的集中式控制
	public static void gotoPanel(PanelType type){
		mf.pnl_tools.addPanel(type);
		mf.pnl_tools.pushPanel(type);
		mf.pnl_tools.showPanel(type);
	}
	
	static public int getPanelWidth(){
		return mf.getWidth();
	}
	static public int getPanelHeight(){
		return mf.getHeight();
	}

	public static void refreshAll(){
		mf.refresh();
	}
	public void refresh() {
		pnl_tools.refresh();
		for(FrameRefreshable f:refreshList)
			f.refresh();
	}

	public static void showDialog(FrameRefreshable dia){
		dia.setVisible(true);
		refreshList.add(dia);
	}
	
	public static void disposeDialog(FrameRefreshable dia){
		refreshList.remove(dia);
		dia.dispose();
	}
}

