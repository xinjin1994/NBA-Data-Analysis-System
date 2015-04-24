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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vo.MatchVO;
import businessLogicService.matchesBLService.MatchesBLService;

public class CopyOfRecentMatchPanel extends JPanel {
	
	private static final long serialVersionUID = -6276304921493888018L;
	private static final String PREV = "PREV";
	private static final String JUMP = "JUMP";
	private static final String NEXT = "NEXT";
	private static final String HAS_MATCH = "HAS_MATCH";
	private static final String NO_MATCH = "NO_MATCH";
	private static final String NO_MATCH_TODAY = "NO_MATCH_TODAY";
	private MatchesBLService matchbl = new ObjectCreator().matchesBLService();
	private JComboBox<ShortDate> cbbx_date;
	private JPanel pnl_view;
	private MatchItemPanel_Small pnl_item;
	private JButton btn_prev;
	private JButton btn_next;
	private MatchChangeable matchChanger;

	/**
	 * Create the panel.
	 */
	public CopyOfRecentMatchPanel(ArrayList<Date> availables,MatchChangeable matchChanger) {
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
		
		JPanel pnl_date = new JPanel();
		add(pnl_date,BorderLayout.NORTH);
		pnl_date.setLayout(new BoxLayout(pnl_date,BoxLayout.X_AXIS));
		btn_prev = new JButton("◀");
		if(availables.size() == 1)
			btn_prev.setEnabled(false);
		pnl_date.add(btn_prev);
		pnl_date.add(Box.createHorizontalGlue());
		cbbx_date = new JComboBox<ShortDate>(datelist);
		pnl_date.add(cbbx_date);
		pnl_date.add(Box.createHorizontalGlue());
		btn_next = new JButton("▶");
		btn_next.setEnabled(false);
		pnl_date.add(btn_next);
		
		pnl_view = new JPanel(new CardLayout());
		add(pnl_view);
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
		
		btn_prev.setActionCommand(PREV);
		cbbx_date.setActionCommand(JUMP);
		btn_next.setActionCommand(NEXT);
		
		btn_prev.addActionListener(new DateChangeListener());
		cbbx_date.addActionListener(new DateChangeListener());
		btn_next.addActionListener(new DateChangeListener());
		
		cbbx_date.setSelectedIndex(0);
		try {
			MatchVO vo = matchChanger.getMatch(matchbl,MainFrame.season.season, datelist[0].date);
			pnl_item.setMatchVO(vo);
		} catch (MatchNotFound e) {
			((CardLayout)pnl_view.getLayout()).show(pnl_view, NO_MATCH_TODAY);
			matchChanger.noMatch();
		}
	}
	
	class DateChangeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			switch(ae.getActionCommand()){
			case PREV:
				cbbx_date.setSelectedIndex(cbbx_date.getSelectedIndex()+1);
				break;
			case NEXT:
				cbbx_date.setSelectedIndex(cbbx_date.getSelectedIndex()-1);
				break;
			default:
				if(cbbx_date.getSelectedIndex() == -1){
					((CardLayout)pnl_view.getLayout()).show(pnl_view, NO_MATCH);
					return;
				}
			}
			if(cbbx_date.getSelectedIndex() == cbbx_date.getItemCount()-1)
				btn_prev.setEnabled(false);
			else
				btn_prev.setEnabled(true);
			if(cbbx_date.getSelectedIndex() == 0)
				btn_next.setEnabled(false);
			else
				btn_next.setEnabled(true);
			Date date = cbbx_date.getItemAt(cbbx_date.getSelectedIndex()).date;
			
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
	}

}
