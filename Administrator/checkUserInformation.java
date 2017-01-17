package Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DataBase.SqlConnect;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;

public class checkUserInformation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[][] tab  = new String[100][3];
	/**
	 * Launch the application.
	 */
	public static void startCheckUserInformation() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkUserInformation frame = new checkUserInformation();
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
	public checkUserInformation() {
		setTitle("\u5DF2\u6CE8\u518C\u7528\u6237\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBackground(new Color(255,0xD0,0x60));
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Œ¢»Ì—≈∫⁄ Light", Font.PLAIN, 18));
		String sql = "select * from bettor";
		ResultSet set = SqlConnect.querySQL(sql);
		int i=0;
		try {
			while(set.next())
			{
				String name = set.getString(1);
				String phone = set.getString(2);
				String cash = set.getString(3);
				tab[i][0]=name;
				tab[i][1]=phone;
				tab[i][2]=cash;	
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(new DefaultTableModel(
				tab,
			new String[] {
				"\u7528\u6237\u540D", "\u624B\u673A\u53F7", "\u4F59\u989D"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		DefaultTableCellRenderer r   = new DefaultTableCellRenderer(); //…Ë÷√ƒ⁄»›æ”÷–  
		r.setHorizontalAlignment(JLabel.CENTER);   
		table.setDefaultRenderer(Object.class, r);
		scrollPane.setViewportView(table);
	}

}
