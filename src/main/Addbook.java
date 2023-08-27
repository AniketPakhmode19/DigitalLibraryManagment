package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

@SuppressWarnings("serial")
public class Addbook extends JFrame implements ActionListener {

	JLabel l11, l12, l13, l14, l15, l16;
	JTextField t11, t12, t13, t14, t15;
	JButton b1, b2, b3, b4, b5;
	Container con;
	JLabel label;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Addbook ab = new Addbook(); 
	}

	public void random() {
		Random rd = new Random();
		t11.setText("B" + rd.nextInt(0000 + 3000));
	}

	public Addbook() {
		
		setTitle("Add Book");
		

		con = getContentPane();
		ImageIcon icon = new ImageIcon("images/lib5.jpg");
		label = new JLabel(icon);
		label.setBounds(0, 0, 1000, 667);
		getContentPane().add(label);
		
		Font font = new Font("ARIAL", Font.BOLD , 15);

		l11 = new JLabel(" ADD BOOK / SEARCH BOOK ");
		label.add(l11);
		l11.setBounds(250, 21, 600, 60);
		l11.setFont(new Font("Rockwell Nova Light", Font.BOLD , 35));
		l11.setForeground(Color.WHITE);

		l12 = new JLabel("Book ID : ");
		l12.setBounds(150, 140, 140, 30);
		l12.setFont(font);
		label.add(l12);
		l12.setForeground(Color.WHITE);

		l13 = new JLabel("Book Name : ");
		l13.setBounds(150, 210, 140, 30);
		l13.setFont(font);
		label.add(l13);
		l13.setForeground(Color.WHITE);

		l14 = new JLabel("Author : ");
		l14.setBounds(150, 280, 140, 30);
		l14.setFont(font);
		label.add(l14);
		l14.setForeground(Color.WHITE);

		l15 = new JLabel("Price : ");
		l15.setBounds(150, 350, 140, 30);
		l15.setFont(font);
		label.add(l15);
		l15.setForeground(Color.WHITE);

		l16 = new JLabel("Search by ID : ");
		l16.setBounds(630, 200, 240, 60);
		l16.setFont(font);
		label.add(l16);
		l16.setForeground(Color.WHITE);

		t11 = new JTextField();
		t11.setEditable(false);
		t11.setBounds(270, 140, 120, 30);
		t11.setFont(font);
		label.add(t11);

		t12 = new JTextField();
		t12.setBounds(270, 210, 120, 30);
		t12.setFont(font);
		label.add(t12);

		t13 = new JTextField();
		t13.setBounds(270, 280, 120, 30);
		t13.setFont(font);
		label.add(t13);

		t14 = new JTextField();
		t14.setBounds(270, 350, 120, 30);
		t14.setFont(font);
		label.add(t14);

		t15 = new JTextField();
		t15.setBounds(750, 215, 120, 30);
		t15.setFont(font);
		label.add(t15);

		b1 = new JButton("Save");
		b1.setFont(font);
		b1.setBounds(150, 450, 100, 30);
		label.add(b1);
		b1.addActionListener(this);

		b3 = new JButton("Cancel");
		b3.setFont(font);
		b3.setBounds(290, 450, 100, 30);
		label.add(b3);
		b3.addActionListener(this);

		b4 = new JButton("Search");
		b4.setFont(font);
		b4.setBounds(620, 270, 100, 30);
		label.add(b4);
		b4.addActionListener(this);

		b5 = new JButton("Delete");
		b5.setFont(font);
		b5.setBounds(770, 270, 100, 30);
		label.add(b5);
		b5.addActionListener(this);
		
		setLayout(null);
		setVisible(true);
		setSize(1000, 600);
		setLocationRelativeTo(null);

		random();

	}

	public void actionPerformed(ActionEvent ae) {
		String sa = ae.getActionCommand();

		if (sa.equals("Save")) {
			try {
				Coon conn = new Coon();

				String sql = "insert into book values(?, ?, ?, ?)";
				PreparedStatement ps = conn.c.prepareStatement(sql);

				ps.setString(1, t11.getText());
				ps.setString(2, t12.getText());
				ps.setString(3, t13.getText());
				ps.setInt(4, Integer.parseInt(t14.getText()));

				int rs = ps.executeUpdate();
				if (rs > 0)
					JOptionPane.showMessageDialog(null, "Successfully Added");
				else
					JOptionPane.showMessageDialog(null, "Error");
				Random rd = new Random();
				t11.setText("B" + rd.nextInt(0000 + 3000));
				t12.setText("");
				t13.setText("");
				t14.setText("");
				ps.close();

				conn.c.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error...All Fileds Required Or ID is SAME");

			}
		}

		if (sa.equals("Search")) {
			try {
				Coon conn = new Coon();

				String s1;

				s1 = t15.getText();

				@SuppressWarnings("unused")
				Statement st = conn.c.createStatement();
				PreparedStatement ps = conn.c.prepareStatement("select * from book where bid=(?)");
				ps.setString(1, s1);

				ResultSet Rs = ps.executeQuery();
				if (Rs.next())

				{
					JOptionPane.showMessageDialog(null,
							"Book Name : " + Rs.getString(2) +"\n"+"Book ID : " + Rs.getString(1));
				} 
				else
					JOptionPane.showMessageDialog(null, "Error!!! ID is Not Present");

				ps.close();
				conn.c.close();
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "BOOK IS NOT AVAILABLE ON THIS ID.");
			}
		}

		if (sa.equals("Delete")) {
			try {
				Coon conn = new Coon();

				String sql = "delete from book where bid = '" + t15.getText() + "'";
				PreparedStatement ps = conn.c.prepareStatement(sql);

				JDialog.setDefaultLookAndFeelDecorated(true);
				int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.NO_OPTION) {

				} 
				else if (response == JOptionPane.YES_OPTION) {
					@SuppressWarnings("unused")
					int rs = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted !!");
				} 
				else if (response == JOptionPane.CLOSED_OPTION) {
				}
				ps.close();
				conn.c.close();
			} 
			catch (Exception e) {
			}
		}

		if (sa.equals("Cancel")) {
			@SuppressWarnings("unused")
			Home h = new Home();
		}
	}
}
