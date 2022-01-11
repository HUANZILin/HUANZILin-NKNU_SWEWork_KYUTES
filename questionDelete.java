import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

public class questionDelete extends JFrame {

	private JPanel contentPane;
	private JTextField txtEasy;
	private JTextField txtA;
	String subject;
	String difficulty;
	int quesCode;
	QuesDataBase database;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the frame.
	 */
	public questionDelete() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(480, 200, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEasy = new JTextField();
		txtEasy.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		txtEasy.setColumns(10);
		txtEasy.setBounds(180, 320, 100, 30);
		contentPane.add(txtEasy);
		
		txtA = new JTextField();
		txtA.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		txtA.setColumns(10);
		txtA.setBounds(450, 320, 100, 30);
		contentPane.add(txtA);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("\u96E3\u6613\u5EA6\uFF1A");
		textPane_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_2.setEditable(false);
		textPane_2.setBackground(SystemColor.menu);
		textPane_2.setBounds(60, 320, 100, 30);
		contentPane.add(textPane_2);
		
		JTextPane textPane_2_1 = new JTextPane();
		textPane_2_1.setText("\u7B54\u6848\uFF1A");
		textPane_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_2_1.setEditable(false);
		textPane_2_1.setBackground(SystemColor.menu);
		textPane_2_1.setBounds(330, 320, 100, 30);
		contentPane.add(textPane_2_1);
		
		JButton btnNewButton = new JButton("\u78BA\u8A8D\u522A\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					runDelete();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(50, 370, 230, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88\u522A\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(320, 370, 230, 30);
		contentPane.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField_2.setEditable(false);
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setBounds(50, 10, 500, 135);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField_3.setBackground(Color.WHITE);
		textField_3.setEditable(false);
		textField_3.setBounds(50, 165, 230, 60);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField_4.setBackground(Color.WHITE);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(320, 165, 230, 60);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField_5.setBackground(Color.WHITE);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(50, 245, 230, 60);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField_6.setBackground(new Color(255, 255, 255));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(320, 245, 230, 60);
		contentPane.add(textField_6);
	}

	public void setData(String subject, String difficulty, int quesCode) {
		this.subject = subject;
		this.difficulty = difficulty;
		this.quesCode = quesCode;
		database = new QuesDataBase(subject, difficulty);
	}
	
	public void runDelete() throws IOException {
		database.delete(quesCode);
	}
	
	public void showQuestion() {
		try {
			String[] question = database.getQuestion(quesCode);
			txtEasy.setText(difficulty);
			txtA.setText(question[5]);
			textField_2.setText(question[0]);
			textField_3.setText(question[1]);
			textField_4.setText(question[2]);
			textField_5.setText(question[3]);
			textField_6.setText(question[4]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
