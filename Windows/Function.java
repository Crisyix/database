package Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Function extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void startFunction() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Function frame = new Function();
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
	public Function() {
		setTitle("\u529F\u80FD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yi\\Desktop\\logo.png"));
		lblNewLabel.setBounds(88, 10, 394, 89);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u6295\u6CE8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//µã»÷Í¶×¢Ìøµ½Í¶×¢½çÃæ
				BuyFrame.startBuy();
			}
		});
		btnNewButton.setBackground(new Color(0xff, 0xaa, 0x44));
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		btnNewButton.setBounds(49, 196, 112, 38);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u6295\u6CE8\u8BB0\u5F55");
		button.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		button.setBackground(new Color(255, 170, 68));
		button.setBounds(216, 196, 112, 38);
		panel.add(button);
		
		JButton button_1 = new JButton("\u5151\u5956");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		button_1.setBackground(new Color(255, 170, 68));
		button_1.setBounds(377, 196, 112, 38);
		panel.add(button_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u6B22\u8FCE\u60A8\uFF0C\u5C0A\u656C\u7684"+WindowsFrame.username);
		lblNewLabel_1.setForeground(new Color(153, 51, 255));
		lblNewLabel_1.setFont(new Font("·½ÕýÊæÌå", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(49, 109, 334, 38);
		panel.add(lblNewLabel_1);
	}
}
