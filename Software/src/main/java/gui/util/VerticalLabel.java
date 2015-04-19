package gui.util;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VerticalLabel extends JPanel {
	private static final long serialVersionUID = 5809659239182219938L;

	public VerticalLabel(String string) {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		String[] chars = string.split("");
		for(String str:chars)
			add(new JLabel(str));
	}

}
