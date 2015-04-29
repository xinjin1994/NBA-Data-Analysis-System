package gui.match;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import vo.MatchVO;

public class MatchList extends JList<MatchItemPanel_Large> {
	private static final long serialVersionUID = 803927376403932479L;

	public MatchList() {
		init();
	}
	
	public MatchList(ArrayList<MatchVO> matchlist) {
		super(toArray(matchlist));
		init();
	}
	
	private void init() {
		setCellRenderer(new ListCellRenderer<MatchItemPanel_Large>(){
			@Override
			public Component getListCellRendererComponent(
					JList<? extends MatchItemPanel_Large> list, MatchItemPanel_Large value,
					int index, boolean isSelected, boolean cellHasFocus) {
				value.setBorder(new LineBorder(Color.BLACK,1));
				return value;
			}
		});
		setLayoutOrientation(JList.VERTICAL);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public static MatchItemPanel_Large[] toArray(
			ArrayList<MatchVO> matchlist) {
		MatchItemPanel_Large[] list = new MatchItemPanel_Large[matchlist.size()];
		for(int i = 0;i < list.length;i++)
			list[i] = new MatchItemPanel_Large(matchlist.get(i),true);
		return list;
	}
}
