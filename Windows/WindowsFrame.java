package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import DataBase.SqlConnect;

import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WindowsFrame {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	public static String username = "USERCREATOR";
	public static String password = "PASSWORD";
	private int width=550;
	private int height=350;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsFrame window = new WindowsFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5DE8\u4E50\u5F69\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(400,200,width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0xff, 0xd0, 0x60));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(80, 19, 403, 122);
		lblNewLabel.setIcon(new ImageIcon("E:\\img\\logo.png"));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26 \u53F7");
		lblNewLabel_1.setBounds(145, 150, 45, 26);
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄ Light", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Œ¢»Ì—≈∫⁄ Light", Font.PLAIN, 16));
		textField.setBounds(200, 150, 150, 30);
		textField.setText("MANAGER");
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6 \u7801");
		lblNewLabel_2.setBounds(145, 190, 45, 26);
		lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄ Light", Font.PLAIN, 18));
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					login();
			}
		});
		passwordField.setBounds(200, 190, 150, 30);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("\u767B  \u9646");
		btnNewButton.setBackground(new Color(255,0xfa,0xe5));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄ Light", Font.PLAIN, 14));
		btnNewButton.setBounds(width/2-40, height*5/7-15, 80, 30);
		panel.add(btnNewButton);
	}

	private void login() {
		username=textField.getText();
		password=passwordField.getText();
		boolean flag = true;		
		try{
			SqlConnect.OldUserLogin(username, password);
			}
		catch(Exception e){
			flag=false;
		}
		if(flag)
		{
			frame.dispose();
			Administrator.AdminFuction.startAdmin();
		}
		if(!flag)
		{
			JOptionPane.showMessageDialog(frame, "√‹¬Î¥ÌŒÛ£°","’À∫≈",JOptionPane.ERROR_MESSAGE);
			passwordField.setText("");
		}

	}
	public static void ini(String[][] tab)
	{
		int j=0;
		while (j<50)
		{
			tab[j][0]=null;
			tab[j][1]=null;
			tab[j][2]=null;
			tab[j][3]=null;
			j++;
		}
	}
}
