package gui.match;

import java.awt.Dimension;

import javax.swing.JDialog;

import vo.MatchVO;

public class MatchDialog extends JDialog {
	private static final long serialVersionUID = -6180266678801351408L;

	public MatchDialog(MatchVO vo){
		this.setContentPane(new MatchStatsPanel(vo));
		setMinimumSize(new Dimension(1181,700));
		setMaximumSize(new Dimension(1600,730));
	}
}
