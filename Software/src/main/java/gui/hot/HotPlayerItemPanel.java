package gui.hot;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.PlayerExtraStatsVO;
import vo.PlayerHotStatsVO;
import vo.PlayerVO;
import businessLogicService.playersBLService.PlayersBLService_new;
import enums.Terminology;
import exceptions.PlayerNotFound;
import factory.ObjectCreator;
import gui.player.PortraitPanel;
import gui.util.GUIUtility;
import gui.util.LabelPanel;

public class HotPlayerItemPanel extends JPanel {
	private static final long serialVersionUID = -8038316105498505686L;
	private static final int RANK_NUMBER = 5;
	private static PlayersBLService_new playerbl = new ObjectCreator().playersBLService();
	private ArrayList<PlayerHotStatsVO> players;
	private String season;
	private Date date;

	private void construct(Terminology term,boolean average) {
		if(players.size() == 0){
			setLayout(new BorderLayout());
			add(new JLabel("该排名无数据"));
		}
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		add(new LabelPanel(term,GUIUtility.formatDouble(players.get(0).getStats()),average));
		
		try {
			PlayerVO vo = playerbl.getPlayerInfo(players.get(0).getName());
			add(new PortraitPanel(vo.getPortrait(),vo.getName(),0.4));
		} catch (PlayerNotFound e) {
			add(new PortraitPanel(players.get(0).getName(),0.4));
		}
		
		JLabel lbl_team = new JLabel(players.get(0).getTeam().toString()+"——"+players.get(0).getPosition().toString());
		lbl_team.setAlignmentX(0.5f);
		add(lbl_team);
		
		/*
		JLabel lbl_position = new JLabel();
		lbl_position.setAlignmentX(0.5f);
		add(lbl_position);
		*/
		
		JButton btn_rank = new JButton("查看前5名");
		btn_rank.setAlignmentX(0.5f);
		add(btn_rank);
		btn_rank.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(average)
					new PlayerCompareDialog("赛季"+term.toString()+"排名",season, term, new ArrayList<PlayerExtraStatsVO>(players)).setVisible(true);
				else
					new PlayerCompareDialog(new SimpleDateFormat("MM月dd日").format(date)+term.toString()+"排名",season, 
							date, term, new ArrayList<PlayerExtraStatsVO>(players)).setVisible(true);
			}
		});
		
		add(Box.createVerticalGlue());
	}
	public HotPlayerItemPanel(String season,Date date,Terminology term) {
		this.season = season;
		this.date = date;
		players = playerbl.getHotPlayersByDay(season, date, term, RANK_NUMBER);
		construct(term,false);
	}
	public HotPlayerItemPanel(String season,Terminology term){
		this.season = season;
		players = playerbl.getHotPlayersBySeason(season, term, RANK_NUMBER);
		construct(term,true);
	}

}
