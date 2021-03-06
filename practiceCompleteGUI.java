import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class practiceCompleteGUI extends JFrame {
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					practiceCompleteGUI frame = new practiceCompleteGUI();
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
	public practiceCompleteGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u56DE\u9996\u9801");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", btnNewButton.getFont().getStyle() | Font.BOLD, 24));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 153, 255));
		btnNewButton.setBounds(418, 415, 136, 52);
		contentPane.add(btnNewButton);
		
		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(new Color(0, 153, 255));
		textField.setForeground(new Color(255, 255, 255));
		textField.setFont(new Font("Microsoft JhengHei UI", textField.getFont().getStyle() | Font.BOLD, 48));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\u606D\u559C\u5DF2\u5B8C\u6210\u7DF4\u7FD2\uFF01");
		textField.setBounds(81, 114, 823, 270);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("?L?n??????", Font.BOLD, 25));
		textField_1.setEditable(false);
		textField_1.setBounds(404, 296, 186, 57);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}