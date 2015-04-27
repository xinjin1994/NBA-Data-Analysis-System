package gui.team;

import enums.Teams;
import exceptions.TeamNotFound;
import gui.MainFrame;
import gui.util.NamedLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NamedTeamLabel extends NamedLabel {
	private static final long serialVersionUID = -4521190206450643161L;
	private Teams team;
	
	public NamedTeamLabel(){
		super("<html><u>队伍","</u></html>");
		
		setForeground(Color.BLUE);
		
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				try {
					MainFrame.showDialog(new TeamDialog(team));
				} catch (TeamNotFound e1) {
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
	}
	public NamedTeamLabel(Teams team){
		super("<html><u>队伍",team.toString(),"</u></html>");
		this.team = team;
	}
	
	@Override
	public void setText(String value){
		super.setText(value);
		try {
			team = Teams.toEnum(value);
		} catch (TeamNotFound e) {
			e.printStackTrace();
		}
	}
}
