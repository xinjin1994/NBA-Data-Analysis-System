package gui.player.detail;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

import businessLogicService.playersBLService.PlayersBLService_new;
import vo.PlayerVO;
import exceptions.PlayerNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.match.RecentMatchPanel;
import gui.match.player.PlayerMatchStatsPanel;

public class PlayerDetailDialog extends JDialog {

	private static final long serialVersionUID = -8359637791685664538L;
	private final JPanel contentPanel = new JPanel();
	private PlayersBLService_new playerbl = new ObjectCreator().playersBLService();
	/**
	 * Create the dialog.
	 */
	public PlayerDetailDialog(String name) {
		super(MainFrame.currentFrame);
		
		playerbl.favouritePlayers(name);
		
		setTitle("球员详情");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		PlayerVO vo = null;
		try {
			vo = playerbl.getPlayerInfo(name);
		} catch (PlayerNotFound e1) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, "Error!");
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_confirm = new JButton("OK");
				btn_confirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btn_confirm.setActionCommand("OK");
				buttonPane.add(btn_confirm);
				getRootPane().setDefaultButton(btn_confirm);
			}
		}
		
		pack();
	}

}
