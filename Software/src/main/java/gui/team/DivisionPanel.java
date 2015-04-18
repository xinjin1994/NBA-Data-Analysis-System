package gui.team;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import businessLogicService.teamsBLService.TeamsBLService_new;
import vo.TeamVO;
import data.init.DataInit;
import enums.Conference;
import enums.Division;
import exceptions.TeamNotFound;
import factory.ObjectCreator;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

public class DivisionPanel extends JPanel {
	private static final long serialVersionUID = -8415790128985762866L;
	TeamsBLService_new service;
	
	public DivisionPanel(Conference conference, Division division) {
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JLabel lbl_division = new JLabel(division.toString());
		lbl_division.setFont(new Font("宋体", Font.PLAIN, 30));
		lbl_division.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl_division);

		service = new ObjectCreator().teamsBLService();
		try {
			ArrayList<TeamVO> teamList = service.getTeamsInfo(conference, division);
			for(TeamVO team: teamList){
				add(new TeamPortraitPanel(team));
			}
		} catch (TeamNotFound e) {
			
		}

	}
	/*
	public void setSize(int width, int height) {
		int wid = (int)width/2;
		int hei = 600;
		Dimension dim = new Dimension(wid, hei);
		this.setPreferredSize(dim);
	}
	*/
	public static void main(String args[]){
		new DataInit().init();
		JFrame frame = new JFrame();
		frame.setSize(1280, 720);
		DivisionPanel panel = new DivisionPanel(Conference.EASTERN, Division.ATLANTIC);
		frame.getContentPane().add(panel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
