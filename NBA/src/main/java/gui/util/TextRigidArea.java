package gui.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TextRigidArea extends JPanel {
	private static final long serialVersionUID = -23251709075324870L;

	public TextRigidArea(Dimension size,String text,Color background) {
		JLabel lblPic = new JLabel(text);
		lblPic.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setBackground(background);
		lblPic.setPreferredSize(size);
		lblPic.setMaximumSize(size);
		lblPic.setSize(size);
		setLayout(new BorderLayout());
		setBackground(background);
		add(lblPic);
		setPreferredSize(size);
	}
	public TextRigidArea(int width,int height,String text,Color background) {
		this(new Dimension(width,height),text,background);
	}

}
