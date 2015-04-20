package gui.hot;

import enums.Terminology;
import exceptions.StatsNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.util.ShortDate;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import businessLogicService.matchesBLService.MatchesBLService;

public class HotPlayerPanel extends JPanel {
	
	private static final long serialVersionUID = -464887637378876170L;
	private static final String TODAY = "TODAY";
	private static final String SEASON = "SEASON";
	private static final String JUMP = "JUMP";
	private static MatchesBLService matchbl = new ObjectCreator().matchesBLService();
	private JPanel pnl_hot;
	private JRadioButton rdibtn_today;
	private JRadioButton rdibtn_season;
	private boolean matchToday = false;
	private JComboBox<ShortDate> cbbx_date;

	public HotPlayerPanel() {
		setLayout(new BorderLayout());
		setBorder(new LineBorder(Color.BLACK));
		{
			JPanel pnl_choose = new JPanel();
			add(pnl_choose, BorderLayout.NORTH);
			pnl_choose.setLayout(new BoxLayout(pnl_choose, BoxLayout.X_AXIS));
			
			JLabel lbl_title = new JLabel("球员数据");
			pnl_choose.add(lbl_title);
			
			ArrayList<Date> dates = null;
			try {
				dates = matchbl.getAvailableDays(MainFrame.season.season);
			} catch (StatsNotFound e) {
				JLabel lbl_no_match = new JLabel("无比赛数据");
				lbl_no_match.setHorizontalAlignment(SwingConstants.CENTER);
				add(lbl_no_match);
				e.printStackTrace();
				return;
			}
			
			rdibtn_today = new JRadioButton("本日");
			rdibtn_today.setActionCommand(TODAY);
			rdibtn_today.setSelected(true);
			rdibtn_today.addActionListener(new DateChangeListener());
			pnl_choose.add(rdibtn_today);
			
			rdibtn_season = new JRadioButton("赛季");
			rdibtn_season.setActionCommand(SEASON);
			rdibtn_season.setSelected(false);
			rdibtn_season.addActionListener(new DateChangeListener());
			pnl_choose.add(rdibtn_season);
	
			pnl_choose.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

			ShortDate today = new ShortDate();
			ShortDate day = new ShortDate(dates.get(0));
			ShortDate[] datelist;
			if(today.equals(day)){
				datelist = new ShortDate[dates.size()];
				for(int i = 0;i < datelist.length;i++)
					datelist[i] = new ShortDate(dates.get(i));
				matchToday = true;
			}
			else{
				datelist = new ShortDate[dates.size()+1];
				datelist[0] = today;
				for(int i = 0;i < dates.size();i++)
					datelist[i+1] = new ShortDate(dates.get(i));
			}
			cbbx_date = new JComboBox<ShortDate>(datelist);
			cbbx_date.setActionCommand(JUMP);
			cbbx_date.setSelectedIndex(0);
			cbbx_date.addActionListener(new DateChangeListener());
			pnl_choose.add(cbbx_date);
		}
		{
			pnl_hot = new JPanel(new CardLayout());
			add(pnl_hot);
			
			setTodayHot();
			setSeasonHot();
			((CardLayout)pnl_hot.getLayout()).show(pnl_hot,TODAY);
		}
	}
	
	private void setSeasonHot(){
		Terminology[] terms = Terminology.getPlayerSeasonHot();
		JPanel pnl_season = new JPanel();
		pnl_season.setLayout(new BoxLayout(pnl_season,BoxLayout.X_AXIS));
		for(Terminology term:terms){
			pnl_season.add(Box.createHorizontalGlue());
			pnl_season.add(new HotPlayerItemPanel(MainFrame.season.season,term));
		}
		pnl_season.add(Box.createHorizontalGlue());
		pnl_hot.add(pnl_season, SEASON);
	}
	private void setTodayHot(){
		if(matchToday){
			Terminology[] terms = Terminology.getPlayerTodayHot();
			JPanel pnl_day = new JPanel();
			pnl_day.setLayout(new BoxLayout(pnl_day,BoxLayout.X_AXIS));
			for(Terminology term:terms){
				pnl_day.add(Box.createHorizontalGlue());
				pnl_day.add(new HotPlayerItemPanel(MainFrame.season.season,Calendar.getInstance().getTime(),term));
			}
			pnl_day.add(Box.createHorizontalGlue());
			pnl_hot.add(pnl_day, TODAY);
		}else{
			JLabel lbl_no_match = new JLabel("今日无比赛");
			lbl_no_match.setHorizontalAlignment(SwingConstants.CENTER);
			pnl_hot.add(lbl_no_match,TODAY);
		}
	}
	private void setDayHot(Date date){
		Terminology[] terms = Terminology.getPlayerTodayHot();
		JPanel pnl_day = new JPanel();
		pnl_day.setLayout(new BoxLayout(pnl_day,BoxLayout.X_AXIS));
		for(Terminology term:terms){
			pnl_day.add(Box.createHorizontalGlue());
			pnl_day.add(new HotPlayerItemPanel(MainFrame.season.season,date,term));
		}
		pnl_day.add(Box.createHorizontalGlue());
		pnl_hot.add(pnl_day, JUMP);
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
			case JUMP:
				rdibtn_today.setSelected(false);
				rdibtn_season.setSelected(false);
				if(cbbx_date.getSelectedIndex() == 0){
					rdibtn_today.setSelected(true);
					((CardLayout)pnl_hot.getLayout()).show(pnl_hot,TODAY);
				}
				else{
					setDayHot(cbbx_date.getItemAt(cbbx_date.getSelectedIndex()).date);
					((CardLayout)pnl_hot.getLayout()).show(pnl_hot,JUMP);
				}
				break;
			}
		}
	}

}
