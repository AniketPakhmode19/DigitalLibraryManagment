package main;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ReturnBook extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10,label;
	JTextField t11, t12, t13, t14, t10, t15, t16, t17;
	JButton b1, b2, b3, b4, b5, b6;
	Container con;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ReturnBook r = new ReturnBook();
	}
	
	public void showDate() {
		Date z = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
		t17.setText(s.format(z));
	}


	public ReturnBook() {
		
		setTitle("Return Book");
		
		con = getContentPane();
		ImageIcon icon = new ImageIcon("images/lib3.jpg");
		label = new JLabel(icon);
		label.setBounds(0, 0, 1000, 667);
		add(label);
		
		Font font = new Font("ARIAL" , Font.BOLD , 15);

		l1 = new JLabel(" RETURN BOOKS ");
		label.add(l1);
		l1.setFont(new Font("Rockwell Nova Light", Font.BOLD , 45));
		l1.setBounds(350, 20, 500, 60);
		l1.setForeground(Color.WHITE);
		
		l2 = new JLabel("Student ID :");
		label.add(l2);
		l2.setBounds(150, 120, 140, 30);
		l2.setFont(font);
		l2.setForeground(Color.WHITE);

		l3 = new JLabel("Student Name:");
		label.add(l3);
		l3.setBounds(150, 170, 140, 30);
		l3.setFont(font);
		l3.setForeground(Color.WHITE);

		l4 = new JLabel("Year & Class:");
		label.add(l4);
		l4.setBounds(150, 220, 140, 30);
		l4.setFont(font);
		l4.setForeground(Color.WHITE);

		l5 = new JLabel("Book ID:");
		label.add(l5);
		l5.setBounds(150, 270, 140, 30);
		l5.setFont(font);
		l5.setForeground(Color.WHITE);

		l6 = new JLabel("Book Name:");
		label.add(l6);
		l6.setBounds(150, 320, 140, 30);
		l6.setFont(font);
		l6.setForeground(Color.WHITE);

		l7 = new JLabel("Issuee Date:");
		label.add(l7);
		l7.setBounds(150, 370, 140, 30);
		l7.setFont(font);
		l7.setForeground(Color.WHITE);

		l8 = new JLabel("Return Date");
		label.add(l8);
		l8.setBounds(150, 420, 140, 30);
		l8.setFont(font);
		l8.setForeground(Color.WHITE);

		l9 = new JLabel("(YYYY/MM/DD)");
		label.add(l9);
		l9.setBounds(420, 420, 111, 30);
		l9.setFont(font);
		l9.setForeground(Color.WHITE);

		b5 = new JButton("Search Student");
		label.add(b5);
		b5.setFont(font);
		b5.setBounds(500, 120, 170, 30);

		t10 = new JTextField();
		label.add(t10);
		t10.setBounds(270, 120, 140, 30);
		t10.setFont(font);

		t11 = new JTextField();
		label.add(t11);
		t11.setEditable(false);
		t11.setBounds(270, 170, 140, 30);
		t11.setFont(font);

		t13 = new JTextField();
		label.add(t13);
		t13.setEditable(false);
		t13.setBounds(340, 220, 60, 30);
		t13.setFont(font);

		t12 = new JTextField();
		label.add(t12);
		t12.setEditable(false);
		t12.setBounds(270, 220, 60, 30);
		t12.setFont(font);

		t14 = new JTextField();
		label.add(t14);
		t14.setEditable(false);
		t14.setBounds(270, 270, 129, 30);
		t14.setFont(font);

		t15 = new JTextField();
		label.add(t15);
		t15.setEditable(false);
		t15.setBounds(270, 320, 129, 30);
		t15.setFont(font);

		t16 = new JTextField();
		label.add(t16);
		t16.setEditable(false);
		t16.setBounds(270, 370, 130, 30);
		t16.setFont(font);

		t17 = new JTextField();
		label.add(t17);
		t17.setBounds(270, 420, 129, 30);
		t17.setFont(font);

		b1 = new JButton("Save");
		label.add(b1);
		b1.setBounds(159, 494, 120, 30);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 17));

		b2 = new JButton("View");
		label.add(b2);
		b2.setBounds(327, 494, 120, 30);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		b3 = new JButton("Cancel");
		label.add(b3);
		b3.setBounds(491, 494, 120, 30);
		b3.setFont(new Font("Times New Roman", Font.BOLD, 17));

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b5.addActionListener(this);

		setLayout(null);
		setVisible(true);
		setSize(1000, 667);
		setLocationRelativeTo(null);
		
		showDate();
	}

	public void actionPerformed(ActionEvent ae) {
		String sa = ae.getActionCommand();
		if (sa.equals("Save")) {
			try {
				Coon conn = new Coon();

				String s1;
				s1 = t10.getText();
				@SuppressWarnings("unused")
				Statement st = conn.c.createStatement();
				PreparedStatement ps = conn.c.prepareStatement("Delete from issuee where sid=(?)");
				ps.setString(1, s1);

				int i = ps.executeUpdate();
				if (i > 0) {
					JOptionPane.showConfirmDialog(null, "Book Returned");					
				}
				else {
					JOptionPane.showMessageDialog(null, "Error!!! ID is not Present");					
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}

			try {
				Coon conn = new Coon();

				String sql = "insert into returnb values(?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = conn.c.prepareStatement(sql);

				ps.setInt(1, Integer.parseInt(t10.getText()));
				ps.setString(2, t11.getText());
				ps.setString(3, t12.getText());
				ps.setString(4, t13.getText());
				ps.setString(5, t14.getText());
				ps.setString(6, t15.getText());
				ps.setString(7, t16.getText());
				ps.setString(8, t17.getText());
				int i = ps.executeUpdate();
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "Book Is Returned.");
				} 
				else
					JOptionPane.showMessageDialog(null, "Error!!! ID is not Present");

			} 
			catch (Exception e) {
				System.out.println(e);
			}
		}

		if (sa.equals("Search Student")) {
			try {
				Coon conn = new Coon();

				String s1,s2;
				s1 = t10.getText();
				s2 = t17.getText();

				@SuppressWarnings("unused")
				Statement st = conn.c.createStatement();
				PreparedStatement ps = conn.c.prepareStatement("select * from issuee where sid=(?)");
				ps.setString(1, s1);
				ResultSet Rs = ps.executeQuery();
				if (Rs.next()) {
					t11.setText(Rs.getString("name"));
					t12.setText(Rs.getString("year"));
					t13.setText(Rs.getString("class"));
					t14.setText(Rs.getString("bid"));
					t15.setText(Rs.getString("bname"));
					t16.setText(Rs.getString("issuee_date"));
					t17.setText(s2);
				}
				else {
					JOptionPane.showMessageDialog(null, "Error!!! ID Not Present");					
				}

				ps.close();
				conn.c.close();
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "NO STUDENT AVAILABLE:");
			}
		}

		if (sa.equals("Cancel")) {
			dispose();
		}
		
		if (sa.equals("View")) {
			@SuppressWarnings("unused")
			Viewre v = new Viewre();
		}
	}
}
