package data.imageData;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataService.imageService.ImageService;
import enums.Teams;

public class ImageData implements ImageService {
	
	static HashMap<String, ImageIcon> playerPortraitList;
	static HashMap<Teams, ImageIcon> teamsImage;
	
	public ImageData(){
		if(ImageData.playerPortraitList == null){
			playerPortraitList = new HashMap<String, ImageIcon>();
		}
		if(ImageData.teamsImage == null){
			teamsImage = new HashMap<Teams, ImageIcon>();
		}
	}

	@Override
	public ImageIcon getPlayerAction(String name) {
		String filename = "players/action/" + name + ".png";
		if(!fileExists(filename)){
			filename = "players/action/action.png";
		}
		ImageIcon image = new ImageIcon(filename);
		return image;
	}

	@Override
	public ImageIcon getPlayerPortrait(String name) {
		ImageIcon image = playerPortraitList.get(name);
		if(image != null){
			return image;
		}
		
		String filename = "players/portrait/" + name + ".png";
		if(!fileExists(filename)){
			filename = "players/portrait/portrait.png";
		}
		image = new ImageIcon(filename);
		playerPortraitList.put(name, image);
		return image;
	}

	@Override
	public ImageIcon getTeamImage(Teams team) {
		ImageIcon image = teamsImage.get(team);
		if(image != null){
			return image;
		}
		
		String filename = "teams/" + team.toAbbr() + ".png";
		image = new ImageIcon(filename);
		return image;
	}
	
	private boolean fileExists(String path){
		File file = new File(path);
		if(file.exists()){
			return true;
		}else{
			return false;
		}
	}

	
	public static void main(String[] args){
		String name = "LeBron James";
		ImageIcon image = new ImageData().getPlayerPortrait(name);
		image.setImage(image.getImage().getScaledInstance(image.getIconWidth()*2, 
				image.getIconHeight()*2, Image.SCALE_DEFAULT));
		
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
