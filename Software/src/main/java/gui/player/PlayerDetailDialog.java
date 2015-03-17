package gui.player;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

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
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		ImageIcon image = new ImageIcon("E:\\assignment\\2015 I\\softwareIII\\迭代一数据\\players\\action\\Aaron Brooks.png");
		JLabel lbl_photo = new JLabel(image);
		contentPanel.add(lbl_photo,BorderLayout.WEST);
		{
			JPanel pnl_info = new JPanel();
			contentPanel.add(pnl_info, BorderLayout.CENTER);
			pnl_info.setLayout(new BoxLayout(pnl_info, BoxLayout.Y_AXIS));
			{
				JPanel pnl_basic = new JPanel();
				pnl_info.add(pnl_basic);
			}
			{
				JPanel pnl_tech = new JPanel();
				pnl_info.add(pnl_tech);
			}
			{
				JPanel pnl_advanced = new JPanel();
				pnl_info.add(pnl_advanced);
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
