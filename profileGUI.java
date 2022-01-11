import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class profileGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	User newUser;

	/**
	 * Launch the application.
	 */
	public void start(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profileGUI frame = new profileGUI();
					frame.setVisible(true);
					newUser = user;
					getData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public profileGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(560, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane.setText("\u5E33\u865F\uFF1A");
		textPane.setBounds(10, 40, 140, 40);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBackground(UIManager.getColor("Button.background"));
		textPane_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_1.setText("\u5BC6\u78BC\uFF1A");
		textPane_1.setBounds(10, 120, 140, 40);
		contentPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setBackground(UIManager.getColor("Button.background"));
		textPane_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_2.setText("\u4F7F\u7528\u8005\u540D\u7A31\uFF1A");
		textPane_2.setBounds(10, 200, 140, 40);
		contentPane.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setBackground(UIManager.getColor("Button.background"));
		textPane_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_3.setText("\u7FA4\u7D44\u5225\uFF1A");
		textPane_3.setBounds(10, 280, 140, 40);
		contentPane.add(textPane_3);
		
		textField = new JTextField();
		textField.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField.setBounds(160, 40, 250, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(160, 120, 250, 40);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(160, 200, 250, 40);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(160, 280, 250, 40);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("\u78BA\u8A8D\u66F4\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					saveProfile();
				} catch(Exception error){
					error.getStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBounds(150, 380, 130, 40);
		contentPane.add(btnNewButton);
	}
	
	public void getData() {
		textField.setText(newUser.account);
		textField_1.setText(newUser.password);
		textField_2.setText(newUser.name);
		textField_3.setText(newUser.group);
	}
	
	public void saveProfile() throws IOException {
		String filePath = "data/profile/" + newUser.group + File.separator + newUser.account + ".json";
		File file = new File(filePath);
		newUser.account = textField.getText();
		newUser.password = textField_1.getText();
		newUser.name = textField_2.getText();
		newUser.group = textField_3.getText();
		if(file.exists()) {
			file.delete();
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String write = newUser.toString();
			System.out.println(write);
			bw.close();
		} else
			System.out.println("error");
	}
}
