package gui.player;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import enums.Conference;
import enums.Division;
import enums.Position;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPlayerPanel extends JPanel {

	private static final long serialVersionUID = -6518841410199427697L;
	private JTextField txf_name;
	//private JTable table;
	private PlayerSearch playerPanel;
	private JComboBox<Conference> cbbx_conference;
	private JComboBox<Position> cbbx_position;
	private JComboBox<Division> cbbx_division;

	public SearchPlayerPanel(PlayerSearch playerPanel) {
		this.playerPanel = playerPanel;
		//this.table = table;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		JLabel lbl_conference = new JLabel("联盟：");
		GridBagConstraints gbc_lbl_conference = new GridBagConstraints();
		gbc_lbl_conference.anchor = GridBagConstraints.EAST;
		gbc_lbl_conference.insets = new Insets(0, 0, 0, 0);
		gbc_lbl_conference.gridx = 0;
		gbc_lbl_conference.gridy = 0;
		add(lbl_conference, gbc_lbl_conference);
		
		cbbx_conference = new JComboBox<Conference>(Conference.values());
		GridBagConstraints gbc_cbbx_conference = new GridBagConstraints();
		gbc_cbbx_conference.anchor = GridBagConstraints.WEST;
		gbc_cbbx_conference.insets = new Insets(0, 0, 0, 30);
		gbc_cbbx_conference.gridx = 1;
		gbc_cbbx_conference.gridy = 0;
		add(cbbx_conference, gbc_cbbx_conference);
		
		JLabel lbl_division = new JLabel("地区：");
		GridBagConstraints gbc_lbl_division = new GridBagConstraints();
		gbc_lbl_division.anchor = GridBagConstraints.EAST;
		gbc_lbl_division.insets = new Insets(0, 0, 0, 0);
		gbc_lbl_division.gridx = 2;
		gbc_lbl_division.gridy = 0;
		add(lbl_division, gbc_lbl_division);
		
		cbbx_division = new JComboBox<Division>(Division.values());
		GridBagConstraints gbc_cbbx_division = new GridBagConstraints();
		gbc_cbbx_division.anchor = GridBagConstraints.WEST;
		gbc_cbbx_division.insets = new Insets(0, 0, 0, 30);
		gbc_cbbx_division.gridx = 3;
		gbc_cbbx_division.gridy = 0;
		add(cbbx_division, gbc_cbbx_division);
		
		/*
		JLabel label_team = new JLabel("队伍：");
		GridBagConstraints gbc_label_team = new GridBagConstraints();
		gbc_label_team.anchor = GridBagConstraints.EAST;
		gbc_label_team.insets = new Insets(0, 0, 0, 0);
		gbc_label_team.gridx = 4;
		gbc_label_team.gridy = 0;
		add(label_team, gbc_label_team);
		
		JComboBox<Teams> cbbx_team = new JComboBox<Teams>(Teams.values());
		GridBagConstraints gbc_cbbx_team = new GridBagConstraints();
		gbc_cbbx_team.anchor = GridBagConstraints.WEST;
		gbc_cbbx_team.insets = new Insets(0, 0, 0, 30);
		gbc_cbbx_team.gridx = 5;
		gbc_cbbx_team.gridy = 0;
		add(cbbx_team, gbc_cbbx_team);
		*/
		
		JLabel label_position = new JLabel("位置：");
		GridBagConstraints gbc_label_position = new GridBagConstraints();
		gbc_label_position.anchor = GridBagConstraints.EAST;
		gbc_label_position.insets = new Insets(0, 0, 0, 0);
		gbc_label_position.gridx = 4;
		gbc_label_position.gridy = 0;
		add(label_position, gbc_label_position);
		
		cbbx_position = new JComboBox<Position>(Position.values());
		GridBagConstraints gbc_cbbx_position = new GridBagConstraints();
		gbc_cbbx_position.anchor = GridBagConstraints.WEST;
		gbc_cbbx_position.insets = new Insets(0, 0, 0, 30);
		gbc_cbbx_position.gridx = 5;
		gbc_cbbx_position.gridy = 0;
		add(cbbx_position, gbc_cbbx_position);
		
		JLabel label_name = new JLabel("姓名：");
		GridBagConstraints gbc_label_name = new GridBagConstraints();
		gbc_label_name.insets = new Insets(0, 0, 0, 0);
		gbc_label_name.anchor = GridBagConstraints.EAST;
		gbc_label_name.gridx = 6;
		gbc_label_name.gridy = 0;
		add(label_name, gbc_label_name);
		
		txf_name = new JTextField();
		txf_name.setColumns(10);
		GridBagConstraints gbc_txf_name = new GridBagConstraints();
		gbc_txf_name.anchor = GridBagConstraints.WEST;
		gbc_txf_name.gridx = 7;
		gbc_txf_name.gridy = 0;
		add(txf_name, gbc_txf_name);
		
		cbbx_conference.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cbbx_division.removeAllItems();
				switch(cbbx_conference.getItemAt(cbbx_conference.getSelectedIndex())){
				case ESTERN:
					for(Division d : Division.getEasternDivision())
						cbbx_division.addItem(d);
				case NATIONAL:
					for(Division d : Division.values())
						cbbx_division.addItem(d);
					break;
				case WESTERN:
					for(Division d : Division.getWesternDivision())
						cbbx_division.addItem(d);
					break;
				}
				
				search();
			}
		});
		cbbx_division.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		cbbx_position.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		txf_name.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
	}

	private void search() {
		Conference c = cbbx_conference.getItemAt(cbbx_conference.getSelectedIndex());
		Division d = cbbx_division.getItemAt(cbbx_division.getSelectedIndex());
		Position p = cbbx_position.getItemAt(cbbx_position.getSelectedIndex());
		String name = txf_name.getText().trim();
		playerPanel.buildList(c,d,p,name);
	}
}
