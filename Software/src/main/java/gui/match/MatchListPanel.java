package gui.match;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import exceptions.MatchNotFound;
import exceptions.StatsNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.util.ShortDate;
import businessLogicService.matchesBLService.MatchesBLService;

public class MatchListPanel extends JPanel implements DateChangeable{
	private static final long serialVersionUID = 6188988795153593485L;
	private static MatchesBLService matchbl = new ObjectCreator().matchesBLService();
	private MatchList list = new MatchList();
	private String season = MainFrame.season.season;

	public MatchListPanel(MatchVOChangeable changer) {
		setLayout(new BorderLayout());
		
		try {
			ArrayList<Date> dates = matchbl.getAvailableDays(season);
			ShortDate[] datelist = new ShortDate[dates.size()];
			for(int i = 0;i < dates.size();i++)
				datelist[i] = new ShortDate(dates.get(i));
			DateChooser chooser = new DateChooser(datelist,this);
			add(chooser,BorderLayout.NORTH);
			
			JScrollPane scrpane = new JScrollPane(list);
			add(scrpane);
			list.setListData(MatchList.toArray(matchbl.getMatchByDate(season, dates.get(0))));
			list.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent me){
					MatchItemPanel_Large pnl_item = list.getSelectedValue();
					if(pnl_item != null)
						changer.changeMatch(pnl_item.getMatch());
					else
						changer.noMatch();
				}
			});
		} catch (StatsNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e);
			e.printStackTrace();
		} catch (MatchNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e);
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void DateChange(Date date) {
		try {
			list.setListData(MatchList.toArray(matchbl.getMatchByDate(season, date)));
		} catch (MatchNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e);
			e.printStackTrace();
		}
	}

	@Override
	public void InvalidDate() {
		JOptionPane.showMessageDialog(MainFrame.currentFrame, "InvalidDate");
	}

}
