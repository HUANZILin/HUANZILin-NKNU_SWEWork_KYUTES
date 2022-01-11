import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class testCreateGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testCreateGUI frame = new testCreateGUI();
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
	public testCreateGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(240, 70, 300, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		textPane.setText("\u8003\u8A66\u79D1\u76EE\uFF1A");
		textPane.setBounds(40, 130, 176, 40);
		contentPane.add(textPane);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(240, 130, 300, 40);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(240, 250, 90, 40);
		contentPane.add(textField_2);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("\u8003\u8A66\u540D\u7A31\uFF1A");
		textPane_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		textPane_1.setEditable(false);
		textPane_1.setBackground(SystemColor.menu);
		textPane_1.setBounds(40, 70, 176, 40);
		contentPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("\u8003\u8A66\u96E3\u5EA6\uFF1A");
		textPane_2.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		textPane_2.setEditable(false);
		textPane_2.setBackground(SystemColor.menu);
		textPane_2.setBounds(40, 250, 176, 40);
		contentPane.add(textPane_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(340, 250, 90, 40);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(440, 250, 90, 40);
		contentPane.add(textField_4);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setBackground(UIManager.getColor("Button.background"));
		textPane_3.setText("\u6613");
		textPane_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_3.setBounds(270, 290, 40, 34);
		contentPane.add(textPane_3);
		
		JTextPane textPane_3_1 = new JTextPane();
		textPane_3_1.setEditable(false);
		textPane_3_1.setText("\u4E2D");
		textPane_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_3_1.setBackground(SystemColor.menu);
		textPane_3_1.setBounds(370, 290, 40, 34);
		contentPane.add(textPane_3_1);
		
		JTextPane textPane_3_2 = new JTextPane();
		textPane_3_2.setEditable(false);
		textPane_3_2.setText("\u96E3");
		textPane_3_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_3_2.setBackground(SystemColor.menu);
		textPane_3_2.setBounds(470, 290, 40, 34);
		contentPane.add(textPane_3_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(240, 190, 300, 40);
		contentPane.add(textField_5);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setText("\u8003\u8A66\u6642\u9593\uFF1A");
		textPane_4.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		textPane_4.setEditable(false);
		textPane_4.setBackground(SystemColor.menu);
		textPane_4.setBounds(40, 190, 176, 40);
		contentPane.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setEditable(false);
		textPane_5.setBackground(UIManager.getColor("Button.background"));
		textPane_5.setBounds(160, 410, 260, 30);
		contentPane.add(textPane_5);
		
		JButton btnNewButton = new JButton("\u5275\u5EFA\u8003\u8A66");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText();
				String subject = textField.getText();
				int easy = toInt(textField_2.getText());
				int normal = toInt(textField_3.getText());
				int diff = toInt(textField_4.getText());
				int timeLimit = toInt(textField_5.getText());
				try {
					testCreate(title, subject, easy, normal, diff, timeLimit);
				} catch (Exception e1) {
					textPane_5.setText("error");
				}
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		btnNewButton.setBounds(170, 360, 240, 40);
		contentPane.add(btnNewButton);
	}
	
	public int toInt(String number) {
		int result = 0;
		for(int i = 0; i < number.length(); i++) {
			number.charAt(i);
			result *= 10;
			result += (number.charAt(i) - 48);
		}
		return result;
	}
	
	public void testCreate(String title, String subject, int easy, int normal, int diff, int timelimit) throws IOException {
		Test newTest = new Test(subject);
		newTest.createQuiz(timelimit, title, easy, normal, diff);
	}
}
