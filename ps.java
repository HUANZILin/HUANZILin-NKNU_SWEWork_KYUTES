package p2;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ps extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtKyutes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ps frame = new ps();
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
	public ps() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Microsoft JhengHei UI", textField.getFont().getStyle() | Font.BOLD, 28));
		textField.setForeground(new Color(255, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\u7DF4\u7FD2");
		textField.setBackground(new Color(0, 153, 255));
		textField.setBounds(10, 10, 966, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u958B\u59CB\u7DF4\u7FD2");
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", btnNewButton.getFont().getStyle() | Font.BOLD, 24));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 184, 32));
		btnNewButton.setBounds(423, 117, 139, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8A62\u6210\u7E3E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Microsoft JhengHei UI", btnNewButton_1.getFont().getStyle() | Font.BOLD, 24));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 184, 32));
		btnNewButton_1.setBounds(423, 172, 139, 45);
		contentPane.add(btnNewButton_1);
		
		txtKyutes = new JTextField();
		txtKyutes.setFont(new Font("Candara", txtKyutes.getFont().getStyle() | Font.BOLD, 24));
		txtKyutes.setText("KYUTES  ");
		txtKyutes.setHorizontalAlignment(SwingConstants.RIGHT);
		txtKyutes.setForeground(Color.WHITE);
		txtKyutes.setColumns(10);
		txtKyutes.setBackground(new Color(0, 153, 255));
		txtKyutes.setBounds(10, 505, 966, 48);
		contentPane.add(txtKyutes);
	}
}
