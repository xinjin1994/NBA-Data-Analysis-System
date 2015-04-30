package gui.team;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import vo.PlayerVO;
import vo.TeamVO;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.match.RecentMatchPanel;
import gui.player.PlayerDialog;
import gui.player.PortraitPanel;
import businessLogicService.playersBLService.PlayersBLService_new;
import businessLogicService.teamsBLService.TeamsBLService_new;

public class TeamDetailPanel extends JPanel {
	private static final long serialVersionUID = -6532991967501331579L;
	private static TeamsBLService_new teambl = new ObjectCreator().teamsBLService();

	public void paintComponent(Graphics gs) {  
        Graphics2D g = (Graphics2D) gs;  
        super.paintComponent(g);  
        //画背景图片  
        String imagePath="image\\main_menu\\01.jpg";
//        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));  
        ImageIcon img = new ImageIcon(imagePath);
        img.setImage(img.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));
        g.drawImage(img.getImage(), 0, 0,getWidth(),getHeight(), this);  
    }
	public TeamDetailPanel(TeamVO infovo) {
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(5,5,5,5));
		
		{
			JPanel pnl_team = new JPanel();
			pnl_team.setLayout(new BoxLayout(pnl_team,BoxLayout.Y_AXIS));
			add(pnl_team);
			{
				JPanel pnl_basic = new JPanel();
				pnl_team.add(pnl_basic);
				JLabel lbl_icon = new JLabel(new ImageIcon(infovo.getImage().getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH)));
				pnl_basic.add(lbl_icon);
				
				pnl_basic.add(new TeamBasicInfoPanel(infovo));
			}
			pnl_team.add(new TeamSeasonStatsPanel(teambl,infovo.getTeam()));
			pnl_team.add(Box.createVerticalStrut(10));
			
			{
				JPanel pnl_match = new JPanel();
				pnl_match.setLayout(new BoxLayout(pnl_match,BoxLayout.Y_AXIS));
				pnl_team.add(pnl_match);
				pnl_match.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLACK), "比赛数据"));
				ArrayList<Date> datelist = teambl.getAvailableDays(MainFrame.season.season, infovo.getTeam());
				TeamMatchStatsPanel pnl_matchStats = new TeamMatchStatsPanel(teambl, infovo.getTeam());
				JPanel boxPanel = new JPanel();
				boxPanel.add(new RecentMatchPanel(datelist,pnl_matchStats,infovo.getTeam()));
				pnl_match.add(boxPanel);
				pnl_match.add(pnl_matchStats);
			}
		}
		
		{
			PlayersBLService_new playerbl = new ObjectCreator().playersBLService();
			ArrayList<PlayerVO> players = playerbl.getTeamMembers(infovo.getTeam());
			PortraitPanel[] portraits = new PortraitPanel[players.size()];
			for(int i = 0;i < players.size();i++){
				PlayerVO player = players.get(i);
				if(player.getPortrait() != null)
					portraits[i] = new PortraitPanel(player.getPortrait(),player.getName(),0.4,player.getPosition());
				else
					portraits[i] = new PortraitPanel(players.get(i).getName(),0.4,player.getPosition());
				
			}
			JList<PortraitPanel> list = new JList<PortraitPanel>(portraits);
			list.setLayoutOrientation(JList.VERTICAL);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setCellRenderer(new ListCellRenderer<PortraitPanel>(){
				@Override
				public Component getListCellRendererComponent(
						JList<? extends PortraitPanel> arg0, PortraitPanel pnl,
						int arg2, boolean selected, boolean focused) {
					pnl.setBorder(new LineBorder(Color.BLACK,1));
					pnl.setToolTipText("双击以查看球员详细信息");
					return pnl;
				}
			});
			list.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent me){
					if(me.getButton() == MouseEvent.BUTTON1 && me.getClickCount() == 2){
						MainFrame.showDialog(new PlayerDialog(list.getSelectedValue().getName()));
					}
				}
			});
			JScrollPane scrp =  new JScrollPane(list);
			scrp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrp.setBorder(BorderFactory.createTitledBorder(new EmptyBorder(5,0,5,0), "球员列表"));
			
			add(scrp,BorderLayout.EAST);
		}
	}
}
