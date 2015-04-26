package gui.player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
		playerbl.favouritePlayers(name);
		
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
			pnl_info.add(new PlayerSeasonStatsPanel(playerbl,vo.getName()));
			pnl_main.add(pnl_info);
			
			JPanel pnl_match = new JPanel();
			pnl_match.setLayout(new BoxLayout(pnl_match,BoxLayout.X_AXIS));
			PlayerMatchStatsPanel pnl_match_stats = new PlayerMatchStatsPanel(playerbl, vo.getName());
			try {
				ArrayList<Date> dates = playerbl.getAvailableDays(MainFrame.season.season, vo.getName());
				pnl_main.add(new RecentMatchPanel(dates, pnl_match_stats));
			} catch (PlayerNotFound e) {
				JOptionPane.showMessageDialog(this, e.toString());
			}
			pnl_main.add(pnl_match_stats);
			pnl_main.add(pnl_match);
		}
	}

}
