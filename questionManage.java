import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class questionManage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtKyutes;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					questionManage frame = new questionManage();
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
	public questionManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Microsoft JhengHei UI", textField.getFont().getStyle() | Font.BOLD, 28));
		textField.setForeground(new Color(255, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\u984C\u5EAB\u7BA1\u7406\r\n");
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
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane.setText("\u9078\u64C7\u79D1\u76EE\uFF1A");
		textPane.setBounds(350, 110, 187, 36);
		contentPane.add(textPane);
		
		textField_1 = new JTextField();
		textField_1.setBounds(360, 156, 288, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_1.setText("\u96E3\u6613\u5EA6\uFF1A");
		textPane_1.setBounds(350, 210, 187, 36);
		contentPane.add(textPane_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(360, 256, 288, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(360, 356, 288, 30);
		contentPane.add(textField_3);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setEditable(false);
		textPane_1_1.setText("\u984C\u865F\uFF1A");
		textPane_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_1_1.setBounds(350, 310, 187, 36);
		contentPane.add(textPane_1_1);
		
		JButton btnNewButton = new JButton("\u65B0\u589E\u984C\u76EE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subject = textField_1.getText();
				runAdd(subject);
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBounds(350, 450, 128, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u522A\u9664\u984C\u76EE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subject = textField_1.getText();
				String difficulity = textField_2.getText();
				String number = textField_3.getText();
				runDelete(subject, difficulity, number);
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBounds(525, 450, 123, 48);
		contentPane.add(btnNewButton_1);
	}
	
	public void runAdd(String subject) {
		questionAdd add = new questionAdd();
		add.setSubject(subject);
	}
	
	public void runDelete(String subject, String difficulity, String number) {
		int num = 0;
		for(int i = 0; i < number.length(); i++) {
			num *= 10;
			num += (number.charAt(i) - 48);
		}
		questionDelete deletePage = new questionDelete();
		deletePage.start();
		deletePage.setData(subject, difficulity, num);
		deletePage.showQuestion();
	}
}
