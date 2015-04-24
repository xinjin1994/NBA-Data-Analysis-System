package gui.team;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vo.TeamVO;
import enums.Teams;

public class TeamPortraitPanel extends JPanel {
	private static final long serialVersionUID = -3815129792429001677L;
	private TeamVO vo;
	
	public TeamPortraitPanel(ImageIcon image, Teams team) {
		
		image.setImage(image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		//this.setSize(150, 180);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JLabel lbl_image = new JLabel();
		lbl_image.setIcon(image);
		lbl_image.setAlignmentX(0.5f);
		add(lbl_image);
		
		JLabel lbl_name = new JLabel(team.toString());
		lbl_name.setFont(new Font("宋体", Font.PLAIN, 20));
		lbl_name.setAlignmentX(0.5f);
		lbl_name.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl_name);
		
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1){
					new TeamDetailDialog(vo).setVisible(true);
				}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setCursor(Cursor.getDefaultCursor());
			}
			
		});
		
	}
	
	public TeamPortraitPanel(TeamVO vo){
		this(vo.getImage(), vo.getTeam());
		this.vo = vo;
	}
	
	public Teams getTeam(){
		return vo.getTeam();
	}
}
