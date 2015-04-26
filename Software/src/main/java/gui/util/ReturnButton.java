package gui.util;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ReturnButton extends JButton {

	private static final long serialVersionUID = -6384563195329557062L;

	public ReturnButton() {
		this.setText("返回");
		
		this.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.mf.popPanel();
			}
		});
	}

}
