package dataService.imageService;

import javax.swing.ImageIcon;

import enums.Teams;

public interface ImageService {
	//
	public ImageIcon getPlayerAction(String name);
	public ImageIcon getPlayerPortrait(String name);
	public ImageIcon getTeamImage(Teams team);
	
}
