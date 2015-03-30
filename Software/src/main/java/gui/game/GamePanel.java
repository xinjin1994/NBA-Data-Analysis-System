package gui.game;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import gui.MainFrame;
import gui.SelfAdjustPanel;
import gui.enums.PanelType;

public class GamePanel extends SelfAdjustPanel {

	private static final long serialVersionUID = 5680194087318418298L;

	public GamePanel() {

		GridBagLayout gbl = new GridBagLayout();
		gbl.rowHeights = new int[] { pHeight / 8, 3 * pHeight / 4, pHeight / 8 };
		gbl.columnWidths = new int[] { pWidth / 8, 3 * pWidth / 4, pWidth / 8 };
		gbl.rowWeights = new double[] { 1, 1, 1 };
		setLayout(gbl);

		JTextField textField_Date = new JTextField("fuck you !");
		GridBagConstraints gbc_DateShow = new GridBagConstraints();
		gbc_DateShow.gridy = 0;
		gbc_DateShow.gridx = 0;
		add(textField_Date, gbc_DateShow);
		gbc_DateShow.anchor = GridBagConstraints.SOUTHWEST;

		JButton btn_Date = new JButton("选择日期");
		GridBagConstraints gbc_DateChoose = new GridBagConstraints();
		gbc_DateChoose.gridy = 0;
		gbc_DateChoose.gridx = 2;
		add(btn_Date, gbc_DateChoose);
		gbc_DateChoose.anchor = GridBagConstraints.NORTHEAST;

		JButton btn_Back = new JButton("返回");
		GridBagConstraints gbc_Back = new GridBagConstraints();
		gbc_Back.gridy = 2;
		gbc_Back.gridx = 0;
		add(btn_Back, gbc_Back);
		gbc_Back.anchor = GridBagConstraints.WEST;
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.mf.gotoPanel(PanelType.MENU);
			}
		});

	}

}
