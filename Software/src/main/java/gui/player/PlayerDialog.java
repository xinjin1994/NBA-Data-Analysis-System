package gui.player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.util.ArrayList;
import java.util.Date;

import businessLogicService.playersBLService.PlayersBLService_new;
import vo.PlayerVO;
import exceptions.PlayerNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.FrameRefreshable;
import gui.match.RecentMatchPanel;

public class PlayerDialog extends FrameRefreshable{

	private static final long serialVersionUID = -8359637791685664538L;
	private PlayersBLService_new playerbl = new ObjectCreator().playersBLService();
	private String name;
	public PlayerDialog(String name) {
		super("球员详情");
		this.name = name;
		
		setTitle("球员详情");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		refresh();
		pack();
	}
	@Override
	public void refresh() {
		JPanel contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));

		PlayerVO vo = null;
		try {
			vo = playerbl.getPlayerInfo(name);
		} catch (PlayerNotFound e1) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e1.getErrorMessage());
			e1.printStackTrace();
			MainFrame.disposeDialog(this);
		}
		
		Image source = vo.getAction().getImage();
		ImageIcon image = new ImageIcon(source.getScaledInstance((int)(440*0.8), (int)(700*0.8), Image.SCALE_FAST));
		JLabel lbl_photo = new JLabel(image);
		lbl_photo.setBorder(new LineBorder(Color.BLACK,1));
		contentPanel.add(lbl_photo,BorderLayout.WEST);
		{
			JPanel pnl_main = new JPanel();
			pnl_main.setLayout(new BoxLayout(pnl_main,BoxLayout.Y_AXIS));
			contentPanel.add(pnl_main);
			
			JPanel pnl_info = new JPanel();
			pnl_info.setLayout(new BoxLayout(pnl_info,BoxLayout.X_AXIS));
			pnl_info.add(new PlayerBasicInfoPanel(vo));
			pnl_info.add(Box.createHorizontalStrut(40));
			PlayerSeasonStatsPanel pnl_season = new PlayerSeasonStatsPanel(playerbl,vo.getName());
			pnl_season.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLACK),"赛季数据",TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,new Font("黑体",Font.BOLD,20)));
			pnl_info.add(pnl_season);
			pnl_main.add(pnl_info);
			
			JPanel pnl_match = new JPanel();
			pnl_main.add(pnl_match);
			pnl_match.setLayout(new BoxLayout(pnl_match,BoxLayout.X_AXIS));
			pnl_match.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLACK),"比赛数据",TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION,new Font("黑体",Font.BOLD,20)));
			PlayerMatchStatsPanel pnl_match_stats = new PlayerMatchStatsPanel(playerbl, vo.getName());
			//pnl_match_stats.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			try {
				ArrayList<Date> dates = playerbl.getAvailableDays(MainFrame.season.season, vo.getName());
				pnl_match.add(new RecentMatchPanel(dates, pnl_match_stats));
			} catch (PlayerNotFound e) {
				JOptionPane.showMessageDialog(this, e.toString());
			}
			pnl_match.add(Box.createHorizontalStrut(20));
			pnl_match.add(pnl_match_stats);
			
		}
	}

}
