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

public class homePageStudent {

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
					homePageStudent window = new homePageStudent();
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
	public homePageStudent() {
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
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("�ӤH���");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toProfile();
			}
		});
		btnNewButton.setBounds(493, 115, 483, 81);
		btnNewButton.setBackground(new Color(255, 184, 32));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", btnNewButton.getFont().getStyle() | Font.BOLD, 28));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�m��");
		btnNewButton_1.setBounds(493, 241, 483, 81);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				practiceGUI.start();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 184, 32));
		btnNewButton_1.setFont(new Font("Microsoft JhengHei UI", btnNewButton_1.getFont().getStyle() | Font.BOLD, 28));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("����");
		btnNewButton_2.setBounds(493, 373, 483, 81);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestGUI.start();
			}
		});
		btnNewButton_2.setFont(new Font("Microsoft JhengHei UI", btnNewButton_2.getFont().getStyle() | Font.BOLD, 28));
		btnNewButton_2.setBackground(new Color(255, 184, 32));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(493, 505, 483, 48);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Microsoft JhengHei UI", textField.getFont().getStyle(), 18));
		textField.setForeground(new Color(255, 255, 255));
		textField.setText("�w��A�ǥ�~");
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
	}

	public void getUser(User newUser) {
		user = newUser;
	}
	
	public void toProfile() {
		profileGUI profile = new profileGUI();
		profile.start(user);
	}
}