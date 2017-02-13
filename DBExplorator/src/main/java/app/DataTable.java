package app;

import dbutils.MySQLDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class DataTable extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable dataTable;
    private JScrollPane scrollPane;
    private MySQLDAO dao;

    public DataTable(MySQLDAO dao){
        super(new GridLayout(1,1));
        dataTable=new JTable();
        dataTable.setPreferredScrollableViewportSize(new Dimension(500,300));
        dataTable.setFillsViewportHeight(true);
        scrollPane=new JScrollPane(dataTable);
        add(scrollPane);

        this.dao= dao;
    }

    public void fillTableWithData(String query){
        ResultSet set = dao.executeQuery(query);
        String [] columns = MySQLDAO.resultSetToColumnNames(set);
        String [][] data = MySQLDAO.resultSetToArray(set);
        dataTable.setModel(new DefaultTableModel(data,columns));
    }

}
