package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {

	public static void main(String args[]) {
		Login r = new Login();
		r.setVisible(true);
		r.setSize(1000, 600);
		r.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	JLabel l1, l2, l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2;

	public Login() {
		
		setTitle("Liberary Managment App");
	
		ImageIcon icon = new ImageIcon("images/lib1.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0, 0, 1000, 667);
		getContentPane().add(label);
		
		l3 = new JLabel("L I B R A R Y");
		label.add(l3);
		l3.setFont(new Font("Rockwell Nova Light", Font.BOLD , 50));
		l3.setForeground(Color.WHITE);
		l3.setBounds(350, 80, 500, 44);
		
		Font font = new Font("Arial",Font.BOLD,17);
		
		l1 = new JLabel("Username:");
		label.add(l1);
		l1.setBounds(350, 230, 140, 30);
		l1.setFont(font);
		l1.setForeground(Color.WHITE);
		
		l2 = new JLabel("Password:");
		label.add(l2);
		l2.setBounds(350, 308, 140, 30);
		l2.setFont(font);
		l2.setForeground(Color.WHITE);
		
		b1 = new JButton("Login");
		label.add(b1);
		b1.setFont(font);
		b1.setBounds(310, 419, 130, 30);
		b1.addActionListener(this);

		b2 = new JButton("Cancel");
		label.add(b2);
		b2.setFont(font);
		b2.setBounds(550, 419, 130, 30);
		b2.addActionListener(this);

		t1 = new JTextField();
		label.add(t1);
		t1.setFont(font);
		t1.setBounds(500, 230, 147, 30);

		t2 = new JPasswordField();
		label.add(t2);
		t2.setFont(font);
		t2.setBounds(500, 310, 147, 30);

		setLayout(null);
		setVisible(true);
		setSize(1000, 600);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent ae) {
		String tf1 = t1.getText();
		@SuppressWarnings("deprecation")
		String tf2 = t2.getText();

		String s = ae.getActionCommand();
		if (s.equals("Login")) {
			if (tf1.equals("admin") && tf2.equals("admin")) {
				@SuppressWarnings("unused")
				Home h = new Home();
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Wrong ID or Password");
			}
		}
		if (s.equals("Cancel")) {
			System.exit(0);
		}
	}
}
