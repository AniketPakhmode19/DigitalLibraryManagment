package main;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

@SuppressWarnings("serial")
public class Viewbook extends JFrame {

	DefaultTableModel model = new DefaultTableModel();
	Container co = getContentPane();
	JTable jtbl = new JTable(model);

	public Viewbook() {
		
		model.addColumn("Book ID");
		model.addColumn("Book Name");
		model.addColumn("Author");
		model.addColumn("Price");
		
		setLayout(null);
		setVisible(true);
		setSize(1000, 667);
		setLocationRelativeTo(null);

		try {
			Coon conn = new Coon();

			String sql = "select * from book";
			PreparedStatement ps = conn.c.prepareStatement(sql);

			ResultSet Rs = ps.executeQuery();
			while (Rs.next()) {
				model.addRow(new Object[] { Rs.getString(1), Rs.getString(2), Rs.getString(3), Rs.getString(4) });
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
}
