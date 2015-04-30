package gui.statistic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class StatisticPanel extends JPanel {

	private static final long serialVersionUID = 8475751505006519027L;

	/**
	 * Create the panel.
	 */
	 public void paintComponent(Graphics gs) {  
	        Graphics2D g = (Graphics2D) gs;  
	        super.paintComponent(g);  
	        //画背景图片  
	        String imagePath="image\\main_menu\\04.png";
//	        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));  
	        ImageIcon img = new ImageIcon(imagePath);
	        img.setImage(img.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));
	        g.drawImage(img.getImage(), 0, 0,getWidth(),getHeight(), this);  
	    }
	public StatisticPanel() {
		setLayout(new BorderLayout());
		
		JTabbedPane pane = new JTabbedPane();
		pane.setBackground(new Color(0,0,0,0));
		pane.add(new PlayerStatisticPanel(),"球员统计数据");
		pane.add(new TeamStatisticPanel(),"球队统计数据");

		add(pane);
	}

}
