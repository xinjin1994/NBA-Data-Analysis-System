package gui.match;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vo.MatchVO;
import vo.TeamVO;

import javax.swing.SwingConstants;

import exceptions.TeamNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.team.TeamDialog;
import businessLogicService.teamsBLService.TeamsBLService_new;

public class MatchItemPanel_Large extends JPanel {
	private static final long serialVersionUID = 8710772911966562176L;
	private MatchVO vo;
	private JLabel lbl_date;
	private JLabel lbl_host;
	private JLabel lbl_guest;
	private JLabel lbl_host_score;
	private JLabel lbl_guest_score;
	private JLabel lbl_host_icon;
	private JLabel lbl_guest_icon;
	private JLabel lbl_hostCon;
	private JLabel lbl_guestCon;
	private TeamVO hostvo;
	private TeamVO guestvo;

	 public void paintComponent(Graphics gs) {  
	        Graphics2D g = (Graphics2D) gs;  
	        super.paintComponent(g);  
	        //画背景图片  
	        String imagePath="image\\main_menu\\04.png";
//	        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));  
	        ImageIcon img = new ImageIcon(imagePath);
	        img.setImage(img.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));
	        g.drawImage(img.getImage(), 0, 0,getWidth(),getHeight(), this);  
	    }
	 
	public MatchItemPanel_Large(boolean displaydate) {
		this.setLayout(new BorderLayout());
		
		JPanel pnl_match = new JPanel(){
			public void paintComponent(Graphics gs) {  
		        Graphics2D g = (Graphics2D) gs;  
//		        super.paintComponent(g);  
		        Paint p = new Color(0,0,0,0);
		        g.setPaint(p);
		        g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		pnl_match.setLayout(new BoxLayout(pnl_match,BoxLayout.Y_AXIS));
		add(pnl_match);
		
		lbl_date = new JLabel();
		lbl_date.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date.setAlignmentX(0.5f);
		if(displaydate)
			add(lbl_date,BorderLayout.NORTH);
		
		
		JPanel pnl_team = new JPanel(){
			public void paintComponent(Graphics gs) {  
		        Graphics2D g = (Graphics2D) gs;  
//		        super.paintComponent(g);  
		        Paint p = new Color(0,0,0,0);
		        g.setPaint(p);
		        g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		
		pnl_team.setLayout(new GridLayout(5,3));
		pnl_match.add(pnl_team);
		
		JLabel hostLabel = new JLabel("主队");
		hostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel guestLabel = new JLabel("客队");
		guestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_team.add(hostLabel);
		pnl_team.add(Box.createHorizontalGlue());
		pnl_team.add(guestLabel);
		
		lbl_host_icon = new JLabel();
		lbl_host_icon.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_host_icon.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				MainFrame.showDialog(new TeamDialog(hostvo));
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		lbl_guest_icon = new JLabel();
		lbl_guest_icon.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_guest_icon.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				MainFrame.showDialog(new TeamDialog(hostvo));
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		add(lbl_host_icon,BorderLayout.WEST);
		add(lbl_guest_icon,BorderLayout.EAST);
		
		lbl_hostCon = new JLabel();
		lbl_hostCon.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hostCon.setFont(new Font(lbl_hostCon.getFont().getName(),Font.BOLD,15));
		lbl_guestCon = new JLabel();
		lbl_guestCon.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_guestCon.setFont(new Font(lbl_guestCon.getFont().getName(),Font.BOLD,15));
		pnl_team.add(lbl_hostCon);
		pnl_team.add(Box.createHorizontalGlue());
		pnl_team.add(lbl_guestCon);
		
		lbl_host = new JLabel();
		lbl_host.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_host.setFont(new Font(lbl_host.getFont().getName(),Font.BOLD,25));
		lbl_guest = new JLabel();
		lbl_guest.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_guest.setFont(new Font(lbl_guest.getFont().getName(),Font.BOLD,25));
		pnl_team.add(lbl_host);
		pnl_team.add(Box.createHorizontalGlue());
		pnl_team.add(lbl_guest);

		lbl_host_score = new JLabel();
		lbl_host_score.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_host_score.setFont(new Font(lbl_host_score.getFont().getName(),Font.BOLD,25));
		lbl_guest_score = new JLabel();
		lbl_guest_score.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_guest_score.setFont(new Font(lbl_guest_score.getFont().getName(),Font.BOLD,25));
		JLabel label = new JLabel(":");
		label.setFont(new Font(label.getFont().getName(),Font.BOLD,25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_team.add(lbl_host_score);
		pnl_team.add(label);
		pnl_team.add(lbl_guest_score);
	}
	public MatchItemPanel_Large(MatchVO vo,boolean displaydate){
		this(displaydate);
		setMatchVO(vo);
	}
	
	public void setMatchVO(MatchVO vo){
		this.vo = vo;
		lbl_date.setText(new SimpleDateFormat("yyyy年MM月dd日").format(vo.getDay()));
		TeamsBLService_new teambl = new ObjectCreator().teamsBLService();
		
		try {
			hostvo = teambl.getTeamInfo(vo.getTeam1());
			guestvo = teambl.getTeamInfo(vo.getTeam2());
			
			lbl_host_icon.setIcon(new ImageIcon(hostvo.getImage().getImage().getScaledInstance(
					150,150,Image.SCALE_SMOOTH)));
			lbl_guest_icon.setIcon(new ImageIcon(guestvo.getImage().getImage().getScaledInstance(
					150,150,Image.SCALE_SMOOTH)));
			
			lbl_hostCon.setText(hostvo.getConference().toString());
			lbl_guestCon.setText(guestvo.getConference().toString());
			
			lbl_host.setText(vo.getTeam1().toString());
			lbl_guest.setText(vo.getTeam2().toString());
		} catch (TeamNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		}

		String[] score = vo.getScore().split("-");
		lbl_host_score.setText(score[0]);
		lbl_guest_score.setText(score[1]);
	}

	public MatchVO getMatch(){
		return vo;
	}
}
