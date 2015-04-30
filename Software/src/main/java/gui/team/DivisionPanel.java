package gui.team;

import java.util.ArrayList;

import javax.swing.ImageIcon;
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;

import javax.swing.SwingConstants;

public class DivisionPanel extends JPanel {
	private static final long serialVersionUID = -8415790128985762866L;
	TeamsBLService_new service;
	
	
	public void paintComponent(Graphics gs) {  
        Graphics2D g = (Graphics2D) gs;  
        super.paintComponent(g);  
        //画背景图片  
        String imagePath="image\\main_menu\\tool_pic.jpg";
//        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));  
        ImageIcon img = new ImageIcon(imagePath);
        img.setImage(img.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));
        g.drawImage(img.getImage(), 0, 0,getWidth(),getHeight(), this);  
    }
	public DivisionPanel(Conference conference, Division division) {
		
		setLayout(new BorderLayout());
		
		JLabel lbl_title = new JLabel(division.toString());
		lbl_title.setFont(new Font("宋体", Font.BOLD, 35));
		lbl_title.setAlignmentX(0.5f);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl_title,BorderLayout.NORTH);

		JPanel pnl_teams = new JPanel(){
			public void paintComponent(Graphics gs) {  
		        Graphics2D g = (Graphics2D) gs;  
//		        super.paintComponent(g);  
		        Paint p = new Color(0,0,0,0);
		        g.setPaint(p);
		        g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		add(pnl_teams);
		
		service = new ObjectCreator().teamsBLService();
		try {
			ArrayList<TeamVO> teamList = service.getTeamsInfo(conference, division);
			for(TeamVO team: teamList){
				pnl_teams.add(new TeamPortraitPanel(team));
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
