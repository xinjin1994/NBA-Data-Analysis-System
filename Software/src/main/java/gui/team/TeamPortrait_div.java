package gui.team;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import businessLogicService.teamsBLService.TeamsBLService_new;
import vo.TeamVO;
import data.init.DataInit;
import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;
import factory.ObjectCreator;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JSplitPane;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class TeamPortrait_div extends JPanel {

	TeamsBLService_new service;
	
	public TeamPortrait_div(Conference conference, Division division) {
		//this.setSize(450, 680);
		//this.setSize(new Dimension(400, 680));
		this.setPreferredSize(new Dimension(400, 680));
		
		setLayout(new BorderLayout(0, 0));
		
		UIDefaults defaults = UIManager.getDefaults();  
		defaults.remove( "SplitPane.border");  
		defaults.remove( "SplitPaneDivider.border"); 
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		JLabel lblDivision = new JLabel(division.toString());
		lblDivision.setFont(new Font("宋体", Font.PLAIN, 30));
		lblDivision.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane.setLeftComponent(lblDivision);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		service = new ObjectCreator().teamsBLService();
		try {
			ArrayList<TeamVO> teamList = service.getTeamsInfo(conference, division);
			for(TeamVO team: teamList){
				panel.add(new TeamPortraitPanel(team));
			}
		} catch (TeamNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void setSize(int width, int height) {
		int wid = (int)width/2;
		int hei = 600;
		Dimension dim = new Dimension(wid, hei);
		this.setPreferredSize(dim);
	}
	
	public static void main(String args[]){
		new DataInit().init();
		JFrame frame = new JFrame();
		frame.setSize(1280, 720);
		TeamPortrait_div panel = new TeamPortrait_div(Conference.EASTERN, Division.ATLANTIC);
		frame.getContentPane().add(panel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
