import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;
import java.awt.List;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TestSelectGUI extends JFrame {

	private JPanel contentPane;
	String subject;
	testProgress test;
	private JTextField textField;
	private JTable table;
	Test test1;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSelectGUI frame = new TestSelectGUI();
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
	public TestSelectGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(440, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		textPane.setText("\u6E2C\u9A57\u9078\u64C7");
		textPane.setBounds(285, 25, 130, 47);
		contentPane.add(textPane);
		
		textField = new JTextField();
		textField.setBounds(214, 316, 276, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBackground(UIManager.getColor("Button.background"));
		textPane_1.setText("\u8003\u8A66\u540D\u7A31\uFF1A");
		textPane_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_1.setBounds(214, 272, 205, 34);
		contentPane.add(textPane_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 228, 276, 47);
		contentPane.add(textField_1);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setText("\u5E33\u865F\uFF1A");
		textPane_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_1_1.setEditable(false);
		textPane_1_1.setBackground(SystemColor.menu);
		textPane_1_1.setBounds(214, 184, 205, 34);
		contentPane.add(textPane_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(214, 138, 276, 47);
		contentPane.add(textField_2);
		
		JTextPane textPane_1_2 = new JTextPane();
		textPane_1_2.setText("\u7FA4\u7D44\uFF1A");
		textPane_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		textPane_1_2.setEditable(false);
		textPane_1_2.setBackground(SystemColor.menu);
		textPane_1_2.setBounds(214, 94, 205, 34);
		contentPane.add(textPane_1_2);
		
		JButton btnNewButton = new JButton("\u958B\u59CB\u6E2C\u9A57");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					test = new testProgress(subject,textField.getText());
					test.startQuiz(textField_2.getText(), textField.getText());
					test.getAccount(textField_1.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setBounds(285, 390, 140, 40);
		contentPane.add(btnNewButton);
	}
	
	public void getData(String subject) {
		this.subject = subject;
		test1 = new Test(subject);
	}
}
