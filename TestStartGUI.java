import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JSlider;

public class TestStartGUI extends JFrame {

	private JPanel contentPane;
	private JTextPane textPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private String[] question;
	private String[] ans1;
	private String[] ans2;
	private String[] ans3;
	private String[] ans4;
	private char[] answer;
	private int numberNow = 0;
	private int total;
	String ansPath, testPath;

	/**
	 * Launch the application.
	 */
	public void start(int total, String testPath, String ansPath) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestStartGUI frame = new TestStartGUI();
					frame.setData(total, testPath, ansPath);
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
	public TestStartGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane.setEditable(false);
		textPane.setBounds(90, 50, 720, 150);
		contentPane.add(textPane);
		
		btnNewButton = new JButton("\r\n");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(90, 230, 300, 100);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(510, 230, 300, 100);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(90, 360, 300, 100);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(510, 360, 300, 100);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u4EA4\u5377");
		btnNewButton_4.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testCompleteGUI testcomplete = new testCompleteGUI();
				testcomplete.start(answer.toString(), ansPath);
				dispose();
			}
		});
		btnNewButton_4.setBounds(375, 500, 150, 30);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u4E0B\u4E00\u984C");
		btnNewButton_5.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton_5.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				next();
				if(numberNow == total)
					btnNewButton_5.disable();
				else
					btnNewButton_5.enable();
			}
		});
		btnNewButton_5.setBounds(660, 501, 150, 30);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u4E0A\u4E00\u984C");
		btnNewButton_6.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton_6.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				last();
				if(numberNow == 0)
					btnNewButton_6.disable();
				else
					btnNewButton_6.enable();
			}
		});
		btnNewButton_6.setBounds(90, 500, 150, 30);
		contentPane.add(btnNewButton_6);
		
		//set each button action
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer[numberNow] = 'A';
				btnNewButton.setBackground(new Color(255,184,32));
				btnNewButton_1.setBackground(Color.WHITE);
				btnNewButton_2.setBackground(Color.WHITE);
						btnNewButton_3.setBackground(Color.WHITE);
			}
		});
				
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer[numberNow] = 'B';
				btnNewButton.setBackground(Color.WHITE);
				btnNewButton_1.setBackground(new Color(255,184,32));
				btnNewButton_2.setBackground(Color.WHITE);
				btnNewButton_3.setBackground(Color.WHITE);
			}
		});
				
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer[numberNow] = 'C';
				btnNewButton.setBackground(Color.WHITE);
				btnNewButton_1.setBackground(Color.WHITE);
				btnNewButton_2.setBackground(new Color(255,184,32));
				btnNewButton_3.setBackground(Color.WHITE);
			}
		});
				
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer[numberNow] = 'D';
				btnNewButton.setBackground(Color.WHITE);
				btnNewButton_1.setBackground(Color.WHITE);
				btnNewButton_2.setBackground(Color.WHITE);
				btnNewButton_3.setBackground(new Color(255,184,32));
			}
		});
	}

	public void setData(int total, String testPath, String ansPath) {
		this.total = total;
		this.testPath = testPath;
		this.ansPath = ansPath;
	}
	
	public void setTest() throws FileNotFoundException {
		question = new String[total];
		ans1 = new String[total];
		ans2 = new String[total];
		ans3 = new String[total];
		ans4 = new String[total];
		answer = new char[total];
		String[] reader;
		Scanner scan = new Scanner(new FileReader(testPath));
		for(int i = 0; i < total; i++) {
			reader = scan.nextLine().split(",");
			question[i] = reader[0];
			ans1[i] = reader[1];
			ans2[i] = reader[2];
			ans3[i] = reader[3];
			ans4[i] = reader[4];
		}
		setOption(0);
	}
	
	public void setOption(int number) {
		textPane.setText(question[number]);
		btnNewButton.setText(ans1[number]);
		btnNewButton_1.setText(ans2[number]);
		btnNewButton_2.setText(ans3[number]);
		btnNewButton_3.setText(ans4[number]);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_3.setBackground(Color.WHITE);
		switch(answer[number]) {
		case 'A':
			btnNewButton.setBackground(new Color(255,184,32));
			break;
		case 'B':
			btnNewButton_1.setBackground(new Color(255,184,32));
			break;
		case 'C':
			btnNewButton_2.setBackground(new Color(255,184,32));
			break;
		case 'D':
			btnNewButton_3.setBackground(new Color(255,184,32));
			break;
		}
	}
	
	public void next() {
		numberNow ++;
		setOption(numberNow);
	}
	
	public void last() {
		numberNow --;
		setOption(numberNow);
	}
	
}
