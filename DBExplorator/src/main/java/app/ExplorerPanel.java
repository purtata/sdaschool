package app;

import dbutils.MySQLDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExplorerPanel extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] schemas;
    private String[] tables;
    private JComboBox<String> schemaCombo; 
    private JComboBox<String> tableCombo;
    private JLabel schemaLabel; 
    private JLabel tableLabel;
    private JButton buttonConnect, buttonDisconnect;
    private MySQLDAO dao;
    private String login="root", password="root";

    private DataTable dataTable;

    public ExplorerPanel(DataTable dataTable, MySQLDAO dao) {
        super();
        this.dataTable=dataTable;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        schemaLabel = new JLabel("Schemas:");
        tableLabel = new JLabel("Tables:");

        schemaCombo = new JComboBox<>();
        schemaCombo.setMaximumSize(new Dimension(100,20));
        schemaCombo.addActionListener(this);

        tableCombo = new JComboBox<>();
        tableCombo.setMaximumSize(new Dimension(100,20));
        tableCombo.addActionListener(this);
        
        this.dao=dao;

        buttonConnect = new JButton("Connect to Data Base");
        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.connect(login,password);
                schemas =getSchemas();
                updateCombo(schemaCombo,schemas);
                dataTable.fillTableWithData("show schemas");
            }

        });
        
        buttonDisconnect = new JButton("Disconnect");
        buttonDisconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dao.close();
            	schemaCombo.removeAllItems();
            	tableCombo.removeAllItems();
            }

        });

        add(schemaLabel);
        add(schemaCombo);
        add(tableLabel);
        add(tableCombo);
        add(buttonConnect);
        add(buttonDisconnect);

    }

    private String[] getTables(String query){
        //String [] tables = {"customer"+str,"film"+str,"payment"+str,"actor"+str};
    	String[] tables = MySQLDAO.resultSetToTables(dao.executeQuery(query));
        return tables;
    }

    private String[] getSchemas(){
    	String[] schemas = MySQLDAO.resultSetToTables(dao.executeQuery("show schemas"));
        return schemas;
    }
    
	public void updateCombo(JComboBox<String> combo, String[] list) {
		combo.removeAllItems();
		int index=0;
        for (String string : list) {
			combo.insertItemAt(string, index);
		}
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> combo = (JComboBox<String>)e.getSource();

        String selectedItem = (String)combo.getSelectedItem();
		if (combo.equals(tableCombo)&&selectedItem!=null){
            dataTable.fillTableWithData("select * from "+(String)schemaCombo.getSelectedItem()+"."+selectedItem);
        }

        else if (combo.equals(schemaCombo)&&selectedItem!=null){
        	String qr = "show tables from "+selectedItem;
            tables=getTables(qr);
            updateCombo(tableCombo, tables);
            dataTable.fillTableWithData(qr);
        }
    }
}
