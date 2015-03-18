package gui.player;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.Component;
import javax.swing.border.CompoundBorder;

public class PortraitPanel extends JPanel {

	private static final long serialVersionUID = -3196192629310865321L;

	/**
	 * Create the panel.
	 */
	public PortraitPanel(ImageIcon image, String name) {
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

}
