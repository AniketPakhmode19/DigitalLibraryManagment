package main;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public class Issuee extends JFrame implements ActionListener {

	JLabel l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, label;
	JTextField t11, t12, t13, t14, t10, t15, t16, t17;
	JButton b1, b2, b3, b4, b5, b6;
	Container con;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Issuee issuee = new Issuee();
	}

	public void showDate() {
		Date z = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
		t16.setText(s.format(z));
	}

	public Issuee() {
		
		setTitle("ISSUEE BOOK");
	
		con = getContentPane();
		ImageIcon icon = new ImageIcon("images/lib4.jpg");
		label = new JLabel(icon);
		label.setBounds(0, 0, 1000, 667);
		getContentPane().add(label);
	
		Font font = new Font("ARIAL" , Font.BOLD , 15);

		l11 = new JLabel(" ISSUEE BOOKS ");
		label.add(l11);
		l11.setBounds(390, 40, 700, 60);
		l11.setFont(new Font("Times New Roman", Font.BOLD, 40));
		l11.setForeground(Color.WHITE);

		l12 = new JLabel("Student ID : ");
		label.add(l12);
		l12.setBounds(350, 120, 140, 30);
		l12.setFont(font);
		l12.setForeground(Color.WHITE);

		l13 = new JLabel("Student Name : ");
		label.add(l13);
		l13.setBounds(350, 180, 140, 30);
		l13.setFont(font);
		l13.setForeground(Color.WHITE);

		l14 = new JLabel("Year & Class :");
		label.add(l14);
		l14.setBounds(350, 240, 140, 30);
		l14.setFont(font);
		l14.setForeground(Color.WHITE);

		l15 = new JLabel("Book ID : ");
		label.add(l15);
		l15.setBounds(350, 300, 140, 30);
		l15.setFont(font);
		l15.setForeground(Color.WHITE);

		l16 = new JLabel("Book Name : ");
		label.add(l16);
		l16.setBounds(350, 360, 140, 30);
		l16.setFont(font);
		l16.setForeground(Color.WHITE);

		l17 = new JLabel("Issuee Date : ");
		label.add(l17);
		l17.setBounds(350, 420, 140, 30);
		l17.setFont(font);
		l17.setForeground(Color.WHITE);
		
		l18 = new JLabel("(YYYY/MM/DD)");
		label.add(l18);
		l18.setBounds(650, 421, 121, 30);
		l18.setFont(font);
		l18.setForeground(Color.WHITE);

		t10 = new JTextField();
		label.add(t10);
		t10.setBounds(500, 120, 140, 30);
		t10.setFont(font);

		t11 = new JTextField();
		label.add(t11);
		t11.setEditable(false);
		t11.setBounds(500, 180, 140, 30);
		t11.setFont(font);

		t12 = new JTextField();
		label.add(t12);
		t12.setEditable(false);
		t12.setBounds(500, 240, 50, 30);
		t12.setFont(font);

		t13 = new JTextField();
		label.add(t13);
		t13.setEditable(false);
		t13.setBounds(590, 240, 50, 30);
		t13.setFont(font);

		t14 = new JTextField();
		label.add(t14);
		t14.setBounds(500, 300, 140, 30);
		t14.setFont(font);

		t15 = new JTextField();
		label.add(t15);
		t15.setEditable(false);
		t15.setBounds(500, 360, 140, 30);
		t15.setFont(font);

		t16 = new JTextField();
		label.add(t16);
		t16.setBounds(500, 421, 140, 30);
		t16.setFont(font);

		b1 = new JButton("Save");
		label.add(b1);
		b1.setFont(font);
		b1.setBounds(440, 520, 121, 30);

		b2 = new JButton("View");
		label.add(b2);
		b2.setFont(font);
		b2.setBounds(200, 520, 121, 30);

		b3 = new JButton("Cancel");
		label.add(b3);
		b3.setFont(font);
		b3.setBounds(670, 520, 121, 30);
		
		b5 = new JButton("Search Student");
		label.add(b5);
		b5.setFont(font);
		b5.setBounds(700, 120, 150, 30);

		b6 = new JButton("Search Book");
		label.add(b6);
		b6.setFont(font);
		b6.setBounds(700, 300, 150, 30);

		b3.addActionListener(this);
		b2.addActionListener(this);
		b1.addActionListener(this);
		b6.addActionListener(this);
		b5.addActionListener(this);
		
		setLayout(null);
		setVisible(true);
		setSize(1000, 667);
		setLocationRelativeTo(null);

		showDate();

	}

	public void actionPerformed(ActionEvent ae) {
		String sa = ae.getActionCommand();
		
		if (sa.equals("Search Book")) {
			try {
				Coon conn = new Coon();

				String s1;
				s1 = t16.getText();
				@SuppressWarnings("unused")
				Statement st = conn.c.createStatement();
				PreparedStatement ps = conn.c.prepareStatement("select * from student where sid=(?)");
				ps.setString(1, s1);
				ResultSet Rs = ps.executeQuery();
				if (Rs.next()) {
					JOptionPane.showMessageDialog(null,
							"Student Name is : " + Rs.getString(2) +"\n"+"RollNo : " + Rs.getString(1));
				}

				ps.close();
				conn.c.close();
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Student Roll No. is not available:");
			}
		}

		if (sa.equals("Search Student")) {
			try {
				Coon conn = new Coon();

				String s1;

				s1 = t10.getText();

				@SuppressWarnings("unused")
				Statement st = conn.c.createStatement();
				PreparedStatement ps = conn.c.prepareStatement("select * from student where sid=(?)");
				ps.setString(1, s1);

				ResultSet Rs = ps.executeQuery();
				if (Rs.next()) {
					t11.setText(Rs.getString("name"));
					t12.setText(Rs.getString("year"));
					t13.setText(Rs.getString("class"));

				} else
					JOptionPane.showMessageDialog(null, "Please Enter Student ID");

				ps.close();
				conn.c.close();
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "NO STUDENT AVAILABLE:");
			}
		}

		if (sa.equals("Search Book")) {
			try {
				Coon conn = new Coon();

				String s1;

				s1 = t14.getText();

				@SuppressWarnings("unused")
				Statement st = conn.c.createStatement();
				PreparedStatement ps = conn.c.prepareStatement("select * from book where bid=(?)");
				ps.setString(1, s1);

				ResultSet Rs = ps.executeQuery();
				if (Rs.next()) {
					t15.setText(Rs.getString("bname"));
				} 
				else
					JOptionPane.showMessageDialog(null, "Error!!! ID is not Present");

				ps.close();
				conn.c.close();
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "NO BOOK AVAILABLE:");
			}
		}

		if (sa.equals("Save")) {
			try {
				Coon conn = new Coon();

				String sql = "insert into issuee values(?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = conn.c.prepareStatement(sql);

//				ps.setInt(1, Integer.parseInt(t10.getText()));
				ps.setString(1, t10.getText());
				ps.setString(2, t11.getText());
				ps.setString(3, t12.getText());
				ps.setString(4, t13.getText());
				ps.setString(5, t14.getText());
				ps.setString(6, t15.getText());
				ps.setString(7, t16.getText());
//				ps.setInt(7, Integer.parseInt( t16.getText()));

				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Book is ISSUEED");

				conn.c.close();
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Book Is Not Availabel");
			}
		}
		
		if (sa.equals("Cancel")) {
			@SuppressWarnings("unused")
			Home h = new Home();
		}
		
		if (sa.equals("View")) {
			@SuppressWarnings("unused")
			ViewisBook v = new ViewisBook ();
		}
	}
}