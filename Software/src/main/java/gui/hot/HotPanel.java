package gui.hot;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Image;

public class HotPanel extends JPanel {
	private static final long serialVersionUID = 27172124389622473L;

	public HotPanel() {
		setLayout(new CardLayout(0, 0));
		
		JPanel pnl_main = new JPanel(){
			public void paintComponent(Graphics gs) {  
		        Graphics2D g = (Graphics2D) gs;  
		        super.paintComponent(g);  
		        //画背景图片  
		        String imagePath="image\\main_menu\\01.jpg";
//		        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));  
		        ImageIcon img = new ImageIcon(imagePath);
		        img.setImage(img.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_DEFAULT));
		        g.drawImage(img.getImage(), 0, 0,getWidth(),getHeight(), this);  
		    }
		};
		pnl_main.setLayout(new GridLayout(3, 0, 0, 0));
		add(pnl_main);
		
		pnl_main.add(new HotPlayerPanel_OneDay());
		
		pnl_main.add(new ProgressPlayerPanel());
		
		pnl_main.add(new HotTeamPanel());
		
		

	}

}
