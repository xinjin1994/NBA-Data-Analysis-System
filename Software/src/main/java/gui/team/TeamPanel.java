package gui.team;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JList;

import vo.TeamVO;
import data.init.DataInit;
import enums.Conference;
import enums.Division;
import factory.ObjectCreator;
import businessLogicService.teamsBLService.TeamsBLService_new;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import java.awt.FlowLayout;

public class TeamPanel extends JPanel {
	private static final long serialVersionUID = 7485651519540450895L;

	JList<TeamPortrait_div> list;
	TeamsBLService_new teamService = new ObjectCreator().teamsBLService();
	ArrayList<TeamVO> teamList;

	public TeamPanel() {
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		this.setSize(1280, 720);
		
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setDividerLocation(this.getWidth()/2);
		add(splitPane_3, BorderLayout.NORTH);
		
		JLabel label = new JLabel("东部");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 65));
		splitPane_3.setLeftComponent(label);
		
		JLabel lblNewLabel = new JLabel("西部");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 65));
		splitPane_3.setRightComponent(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		/*
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		*/
		int height = this.getHeight();
		int width = this.getWidth();
		TeamPortrait_div[] panelList = new TeamPortrait_div[6];
		panelList[0] = new TeamPortrait_div(Conference.EASTERN, Division.ATLANTIC);
		panelList[1] = new TeamPortrait_div(Conference.WESTERN, Division.SOUTHWEST);
		panelList[2] = new TeamPortrait_div(Conference.EASTERN, Division.CENTRAL);
		panelList[3] = new TeamPortrait_div(Conference.WESTERN, Division.NORTHWEST);
		panelList[4] = new TeamPortrait_div(Conference.EASTERN, Division.SOUTHEAST);
		panelList[5] = new TeamPortrait_div(Conference.WESTERN, Division.PACIFIC);
		for(int i=0; i<6; i++){
			panelList[i].setSize(width, height);
			//panel.add(panelList[i]);
		}
		
		list = new JList<TeamPortrait_div>(panelList);
		list.setCellRenderer(new ListCellRenderer<TeamPortrait_div>(){
			@Override
			public Component getListCellRendererComponent(
					JList<? extends TeamPortrait_div> list, TeamPortrait_div value,
					int index, boolean isSelected, boolean cellHasFocus) {
				return value;
			}
		});
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(3);
		list.setToolTipText("双击以查看详细信息");
		scrollPane.setViewportView(list);
		
	}
	
	public static void main(String[] args) {
		new DataInit().init();
		JFrame frame = new JFrame();
		frame.setSize(1280, 720);
		TeamPanel panel = new TeamPanel();
		frame.getContentPane().add(panel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
