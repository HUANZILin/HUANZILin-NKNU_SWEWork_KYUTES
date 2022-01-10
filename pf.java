import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class pf extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtKyutes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pf frame = new pf();
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
	public pf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Microsoft JhengHei UI", textField.getFont().getStyle() | Font.BOLD, 28));
		textField.setForeground(new Color(255, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("個人資料");
		textField.setBackground(new Color(0, 153, 255));
		textField.setBounds(10, 10, 966, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setForeground(new Color(0, 153, 255));
		textField_1.setFont(new Font("Microsoft JhengHei UI", textField_1.getFont().getStyle() | Font.BOLD, 24));
		textField_1.setText("名稱：");
		textField_1.setBounds(10, 117, 279, 45);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setEditable(false);
		textField_2.setForeground(new Color(0, 153, 255));
		textField_2.setFont(new Font("Microsoft JhengHei UI", textField_2.getFont().getStyle() | Font.BOLD, 24));
		textField_2.setText("帳號：");
		textField_2.setBounds(10, 172, 279, 45);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Microsoft JhengHei UI", textField_3.getFont().getStyle() | Font.BOLD, 24));
		textField_3.setForeground(new Color(0, 153, 255));
		textField_3.setText("群組：");
		textField_3.setBounds(10, 230, 279, 45);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("修改名稱");
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", btnNewButton.getFont().getStyle() | Font.BOLD, 24));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 184, 32));
		btnNewButton.setBounds(366, 117, 139, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改密碼");
		btnNewButton_1.setFont(new Font("Microsoft JhengHei UI", btnNewButton_1.getFont().getStyle() | Font.BOLD, 24));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 184, 32));
		btnNewButton_1.setBounds(366, 172, 139, 45);
		contentPane.add(btnNewButton_1);
		
		txtKyutes = new JTextField();
		txtKyutes.setEditable(false);
		txtKyutes.setFont(new Font("Adobe Garamond Pro", txtKyutes.getFont().getStyle() | Font.BOLD, 24));
		txtKyutes.setText("KYUTES  ");
		txtKyutes.setHorizontalAlignment(SwingConstants.RIGHT);
		txtKyutes.setForeground(Color.WHITE);
		txtKyutes.setColumns(10);
		txtKyutes.setBackground(new Color(0, 153, 255));
		txtKyutes.setBounds(10, 505, 966, 48);
		contentPane.add(txtKyutes);
	}
}
