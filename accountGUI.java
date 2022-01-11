import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.DropMode;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class accountGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	AccountManager am = new AccountManager();

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accountGUI frame = new accountGUI();
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
	public accountGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField.setBounds(130, 90, 310, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(130, 160, 310, 40);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("\u5275\u5EFA\u7FA4\u7D44");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String group = textField_3.getText();
				String number = textField_4.getText();
				int amount = 0;
				for(int i = 0; i < number.length(); i++) {
					amount *= 10;
					amount += (number.charAt(i) - 48);
				}
				try {
					am.createAccountGrorp(group, amount);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBounds(280, 210, 159, 40);
		contentPane.add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 260, 480, 10);
		contentPane.add(textPane);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(130, 360, 310, 40);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(130, 430, 310, 40);
		contentPane.add(textField_4);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u7BA1\u7406\u6B0A\u9650");
		chckbxNewCheckBox.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		chckbxNewCheckBox.setBounds(130, 480, 120, 40);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("\u5275\u5EFA\u5E33\u865F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean type = chckbxNewCheckBox.isSelected();
				String account = textField_3.getText();
				String password = textField_4.getText();
				try {
					am.createAccountSingle(account, password, type);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBounds(280, 480, 159, 40);
		contentPane.add(btnNewButton_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(UIManager.getColor("Button.background"));
		textPane_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		textPane_1.setText("\u5275\u5EFA\u5E33\u865F\u7FA4\u7D44");
		textPane_1.setBounds(170, 30, 160, 40);
		contentPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("\u73ED\u7D1A\uFF1A");
		textPane_2.setBackground(UIManager.getColor("Button.background"));
		textPane_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_2.setBounds(10, 90, 120, 40);
		contentPane.add(textPane_2);
		
		JTextPane textPane_2_2 = new JTextPane();
		textPane_2_2.setText("\u6578\u91CF");
		textPane_2_2.setBackground(UIManager.getColor("Button.background"));
		textPane_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_2_2.setBounds(10, 160, 120, 40);
		contentPane.add(textPane_2_2);
		
		JTextPane textPane_2_3 = new JTextPane();
		textPane_2_3.setText("\u5E33\u865F\uFF1A");
		textPane_2_3.setBackground(UIManager.getColor("Button.background"));
		textPane_2_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_2_3.setBounds(10, 360, 120, 40);
		contentPane.add(textPane_2_3);
		
		JTextPane textPane_2_4 = new JTextPane();
		textPane_2_4.setText("\u5BC6\u78BC\uFF1A");
		textPane_2_4.setBackground(new Color(240, 240, 240));
		textPane_2_4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_2_4.setBounds(10, 430, 120, 40);
		contentPane.add(textPane_2_4);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setText("\u5275\u5EFA\u55AE\u4E00\u5E33\u865F");
		textPane_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		textPane_1_1.setBackground(SystemColor.menu);
		textPane_1_1.setBounds(170, 300, 160, 40);
		contentPane.add(textPane_1_1);
	}
}
