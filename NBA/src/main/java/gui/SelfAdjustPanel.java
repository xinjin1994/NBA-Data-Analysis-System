package gui;

import javax.swing.JPanel;

public class SelfAdjustPanel extends JPanel {

	private static final long serialVersionUID = 5624351623992258167L;

	protected int pWidth;
	protected int pHeight;
	
	public SelfAdjustPanel(){
		this(MainFrame.getPanelWidth(),MainFrame.getPanelHeight());
	}
	
	public SelfAdjustPanel(int panelWidth,int panelHeight) {
		pWidth = panelWidth;
		pHeight = panelHeight;
	}
}
