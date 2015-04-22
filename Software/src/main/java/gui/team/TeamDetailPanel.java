package gui.team;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.TeamVO;
import factory.ObjectCreator;
import businessLogicService.teamsBLService.TeamsBLService_new;

public class TeamDetailPanel extends JPanel {
	private static final long serialVersionUID = -6532991967501331579L;
	private static TeamsBLService_new teambl = new ObjectCreator().teamsBLService();

	public TeamDetailPanel(TeamVO infovo) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JPanel pnl_row1 = new JPanel();
		add(pnl_row1);
		JLabel lbl_icon = new JLabel(infovo.getImage());
		pnl_row1.add(lbl_icon);
		
		pnl_row1.add(new TeamBasicInfoPanel(infovo));
	}
}
