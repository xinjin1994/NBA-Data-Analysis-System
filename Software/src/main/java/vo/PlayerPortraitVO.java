package vo;

import javax.swing.ImageIcon;

public class PlayerPortraitVO {

	private String name;
	private ImageIcon portrait;

	public PlayerPortraitVO(String name,ImageIcon portrait) {
		this.setName(name);
		this.setPortrait(portrait);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getPortrait() {
		return portrait;
	}

	public void setPortrait(ImageIcon portrait) {
		this.portrait = portrait;
	}

}
