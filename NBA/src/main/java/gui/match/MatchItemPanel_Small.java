package gui.match;
import enums.Teams;
import gui.MainFrame;
import gui.team.TeamLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vo.MatchVO;
import javax.swing.SwingConstants;
public class MatchItemPanel_Small extends JPanel{
private static final long serialVersionUID = 8710772911966562176L;
private MatchVO vo;
private JLabel lbl_date;
private TeamLabel lbl_host;
private TeamLabel lbl_guest;
private JLabel lbl_host_score;
private JLabel lbl_guest_score;
private Teams team = Teams.ALL;
public MatchItemPanel_Small(boolean displayDate) {
construct(displayDate);
}
public MatchItemPanel_Small(boolean displayDate,Teams team) {
construct(displayDate);
this.team = team;
}
private void construct(boolean displayDate){
setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
lbl_date = new JLabel();
lbl_date.setHorizontalAlignment(SwingConstants.CENTER);
lbl_date.setAlignmentX(0.5f);
if(displayDate)
add(lbl_date,BorderLayout.NORTH);
JPanel pnl_team = new JPanel();
pnl_team.setLayout(new GridLayout(3,3));
add(pnl_team);
JLabel hostLabel = new JLabel("主队");
hostLabel.setHorizontalAlignment(SwingConstants.CENTER);
JLabel guestLabel = new JLabel("客队");
guestLabel.setHorizontalAlignment(SwingConstants.CENTER);
pnl_team.add(hostLabel);
pnl_team.add(Box.createHorizontalGlue());
pnl_team.add(guestLabel);
lbl_host = new TeamLabel();
lbl_host.setHorizontalAlignment(SwingConstants.CENTER);
lbl_host.setFont(new Font(lbl_host.getFont().getName(),Font.BOLD,25));
lbl_guest = new TeamLabel();
lbl_guest.setHorizontalAlignment(SwingConstants.CENTER);
lbl_guest.setFont(new Font(lbl_guest.getFont().getName(),Font.BOLD,25));
pnl_team.add(lbl_host);
pnl_team.add(Box.createHorizontalGlue());
pnl_team.add(lbl_guest);
lbl_host_score = new JLabel();
lbl_host_score.setHorizontalAlignment(SwingConstants.CENTER);
lbl_host_score.setFont(new Font(lbl_host_score.getFont().getName(),Font.BOLD,25));
lbl_guest_score = new JLabel();
lbl_guest_score.setHorizontalAlignment(SwingConstants.CENTER);
lbl_guest_score.setFont(new Font(lbl_guest_score.getFont().getName(),Font.BOLD,25));
pnl_team.add(lbl_host_score);
JLabel label = new JLabel(":");
label.setFont(new Font(label.getFont().getName(),Font.BOLD,25));
label.setHorizontalAlignment(SwingConstants.CENTER);
pnl_team.add(label);
pnl_team.add(lbl_guest_score);
this.addMouseListener(new MouseAdapter(){
@Override
public void mouseClicked(MouseEvent me){
if(me.getButton() == MouseEvent.BUTTON1 && me.getClickCount() == 2){
MainFrame.showDialog(new MatchDialog(vo));
}
}
});
}
public MatchItemPanel_Small(MatchVO vo,boolean displayDate){
construct(displayDate);
setMatchVO(vo);
}
public MatchItemPanel_Small(MatchVO vo,Teams team,boolean displayDate) {
this.team = team;
construct(displayDate);
setMatchVO(vo);
}
public void setMatchVO(MatchVO vo){
this.vo = vo;
lbl_date.setText(new SimpleDateFormat("yyyy年MM月dd日").format(vo.getDay()));
lbl_host.setValue(vo.getTeam1(),vo.getTeam1() != team);
lbl_guest.setValue(vo.getTeam2(),vo.getTeam2() != team);
String[] score = vo.getScore().split("-");
lbl_host_score.setText(score[0]);
lbl_guest_score.setText(score[1]);
}
}