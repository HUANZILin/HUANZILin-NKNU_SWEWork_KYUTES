import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class questionAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	QuesDataBase database;
	String subject;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void start(String subject) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					questionAdd frame = new questionAdd();
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
	public questionAdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(480, 200, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(50, 10, 500, 135);
		textPane.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(50, 165, 230, 60);
		textPane_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		contentPane.add(textPane_1);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setBounds(320, 165, 230, 60);
		textPane_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		contentPane.add(textPane_1_1);
		
		JTextPane textPane_1_2 = new JTextPane();
		textPane_1_2.setBounds(50, 245, 230, 60);
		textPane_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		contentPane.add(textPane_1_2);
		
		JTextPane textPane_1_3 = new JTextPane();
		textPane_1_3.setBounds(320, 245, 230, 60);
		textPane_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		contentPane.add(textPane_1_3);
		
		textField = new JTextField();
		textField.setBounds(140, 322, 100, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(50, 320, 100, 30);
		textPane_2.setEditable(false);
		textPane_2.setBackground(UIManager.getColor("Button.background"));
		textPane_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_2.setText("\u96E3\u6613\u5EA6\uFF1A");
		contentPane.add(textPane_2);
		
		JTextPane textPane_2_1 = new JTextPane();
		textPane_2_1.setBounds(320, 320, 100, 30);
		textPane_2_1.setText("\u7B54\u6848\uFF1A");
		textPane_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_2_1.setEditable(false);
		textPane_2_1.setBackground(SystemColor.menu);
		contentPane.add(textPane_2_1);
		
		JButton btnNewButton = new JButton("\u78BA\u8A8D\u65B0\u589E");
		btnNewButton.setBounds(185, 370, 230, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String question = textPane.getText();
				String ans1 = textPane_1.getText();
				String ans2 = textPane_1_1.getText();
				String ans3 = textPane_1_2.getText();
				String ans4 = textPane_1_3.getText();
				String difficulity = textPane_2.getText();
				char answer = textPane_2_1.getText().charAt(0);
				database = new QuesDataBase(subject, difficulity);
				try {
					database.add(question, ans1, ans2, ans3, ans4, answer);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(410, 322, 100, 30);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
