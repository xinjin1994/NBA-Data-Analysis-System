package gui;

import gui.util.GUIUtility;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 2292455670620751734L;
	private JPanel contentPane;
	
	public static Dimension screen;
	public static Frame currentFrame;

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
		currentFrame = this;
		screen = Toolkit.getDefaultToolkit().getScreenSize();

		this.setSize(screen);
		
		setTitle("NBA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUIUtility.setCenter(this);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnl_main = new JPanel();
		contentPane.add(pnl_main, BorderLayout.CENTER);
		pnl_main.setLayout(new CardLayout(0, 0));
		
		JPanel pnl_menu = new JPanel();
		pnl_main.add(pnl_menu);
		GridBagLayout gbl_pnl_menu = new GridBagLayout();
		gbl_pnl_menu.columnWidths = new int[]{getWidth()/6, getWidth()/3, getWidth()/3,getWidth()/6};
		gbl_pnl_menu.rowHeights = new int[]{getHeight()/6, getHeight()/3, getHeight()/3,getHeight()/6};
		gbl_pnl_menu.columnWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnl_menu.rowWeights = new double[]{Double.MIN_VALUE, 0.0, 0.0, Double.MIN_VALUE};
		pnl_menu.setLayout(gbl_pnl_menu);
		
		JButton btn_player = new JButton("球员");
		GridBagConstraints gbc_btn_player = new GridBagConstraints();
		gbc_btn_player.gridx = 1;
		gbc_btn_player.gridy = 1;
		pnl_menu.add(btn_player, gbc_btn_player);
		
		JButton btn_team = new JButton("球队");
		GridBagConstraints gbc_btn_team = new GridBagConstraints();
		gbc_btn_team.gridx = 2;
		gbc_btn_team.gridy = 1;
		pnl_menu.add(btn_team, gbc_btn_team);
		
		JButton btn_game = new JButton("比赛");
		GridBagConstraints gbc_btn_game = new GridBagConstraints();
		gbc_btn_game.gridx = 1;
		gbc_btn_game.gridy = 2;
		pnl_menu.add(btn_game, gbc_btn_game);
		
		JButton btn_statistic = new JButton("统计");
		GridBagConstraints gbc_btn_statistic = new GridBagConstraints();
		gbc_btn_statistic.gridx = 2;
		gbc_btn_statistic.gridy = 2;
		pnl_menu.add(btn_statistic, gbc_btn_statistic);
	}

}
