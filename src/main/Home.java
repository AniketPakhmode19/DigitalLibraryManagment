package main;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;



@SuppressWarnings("serial")
public class Home extends JFrame implements ActionListener {
	
	JLabel label, l1;
	JButton b1, b2, b3, b4, b5, b6, b8, b9, b10;
	Container con;

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Home h = new Home();
	}

	public Home() {
		
		setTitle("Main menu");
		
		con = getContentPane();
		ImageIcon icon = new ImageIcon("images/lib2.jpg");
		label = new JLabel(icon);
		label.setBounds(0, 0, 1000, 667);
		getContentPane().add(label);
		
		l1 = new JLabel("Main Menu");
		l1.setBounds(400, 100, 250, 60);
		label.add(l1);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Rockwell Nova Light", Font.BOLD ,45));
		
		Font font = new Font("ARIAL", Font.BOLD , 15);

		b1 = new JButton("Return Book");
		label.add(b1);
		b1.setFont(font);
		b1.setBounds(190, 200, 300, 35);
		b1.addActionListener(this);

		b2 = new JButton("Add Student / Search Student");
		label.add(b2);
		b2.setFont(font);
		b2.setBounds(550, 200, 300, 35);
		b2.addActionListener(this);

		b3 = new JButton("Issuee Book");
		label.add(b3);
		b3.setFont(font);
		b3.setBounds(190, 300, 300, 35);
		b3.addActionListener(this);

		b9 = new JButton("Logout");
		label.add(b9);
		b9.setFont(font);
		b9.setBounds(550, 400, 300, 35);
		b9.addActionListener(this);

		b8 = new JButton("View All Books");
		label.add(b8);
		b8.setFont(font);
		b8.setBounds(190, 400, 300, 35);
		b8.addActionListener(this);

		b10 = new JButton("Add Books / Search Book");
		label.add(b10);
		b10.setFont(font);
		b10.setBounds(550, 300, 300, 35);
		b10.addActionListener(this);
		
		setLayout(null);
		setVisible(true);
		setSize(1000, 600);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();

		if (s.equals("Add Books / Search Book")) {
			@SuppressWarnings("unused")
			Addbook a = new Addbook();
		}

		if (s.equals("Add Student / Search Student")) {
			@SuppressWarnings("unused")
			Addstudent b = new Addstudent();
		}

		if (s.equals("Issuee Book")) {
			@SuppressWarnings("unused")
			Issuee c = new Issuee();
		}

		if (s.equals("Return Book")) {
			@SuppressWarnings("unused")
			ReturnBook d = new ReturnBook();
		}

		if (s.equals("View All Books")) {
			@SuppressWarnings("unused")
			Viewall e = new Viewall();
		}
		
		if (s.equals("Logout")) {
			dispose();
		}
	}
}