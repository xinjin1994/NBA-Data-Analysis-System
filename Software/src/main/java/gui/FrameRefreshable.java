package gui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public abstract class FrameRefreshable extends JFrame{
	private static final long serialVersionUID = 2857477414306107239L;

	public FrameRefreshable(String title) {
		super(title);
		addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent fe) {
				MainFrame.currentFrame = FrameRefreshable.this;
			}
			@Override
			public void focusLost(FocusEvent fe) {
				//do nothing
			}
		});
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent arg0) {
				MainFrame.disposeDialog(FrameRefreshable.this);
			}
		});
	}

	public abstract void refresh();
}
