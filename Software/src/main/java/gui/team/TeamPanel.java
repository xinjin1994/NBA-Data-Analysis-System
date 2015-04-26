package gui.team;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import vo.TeamVO;
import data.init.DataInit;
import enums.Conference;
import enums.Division;
import factory.ObjectCreator;
import businessLogicService.teamsBLService.TeamsBLService_new;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class TeamPanel extends JPanel {
	private static final long serialVersionUID = 7485651519540450895L;

	TeamsBLService_new teamService = new ObjectCreator().teamsBLService();
	ArrayList<TeamVO> teamList;

	public TeamPanel() {
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		this.setSize(1280, 720);
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnl_title = new JPanel(new GridLayout(1,2));
		add(pnl_title, BorderLayout.NORTH);
		
		JLabel lbl_east = new JLabel("东部");
		lbl_east.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_east.setFont(new Font("宋体", Font.PLAIN, 65));
		pnl_title.add(lbl_east);
		
		JLabel lbl_west = new JLabel("西部");
		lbl_west.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_west.setFont(new Font("宋体", Font.PLAIN, 65));
		pnl_title.add(lbl_west);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel pnl_teams = new JPanel();
		scrollPane.setViewportView(pnl_teams);
		pnl_teams.setLayout(new GridLayout(3,2));
		
		int width = this.getWidth();
		DivisionPanel[] panelList = new DivisionPanel[6];
		panelList[0] = new DivisionPanel(Conference.EASTERN, Division.ATLANTIC);
		panelList[1] = new DivisionPanel(Conference.WESTERN, Division.SOUTHWEST);
		panelList[2] = new DivisionPanel(Conference.EASTERN, Division.CENTRAL);
		panelList[3] = new DivisionPanel(Conference.WESTERN, Division.NORTHWEST);
		panelList[4] = new DivisionPanel(Conference.EASTERN, Division.SOUTHEAST);
		panelList[5] = new DivisionPanel(Conference.WESTERN, Division.PACIFIC);
		for(int i=0; i<6; i++){
			panelList[i].setSize(width-20,panelList[i].getPreferredSize().height);
			panelList[i].setAlignmentX(0.5f);
			pnl_teams.add(panelList[i]);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new DataInit().init();
		JFrame frame = new JFrame();
		frame.setSize(1280, 720);
		TeamPanel panel = new TeamPanel();
		frame.getContentPane().add(panel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
