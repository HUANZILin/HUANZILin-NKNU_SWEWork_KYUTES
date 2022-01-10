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

public class qM extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtKyutes;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					qM frame = new qM();
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
	public qM() {
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
		textField.setText("分科題庫");
		textField.setBackground(new Color(0, 153, 255));
		textField.setBounds(10, 10, 966, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("國文");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", btnNewButton.getFont().getStyle() | Font.BOLD, 36));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 184, 32));
		btnNewButton.setBounds(123, 186, 164, 60);
		contentPane.add(btnNewButton);
		
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
		
		button = new JButton("英文");
		button.setFont(new Font("Microsoft JhengHei UI", button.getFont().getStyle() | Font.BOLD, 36));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(255, 184, 32));
		button.setBounds(411, 186, 164, 60);
		contentPane.add(button);
		
		button_1 = new JButton("數學");
		button_1.setFont(new Font("Microsoft JhengHei UI", button_1.getFont().getStyle() | Font.BOLD, 36));
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(255, 184, 32));
		button_1.setBounds(697, 186, 164, 60);
		contentPane.add(button_1);
		
		button_2 = new JButton("自然");
		button_2.setFont(new Font("Microsoft JhengHei UI", button_2.getFont().getStyle() | Font.BOLD, 36));
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(255, 184, 32));
		button_2.setBounds(219, 311, 164, 60);
		contentPane.add(button_2);
		
		button_3 = new JButton("社會");
		button_3.setFont(new Font("Microsoft JhengHei UI", button_3.getFont().getStyle() | Font.BOLD, 36));
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(255, 184, 32));
		button_3.setBounds(602, 311, 164, 60);
		contentPane.add(button_3);
	}
}
