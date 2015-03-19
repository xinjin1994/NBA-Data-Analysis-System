package data.imageData;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataService.imageService.ImageService;
import enums.Teams;

public class ImageData implements ImageService {

	@Override
	public ImageIcon getPlayerAction(String name) {
		String filename = "players/acton/" + name + ".png";
		ImageIcon image = new ImageIcon(filename);
		return image;
	}

	@Override
	public ImageIcon getPlayerPortrait(String name) {
		String filename = "players/portrait/" + name + ".png";
		ImageIcon image = new ImageIcon(filename);
		return image;
	}

	@Override
	public ImageIcon getTeamImage(Teams team) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static void main(String[] args){
		String name = "LeBron James";
		ImageIcon image = new ImageData().getPlayerPortrait(name);
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JLabel label = new JLabel(image);
		panel.add(label);
		label.setBounds(0,0,image.getIconWidth(), image.getIconHeight());
		
		frame.setSize((int)(image.getIconWidth()*1.3), (int)(image.getIconHeight()*1.3));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
