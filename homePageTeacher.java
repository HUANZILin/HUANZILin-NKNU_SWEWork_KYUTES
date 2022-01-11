import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class homePageTeacher {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	User user;

	/**
	 * Launch the application.
	 */
	public void start(String account, String group) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePageTeacher window = new homePageTeacher();
					window.getUser(account, group);
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
	public homePageTeacher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addContainerListener(new ContainerAdapter() {
		});
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(300, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("個人資料");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toProfile();
			}
		});
		btnNewButton.setBounds(493, 68, 483, 59);
		btnNewButton.setBackground(new Color(255, 184, 32));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", btnNewButton.getFont().getStyle() | Font.BOLD, 28));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("帳號管理");
		btnNewButton_1.setBounds(493, 157, 483, 59);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountGUI.start();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 184, 32));
		btnNewButton_1.setFont(new Font("Microsoft JhengHei UI", btnNewButton_1.getFont().getStyle() | Font.BOLD, 28));
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(493, 505, 483, 48);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Microsoft JhengHei UI", textField.getFont().getStyle(), 18));
		textField.setForeground(new Color(255, 255, 255));
		textField.setText("歡迎，老師~");
		textField.setBackground(new Color(38, 146, 212));
		frame.getContentPane().add(textField);
		textField.setColumns(12);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(493, 10, 483, 48);
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setFont(new Font("Microsoft JhengHei UI", textField_1.getFont().getStyle() | Font.BOLD, 28));
		textField_1.setText("首頁");
		textField_1.setBackground(new Color(38, 146, 212));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(28);
		
		JButton button = new JButton("題庫管理");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questionManage.start();
			}
		});
		button.setFont(new Font("Microsoft JhengHei UI", button.getFont().getStyle() | Font.BOLD, 28));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(255, 184, 32));
		button.setBounds(493, 348, 483, 59);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("測驗管理");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorPage.start();
			}
		});
		button_1.setFont(new Font("Microsoft JhengHei UI", button_1.getFont().getStyle() | Font.BOLD, 28));
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(255, 184, 32));
		button_1.setBounds(493, 436, 483, 59);
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton_2 = new JButton("\u6E2C\u9A57\u8A2D\u5B9A");
		btnNewButton_2.setFont(new Font("Microsoft JhengHei UI", btnNewButton_2.getFont().getStyle() | Font.BOLD, 28));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testCreateGUI.start();
			}
		});
		btnNewButton_2.setBounds(493, 254, 483, 59);
		btnNewButton_2.setBackground(new Color(255, 184, 32));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse-java workspace\\KYUTES_system\\imgs\\kyutes_home.png"));
		lblNewLabel.setBounds(0, 0, 483, 563);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void toProfile() {
		profileGUI profile = new profileGUI();
		profile.start(user.account, user.group);
	}

	public void getUser(String account, String group) {
		try {
			user = new User(group, account);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
