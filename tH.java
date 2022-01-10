import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class tH extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtKyutes;
	private JTable table;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tH frame = new tH();
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
	public tH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		checkBox_3 = new JCheckBox("勾選以查詢成績");
		checkBox_3.setFont(new Font("Microsoft JhengHei UI", checkBox_3.getFont().getStyle() | Font.BOLD, 20));
		checkBox_3.setForeground(new Color(255, 184, 32));
		checkBox_3.setBackground(Color.WHITE);
		checkBox_3.setBounds(669, 358, 170, 39);
		contentPane.add(checkBox_3);
		
		checkBox_2 = new JCheckBox("勾選以查詢成績");
		checkBox_2.setFont(new Font("Microsoft JhengHei UI", checkBox_2.getFont().getStyle() | Font.BOLD, 20));
		checkBox_2.setForeground(new Color(255, 184, 32));
		checkBox_2.setBackground(Color.WHITE);
		checkBox_2.setBounds(669, 307, 170, 39);
		contentPane.add(checkBox_2);
		
		checkBox_1 = new JCheckBox("勾選以查詢成績");
		checkBox_1.setFont(new Font("Microsoft JhengHei UI", checkBox_1.getFont().getStyle() | Font.BOLD, 20));
		checkBox_1.setForeground(new Color(255, 184, 32));
		checkBox_1.setBackground(Color.WHITE);
		checkBox_1.setBounds(669, 256, 170, 39);
		contentPane.add(checkBox_1);
		
		checkBox = new JCheckBox("勾選以查詢成績");
		checkBox.setFont(new Font("Microsoft JhengHei UI", checkBox.getFont().getStyle() | Font.BOLD, 20));
		checkBox.setForeground(new Color(255, 184, 32));
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(669, 208, 170, 39);
		contentPane.add(checkBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("勾選以查詢成績");
		chckbxNewCheckBox.setForeground(new Color(255, 184, 32));
		chckbxNewCheckBox.setFont(new Font("Microsoft JhengHei UI", chckbxNewCheckBox.getFont().getStyle() | Font.BOLD, 20));
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBounds(669, 157, 170, 39);
		contentPane.add(chckbxNewCheckBox);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Microsoft JhengHei UI", textField.getFont().getStyle() | Font.BOLD, 28));
		textField.setForeground(new Color(255, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("測驗歷史");
		textField.setBackground(new Color(0, 153, 255));
		textField.setBounds(10, 10, 966, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtKyutes = new JTextField();
		txtKyutes.setEditable(false);
		txtKyutes.setFont(new Font("Adobe Garamond Pro", txtKyutes.getFont().getStyle() | Font.BOLD, 24));
		txtKyutes.setText("KYUTES  ");
		txtKyutes.setHorizontalAlignment(SwingConstants.RIGHT);
		txtKyutes.setForeground(Color.WHITE);
		txtKyutes.setColumns(10);
		txtKyutes.setBackground(new Color(0, 153, 255));
		txtKyutes.setBounds(10, 505, 966, 48);
		contentPane.add(txtKyutes);
		
		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(50);
		table.setForeground(new Color(0, 153, 255));
		table.setFont(new Font("Microsoft JhengHei UI", table.getFont().getStyle() | Font.BOLD, 24));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u65E5\u671F", "\u6642\u9593", "\u79D1\u76EE", "\u6E2C\u9A57"},
				{"2022/1/11", "13:30~16:20", "\u570B\u6587", null},
				{"2022/1/11", "13:30~16:20", "\u82F1\u6587", null},
				{"2022/1/11", "13:30~16:20", "\u6578\u5B78", null},
				{"2022/1/11", "13:30~16:20", "\u81EA\u7136", null},
				{"2022/1/11", "13:30~16:20", "\u793E\u6703", null},
			},
			new String[] {
				"\u65E5\u671F", "\u6642\u9593", "\u79D1\u76EE", "\u6E2C\u9A57"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.setToolTipText("");
		table.setBounds(138, 102, 707, 300);
		contentPane.add(table);
		
		btnNewButton = new JButton("查詢成績");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", btnNewButton.getFont().getStyle() | Font.BOLD, 24));
		btnNewButton.setBackground(new Color(255, 184, 32));
		btnNewButton.setBounds(416, 428, 154, 49);
		contentPane.add(btnNewButton);
	}
}
