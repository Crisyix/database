package Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DataBase.SqlConnect;
import Windows.BuyFrame;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchTerm extends JFrame {

	private JPanel contentPane;
	public static JTable table;
	private static boolean flag=true;
	private static String bla = "";
	private static searchTerm frame;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private static boolean ff = true;
	private JButton btnNewButton_2 ;
	public static JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void startCheck() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new searchTerm();
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
	public searchTerm() {
		setTitle("\u5F80\u671F\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 550, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,0xAA,0x44));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 49, 534, 291);
		contentPane.add(scrollPane);
		
		getInfo();
		
		btnNewButton = new JButton("\u70B9\u51FB\u5F00\u5956");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuyFrame.startBuy();
				btnNewButton.setVisible(false);
				lblNewLabel.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(255,0xfa,0xe5));
		btnNewButton.setBounds(350, 17, 100, 23);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(150, 17, 180, 20);
		if(!flag)//Èç¹ûÓÐÎ´¿ª½±
		{
			lblNewLabel.setText("µÚ"+bla+"ÆÚÉÐÎ´¿ª½±");
			contentPane.add(btnNewButton);
		}
		else
		{
			btnNewButton_1 = new JButton("\u521B\u5EFA\u65B0\u4E00\u671F");
			btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 14));
			btnNewButton_1.setBackground(new Color(255,0xfa,0xe5));
			btnNewButton_1.setBounds(206, 16, 120, 23);
			contentPane.add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					AdminFuction.newLottert();
					btnNewButton_1.setVisible(false);
					getInfo();
					lblNewLabel.setText("µÚ"+bla+"ÆÚÉÐÎ´¿ª½±");
					contentPane.add(btnNewButton);
				}
			});
		}
		contentPane.add(lblNewLabel);
	}

	public static void getInfo() {
		table = new JTable();
		table.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		table.setBackground(new Color(255,0xD0,0x60));
		String sql = "select * from TERM";
		int i=0;
		ResultSet set = SqlConnect.querySQL(sql);
		String tab[][] = new String[100][100];
		try {
			while(set.next())
			{
				String tno = set.getString(1);
				String luc = set.getString(2);
				if(luc.equals("BLANK"))
					{
						flag = false;
						bla = tno;
					}
				else
				{
					tab [i][0]=tno;
					tab	[i][1]=luc;
					i++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(new DefaultTableModel(
			tab,
			new String[] {
				"\u5F00\u5956\u65E5\u671F", "\u5F00\u5956\u53F7\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		DefaultTableCellRenderer r   = new DefaultTableCellRenderer(); //ÉèÖÃÄÚÈÝ¾ÓÖÐ  
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class, r);
		scrollPane.setViewportView(table);
	}
}
