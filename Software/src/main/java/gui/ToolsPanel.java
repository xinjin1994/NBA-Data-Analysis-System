package gui;

import exceptions.StatsNotFound;
import gui.match.Season;
import gui.util.ReturnButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import businessLogic.matchesBL.MatchesBL_new;
import businessLogicService.matchesBLService.MatchesBLService;

public class ToolsPanel extends JPanel {
	private static final long serialVersionUID = 8036099557199056090L;
	private JLabel lbl_title = new JLabel();
	private JLabel lbl_season;
	private JComboBox<Season> cbbx_season;
	
	public ToolsPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		lbl_title.setFont(new Font(lbl_title.getFont().getName(),Font.BOLD,15));
		add(lbl_title);
		
		add(Box.createHorizontalGlue());
		
		lbl_season = new JLabel();
		add(lbl_season);
		add(Box.createHorizontalStrut(20));
		add(new JLabel("切换赛季："));
		cbbx_season = new JComboBox<Season>();
		cbbx_season.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.season = cbbx_season.getItemAt(cbbx_season.getSelectedIndex());
				lbl_season.setText(MainFrame.season.toString());
			}
		});
		add(cbbx_season);
		MatchesBLService matchbl = new MatchesBL_new();
		
		try {
			ArrayList<String> seasons = matchbl.getAvailableSeasons();
			for(String s:seasons)
				cbbx_season.addItem(new Season(s));
			cbbx_season.setSelectedIndex(0);
		} catch (StatsNotFound e) {
			JOptionPane.showMessageDialog(this, "无可用数据！程序退出！");
			MainFrame.currentFrame.dispose();
		}
		
		add(Box.createHorizontalGlue());
		
		add(new ReturnButton());
		
		cbbx_season.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.mf.refresh();
			}
		});
	}
}
