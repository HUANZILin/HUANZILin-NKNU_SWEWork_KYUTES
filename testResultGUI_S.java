import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class testResultGUI_S extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	TestResult result;
	String subject;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testResultGUI_S frame = new testResultGUI_S();
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
	public testResultGUI_S() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(99, 60, 250, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setText("\u8003\u8A66\u540D\u7A31\uFF1A");
		textPane.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane.setBounds(99, 20, 166, 30);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("\u4F7F\u7528\u8005\u540D\u7A31\uFF1A");
		textPane_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_1.setEditable(false);
		textPane_1.setBackground(SystemColor.menu);
		textPane_1.setBounds(99, 110, 166, 30);
		contentPane.add(textPane_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(99, 150, 250, 40);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(99, 293, 250, 40);
		contentPane.add(textField_2);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setText("\u6A94\u6848\u8DEF\u5F91\uFF1A");
		textPane_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_1_1.setEditable(false);
		textPane_1_1.setBackground(SystemColor.menu);
		textPane_1_1.setBounds(99, 253, 166, 30);
		contentPane.add(textPane_1_1);
		
		JButton btnNewButton = new JButton("\u7DF4\u7FD2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = new TestResult(textField_1.getText(), subject, false);
				String path = result.getScore("practice");
				File file = new File(path);
				textPane_1_1.setText(file.getAbsolutePath());
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBounds(99, 200, 100, 40);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u8003\u8A66");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = new TestResult(textField_1.getText(), subject, false);
				String path = result.getScore("test");
				File file = new File(path);
				textPane_1_1.setText(file.getAbsolutePath());
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBounds(249, 200, 100, 40);
		contentPane.add(btnNewButton_1);
		
	}

}
