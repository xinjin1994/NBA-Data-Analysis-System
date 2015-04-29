package gui.team;
import enums.Teams;
import exceptions.TeamNotFound;
import gui.MainFrame;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
public class TeamLabel extends JLabel {
private static final long serialVersionUID = -4521190206450643161L;
private Teams team;
private MouseAdapter cursorMouse = new MouseAdapter(){
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
};
public TeamLabel(Teams team){
super("<html><u>"+team.toString()+"</u></html>");
this.team = team;
setForeground(Color.BLUE);
this.addMouseListener(cursorMouse);
}
public TeamLabel(){
setForeground(Color.BLUE);
this.addMouseListener(cursorMouse);
}
public void setValue(String value,boolean linkable){
if(linkable){
super.setText("<html><u>"+value+"</u></html>");
setForeground(Color.BLUE);
if(this.getMouseListeners().length==0)
this.addMouseListener(cursorMouse);
try {
this.team = Teams.toEnum(value);
} catch (TeamNotFound e) {
e.printStackTrace();
}
}
else{
super.setText(value);
setForeground(Color.BLACK);
this.removeMouseListener(cursorMouse);
}
}
public void setValue(Teams team,boolean linkable){
this.team = team;
if(linkable){
super.setText("<html><u>"+team.toString()+"</u></html>");
setForeground(Color.BLUE);
if(this.getMouseListeners().length==0)
this.addMouseListener(cursorMouse);
}
else{
super.setText(team.toString());
setForeground(Color.BLACK);
this.removeMouseListener(cursorMouse);
}
}
}