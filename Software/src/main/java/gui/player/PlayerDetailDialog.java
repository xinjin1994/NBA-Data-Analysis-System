package gui.player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;

import businessLogic.playersBL.PlayersBL;
import businessLogicService.playersBLService.PlayersBLService_new;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import vo.PlayerVO;
import enums.Terminology;
import exceptions.PlayerNotFound;
import factory.ObjectCreator;

import java.awt.GridBagLayout;

import gui.MainFrame;
import gui.util.GUIUtility;
import gui.util.LabelPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PlayerDetailDialog extends JDialog {

	private static final long serialVersionUID = -8359637791685664538L;
	private final JPanel contentPanel = new JPanel();
	private PlayersBLService_new playerService = new ObjectCreator().playersBLService();
	/**
	 * Create the dialog.
	 */
	public PlayerDetailDialog(String name) {
		super(MainFrame.currentFrame,true);
		
		setTitle("球员详情");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		PlayerVO vo = null;
		try {
			vo = playerService.getPlayerInfo(name);
		} catch (PlayerNotFound e1) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, "Error!");
		}
		
		ImageIcon image = vo.getAction();
		JLabel lbl_photo = new JLabel(image);
		lbl_photo.setBorder(new LineBorder(Color.BLACK,1));
		contentPanel.add(lbl_photo,BorderLayout.WEST);
		{
			JPanel pnl_info = new JPanel();
			contentPanel.add(pnl_info, BorderLayout.CENTER);
			pnl_info.setLayout(new BoxLayout(pnl_info, BoxLayout.Y_AXIS));
			{
				JPanel pnl_basic = new JPanel();
				pnl_info.add(pnl_basic);
				GridBagLayout gbl_pnl_basic = new GridBagLayout();
				pnl_basic.setLayout(gbl_pnl_basic);
				{
					LabelPanel labelPanel = new LabelPanel("姓名",vo.getName(),"");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.insets = new Insets(0, 0, 5, 0);
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 0;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("球衣号",vo.getNumber(),"");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 1;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("位置",vo.getPosition().toString(),"");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 2;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("身高",GUIUtility.formatDouble(vo.getHeight_Inch())+"/"+GUIUtility.formatDouble(vo.getHeight_Foot()),"（英尺/英寸）");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 3;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("体重",GUIUtility.formatDouble(vo.getWeight_Pounds()),"磅");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 4;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("生日",vo.getBirthday(),"");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 5;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("年龄",String.valueOf(vo.getAge()),"");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 6;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("球龄",String.valueOf(vo.getExp()),"年");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 7;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("毕业学校",vo.getSchool(),"");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 8;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
			}
			{
				JPanel pnl_tech = new JPanel();
				pnl_info.add(pnl_tech);
				GridBagLayout gbl_pnl_tech = new GridBagLayout();
				pnl_tech.setLayout(gbl_pnl_tech);
				
				PlayerBasicStatsVO bs = null;
				try {
					bs = playerService.getBasicPlayerStatsTotal(vo.getName());
				} catch (PlayerNotFound e) {
					JOptionPane.showMessageDialog(MainFrame.currentFrame, "Error!");
				}
				
				int i = 0;
				for(Terminology[] term = Terminology.getPlayerBasic();i < term.length;i++){
					String unit = "";
					if(i == 5 || i == 6 || i ==7)
						unit = "%";
					LabelPanel labelPanel = new LabelPanel(term[i].toString(),bs.getProperty(term[i]),unit);
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = i%2;
					gbc_labelPanel.gridy = i/2;
					pnl_tech.add(labelPanel, gbc_labelPanel);
				}
			}
			{
				JPanel pnl_advanced = new JPanel();
				pnl_info.add(pnl_advanced);
				GridBagLayout gbl_pnl_advanced = new GridBagLayout();
				pnl_advanced.setLayout(gbl_pnl_advanced);
				
				PlayerAdvancedStatsVO as = null;
				try {
					as = new PlayersBL().getAdvancedPlayerStatsTotal(vo.getName());
				} catch (PlayerNotFound e) {
					JOptionPane.showMessageDialog(MainFrame.currentFrame, "Error!");
				}
				
				int i = 0;
				for(Terminology[] term = Terminology.getPlayerAdvanced();i < term.length;i++){
					LabelPanel labelPanel = new LabelPanel(term[i].toString(),as.getProperty(term[i]),"%");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = i%2;
					gbc_labelPanel.gridy = i/2;
					pnl_advanced.add(labelPanel, gbc_labelPanel);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_confirm = new JButton("OK");
				btn_confirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btn_confirm.setActionCommand("OK");
				buttonPane.add(btn_confirm);
				getRootPane().setDefaultButton(btn_confirm);
			}
		}
		
		pack();
	}

}
