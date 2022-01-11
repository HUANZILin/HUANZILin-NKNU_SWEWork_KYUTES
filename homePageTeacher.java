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

public class homePageTeacher {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	User user;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePageTeacher window = new homePageTeacher();
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
	
	public void getUser(User newUser) {
		user = newUser;
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
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("�ӤH���");
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
		
		JButton btnNewButton_1 = new JButton("�b���޲z");
		btnNewButton_1.setBounds(493, 191, 483, 59);
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
		textField.setText("�w��A�Ѯv~");
		textField.setBackground(new Color(38, 146, 212));
		frame.getContentPane().add(textField);
		textField.setColumns(12);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(493, 10, 483, 48);
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setFont(new Font("Microsoft JhengHei UI", textField_1.getFont().getStyle() | Font.BOLD, 28));
		textField_1.setText("����");
		textField_1.setBackground(new Color(38, 146, 212));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(28);
		
		JButton button = new JButton("�D�w�޲z");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questionManage.start();
			}
		});
		button.setFont(new Font("Microsoft JhengHei UI", button.getFont().getStyle() | Font.BOLD, 28));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(255, 184, 32));
		button.setBounds(493, 314, 483, 59);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("����޲z");
		button_1.setFont(new Font("Microsoft JhengHei UI", button_1.getFont().getStyle() | Font.BOLD, 28));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testCreateGUI.start();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(255, 184, 32));
		button_1.setBounds(493, 436, 483, 59);
		frame.getContentPane().add(button_1);
	}
	
	public void toProfile() {
		profileGUI profile = new profileGUI();
		profile.start(user);
	}
}