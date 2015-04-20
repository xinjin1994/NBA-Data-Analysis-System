package gui.hot;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.PlayerProgressVO;
import vo.PlayerVO;
import businessLogicService.playersBLService.PlayersBLService_new;
import enums.Terminology;
import exceptions.PlayerNotFound;
import factory.ObjectCreator;
import gui.player.PortraitPanel;
import gui.util.GUIUtility;

public class ProgressPlayerItemPanel extends JPanel {
	private static final long serialVersionUID = -8038316105498505686L;
	private static final int RANK_NUMBER = 5;
	private static PlayersBLService_new playerbl = new ObjectCreator().playersBLService();
	private ArrayList<PlayerProgressVO> players;

	public ProgressPlayerItemPanel(Terminology term) {
		players = playerbl.getPlayerProgress(term, RANK_NUMBER);
		
		if(players.size() == 0){
			setLayout(new BorderLayout());
			add(new JLabel("该排名无数据"));
		}
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		
		try {
			PlayerVO vo = playerbl.getPlayerInfo(players.get(0).getName());
			add(new PortraitPanel(vo.getPortrait(),vo.getName(),0.4));
		} catch (PlayerNotFound e) {
			add(new PortraitPanel(players.get(0).getName(),0.4));
		}
		
		JLabel lbl_team = new JLabel(players.get(0).getTeam().toString()+"——"+players.get(0).getPosition().toString());
		lbl_team.setAlignmentX(0.5f);
		add(lbl_team);
		
		ArrayList<Double> stats = players.get(0).getStats();
		JLabel lbl_stats1 = new JLabel("近5场"+term.toString()+":"+GUIUtility.formatDouble(stats.get(0))+", "
				+GUIUtility.formatDouble(stats.get(1))+","+GUIUtility.formatDouble(stats.get(2))+", "
				+GUIUtility.formatDouble(stats.get(3))+", "+GUIUtility.formatDouble(stats.get(4)));
		lbl_stats1.setAlignmentX(0.5f);
		add(lbl_stats1);
		
		JLabel lbl_improv = new JLabel("提升:"+GUIUtility.formatDouble(players.get(0).getImprovement())+"%");
		lbl_improv.setAlignmentX(0.5f);
		add(lbl_improv);
		
		JButton btn_rank = new JButton("查看前5名");
		btn_rank.setAlignmentX(0.5f);
		add(btn_rank);
		btn_rank.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
	}

}
