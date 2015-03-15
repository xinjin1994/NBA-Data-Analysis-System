package gui.player;

import javax.swing.JPanel;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PortraitPanel extends JPanel {

	private static final long serialVersionUID = -3196192629310865321L;

	/**
	 * Create the panel.
	 */
	public PortraitPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ImageIcon ii = new ImageIcon("E:\\assignment\\2015 I\\softwareIII\\迭代一数据\\players\\portrait\\Aaron Brooks.png");
		
		JLabel lblPic = new JLabel(ii);
		add(lblPic);
		
		JLabel lblName = new JLabel("Aaron Brooks");
		add(lblName);
		
	}

}
