package Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.zip.Inflater;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DataBase.SqlConnect;
import Windows.WindowsFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class checkAllBuy extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JLabel lblNewLabel;
	private static JTextField textField;
	private static String tab[][] = new String[100][4];
	private static boolean f = true;
	private static JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void startCheckAllBuy() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkAllBuy frame = new checkAllBuy();
					frame.setVisible(true);
					manTermInfo();
					information();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected static void manTermInfo() {
		// TODO Auto-generated method stub
		String s=null;
		String sql = "SELECT MAX(TNO) FROM LOTTERY.TERM ;";
		ResultSet set = SqlConnect.querySQL(sql);
		try {
			while(set.next())
			{
				s = set.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textField.setText(s);
	}

	/**
	 * Create the frame.
	 */
	public checkAllBuy() {
		setTitle("\u67E5\u8BE2\u6295\u6CE8\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 550, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,0xAA,0x44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 45, 534, 428);
		contentPane.add(scrollPane);
		
		/**
		显示投注信息
		*/
		table = new JTable();
		table.setFont(new Font("等线 Light", Font.PLAIN, 18));
		table.setBackground(new Color(255,0xd0,0x60));
		//scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("\u8F93\u5165\u671F\u53F7");
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(25, 10, 74, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(97, 13, 132, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5 \u8BE2");
		btnNewButton.setBackground(new Color(255,0xfa,0xe5));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					f=true;
					information();//查询
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		btnNewButton.setBounds(261, 12, 74, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u663E\u793A\u4E2D\u5956\u8005");
		btnNewButton_1.setBackground(new Color(255,0xfa,0xe5));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f=!f;
				if(f)
				{
					//显示全部
					btnNewButton_1.setText("显示中奖者");
					information();
				}
				else
				{
					btnNewButton_1.setText("显示全部");
					information();
				}
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		btnNewButton_1.setBounds(408, 12, 104, 23);
		contentPane.add(btnNewButton_1);
	}

	private static void information() {//显示投注信息
		WindowsFrame.ini(tab);
		String sql;
		if(f)
			sql = "SELECT BNO,BETTORNAME,BNU,MUL FROM LOTTERY.BUY WHERE TNO='"+textField.getText()+"'";
		else
			sql = "SELECT BNO,BETTORNAME,BNU,MUL FROM LOTTERY.LUCKYMAN WHERE TNO='"+textField.getText()+"'";
		ResultSet set = SqlConnect.querySQL(sql);
		int i=0;
		try {
			while(set.next())
			{
				String bn = set.getString(1);
				String nam = set.getString(2);
				String bu  = set.getString(3);
				String mu = set.getString(4);
				bu = addSpace(bu);
				tab [i][0]=bn;
				tab	[i][1]=nam;
				tab [i][2]= bu;
				tab [i][3]=mu;
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(new DefaultTableModel(
				tab,
		new String[] {
			"\u8BA2\u5355\u53F7", "用户名", "\u6295\u6CE8\u53F7\u7801", "\u500D\u6570"
		}
	) {
		boolean[] columnEditables = new boolean[] {
			false, false, false, false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	});
	table.getColumnModel().getColumn(0).setPreferredWidth(50);
	table.getColumnModel().getColumn(1).setPreferredWidth(70);
	table.getColumnModel().getColumn(2).setPreferredWidth(100);
	table.getColumnModel().getColumn(3).setPreferredWidth(60);
		DefaultTableCellRenderer r   = new DefaultTableCellRenderer(); //设置内容居中  
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class, r);
		scrollPane.setViewportView(table);
	}

	private static String addSpace(String bn) {//号码一个一个输出
		// TODO Auto-generated method stub
		String regex = "(.{2})";
        bn = bn.replaceAll (regex, "$1  ");
		return bn;
	}
}
