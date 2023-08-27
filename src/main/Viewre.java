package main;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


@SuppressWarnings("serial")
public class Viewre extends JFrame {

	DefaultTableModel model = new DefaultTableModel();
	JTable jtbl = new JTable(model);
	Container co = getContentPane();

	public Viewre() {
		setLayout(new FlowLayout());

		model.addColumn("Student ID");
		model.addColumn("Student Name");
		model.addColumn("Year & Class");
		model.addColumn("Book ID");
		model.addColumn("Book Name");
		model.addColumn("Issuee Date");
		model.addColumn("Return Date");

		try {
			Coon conn = new Coon();

			String sql = "select * from returnb";
			PreparedStatement ps = conn.c.prepareStatement(sql);

			ResultSet Rs = ps.executeQuery();
			while (Rs.next()) {
				model.addRow(new Object[] { Rs.getString(1), Rs.getString(2), Rs.getString(3) + Rs.getString(4),
						Rs.getString(5), Rs.getString(6), Rs.getString(7), Rs.getString(8) });
			}
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		JScrollPane pg = new JScrollPane(jtbl);
		pg.setBounds(84, 5, 811, 402);
		co.add(pg);
		
		setLayout(null);
		setSize(1000, 600);
		setVisible(true);

	}
}
