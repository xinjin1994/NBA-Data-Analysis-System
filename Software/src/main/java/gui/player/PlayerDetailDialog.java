package gui.player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;

import enums.Terminology;

import java.awt.GridBagLayout;

import gui.MainFrame;
import gui.util.LabelPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PlayerDetailDialog extends JDialog {

	private static final long serialVersionUID = -8359637791685664538L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PlayerDetailDialog dialog = new PlayerDetailDialog();
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PlayerDetailDialog() {
		super(MainFrame.currentFrame,true);
		
		setTitle("球员详情");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		ImageIcon image = new ImageIcon("E:\\assignment\\2015 I\\softwareIII\\迭代一数据\\players\\action\\Aaron Brooks.png");
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
					LabelPanel labelPanel = new LabelPanel("姓名","Aaron Brooks","");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.insets = new Insets(0, 0, 5, 0);
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 0;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("球衣号","0","");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 1;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("位置","GUARD","");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 2;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("身高","6/0","（英尺/英寸）");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 3;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("体重","161","磅");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 4;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("生日","JAN 14, 1985","");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 5;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("年龄","20","");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 6;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("球龄","5","年");
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = 7;
					pnl_basic.add(labelPanel, gbc_labelPanel);
				}
				{
					LabelPanel labelPanel = new LabelPanel("毕业学校","Oregon","");
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
				
				int i = 0;
				for(Terminology[] term = Terminology.getBasic();i < term.length;i++){
					String unit = "";
					if(i == 5 || i == 6 || i ==7)
						unit = "%";
					LabelPanel labelPanel = new LabelPanel(term[i].toString(),"123",unit);
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
				
				int i = 0;
				for(Terminology[] term = Terminology.getAdvanced();i < term.length;i++){
					LabelPanel labelPanel = new LabelPanel(term[i].toString(),"123","%");
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
