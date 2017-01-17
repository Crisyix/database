package Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Administrator.searchTerm;
import DataBase.SqlConnect;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class BuyFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox ;
	private JComboBox comboBox_1 ;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private static BuyFrame frame;

	/**
	 * Launch the application.
	 */
	public static void startBuy() {//ÏÔÊ¾Í¶×¢½çÃæ
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BuyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuyFrame() {
		
		setTitle("\u5F00\u5956");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 240, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,0xAA,0x44));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255,0xfa,0xe5));
		comboBox.setBounds(33, 86, 60, 40);
		comboBox.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"}));
		panel.add(comboBox);
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.setBackground(new Color(255,0xfa,0xe5));
		comboBox_1.setBounds(136, 86, 60, 40);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16"}));
		comboBox_1.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 22));
		panel.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(255,0xfa,0xe5));
		comboBox_2.setBounds(233, 86, 60, 40);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17"}));
		comboBox_2.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 22));
		panel.add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBackground(new Color(255,0xfa,0xe5));
		comboBox_3.setBounds(330, 86, 60, 40);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18"}));
		comboBox_3.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 22));
		panel.add(comboBox_3);
		
		randLucky();
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u53F7\u7801");
		lblNewLabel.setBounds(136, 24, 120, 36);
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 24));
		panel.add(lblNewLabel);
		
		JButton button = new JButton("\u786E \u5B9A");
		button.setBackground(new Color(255,0xfa,0xe5));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetLucky();
				JOptionPane.showMessageDialog(contentPane, "¿ª½±³É¹¦£¡","¿ª½±",JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
			}
		});
		button.setBounds(61, 185, 93, 36);
		button.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		panel.add(button);
		
		JButton button_1 = new JButton("\u91CD \u9009");
		button_1.setBackground(new Color(255,0xfa,0xe5));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//ÖØÖÃÑ¡Ïî
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
			}
		});
		button_1.setBounds(264, 185, 93, 36);
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		panel.add(button_1);
	}

	protected void SetLucky() {
		// TODO Auto-generated method stub
		//System.out.println(comboBox_1.getSelectedItem());
		StringBuffer sb = new StringBuffer();
		sb.append(comboBox.getSelectedItem());
		sb.append(comboBox_1.getSelectedItem());
		sb.append(comboBox_2.getSelectedItem());
		sb.append(comboBox_3.getSelectedItem());
		System.out.println(sb.toString());
		String sql = "call SET_LUCKY('"+sb.toString()+"')";
		SqlConnect.updateSQL(sql);
		searchTerm.getInfo();
	}
	protected void randLucky()
	{
		int i=0,x;
		String[] str = new String[4]; 
		while(i<4)
			{
				StringBuffer sb = new StringBuffer();
				x=1+(int)(Math.random()*18);
				Integer s = new Integer(x);
				if(x<10)
				{
					sb.append("0");
				}
				sb.append(s.toString());
				str[i]= sb.toString();
				i++;
				for(int j = 0;j<i-1;j++)
				{
					if(str[j].equals(str[i-1]))
					{
						i--;
						break;
					}
				}
				
			}
		Arrays.sort(str);
		comboBox.setSelectedItem(str[0]);
		comboBox_1.setSelectedItem(str[1]);
		comboBox_2.setSelectedItem(str[2]);
		comboBox_3.setSelectedItem(str[3]);
	}
}
