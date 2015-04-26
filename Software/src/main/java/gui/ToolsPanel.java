
package gui;

import enums.PanelType;
import exceptions.StatsNotFound;
import gui.hot.HotPanel;
import gui.match.MatchPanel;
import gui.match.Season;
import gui.player.PlayerPanel;
import gui.statistic.StatisticPanel;
import gui.team.TeamPanel;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import businessLogic.matchesBL.MatchesBL_new;
import businessLogicService.matchesBLService.MatchesBLService;

public class ToolsPanel extends JPanel{
	private static final long serialVersionUID = 8036099557199056090L;
	private Map<PanelType,JPanel> panels = new EnumMap<PanelType,JPanel>(PanelType.class);
	private JPanel pnl_main;
	private JLabel lbl_title = new JLabel();
	private JLabel lbl_season;
	private JComboBox<Season> cbbx_season;
	private ArrayList<PanelType> refreshList = new ArrayList<PanelType>();
	private JButton btn_return;
	
	public ToolsPanel(JPanel pnl_main){
		this.pnl_main = pnl_main;
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
		cbbx_season.setMaximumSize(new Dimension(50,50));
		add(cbbx_season);
		MatchesBLService matchbl = new MatchesBL_new();
		
		try {
			ArrayList<String> seasons = matchbl.getAvailableSeasons();
			for(String s:seasons)
				cbbx_season.addItem(new Season(s));
			cbbx_season.setSelectedIndex(0);
		} catch (StatsNotFound e) {
			JOptionPane.showMessageDialog(this, "无可用数据！程序退出！");
			MainFrame.disposeDialog(MainFrame.currentFrame);
		}
		
		add(Box.createHorizontalGlue());
		
		btn_return = new JButton("返回");
		btn_return.setEnabled(false);
		btn_return.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				popPanel();
			}
		});
		add(btn_return);
		
		cbbx_season.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.refreshAll();
			}
		});
	}
	
	void addPanel(PanelType type){
		if(!panels.containsKey(type)){
			JPanel panel = null;
			switch(type){
			case STATISTIC:
				panel = new StatisticPanel();
				break;
			case MENU:
				panel = new MenuPanel();
				break;
			case PLAYER:
				panel = new PlayerPanel();
				break;
			case TEAM:
				panel = new TeamPanel();
				break;
			case HOT:
				panel = new HotPanel();
				break;
			case MATCH:
				panel = new MatchPanel();
				break;
			}
			panels.put(type, panel);
			pnl_main.add(panel, type.toString());
		}
	}
	

	void pushPanel(PanelType type) {
		refreshList.add(type);
		if(refreshList.size()>1)
			btn_return.setEnabled(true);
	}

	private void popPanel() {
		refreshList.remove(refreshList.size()-1);
		showPanel(refreshList.get(refreshList.size()-1));
		if(refreshList.size()==1)
			btn_return.setEnabled(false);
	}
	
	void showPanel(PanelType type){
		lbl_title.setText(type.toString());
		((CardLayout)pnl_main.getLayout()).show(pnl_main, type.toString());
	}
	
	public void removePanel(FrameRefreshable pnl) {
		refreshList.remove(pnl);
	}

	public void refresh() {
		panels.clear();
		for(PanelType t:refreshList){
			addPanel(t);
		}
		showPanel(refreshList.get(refreshList.size()-1));
	}
}

