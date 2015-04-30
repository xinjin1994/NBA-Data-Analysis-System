package gui.match;

import gui.MainFrame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import vo.MatchVO;

public class MatchPanel extends JPanel implements MatchVOChangeable{
	private static final long serialVersionUID = 1626371137475494976L;
	
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
	public MatchPanel(){
		setLayout(new BorderLayout());
		
		MatchListPanel pnl_list = new MatchListPanel(this);
		add(pnl_list);
	}

	@Override
	public void changeMatch(MatchVO vo) {
		MainFrame.showDialog(new MatchDialog(vo));
	}

	@Override
	public void noMatch() {
		//
	}
}
