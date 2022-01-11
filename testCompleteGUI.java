import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class testCompleteGUI extends JFrame {
	private JTextField textField_1;
	int score;

	/**
	 * Launch the application.
	 */
	public void start(String answer, String ansPath) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testCompleteGUI frame = new testCompleteGUI();
					frame.getScore(answer, ansPath);
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
	public testCompleteGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u56DE\u9996\u9801");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", btnNewButton.getFont().getStyle() | Font.BOLD, 24));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 153, 255));
		btnNewButton.setBounds(418, 415, 136, 52);
		contentPane.add(btnNewButton);
		
		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(new Color(0, 153, 255));
		textField.setForeground(new Color(255, 255, 255));
		textField.setFont(new Font("Microsoft JhengHei UI", textField.getFont().getStyle() | Font.BOLD, 48));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\u606D\u559C\u5DF2\u5B8C\u6210\u8003\u8A66\uFF01");
		textField.setBounds(81, 114, 823, 270);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("·L³n¥¿¶ÂÅé", Font.BOLD, 25));
		textField_1.setEditable(false);
		textField_1.setBounds(404, 296, 186, 57);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
	
	public void getScore(String answer, String ansPath) {
		String correctAns;
		int correct = 0;
		File file = new File(ansPath);
		try {
			Scanner scan = new Scanner(file);
			correctAns = scan.nextLine();
			for(int count = 0; count < correctAns.length(); count++) {
				if(answer.charAt(count) == correctAns.charAt(count))
					correct ++;
			}
			score = (correct * 100) / correctAns.length();
			textField_1.setText("\u5F97\u5206\uFF1A" + score);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}