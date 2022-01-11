import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class testResultGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	TestResult result;
	String subject;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testResultGUI frame = new testResultGUI();
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
	public testResultGUI() {
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
		textPane_1.setText("\u7FA4\u7D44\uFF1A");
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
		
		JButton btnNewButton = new JButton("\u6210\u7E3E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = new TestResult(textField_1.getText(), subject, true);
				String path = result.getScoreGroup(textField.getText());
				File file = new File(path);
				textPane_1_1.setText(file.getAbsolutePath());
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBounds(99, 200, 100, 40);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("\u8A66\u5377");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = new TestResult(textField_1.getText(), subject, true);
				String path = result.getTestPaper(textField.getText());
				File file = new File(path);
				textPane_1_1.setText(file.getAbsolutePath());
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBounds(249, 200, 100, 40);
		contentPane.add(btnNewButton_1);
	}
}
