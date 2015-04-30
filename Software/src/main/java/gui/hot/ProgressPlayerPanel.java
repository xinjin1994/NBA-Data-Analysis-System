package gui.hot;

import enums.Terminology;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ProgressPlayerPanel extends JPanel {
	
	private static final long serialVersionUID = -464887637378876171L;

	public void paintComponent(Graphics gs) {  
        Graphics2D g = (Graphics2D) gs;  
//        super.paintComponent(g);  
        Paint p = new Color(0,0,0,0);
        g.setPaint(p);
        g.fillRect(0, 0, getWidth(), getHeight());
	}
	public ProgressPlayerPanel() {
		setLayout(new BorderLayout());
		setBorder(new CompoundBorder(new LineBorder(Color.BLACK),new EmptyBorder(0,0,5,0)));
		
		JPanel pnl_title = new JPanel(){
			public void paintComponent(Graphics gs) {  
		        Graphics2D g = (Graphics2D) gs;  
//		        super.paintComponent(g);  
		        Paint p = new Color(0,0,0,0);
		        g.setPaint(p);
		        g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		add(pnl_title, BorderLayout.NORTH);
		pnl_title.setLayout(new BoxLayout(pnl_title, BoxLayout.X_AXIS));
		JLabel lbl_title = new JLabel("进步球员");
		pnl_title.add(lbl_title);
		
		JPanel pnl_progress = new JPanel(){
			public void paintComponent(Graphics gs) {  
		        Graphics2D g = (Graphics2D) gs;  
//		        super.paintComponent(g);  
		        Paint p = new Color(0,0,0,0);
		        g.setPaint(p);
		        g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		pnl_progress.setLayout(new BoxLayout(pnl_progress,BoxLayout.X_AXIS));
		add(pnl_progress);
		for(Terminology term:Terminology.getPlayerProgress()){
			pnl_progress.add(Box.createHorizontalGlue());
			pnl_progress.add(new ProgressPlayerItemPanel(term));
		}
		pnl_progress.add(Box.createHorizontalGlue());
	}
	
	

}
