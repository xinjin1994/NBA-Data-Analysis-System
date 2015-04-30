package gui.team;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.util.ArrayList;

import vo.TeamVO;
import enums.Conference;
import enums.Division;
import factory.ObjectCreator;
import gui.MainFrame;
import businessLogicService.teamsBLService.TeamsBLService_new;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

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
		
		ImageIcon lbl_east_pic=new ImageIcon("image/main_menu/lbl_east.png");
		JLabel lbl_east = new JLabel(lbl_east_pic);
		lbl_east.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_east.setFont(new Font("宋体", Font.PLAIN, 65));
		pnl_title.add(lbl_east);
		
		ImageIcon lbl_west_pic=new ImageIcon("image/main_menu/lbl_west.png");
		JLabel lbl_west = new JLabel(lbl_west_pic);
		lbl_west.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_west.setFont(new Font("宋体", Font.PLAIN, 65));
		pnl_title.add(lbl_west);
		
		JScrollPane scrp = new JScrollPane();
		scrp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrp, BorderLayout.CENTER);
		
		JPanel pnl_teams = new JPanel(){
			 public void paintComponent(Graphics gs) {  
			        Graphics2D g = (Graphics2D) gs;  
			        super.paintComponent(g);  
			        //画背景图片  
			        String imagePath="image\\main_menu\\01.jpg";
//			        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));  
			        ImageIcon img = new ImageIcon(imagePath);
			        img.setImage(img.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));
			        g.drawImage(img.getImage(), 0, 0,getWidth(),getHeight(), this);  
			    }
		};
		pnl_teams.setPreferredSize(new Dimension(MainFrame.screen.width-500,1800));
		scrp.setViewportView(pnl_teams);
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
			if(i%2 == 0)
				panelList[i].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
			else
				panelList[i].setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));
			pnl_teams.add(panelList[i]);
		}
		
		
		
	}
	
}
