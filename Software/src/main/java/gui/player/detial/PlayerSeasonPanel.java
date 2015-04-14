package gui.player.detial;

import enums.Terminology;
import exceptions.PlayerNotFound;
import gui.MainFrame;
import gui.util.GUIUtility;
import gui.util.LabelPanel;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumMap;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import vo.PlayerVO;
import businessLogicService.playersBLService.PlayersBLService_new;

public class PlayerSeasonPanel extends JPanel {
	private static final long serialVersionUID = -1843553808115256738L;
	private PlayersBLService_new playerService;
	private PlayerVO vo;
	private JRadioButton rdibtn_average;
	private JRadioButton rdibtn_total;
	private EnumMap<Terminology,LabelPanel> labelMap_basic;
	private EnumMap<Terminology,LabelPanel> labelMap_advanced;

	public PlayerSeasonPanel(PlayersBLService_new playerService,PlayerVO vo) {
		this.playerService = playerService;
		this.vo = vo;
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		{
			JPanel pnl_basic = new JPanel();
			add(pnl_basic);
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
		
		JPanel pnl_seaTitle = new JPanel();
		pnl_seaTitle.setLayout(new FlowLayout(FlowLayout.LEADING));
		pnl_seaTitle.add(new JLabel("赛季数据"));
		ButtonGroup btngroup = new ButtonGroup();
		rdibtn_average = new JRadioButton("平均");
		rdibtn_average.setActionCommand("AVERAGE");
		rdibtn_average.addActionListener(new RadioButtonListener());
		pnl_seaTitle.add(rdibtn_average);
		btngroup.add(rdibtn_average);
		rdibtn_total = new JRadioButton("总计");
		rdibtn_total.setActionCommand("TOTAL");
		rdibtn_total.addActionListener(new RadioButtonListener());
		pnl_seaTitle.add(rdibtn_total);
		btngroup.add(rdibtn_total);
		btngroup.setSelected(rdibtn_total.getModel(), true);
		add(pnl_seaTitle);
		
		{
			JPanel pnl_tech = new JPanel();
			add(pnl_tech);
			GridBagLayout gbl_pnl_tech = new GridBagLayout();
			pnl_tech.setLayout(gbl_pnl_tech);
			
			labelMap_basic = new EnumMap<Terminology,LabelPanel>(Terminology.class);
			int i = 0;
			for(Terminology[] term = Terminology.getPlayerBasic();i < term.length;i++){
				String unit = "";
				if(term[i] == Terminology.FGP||term[i] == Terminology.TPP||term[i] == Terminology.FTM)
					unit = "%";
				LabelPanel labelPanel = new LabelPanel(term[i].toString(),unit);
				GridBagConstraints gbc_labelPanel = new GridBagConstraints();
				gbc_labelPanel.gridx = i%2;
				gbc_labelPanel.gridy = i/2;
				pnl_tech.add(labelPanel, gbc_labelPanel);
				labelMap_basic.put(term[i], labelPanel);
			}
			setBasicStats(rdibtn_total.getActionCommand());
		}
		{
			JPanel pnl_advanced = new JPanel();
			add(pnl_advanced);
			GridBagLayout gbl_pnl_advanced = new GridBagLayout();
			pnl_advanced.setLayout(gbl_pnl_advanced);
			
			labelMap_advanced = new EnumMap<Terminology,LabelPanel>(Terminology.class);
			int i = 0;
			for(Terminology[] term = Terminology.getPlayerAdvanced();i < term.length;i++){
				LabelPanel labelPanel = new LabelPanel(term[i].toString(),"%");
				GridBagConstraints gbc_labelPanel = new GridBagConstraints();
				gbc_labelPanel.gridx = i%2;
				gbc_labelPanel.gridy = i/2;
				pnl_advanced.add(labelPanel, gbc_labelPanel);
				labelMap_advanced.put(term[i], labelPanel);
			}
			setAdvancedStats();
		}
	}
	
	private void setBasicStats(String type){
		PlayerBasicStatsVO bs = null;
		try {
			if(type == rdibtn_average.getActionCommand())
				bs = playerService.getBasicPlayerStatsAverage(vo.getName());
			else if(type == rdibtn_total.getActionCommand())
				bs = playerService.getBasicPlayerStatsTotal(vo.getName());
		} catch (PlayerNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, "Error!");
		}
		
		for(Terminology term:Terminology.getPlayerBasic()){
			labelMap_basic.get(term).setValue(bs.getProperty(term));
		}
	}
	
	private void setAdvancedStats(){
		PlayerAdvancedStatsVO bs = null;
		try {
			bs = playerService.getAdvancedPlayerStats(vo.getName());
		} catch (PlayerNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, "Error!");
		}
		
		for(Terminology term:Terminology.getPlayerAdvanced()){
			labelMap_advanced.get(term).setValue(bs.getProperty(term));
		}
	}
	
	class RadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			setBasicStats(ae.getActionCommand());
		}
	}


}
