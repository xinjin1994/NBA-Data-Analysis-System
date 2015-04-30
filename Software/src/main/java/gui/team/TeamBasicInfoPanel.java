package gui.team;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.TeamVO;

public class TeamBasicInfoPanel extends JPanel {
	private static final long serialVersionUID = 4320079403822648306L;

	public void paintComponent(Graphics gs) {  
        Graphics2D g = (Graphics2D) gs;  
//        super.paintComponent(g);  
        Paint p = new Color(0,0,0,0);
        g.setPaint(p);
        g.fillRect(0, 0, getWidth(), getHeight());
	}
	public TeamBasicInfoPanel(TeamVO vo) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		ArrayList<JLabel> labels = new ArrayList<JLabel>(6);
		
		labels.add(new JLabel(vo.getTeam().toString()));
		labels.add(new JLabel(vo.getConference().toString()+"联盟  "+vo.getDivision().toString()+"   "+vo.getLocation()));
		labels.add(new JLabel("主场：  "+vo.getHomeCourt()));
		labels.add(new JLabel("创建时间："+vo.getYearOfEstablishment()));
		
		add(Box.createVerticalGlue());
		for(JLabel lbl:labels){
			lbl.setFont(new Font(lbl.getFont().getName(),Font.BOLD,25));
			add(lbl);
		}
		add(Box.createVerticalGlue());
	}

}
