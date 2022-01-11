import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.util.Scanner;

public class TestStartGUI {

	private JFrame frame;
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
	String group, account, title;
	TestResult result;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestStartGUI window = new TestStartGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestStartGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(90, 50, 720, 150);
		frame.getContentPane().add(textPane);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(90, 230, 300, 100);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(510, 230, 300, 100);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(90, 360, 300, 100);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(510, 360, 300, 100);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u4EA4\u5377");
		btnNewButton_4.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = new TestResult(group, account, true);
				try {
					result.writeTestScore(title, account, group, answer);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(375, 500, 150, 30);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("\u4E0B\u4E00\u984C");
		btnNewButton_4_1.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton_4_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				next();
				if(numberNow == total)
					btnNewButton_4_1.disable();
				else
					btnNewButton_4_1.enable();
			}
		});
		btnNewButton_4_1.setBounds(660, 501, 150, 30);
		frame.getContentPane().add(btnNewButton_4_1);
		
		JButton btnNewButton_4_2 = new JButton("\u4E0A\u4E00\u984C");
		btnNewButton_4_2.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton_4_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				last();
				if(numberNow == 0)
					btnNewButton_4_2.disable();
				else
					btnNewButton_4_2.enable();
			}
		});
		btnNewButton_4_2.setBounds(90, 500, 150, 30);
		frame.getContentPane().add(btnNewButton_4_2);
		
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
	
	public void getTest(int questionNum, String path) throws FileNotFoundException {
		question = new String[questionNum];
		ans1 = new String[questionNum];
		ans2 = new String[questionNum];
		ans3 = new String[questionNum];
		ans4 = new String[questionNum];
		answer = new char[questionNum];
		Scanner scan = new Scanner(new FileReader(path));
		for(int i = 0; i < questionNum; i++) {
			question[i] = scan.nextLine();
			ans1[i] = scan.nextLine();
			ans2[i] = scan.nextLine();
			ans3[i] = scan.nextLine();
			ans4[i] = scan.nextLine();
		}
		setOption(numberNow);
		total = questionNum - 1;
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
	
	public void getData(String group, String account, String title) {
		this.group = group;
		this.account = account;
		this.title = title;
	}
}
