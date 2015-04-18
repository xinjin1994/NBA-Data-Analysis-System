package gui.player.detail;

import enums.Terminology;
import exceptions.PlayerNotFound;
import gui.MainFrame;
import gui.util.LabelPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class PlayerInfoPanel extends JPanel {
	private static final long serialVersionUID = -1843553808115256738L;
	private PlayersBLService_new playerService;
	private PlayerVO vo;
	private static final String AVERAGE = "AVERAGE";
	private static final String TOTAL = "TOTAL";
	private static final String BASIC = "BASIC";
	private static final String ADVANCED = "ADVANCED";
	private EnumMap<Terminology,LabelPanel> labelMap_basic;
	private EnumMap<Terminology,LabelPanel> labelMap_advanced;
	private JPanel pnl_stats;

	public PlayerInfoPanel(PlayersBLService_new playerService,PlayerVO vo) {
		this.playerService = playerService;
		this.vo = vo;
		
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		{
			JPanel pnl_info = new PlayerBasicInfoPanel(vo);
			add(pnl_info);
		}
		{
			JPanel pnl_seaStats = new JPanel(new BorderLayout());
			add(pnl_seaStats);
			
			JPanel pnl_seaTitle = new JPanel();
			pnl_seaTitle.setLayout(new FlowLayout(FlowLayout.LEADING));
			pnl_seaTitle.add(new JLabel("赛季数据"));
			
			JRadioButton rdibtn_basic = new JRadioButton("基础数据");
			rdibtn_basic.setActionCommand(BASIC);
			rdibtn_basic.addActionListener(new StatsRadioButtonListener());
			pnl_seaTitle.add(rdibtn_basic);
			
			JRadioButton rdibtn_advanced = new JRadioButton("进阶数据");
			rdibtn_advanced.setActionCommand(ADVANCED);
			rdibtn_advanced.addActionListener(new StatsRadioButtonListener());
			pnl_seaTitle.add(rdibtn_advanced);
			
			ButtonGroup btngrp_stats = new ButtonGroup();
			btngrp_stats.add(rdibtn_basic);
			btngrp_stats.add(rdibtn_advanced);
			btngrp_stats.setSelected(rdibtn_advanced.getModel(), true);
			
			
			pnl_seaStats.add(pnl_seaTitle,BorderLayout.NORTH);
			
			pnl_stats = new JPanel(new CardLayout());
			pnl_seaStats.add(pnl_stats);
			{
				JPanel pnl_basic = new JPanel();
				pnl_stats.add(pnl_basic,BASIC);
				GridBagLayout gbl_pnl_tech = new GridBagLayout();
				pnl_basic.setLayout(gbl_pnl_tech);
				
				JRadioButton rdibtn_average = new JRadioButton("平均");
				rdibtn_average.setActionCommand(AVERAGE);
				rdibtn_average.addActionListener(new TypeRadioButtonListener());
				GridBagConstraints gbc_rdibtn_average = new GridBagConstraints();
				gbc_rdibtn_average.gridx = 0;
				gbc_rdibtn_average.gridy = 0;
				pnl_basic.add(rdibtn_average,gbc_rdibtn_average);
				
				JRadioButton rdibtn_total = new JRadioButton("总计");
				rdibtn_total.setActionCommand(TOTAL);
				rdibtn_total.addActionListener(new TypeRadioButtonListener());
				GridBagConstraints gbc_rdibtn_total = new GridBagConstraints();
				gbc_rdibtn_total.gridx = 1;
				gbc_rdibtn_total.gridy = 0;
				pnl_basic.add(rdibtn_total,gbc_rdibtn_total);
				
				ButtonGroup btngrp_type = new ButtonGroup();
				btngrp_type.add(rdibtn_average);
				btngrp_type.add(rdibtn_total);
				btngrp_type.setSelected(rdibtn_total.getModel(), true);
				
				labelMap_basic = new EnumMap<Terminology,LabelPanel>(Terminology.class);
				int i = 0;
				for(Terminology[] term = Terminology.getPlayerBasic();i < term.length;i++){
					String unit = "";
					if(term[i] == Terminology.FGP||term[i] == Terminology.TPP||term[i] == Terminology.FTM)
						unit = "%";
					LabelPanel labelPanel = new LabelPanel(term[i].toString(),unit);
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.gridx = i%2;
					gbc_labelPanel.gridy = i/2+1;
					pnl_basic.add(labelPanel, gbc_labelPanel);
					labelMap_basic.put(term[i], labelPanel);
				}
				setBasicStats(rdibtn_total.getActionCommand());
			}
			{
				JPanel pnl_advanced = new JPanel();
				pnl_stats.add(pnl_advanced,ADVANCED);
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
			//((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, BASIC);
		}
	}
	
	private void setBasicStats(String type){
		PlayerBasicStatsVO bs = null;
		try {
			if(type == AVERAGE)
				bs = playerService.getBasicPlayerStatsAverage(vo.getName());
			else if(type == TOTAL)
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
	
	class TypeRadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			setBasicStats(ae.getActionCommand());
		}
	}

	class StatsRadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, ae.getActionCommand());
		}
	}

}
