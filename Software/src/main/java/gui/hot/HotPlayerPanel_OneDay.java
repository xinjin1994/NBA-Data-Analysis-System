package gui.hot;

import enums.Terminology;
import exceptions.StatsNotFound;
import factory.ObjectCreator;
import gui.MainFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import businessLogicService.matchesBLService.MatchesBLService;

public class HotPlayerPanel_OneDay extends JPanel {
	
	private static final long serialVersionUID = -464887637378876170L;
	private static final String TODAY = "TODAY";
	private static final String SEASON = "SEASON";
	private static MatchesBLService matchbl = new ObjectCreator().matchesBLService();
	private JPanel pnl_hot;
	private JRadioButton rdibtn_today;
	private JRadioButton rdibtn_season;
	private ArrayList<Date> dates;

	public void paintComponent(Graphics gs) {  
        Graphics2D g = (Graphics2D) gs;  
//        super.paintComponent(g);  
        Paint p = new Color(0,0,0,0);
        g.setPaint(p);
        g.fillRect(0, 0, getWidth(), getHeight());
	}
	public HotPlayerPanel_OneDay() {
		setLayout(new BorderLayout());
		setBorder(new LineBorder(Color.BLACK));
		{
			JPanel pnl_choose = new JPanel(){
				public void paintComponent(Graphics gs) {  
			        Graphics2D g = (Graphics2D) gs;  
//			        super.paintComponent(g);  
			        Paint p = new Color(0,0,0,0);
			        g.setPaint(p);
			        g.fillRect(0, 0, getWidth(), getHeight());
				}
			};
			add(pnl_choose, BorderLayout.NORTH);
			pnl_choose.setLayout(new BoxLayout(pnl_choose, BoxLayout.X_AXIS));
			
			JLabel lbl_title = new JLabel("球员数据");
			pnl_choose.add(lbl_title);
			
			try {
				dates = matchbl.getAvailableDays(MainFrame.season.season);
			} catch (StatsNotFound e) {
				JLabel lbl_no_match = new JLabel("无比赛数据");
				lbl_no_match.setHorizontalAlignment(SwingConstants.CENTER);
				add(lbl_no_match);
				e.printStackTrace();
				return;
			}
			
			rdibtn_today = new JRadioButton("每日热点");
			rdibtn_today.setBackground(new Color(210,225,244,100));
			rdibtn_today.setActionCommand(TODAY);
			rdibtn_today.setSelected(true);
			rdibtn_today.addActionListener(new DateChangeListener());
			pnl_choose.add(rdibtn_today);
			
			rdibtn_season = new JRadioButton("赛季热点");
			rdibtn_season.setBackground(new Color(210,225,244,100));
			rdibtn_season.setActionCommand(SEASON);
			rdibtn_season.setSelected(false);
			rdibtn_season.addActionListener(new DateChangeListener());
			pnl_choose.add(rdibtn_season);
	
			pnl_choose.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		}
		{
			pnl_hot = new JPanel(new CardLayout()){
				public void paintComponent(Graphics gs) {  
			        Graphics2D g = (Graphics2D) gs;  
//			        super.paintComponent(g);  
			        Paint p = new Color(0,0,0,0);
			        g.setPaint(p);
			        g.fillRect(0, 0, getWidth(), getHeight());
				}
			};
			add(pnl_hot);
			
			setTodayHot();
			setSeasonHot();
			((CardLayout)pnl_hot.getLayout()).show(pnl_hot,TODAY);
		}
	}
	
	private void setSeasonHot(){
		Terminology[] terms = Terminology.getPlayerSeasonHot();
		JPanel pnl_season = new JPanel(){
			public void paintComponent(Graphics gs) {  
		        Graphics2D g = (Graphics2D) gs;  
//		        super.paintComponent(g);  
		        Paint p = new Color(0,0,0,0);
		        g.setPaint(p);
		        g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		pnl_season.setLayout(new BoxLayout(pnl_season,BoxLayout.X_AXIS));
		for(Terminology term:terms){
			pnl_season.add(Box.createHorizontalGlue());
			pnl_season.add(new HotPlayerItemPanel(MainFrame.season.season,term));
		}
		pnl_season.add(Box.createHorizontalGlue());
		pnl_hot.add(pnl_season, SEASON);
	}
	private void setTodayHot(){
		Terminology[] terms = Terminology.getPlayerTodayHot();
		JPanel pnl_day = new JPanel(){
			public void paintComponent(Graphics gs) {  
		        Graphics2D g = (Graphics2D) gs;  
//		        super.paintComponent(g);  
		        Paint p = new Color(0,0,0,0);
		        g.setPaint(p);
		        g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		pnl_day.setLayout(new BoxLayout(pnl_day,BoxLayout.X_AXIS));
		for(Terminology term:terms){
			pnl_day.add(Box.createHorizontalGlue());
			pnl_day.add(new HotPlayerItemPanel(MainFrame.season.season,dates.get(0),term));
		}
		pnl_day.add(Box.createHorizontalGlue());
		pnl_hot.add(pnl_day, TODAY);
	}

	private class DateChangeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			switch(ae.getActionCommand()){
			case TODAY:
				rdibtn_today.setSelected(true);
				rdibtn_season.setSelected(false);
				((CardLayout)pnl_hot.getLayout()).show(pnl_hot,TODAY);
				break;
			case SEASON:
				rdibtn_today.setSelected(false);
				rdibtn_season.setSelected(true);
				((CardLayout)pnl_hot.getLayout()).show(pnl_hot,SEASON);
				break;
			}
		}
	}

}
