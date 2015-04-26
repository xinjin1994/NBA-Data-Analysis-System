package gui.player;

import gui.util.GUIUtility;
import gui.util.NamedLabel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

import vo.PlayerVO;

public class PlayerBasicInfoPanel extends JPanel {
	private static final long serialVersionUID = -5971314502257552436L;

	public PlayerBasicInfoPanel(PlayerVO vo) {
		GridBagLayout gbl_pnl_basic = new GridBagLayout();
		setLayout(gbl_pnl_basic);
		{
			NamedLabel labelPanel = new NamedLabel("姓名",vo.getName(),"");
			GridBagConstraints gbc_labelPanel = new GridBagConstraints();
			gbc_labelPanel.insets = new Insets(0, 0, 5, 0);
			gbc_labelPanel.gridwidth = 2;
			gbc_labelPanel.gridx = 0;
			gbc_labelPanel.gridy = 0;
			add(labelPanel, gbc_labelPanel);
		}
		{
			NamedLabel labelPanel = new NamedLabel("球衣号",vo.getNumber(),"");
			GridBagConstraints gbc_labelPanel = new GridBagConstraints();
			gbc_labelPanel.gridx = 0;
			gbc_labelPanel.gridy = 1;
			add(labelPanel, gbc_labelPanel);
		}
		{
			NamedLabel labelPanel = new NamedLabel("位置",vo.getPosition().toString(),"");
			GridBagConstraints gbc_labelPanel = new GridBagConstraints();
			gbc_labelPanel.gridx = 1;
			gbc_labelPanel.gridy = 1;
			add(labelPanel, gbc_labelPanel);
		}
		{
			NamedLabel labelPanel = new NamedLabel("身高",GUIUtility.formatDouble(vo.getHeight_Inch())+"/"+GUIUtility.formatDouble(vo.getHeight_Foot()),"（英尺/英寸）");
			GridBagConstraints gbc_labelPanel = new GridBagConstraints();
			gbc_labelPanel.gridwidth = 2;
			gbc_labelPanel.gridx = 0;
			gbc_labelPanel.gridy = 2;
			add(labelPanel, gbc_labelPanel);
		}
		{
			NamedLabel labelPanel = new NamedLabel("体重",GUIUtility.formatDouble(vo.getWeight_Pounds()),"磅");
			GridBagConstraints gbc_labelPanel = new GridBagConstraints();
			gbc_labelPanel.gridwidth = 2;
			gbc_labelPanel.gridx = 0;
			gbc_labelPanel.gridy = 3;
			add(labelPanel, gbc_labelPanel);
		}
		{
			NamedLabel labelPanel = new NamedLabel("生日",vo.getBirthday(),"");
			GridBagConstraints gbc_labelPanel = new GridBagConstraints();
			gbc_labelPanel.gridwidth = 2;
			gbc_labelPanel.gridx = 0;
			gbc_labelPanel.gridy = 4;
			add(labelPanel, gbc_labelPanel);
		}
		{
			NamedLabel labelPanel = new NamedLabel("年龄",String.valueOf(vo.getAge()),"");
			GridBagConstraints gbc_labelPanel = new GridBagConstraints();
			gbc_labelPanel.gridx = 0;
			gbc_labelPanel.gridy = 5;
			add(labelPanel, gbc_labelPanel);
		}
		{
			NamedLabel labelPanel = new NamedLabel("球龄",String.valueOf(vo.getExp()),"年");
			GridBagConstraints gbc_labelPanel = new GridBagConstraints();
			gbc_labelPanel.gridx = 1;
			gbc_labelPanel.gridy = 5;
			add(labelPanel, gbc_labelPanel);
		}
		{
			NamedLabel labelPanel = new NamedLabel("毕业学校",vo.getSchool(),"");
			GridBagConstraints gbc_labelPanel = new GridBagConstraints();
			gbc_labelPanel.gridwidth = 2;
			gbc_labelPanel.gridx = 0;
			gbc_labelPanel.gridy = 6;
			add(labelPanel, gbc_labelPanel);
		}
	}

}
