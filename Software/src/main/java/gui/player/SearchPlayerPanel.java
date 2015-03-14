package gui.player;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import enums.Conference;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SearchPlayerPanel extends JPanel {

	private static final long serialVersionUID = -6518841410199427697L;
	private JTextField txf_name;

	public SearchPlayerPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		
		JLabel lbl_conference = new JLabel("联盟：");
		GridBagConstraints gbc_lbl_conference = new GridBagConstraints();
		gbc_lbl_conference.anchor = GridBagConstraints.EAST;
		gbc_lbl_conference.insets = new Insets(0, 0, 0, 0);
		gbc_lbl_conference.gridx = 0;
		gbc_lbl_conference.gridy = 0;
		add(lbl_conference, gbc_lbl_conference);
		
		JComboBox<Conference> cbbx_conference = new JComboBox<Conference>(Conference.values());
		GridBagConstraints gbc_cbbx_conference = new GridBagConstraints();
		gbc_cbbx_conference.anchor = GridBagConstraints.WEST;
		gbc_cbbx_conference.insets = new Insets(0, 0, 0, 30);
		gbc_cbbx_conference.gridx = 1;
		gbc_cbbx_conference.gridy = 0;
		add(cbbx_conference, gbc_cbbx_conference);
		
		JLabel label_team = new JLabel("队伍：");
		GridBagConstraints gbc_label_team = new GridBagConstraints();
		gbc_label_team.anchor = GridBagConstraints.EAST;
		gbc_label_team.insets = new Insets(0, 0, 0, 0);
		gbc_label_team.gridx = 2;
		gbc_label_team.gridy = 0;
		add(label_team, gbc_label_team);
		
		JComboBox cbbx_team = new JComboBox();
		GridBagConstraints gbc_cbbx_team = new GridBagConstraints();
		gbc_cbbx_team.anchor = GridBagConstraints.WEST;
		gbc_cbbx_team.insets = new Insets(0, 0, 0, 30);
		gbc_cbbx_team.gridx = 3;
		gbc_cbbx_team.gridy = 0;
		add(cbbx_team, gbc_cbbx_team);
		
		JLabel label_position = new JLabel("位置：");
		GridBagConstraints gbc_label_position = new GridBagConstraints();
		gbc_label_position.anchor = GridBagConstraints.EAST;
		gbc_label_position.insets = new Insets(0, 0, 0, 0);
		gbc_label_position.gridx = 4;
		gbc_label_position.gridy = 0;
		add(label_position, gbc_label_position);
		
		JComboBox cbbx_position = new JComboBox();
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
	}
}
