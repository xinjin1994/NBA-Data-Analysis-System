package gui;

import data.init.DataInit;
import enums.Teams;
import enums.Terminology;
import exceptions.MatchNotFound;
import exceptions.PlayerNotFound;
import gui.match.player.MatchItemPanel_Small;
import gui.match.player.RecentMatchPanel;
import gui.util.AdjustableTable.CheckComboBox;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.matchesBL.MatchesBL_new;
import businessLogic.playersBL.PlayersBL_new;

public class TestFrame extends JFrame {
	private static final long serialVersionUID = -4771769317423285893L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		new DataInit().init();
		
		this.setSize(new Dimension(200,200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		
	}

}
