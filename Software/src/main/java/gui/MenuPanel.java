
package gui;

import enums.PanelType;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends SelfAdjustPanel {

	private static final long serialVersionUID = 8475751505006519027L;

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
//		GridBagLayout gbl_pnl_menu = new GridBagLayout();
//		gbl_pnl_menu.columnWidths = new int[]{pWidth/6, (int)(pWidth*2.0/3.0),pWidth/6};
//		gbl_pnl_menu.rowHeights = new int[]{pHeight/6, (int)(pHeight*2.0/3.0),pHeight/6};
//		gbl_pnl_menu.columnWeights = new double[]{1, 0.0, 1};
//		gbl_pnl_menu.rowWeights = new double[]{1, 0.0, 1};
//		setLayout(gbl_pnl_menu);
//		
//		JPanel pnl_menu = new JPanel();
//		GridBagConstraints gbc_menu = new GridBagConstraints();
//		gbc_menu.gridx = 1;
//		gbc_menu.gridy = 1;
//		add(pnl_menu,gbc_menu);
		this.setLayout(null);
		this.setVisible(true);
//		this.setBorder(null);
		
		ImageIcon btn_player_pic=new ImageIcon("image/main_menu/btn_player.png");
		JButton btn_player = new JButton(btn_player_pic);
		btn_player.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.gotoPanel(PanelType.PLAYER);
			}
		});
		add(btn_player);
		btn_player.setBounds(940, 330, 238, 64);
		btn_player.setBorderPainted(false);
		
		ImageIcon btn_team_pic=new ImageIcon("image/main_menu/btn_team.png");
		JButton btn_team = new JButton(btn_team_pic);
		btn_team.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.gotoPanel(PanelType.TEAM);
			}
		});
		add(btn_team);
		btn_team.setBounds(940, 410, 238, 64);
		btn_team.setBorderPainted(false);
		
		ImageIcon btn_match_pic=new ImageIcon("image/main_menu/btn_game.png");
		JButton btn_match = new JButton(btn_match_pic);
		btn_match.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.gotoPanel(PanelType.MATCH);
			}
		});
		add(btn_match);
		btn_match.setBounds(940,490,238,64);
		btn_match.setBorderPainted(false);
		
		ImageIcon btn_statistic_pic=new ImageIcon("image/main_menu/btn_data.png");
		JButton btn_statistic = new JButton(btn_statistic_pic);
		btn_statistic.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.gotoPanel(PanelType.STATISTIC);
			}
		});
		add(btn_statistic);
		btn_statistic.setBounds(940,570,238,64);
		btn_statistic.setBorderPainted(false);
		
		ImageIcon btn_hot_pic=new ImageIcon("image/main_menu/btn_hotspot.png");
		JButton btn_hot = new JButton(btn_hot_pic);
		btn_hot.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.gotoPanel(PanelType.HOT);
			}
		});
		add(btn_hot);
		btn_hot.setBounds(940,650,238,64);
		btn_hot.setBorderPainted(false);
		
//		ImageIcon btn_minisize_pic=new ImageIcon("image/main_menu/btn_minisize.png");
//		JButton btn_minisize=new JButton(btn_minisize_pic);
//		btn_hot.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				setExtendedState(Frame.ICONIFIED);
//			}
//		});
//		 
		 
	}
	public void paintComponent(Graphics gs) {  
        Graphics2D g = (Graphics2D) gs;  
        super.paintComponent(g);  
        //画背景图片  
        String imagePath="image\\main_menu\\bg01.jpg";
//        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));  
        ImageIcon img = new ImageIcon(imagePath);
        img.setImage(img.getImage().getScaledInstance(pWidth,pHeight,Image.SCALE_DEFAULT));
        g.drawImage(img.getImage(), 0, 0,pWidth,pHeight, this);  
    }

}
