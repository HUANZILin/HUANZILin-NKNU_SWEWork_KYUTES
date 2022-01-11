import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LoginGUI {

	JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	private JTextField textField_2;
	User user;
	

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean login(String account, String password, String group) throws IOException {
		this.user = new User(group, account);
		if (user.login(password)) {
			if(user.admin)
				toHomePageT();
			else
				toHomePageS();
			return true;
		}
		else
			return false;
		
		
	}
	
	public void toHomePageS() {
		homePageStudent homepage = new homePageStudent();
		homepage.start(user.account, user.group);
	}
	
	public void toHomePageT() {
		homePageTeacher homepage = new homePageTeacher();
		homepage.start(user.account, user.group);
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 200, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(170, 110, 320, 40);
		textField.setFont(new Font("新細明體", Font.PLAIN, 20));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(170, 180, 320, 40);
		textField_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane txtpnAccount = new JTextPane();
		txtpnAccount.setEditable(false);
		txtpnAccount.setBounds(30, 110, 130, 40);
		txtpnAccount.setBackground(UIManager.getColor("Button.background"));
		txtpnAccount.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		txtpnAccount.setText("account : ");
		frame.getContentPane().add(txtpnAccount);
		
		JTextPane txtpnAccount_1 = new JTextPane();
		txtpnAccount_1.setEditable(false);
		txtpnAccount_1.setBounds(30, 180, 130, 40);
		txtpnAccount_1.setBackground(UIManager.getColor("Button.background"));
		txtpnAccount_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		txtpnAccount_1.setText("password : ");
		frame.getContentPane().add(txtpnAccount_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 250, 320, 40);
		textField_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JTextPane txtpnGroup = new JTextPane();
		txtpnGroup.setEditable(false);
		txtpnGroup.setBounds(30, 250, 130, 40);
		txtpnGroup.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		txtpnGroup.setBackground(UIManager.getColor("Button.background"));
		txtpnGroup.setText("group : ");
		frame.getContentPane().add(txtpnGroup);
		
		JTextPane txtpnKyutesLoginSystem = new JTextPane();
		txtpnKyutesLoginSystem.setEditable(false);
		txtpnKyutesLoginSystem.setBounds(100, 27, 400, 53);
		txtpnKyutesLoginSystem.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		txtpnKyutesLoginSystem.setText("KYUTES Login System");
		frame.getContentPane().add(txtpnKyutesLoginSystem);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setBounds(198, 408, 200, 21);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String account = textField.getText();
				String password = textField_1.getText();
				String group = textField_2.getText();
				try {
					if(!login(account, password, group))
						textPane.setText("wrong password");
				} catch (IOException e1) {
					textPane.setText("wrong account or wrong group");
				}	
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBounds(198, 360, 200, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JTextPane txtpnteacherother = new JTextPane();
		txtpnteacherother.setBackground(UIManager.getColor("Button.background"));
		txtpnteacherother.setFont(new Font("新細明體", Font.PLAIN, 15));
		txtpnteacherother.setText("\u6709\u73ED\u7D1A\u8ACB\u586B\u5165\u73ED\u7D1A\u7DE8\u865F\uFF0C\u8001\u5E2B\u5247\u586B\u5165teacher\uFF0C\u4EE5\u4E0A\u7686\u975E\u5247\u586B\u5165other");
		txtpnteacherother.setBounds(170, 288, 320, 45);
		frame.getContentPane().add(txtpnteacherother);
		
	}

	
}
