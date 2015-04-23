package gui.team;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.TeamVO;

public class TeamBasicInfoPanel extends JPanel {
	private static final long serialVersionUID = 4320079403822648306L;

	public TeamBasicInfoPanel(TeamVO vo) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		ArrayList<JLabel> labels = new ArrayList<JLabel>(6);
		
		labels.add(new JLabel(vo.getTeam().toString()));
		labels.add(new JLabel(vo.getConference().toString()+"联盟  "+vo.getDivision().toString()+"   "+vo.getLocation()));
		labels.add(new JLabel("球场：  "+vo.getHomeCourt()));
		labels.add(new JLabel("创建时间："+vo.getYearOfEstablishment()));
		
		add(Box.createVerticalGlue());
		for(JLabel lbl:labels){
			lbl.setFont(new Font(lbl.getFont().getName(),Font.BOLD,25));
			add(lbl);
		}
		add(Box.createVerticalGlue());
	}

}
