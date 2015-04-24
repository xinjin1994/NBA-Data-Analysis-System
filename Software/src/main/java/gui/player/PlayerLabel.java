package gui.player;

import gui.player.detail.PlayerDetailDialog;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class PlayerLabel extends JLabel {
	private static final long serialVersionUID = -4521190206450643161L;
	
	public PlayerLabel(String name){
		super("<html><u>"+name+"</u></html>");
		
		setForeground(Color.BLUE);
		
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				new PlayerDetailDialog(name).setVisible(true);
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
}
