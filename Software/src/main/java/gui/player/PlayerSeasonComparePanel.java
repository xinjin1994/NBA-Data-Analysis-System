package gui.player;

import enums.Terminology;
import exceptions.PlayerNotFound;
import exceptions.TermNotFound;
import gui.MainFrame;
import gui.util.NamedLabel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumMap;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import businessLogicService.playersBLService.PlayersBLService_new;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;

public class PlayerSeasonComparePanel extends PlayerStatsPanel {
	private static final long serialVersionUID = -1843553808115256738L;
	private static final String AVERAGE = "AVERAGE";
	private static final String TOTAL = "TOTAL";

	public PlayerSeasonComparePanel(PlayersBLService_new playerService,String name) {
		this(playerService,name,15,new Insets(2,5,2,5),new Insets(5,5,5,5));
	}
	private PlayerSeasonComparePanel(PlayersBLService_new playerService,String name,int fontSize,Insets insets_basic,Insets insets_advanced){
		super(playerService,name);
		{
			JPanel pnl_seaStats = new JPanel(new BorderLayout());
			add(pnl_seaStats);
			
			JPanel pnl_seaTitle = new JPanel();
			pnl_seaTitle.setLayout(new FlowLayout(FlowLayout.LEADING));
			//pnl_seaTitle.add(new JLabel("赛季数据"));
			
			rdibtn_basic = new JRadioButton("基础数据");
			rdibtn_basic.setFont(new Font("黑体",Font.BOLD,fontSize));
			rdibtn_basic.setActionCommand(BASIC);
			rdibtn_basic.addActionListener(new StatsRadioButtonListener());
			pnl_seaTitle.add(rdibtn_basic);
			
			rdibtn_advanced = new JRadioButton("进阶数据");
			rdibtn_advanced.setFont(new Font("黑体",Font.BOLD,fontSize));
			rdibtn_advanced.setActionCommand(ADVANCED);
			rdibtn_advanced.addActionListener(new StatsRadioButtonListener());
			pnl_seaTitle.add(rdibtn_advanced);
			
			ButtonGroup btngrp_stats = new ButtonGroup();
			btngrp_stats.add(rdibtn_basic);
			btngrp_stats.add(rdibtn_advanced);
			btngrp_stats.setSelected(rdibtn_basic.getModel(), true);
			
			
			pnl_seaStats.add(pnl_seaTitle,BorderLayout.NORTH);
			
			pnl_stats = new JPanel(new CardLayout());
			pnl_seaStats.add(pnl_stats);
			{
				JPanel pnl_basic = new JPanel();
				pnl_stats.add(pnl_basic,BASIC);
				GridBagLayout gbl_pnl_tech = new GridBagLayout();
				pnl_basic.setLayout(gbl_pnl_tech);
				
				JRadioButton rdibtn_average = new JRadioButton("平均");
				rdibtn_average.setFont(new Font("黑体",Font.BOLD,15));
				rdibtn_average.setActionCommand(AVERAGE);
				rdibtn_average.addActionListener(new TypeRadioButtonListener());
				GridBagConstraints gbc_rdibtn_average = new GridBagConstraints();
				gbc_rdibtn_average.gridx = 0;
				gbc_rdibtn_average.gridy = 0;
				pnl_basic.add(rdibtn_average,gbc_rdibtn_average);
				
				JRadioButton rdibtn_total = new JRadioButton("总计");
				rdibtn_total.setFont(new Font("黑体",Font.BOLD,15));
				rdibtn_total.setActionCommand(TOTAL);
				rdibtn_total.addActionListener(new TypeRadioButtonListener());
				GridBagConstraints gbc_rdibtn_total = new GridBagConstraints();
				gbc_rdibtn_total.gridx = 0;
				gbc_rdibtn_total.gridy = 1;
				pnl_basic.add(rdibtn_total,gbc_rdibtn_total);
				
				ButtonGroup btngrp_type = new ButtonGroup();
				btngrp_type.add(rdibtn_average);
				btngrp_type.add(rdibtn_total);
				btngrp_type.setSelected(rdibtn_total.getModel(), true);
				
				labelMap_basic = new EnumMap<Terminology,NamedLabel>(Terminology.class);
				int i = 0;
				for(Terminology[] term = Terminology.getPlayerSeasonBasic();i < term.length;i++){
					String unit = Terminology.getUnit(term[i]);
					NamedLabel labelPanel = new NamedLabel(term[i].toString(),unit);
					labelPanel.setFont(new Font("黑体",Font.BOLD,fontSize));
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.anchor = GridBagConstraints.LINE_START;
					gbc_labelPanel.insets = insets_basic;
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = i+2;
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
				
				labelMap_advanced = new EnumMap<Terminology,NamedLabel>(Terminology.class);
				int i = 0;
				for(Terminology[] term = Terminology.getPlayerAdvanced();i < term.length;i++){
					String unit = Terminology.getUnit(term[i]);
					NamedLabel labelPanel = new NamedLabel(term[i].toString(),unit);
					labelPanel.setFont(new Font("黑体",Font.BOLD,fontSize));
					GridBagConstraints gbc_labelPanel = new GridBagConstraints();
					gbc_labelPanel.anchor = GridBagConstraints.LINE_START;
					gbc_labelPanel.insets = insets_advanced;
					gbc_labelPanel.gridx = 0;
					gbc_labelPanel.gridy = i;
					pnl_advanced.add(labelPanel, gbc_labelPanel);
					labelMap_advanced.put(term[i], labelPanel);
				}
				setAdvancedStats();
			}
			((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, BASIC);
		}
	}
	public PlayerSeasonComparePanel(PlayersBLService_new playerService,String name,Terminology term
			,int fontSize,Insets insets_basic,Insets insets_advanced) {
		this(playerService,name,fontSize,insets_basic,insets_advanced);
		NamedLabel lbl = null;
		if(labelMap_basic.containsKey(term)){
			lbl = labelMap_basic.get(term);
			rdibtn_basic.setEnabled(true);
			((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, BASIC);
		}
		else if(labelMap_advanced.containsKey(term)){
			lbl = labelMap_advanced.get(term);
			rdibtn_advanced.setEnabled(true);
			((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, ADVANCED);
		}
		else return;
		lbl.setForeground(Color.RED);
	}
	
	private void setBasicStats(String type){
		PlayerBasicStatsVO bs = null;
		try {
			if(type == AVERAGE)
				bs = playerbl.getBasicPlayerStatsAverage(MainFrame.season.season,name);
			else if(type == TOTAL)
				bs = playerbl.getBasicPlayerStatsTotal(MainFrame.season.season,name);
			
			for(Terminology term:Terminology.getPlayerSeasonBasic()){
				labelMap_basic.get(term).setText(bs.getProperty(term));
			}
		} catch (PlayerNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		} catch (TermNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		}
		
	}
	

	private void setAdvancedStats(){
		PlayerAdvancedStatsVO bs;
		try {
			bs = playerbl.getAdvancedPlayerStats(MainFrame.season.season,name);

			for(Terminology term:Terminology.getPlayerAdvanced()){
				labelMap_advanced.get(term).setText(bs.getProperty(term));
			}
		} catch (PlayerNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
		} catch (TermNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, e.toString());
			e.printStackTrace();
		}
		
	}

	private class TypeRadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			setBasicStats(ae.getActionCommand());
		}
	}

	private class StatsRadioButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			((CardLayout)(pnl_stats.getLayout())).show(pnl_stats, ae.getActionCommand());
		}
	}


}
