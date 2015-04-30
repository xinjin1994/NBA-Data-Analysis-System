package gui.match;

import enums.Terminology;
import exceptions.PlayerNotFound;
import exceptions.TermNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.player.PlayerDialog;
import gui.player.PlayerMatchStatsPanel;
import gui.player.PortraitPanel;
import gui.team.TeamMatchStatsPanel;
import gui.util.NamedLabel;
import helper.TypeTransform;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import businessLogicService.playersBLService.PlayersBLService_new;
import businessLogicService.teamsBLService.TeamsBLService_new;
import vo.MatchVO;
import vo.PlayerVO;

public class MatchStatsPanel extends JPanel{
	private static final long serialVersionUID = -6812401158424280802L;
	private String season;
	private Date date;
	
	public MatchStatsPanel(MatchVO vo){
		season = vo.getSeason();
		date = TypeTransform.str_to_date(vo.getDate());
		setLayout(new BorderLayout());
		
		JPanel pnl_match = new JPanel(){
			public void paintComponent(Graphics gs) {  
		        Graphics2D g = (Graphics2D) gs;  
		        super.paintComponent(g);  
		        //画背景图片  
		        String imagePath="image\\main_menu\\04.png";
//		        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));  
		        ImageIcon img = new ImageIcon(imagePath);
		        img.setImage(img.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));
		        g.drawImage(img.getImage(), 0, 0,getWidth(),getHeight(), this);  
		    }
		};
		pnl_match.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		add(pnl_match);
		pnl_match.setLayout(new BorderLayout());
		
		pnl_match.add(new MatchItemPanel_Large(vo,true),BorderLayout.NORTH);
		
		JPanel pnl_stats = new JPanel();
		pnl_match.add(pnl_stats,BorderLayout.CENTER);
		pnl_stats.setLayout(new BoxLayout(pnl_stats,BoxLayout.Y_AXIS));
		
		JPanel pnl_score = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
		pnl_stats.add(pnl_score,BorderLayout.NORTH);
		for(int i = 1;i <= 4;i++){
			try {
				NamedLabel lbl = new NamedLabel("第"+String.valueOf(i)+"节比分",vo.getScore(i));
				lbl.setFontSize(15);
				pnl_score.add(lbl);
			} catch (TermNotFound e) {
				e.printStackTrace();
			}
		}
		if(vo.getScoreExtra() != null){
			NamedLabel lbl = new NamedLabel("加时比分",vo.getScoreExtra());
			lbl.setFontSize(15);
			pnl_score.add(lbl);
		}
		
		TeamsBLService_new teambl = new ObjectCreator().teamsBLService();
		TeamMatchStatsPanel pnl_hostStats = new TeamMatchStatsPanel(teambl,vo.getTeam1());
		pnl_hostStats.setMatch(season, date);
		JScrollPane scrp_host = new JScrollPane(pnl_hostStats);
		pnl_stats.add(scrp_host);
		scrp_host.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrp_host.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLACK),"主队",TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,new Font("黑体",Font.BOLD,20)));

		TeamMatchStatsPanel pnl_guestStats = new TeamMatchStatsPanel(teambl,vo.getTeam2());
		pnl_guestStats.setMatch(season, date);
		JScrollPane scrp_guest = new JScrollPane(pnl_guestStats);
		pnl_stats.add(scrp_guest);
		scrp_guest.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrp_guest.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLACK),"客队",TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,new Font("黑体",Font.BOLD,20)));
		

		JPanel list_host = createPlayerList(season,date,vo.getHomeTeamPlayers());
		add(list_host,BorderLayout.WEST);
		JPanel list_guest = createPlayerList(season,date,vo.getGuestTeamPlayers());
		add(list_guest,BorderLayout.EAST);
		
	}
	
	private JPanel createPlayerList(String season, Date date, ArrayList<String> players){
		PlayersBLService_new playerbl = new ObjectCreator().playersBLService();
		PortraitPanel[] portraits = new PortraitPanel[players.size()];
		for(int i = 0;i < players.size();i++){
			PlayerVO player;
			try {
				player = playerbl.getPlayerInfo(players.get(i));
				portraits[i] = new PortraitPanel(player.getPortrait(),player.getName(),0.4
						,playerbl.getPlayerPosition(season, date, player.getName()));
			} catch (PlayerNotFound e) {
				portraits[i] = new PortraitPanel(players.get(i),0.4 ,playerbl.getPlayerPosition(season, date, players.get(i)));
				e.printStackTrace();
			}
		}
		JList<PortraitPanel> list = new JList<PortraitPanel>(portraits);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setCellRenderer(new ListCellRenderer<PortraitPanel>(){
			@Override
			public Component getListCellRendererComponent(
					JList<? extends PortraitPanel> arg0, PortraitPanel pnl,
					int arg2, boolean selected, boolean focused) {
				if(selected)
					pnl.setBorder(new LineBorder(Color.BLACK,3));
				else
					pnl.setBorder(new LineBorder(Color.BLACK,1));
				pnl.setToolTipText("双击以查看球员详细信息");
				return pnl;
			}
		});
		JScrollPane scrp =  new JScrollPane(list);
		scrp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel pnl_player = new JPanel();
		pnl_player.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		pnl_player.setLayout(new BoxLayout(pnl_player,BoxLayout.Y_AXIS));
		pnl_player.add(scrp);
		JPanel pnl_stats = new JPanel(new CardLayout());
		pnl_player.add(pnl_stats);
		list.setSelectedIndex(0);
		PlayerMatchStatsPanel pnl_playerStats = new PlayerMatchStatsPanel(playerbl,list.getSelectedValue().getName()
				,Terminology.getPlayerCompareBasic(),13,new Insets(2,1,2,1),new Insets(5,1,5,1));
		pnl_playerStats.setMatch(season, date);
		pnl_stats.add(pnl_playerStats,"M");
		
		list.addMouseListener(new PlayerListListener(playerbl,list,pnl_stats));
		return pnl_player;
	}
	
	private class PlayerListListener extends MouseAdapter{
		private JPanel pnl;
		private JList<? extends PortraitPanel> list;
		private PlayersBLService_new playerbl;
		public PlayerListListener(PlayersBLService_new playerbl,JList<? extends PortraitPanel> list, JPanel pnl){
			this.pnl = pnl;
			this.list = list;
			this.playerbl = playerbl;
		}
		@Override
		public void mouseClicked(MouseEvent me){
			if(me.getButton() == MouseEvent.BUTTON1 && me.getClickCount() == 1){
				PlayerMatchStatsPanel pnl_playerStats = new PlayerMatchStatsPanel(playerbl,list.getSelectedValue().getName()
						,Terminology.getPlayerCompareBasic(),13,new Insets(2,1,2,1),new Insets(5,1,5,1));
				pnl_playerStats.setMatch(season, date);
				pnl.add(pnl_playerStats,"M");
				((CardLayout)pnl.getLayout()).show(pnl, "M");
			}
			else if(me.getButton() == MouseEvent.BUTTON1 && me.getClickCount() == 2){
				MainFrame.showDialog(new PlayerDialog(list.getSelectedValue().getName()));
			}
		}
	}
}
