package gui.player;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.border.LineBorder;

import java.awt.Component;

import javax.swing.border.CompoundBorder;

import vo.PlayerPortraitVO;

public class PortraitPanel extends JPanel {

	private static final long serialVersionUID = -3196192629310865321L;
	private String name;
	private Dimension SIZE = new Dimension(230,185);
	/**
	 * Create the panel.
	 */
	public PortraitPanel(ImageIcon image, String name) {
		this.name = name;
		
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(5, 8, 5, 8)));

		JLabel lblPic = new JLabel(image);
		lblPic.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblPic);
		
		JLabel lblName = new JLabel(name);
		lblName.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblName);
		
	}
	public PortraitPanel(ImageIcon image, String name,double portion) {
		this.name = name;
		
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(5, 8, 5, 8)));

		JLabel lblPic = new JLabel(new ImageIcon(
				image.getImage().getScaledInstance((int)(SIZE.width*portion),(int)(SIZE.height*portion),Image.SCALE_SMOOTH)));
		lblPic.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblPic);
		
		JLabel lblName = new JLabel(name);
		lblName.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblName);
	}
	public PortraitPanel(String name,double portion) {
		this.name = name;
		
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(5, 8, 5, 8)));

		//TextRigidArea pnl_fill = new TextRigidArea((int)(SIZE.width*portion),(int)(SIZE.height*portion),"没有头像",Color.WHITE);
		add(Box.createRigidArea(new Dimension((int)(SIZE.width*portion),(int)(SIZE.height*portion))));
		
		JLabel lblName = new JLabel(name);
		lblName.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblName);
		
	}

	public PortraitPanel(PlayerPortraitVO playerPortraitVO) {
		this(playerPortraitVO.getPortrait(),playerPortraitVO.getName());
	}

	public String getName() {
		return name;
	}

}
