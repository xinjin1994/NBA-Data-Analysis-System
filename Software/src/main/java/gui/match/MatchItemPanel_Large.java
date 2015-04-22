package gui.match;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vo.MatchVO;
import vo.TeamVO;

import javax.swing.SwingConstants;

import exceptions.TeamNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
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

	public MatchItemPanel_Large(boolean displaydate) {
		this.setLayout(new BorderLayout());
		
		JPanel pnl_match = new JPanel();
		pnl_match.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(pnl_match);
		
		lbl_date = new JLabel();
		lbl_date.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date.setAlignmentX(0.5f);
		if(displaydate)
			pnl_match.add(lbl_date,BorderLayout.NORTH);
		
		
		JPanel pnl_team = new JPanel();
		pnl_team.setLayout(new GridLayout(4,3));
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
		lbl_guest_icon = new JLabel();
		lbl_guest_icon.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl_host_icon,BorderLayout.WEST);
		pnl_team.add(Box.createHorizontalGlue());
		add(lbl_guest_icon,BorderLayout.EAST);
		
		lbl_host = new JLabel();
		lbl_host.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_guest = new JLabel();
		lbl_guest.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_team.add(lbl_host);
		pnl_team.add(Box.createHorizontalGlue());
		pnl_team.add(lbl_guest);

		lbl_host_score = new JLabel();
		lbl_host_score.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_guest_score = new JLabel();
		lbl_guest_score.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_team.add(lbl_host_score);
		JLabel label = new JLabel(":");
		label.setHorizontalAlignment(SwingConstants.CENTER);
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
			TeamVO hostvo = teambl.getTeamInfo(vo.getTeam1());
			TeamVO guestvo = teambl.getTeamInfo(vo.getTeam2());
			
			lbl_host_icon.setIcon(hostvo.getImage());
			lbl_guest_icon.setIcon(guestvo.getImage());
			
			lbl_host.setText(hostvo.getConference().toString()+"  "+vo.getTeam1().toString());
			lbl_guest.setText(guestvo.getConference().toString()+"  "+vo.getTeam2().toString());
		} catch (TeamNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		}

		String[] score = vo.getScore().split("-");
		lbl_host_score.setText(score[0]);
		lbl_guest_score.setText(score[1]);
	}

}
