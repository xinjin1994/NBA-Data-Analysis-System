package gui.player;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.border.CompoundBorder;

public class PortraitPanel extends JPanel {

	private static final long serialVersionUID = -3196192629310865321L;

	/**
	 * Create the panel.
	 */
	public PortraitPanel() {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(5, 8, 5, 8)));
		
		ImageIcon ii = new ImageIcon("E:\\assignment\\2015 I\\softwareIII\\迭代一数据\\players\\portrait\\Aaron Brooks.png");
		
		JLabel lblPic = new JLabel(ii);
		lblPic.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblPic);
		
		JLabel lblName = new JLabel("Aaron Brooks");
		lblName.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblName);
		
	}

}
