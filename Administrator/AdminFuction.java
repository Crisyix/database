package Administrator;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DataBase.*;
import Windows.BuyFrame;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
public class AdminFuction extends JFrame {

	private static JPanel contentPane;
	private static boolean flag=true;
	/**
	 * Launch the application.
	 */
	public static void startAdmin(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFuction frame = new AdminFuction();
					frame.setVisible(true);
					check();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminFuction() {
		setTitle("\u7BA1\u7406\u5458\u6A21\u5F0F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 240, 550, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xff, 0xd0, 0x60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u5F00\u5956\u4FE1\u606F");
		btnNewButton.setBackground(new Color(255,0xfa,0xe5));
		btnNewButton.setBounds(200, 157, 150, 37);
		btnNewButton.addActionListener(new ActionListener() {
			//����Ա�鿴���ڿ���
			public void actionPerformed(ActionEvent arg0) {
				searchTerm.startCheck();
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("΢���ź� Light", Font.PLAIN, 16));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\img\\logo.png"));
		lblNewLabel.setBounds(25, 10, 399, 76);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("\u7528\u6237\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO ��ʾ�û���Ϣ��
				checkUserInformation.startCheckUserInformation();
			}
		});
		button.setBackground(new Color(255,0xfa,0xe5));
		button.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		button.setBounds(400, 157, 100, 37);
		contentPane.add(button);
		
		JButton btnNewButton_3 = new JButton("\u6295\u6CE8\u4FE1\u606F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAllBuy.startCheckAllBuy();
			}
		});
		btnNewButton_3.setBackground(new Color(255,0xfa,0xe5));
		btnNewButton_3.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		btnNewButton_3.setBounds(50, 156, 100, 37);
		contentPane.add(btnNewButton_3);
	}

	private static void check() {
		String s = SqlConnect.cheakLucky();
		if(s==null)
		{
			flag = false;
			//JOptionPane.showMessageDialog(contentPane, "û��δ��������!","����",JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(contentPane, "��"+s+"����δ����!","����",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void newLottert() {
		if(flag)
		{			
			JOptionPane.showMessageDialog(contentPane, "����δ������!���ܴ�����һ��","����",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			//���Դ���
			String sql = "INSERT INTO LOTTERY.TERM() VALUE();";
			try{
				SqlConnect.updateSQL(sql);
				JOptionPane.showMessageDialog(contentPane, "�����ɹ�����׼ʱ����","�ɹ�",JOptionPane.INFORMATION_MESSAGE);
				flag = true;
			}
			catch(Exception ee){
				JOptionPane.showMessageDialog(contentPane, "ʱ��δ��,���ܴ�����","ʧ��",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
