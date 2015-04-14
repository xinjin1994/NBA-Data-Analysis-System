package gui.player;

import enums.Conference;
import enums.Division;
import enums.Position;
import exceptions.PlayerNotFound;
import factory.ObjectCreator;
import gui.MainFrame;
import gui.SelfAdjustPanel;
import gui.enums.PanelType;
import gui.player.detial.PlayerDetailDialog;
import gui.util.ReturnButton;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;

import vo.PlayerPortraitVO;
import businessLogicService.playersBLService.PlayersBLService_new;

public class PlayerPanel extends SelfAdjustPanel implements PlayerSearch{

	private static final long serialVersionUID = 9090035509234357424L;
	private JList<PortraitPanel> list;

	private PlayersBLService_new playerService = new ObjectCreator().playersBLService();
//	Image backgroundImage = null;
//
//	//这就是重写paint方法
//	public void paint(Graphics g){
//	    loadRecources();
//	    
//	    
//
//	    if(backgroundImage != null){
//	        g.drawImage(backgroundImage, 0, 0, this.pWidth, this.pHeight,this);
//	    }
//	}
//
//	public void loadRecources(){
//	    //载入背景图片
//	    if(backgroundImage == null){
//	        try{
//	        backgroundImage = ImageIO.read(new File("image/Background01.jpg"));
//	        } catch (IOException e){
//	        System.out.println("缺少背景图片");
//	        JOptionPane.showMessageDialog(this, "找不到背景图片!", "文件缺失", JOptionPane.ERROR_MESSAGE);
//	        }
//	    }
//	}
	 public void paintComponent(Graphics gs) {  
	        Graphics2D g = (Graphics2D) gs;  
	        super.paintComponent(g);  
	        //画背景图片  
	        String imagePath="image\\background01.jpg";
//	        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagePath));  
	        ImageIcon img = new ImageIcon(imagePath);
	        img.setImage(img.getImage().getScaledInstance(pWidth,pHeight,Image.SCALE_DEFAULT));
	        g.drawImage(img.getImage(), 0, 0,pWidth,pHeight, this);  
	    }
	 
	 
	public PlayerPanel() {
		GridBagLayout gbl_pnl_menu = new GridBagLayout();
		gbl_pnl_menu.columnWidths = new int[]{pWidth/10, (int) (pWidth/(10/8.0)), pWidth/10};
		gbl_pnl_menu.rowHeights = new int[]{pHeight/10,pHeight/10, pHeight/10, (int) (pHeight*(6/10.0)), pHeight/10};
		gbl_pnl_menu.columnWeights = new double[]{1,1,1};
		gbl_pnl_menu.rowWeights = new double[]{1,1,1,1,1};
		setLayout(gbl_pnl_menu);
		
		ArrayList<PlayerPortraitVO> volist = null;
		try {
			//volist = new PlayersBL().getPlayersPortrait(Conference.NATIONAL, Division.NATIONAL, Position.ALL);
			volist = playerService.getPlayersPortrait(Conference.NATIONAL, Division.NATIONAL, Position.ALL);
		} catch (PlayerNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, "Error!");
		}
		
		PortraitPanel[] plist = new PortraitPanel[volist.size()];
		for(int i = 0;i < plist.length;i++){
			plist[i] = new PortraitPanel(volist.get(i));
		}
		list = new JList<PortraitPanel>(plist);
		list.setCellRenderer(new ListCellRenderer<PortraitPanel>(){
			@Override
			public Component getListCellRendererComponent(
					JList<? extends PortraitPanel> list, PortraitPanel value,
					int index, boolean isSelected, boolean cellHasFocus) {
				return value;
			}
		});
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
		list.setToolTipText("双击以查看详细信息");
		JScrollPane pane_list = new JScrollPane(list);
		pane_list.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_pane_list = new GridBagConstraints();
		gbc_pane_list.gridx = 1;
		gbc_pane_list.gridy = 3;
		gbc_pane_list.fill = GridBagConstraints.BOTH;
		add(pane_list, gbc_pane_list);
		
		SearchPlayerPanel pnl_search = new SearchPlayerPanel(this);
		GridBagConstraints gbc_pnl_search = new GridBagConstraints();
		gbc_pnl_search.gridx = 1;
		gbc_pnl_search.gridy = 1;
		gbc_pnl_search.fill = GridBagConstraints.HORIZONTAL;
		add(pnl_search, gbc_pnl_search);
		
		ReturnButton btn_return = new ReturnButton();
		btn_return.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.mf.gotoPanel(PanelType.MENU);
			}
		});
		GridBagConstraints gbc_btn_return = new GridBagConstraints();
		gbc_btn_return.gridx = 1;
		gbc_btn_return.gridy = 4;
		gbc_btn_return.anchor = GridBagConstraints.SOUTHWEST;
		add(btn_return,gbc_btn_return);
		
		list.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent me){
				if(me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1)
					if(list.getSelectedValue()!=null)
						new PlayerDetailDialog(list.getSelectedValue().getName()).setVisible(true);
			}
		});
	}

	@Override
	public void buildList(Conference c, Division d, Position p) {
		ArrayList<PlayerPortraitVO> volist = null;
		try {
			volist = playerService.getPlayersPortrait(c,d,p);
		} catch (PlayerNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, "Error!");
		}
		
		DefaultListModel<PortraitPanel> model = new DefaultListModel<PortraitPanel>();
		for(int i = 0;i < volist.size();i++){
			model.addElement(new PortraitPanel(volist.get(i)));
		}
		list.setModel(model);
	}
	@Override
	public void filterList(String name) {
		ArrayList<PlayerPortraitVO> volist = null;
		try {
			volist = playerService.getPlayerPortrait(name);
		} catch (PlayerNotFound e) {
			JOptionPane.showMessageDialog(MainFrame.currentFrame, "未搜索到球员！");
			return;
		}
		
		DefaultListModel<PortraitPanel> model = new DefaultListModel<PortraitPanel>();
		for(int i = 0;i < volist.size();i++){
			model.addElement(new PortraitPanel(volist.get(i)));
		}
		list.setModel(model);
	}

}
