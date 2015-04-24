package gui.match;

import exceptions.MatchNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.util.ShortDate;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vo.MatchVO;
import businessLogicService.matchesBLService.MatchesBLService;

public class RecentMatchPanel extends JPanel implements DateChangeable{
	
	private static final long serialVersionUID = -6276304921493888018L;
	private static final String HAS_MATCH = "HAS_MATCH";
	private static final String NO_MATCH = "NO_MATCH";
	private static final String NO_MATCH_TODAY = "NO_MATCH_TODAY";
	private MatchesBLService matchbl = new ObjectCreator().matchesBLService();
	private JPanel pnl_view;
	private MatchItemPanel_Small pnl_item;
	private MatchChangeable matchChanger;

	/**
	 * Create the panel.
	 */
	public RecentMatchPanel(ArrayList<Date> availables,MatchChangeable matchChanger) {
		this.matchChanger = matchChanger;

		ShortDate today = new ShortDate();
		ShortDate day = new ShortDate(availables.get(0));
		ShortDate[] datelist;
		if(today.equals(day)){
			datelist = new ShortDate[availables.size()];
			for(int i = 0;i < datelist.length;i++)
				datelist[i] = new ShortDate(availables.get(i));
		}
		else{
			datelist = new ShortDate[availables.size()+1];
			datelist[0] = today;
			for(int i = 0;i < availables.size();i++)
				datelist[i+1] = new ShortDate(availables.get(i));
		}
		
		this.setLayout(new BorderLayout());
		
		pnl_view = new JPanel(new CardLayout());
		
		JPanel pnl_match = new JPanel(new BorderLayout());
		pnl_item = new MatchItemPanel_Small(false);
		pnl_match.add(pnl_item);
		JButton btn_match = new JButton("查看比赛");
		JPanel pnl_btn = new JPanel();
		pnl_btn.add(btn_match);
		pnl_match.add(pnl_btn,BorderLayout.SOUTH);
		btn_match.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		pnl_view.add(pnl_match,HAS_MATCH);
		
		JLabel lbl_no_match = new JLabel("无比赛比赛信息");
		lbl_no_match.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_view.add(lbl_no_match,NO_MATCH);
		JLabel lbl_no_match_today = new JLabel("今日该相关无比赛");
		lbl_no_match_today.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_view.add(lbl_no_match_today,NO_MATCH_TODAY);
		try {
			MatchVO vo = matchChanger.getMatch(matchbl,MainFrame.season.season, datelist[0].date);
			pnl_item.setMatchVO(vo);
		} catch (MatchNotFound e) {
			((CardLayout)pnl_view.getLayout()).show(pnl_view, NO_MATCH_TODAY);
			matchChanger.noMatch();
		}
		
		DateChooser pnl_date = new DateChooser(datelist, this);
		
		add(pnl_date,BorderLayout.NORTH);
		add(pnl_view);
	}

	@Override
	public void DateChange(Date date) {
		try {
			MatchVO vo = matchChanger.getMatch(matchbl,MainFrame.season.season, date);
			pnl_item.setMatchVO(vo);
			((CardLayout)pnl_view.getLayout()).show(pnl_view, HAS_MATCH);
			matchChanger.setMatch(MainFrame.season.season, date);
		} catch (MatchNotFound e) {
			((CardLayout)pnl_view.getLayout()).show(pnl_view, NO_MATCH_TODAY);
			matchChanger.noMatch();
		}
	}

	@Override
	public void InvalidDate() {
		((CardLayout)pnl_view.getLayout()).show(pnl_view, NO_MATCH);
	}

}
