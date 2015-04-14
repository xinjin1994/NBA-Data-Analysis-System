package gui.team;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import vo.TeamVO;
import enums.Teams;

import javax.swing.JSplitPane;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeamPortraitPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3815129792429001677L;
	Teams team;
	
	/**
	 * @wbp.parser.constructor
	 */
	public TeamPortraitPanel(ImageIcon image, Teams team) {
		this.team = team;
		
		image.setImage(image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		//this.setSize(150, 180);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTeamname = new JLabel(team.toString());
		lblTeamname.setFont(new Font("宋体", Font.PLAIN, 20));
		lblTeamname.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTeamname, BorderLayout.SOUTH);
		
		JLabel lblImage = new JLabel();
		lblImage.setIcon(image);
		add(lblImage, BorderLayout.CENTER);
		
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1){
					System.out.println("Open a new Window");
				}
			}
		});
		
	}
	
	public TeamPortraitPanel(TeamVO vo){
		this(vo.getImage(), vo.getName());
	}
	
	public Teams getTeam(){
		return team;
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setSize(200, 230);
		
		ImageIcon image = new ImageIcon("teams/ATL.png");
		Teams team = Teams.ATL;
		TeamPortraitPanel panel = new TeamPortraitPanel(image, team);
		
		frame.getContentPane().add(panel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}