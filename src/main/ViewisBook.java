package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import java.sql.*;


@SuppressWarnings("serial")
public class ViewisBook extends JFrame implements ActionListener{

	DefaultTableModel model = new DefaultTableModel();
	Container co = getContentPane();
	JTable jtbl = new JTable(model);
	JLabel l1;
	JButton b1;

	public ViewisBook() {
		setLayout(new FlowLayout());
		model.addColumn("Student ID");
		model.addColumn("Student Name");
		model.addColumn("Year & class");
		model.addColumn("Book ID");
		model.addColumn("Book Name");
		model.addColumn("Issuee Date");
		
		l1 = new JLabel("Books Record");
		add(l1);
		l1.setBounds(400,30,400,30);
		l1.setFont(new Font("Rockwell Nova Light", Font.BOLD , 35));
		
		b1 = new JButton("Back");
		add(b1);
		b1.setBounds(450,520,120,30);
		b1.addActionListener(this);
		
		setLayout(null);
		setSize(1000, 667);
		setVisible(true);
		setLocationRelativeTo(null);

		try {
			Coon conn = new Coon();

			String sql = "select * from issuee";
			PreparedStatement ps = conn.c.prepareStatement(sql);

			ResultSet Rs = ps.executeQuery();
			while (Rs.next()) {
				model.addRow(new Object[] { Rs.getString(1), Rs.getString(2), Rs.getString(3) +"  "+ Rs.getString(4),
						Rs.getString(5), Rs.getString(6), Rs.getString(7) });
			}
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		JScrollPane pg = new JScrollPane(jtbl);
		pg.setBounds(50,100,900,400);
		pg.setOpaque(false);
		pg.getViewport().setOpaque(false);
		add(pg);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sa = e.getActionCommand();
		if (sa.equals("Back")) {
			dispose();
		}
	}
}
