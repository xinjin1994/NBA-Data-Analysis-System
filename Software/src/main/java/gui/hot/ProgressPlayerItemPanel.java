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
		setLayout(new BorderLayout());
		
		JPanel pnl_stats = new JPanel();
		pnl_stats.setLayout(new BoxLayout(pnl_stats,BoxLayout.Y_AXIS));
		add(pnl_stats,BorderLayout.EAST);
		
		
		ArrayList<Double> stats = players.get(0).getStats();
		JLabel lbl_stats1 = new JLabel("场均:"+term.toString()+GUIUtility.formatDouble(stats.get(0))+"% "
				+GUIUtility.formatDouble(stats.get(1)));
		pnl_stats.add(lbl_stats1);
		int i;
		for(i = 2;i < stats.size()-2;i+=3){
			JLabel lbl_stats = new JLabel(GUIUtility.formatDouble(stats.get(i))+"% "
					+GUIUtility.formatDouble(stats.get(i+1))+"% "+GUIUtility.formatDouble(stats.get(i+2))+"%");
			pnl_stats.add(lbl_stats);
		}
		String tail = "";
		for(;i < stats.size();i++){
			tail += GUIUtility.formatDouble(stats.get(i))+"% ";
			
		}
		JLabel lbl_tail = new JLabel(tail);
		pnl_stats.add(lbl_tail);
		
		JLabel lbl_improv = new JLabel("提升："+GUIUtility.formatDouble(players.get(0).getImprovement())+"%");
		pnl_stats.add(lbl_improv);
		
		try {
			PlayerVO vo = playerbl.getPlayerInfo(players.get(0).getName());
			add(new PortraitPanel(vo.getPortrait(),vo.getName(),0.4));
		} catch (PlayerNotFound e) {
			add(new PortraitPanel(players.get(0).getName(),0.4));
		}
		
		JLabel lbl_team = new JLabel(players.get(0).getTeam().toString()+"——"+players.get(0).getPosition().toString());
		lbl_team.setAlignmentX(0.5f);
		pnl_stats.add(lbl_team);
		
		JButton btn_rank = new JButton("查看前5名");
		btn_rank.setAlignmentX(0.5f);
		pnl_stats.add(btn_rank);
		btn_rank.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
	}

}
