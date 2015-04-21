package gui.hot;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.Terminology;
import gui.player.detail.PlayerExtraStats;

public class PlayerCompareDialog extends JDialog {
	private static final long serialVersionUID = -7104843675263001222L;
	private final JPanel contentPanel = new JPanel();
	private ArrayList<PlayerCompareItemPanel> panels = new ArrayList<PlayerCompareItemPanel>(5);

	
	private void construct() {
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.X_AXIS));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		for(PlayerCompareItemPanel panel:panels)
			contentPanel.add(panel);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		pack();
	}
	
	public PlayerCompareDialog(String season,Date date,Terminology term, ArrayList<PlayerExtraStats> players) {
		int i = 1;
		for(PlayerExtraStats vo:players)
			panels.add(new PlayerCompareItemPanel(i++,season,date,term,vo.getName(),vo.getTeam(),vo.getPosition()));
		construct();
	}
	public PlayerCompareDialog(String season,Terminology term, ArrayList<PlayerExtraStats> players) {
		int i = 1;
		for(PlayerExtraStats vo:players)
			panels.add(new PlayerCompareItemPanel(i++,season,term,vo.getName(),vo.getTeam(),vo.getPosition()));
		construct();
	}
}
