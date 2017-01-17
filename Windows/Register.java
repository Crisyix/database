package Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.PasswordView;

import DataBase.SqlConnect;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private static Register frame;

	/**
	 * Launch the application.
	 */
	public static void startRegister() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Register();
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
	public Register() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 240, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setBounds(102, 192, 80, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//¡¨Ω” ˝æ›ø‚≤¢◊¢≤·
				String username = textField.getText();
				String password = passwordField.getText();
				String phone = textField_1.getText();
				int flag = 0;//≈–∂œ◊¢≤·◊¥Ã¨
				if(username.length()==0||username.length()>8)
				{
					JOptionPane.showMessageDialog(contentPane, "’À∫≈≤ªƒ‹Œ™ø’ªÚ’ﬂ≥¨π˝8Œª£°","’À∫≈",JOptionPane.ERROR_MESSAGE);
				}
				else {
				flag = SqlConnect.newUserRegister(username,password,phone);
				if(flag==0)//’À∫≈“—¥Ê‘⁄
				{
					JOptionPane.showMessageDialog(contentPane, "’À∫≈“—¥Ê‘⁄£°","’À∫≈",JOptionPane.ERROR_MESSAGE);
					
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "◊¢≤·≥…π¶£°","’À∫≈",JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(101, 54, 68, 23);
		lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄ Light", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(102, 102, 42, 23);
		lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄ Light", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(179, 58, 138, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 106, 138, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("\u5145\u586B");
		btnNewButton_1.setBounds(251, 192, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u624B\u673A\u53F7");
		lblNewLabel_2.setBounds(102, 147, 57, 23);
		lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄ Light", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 151, 139, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
