package dbutils;

import java.sql.*;
import java.util.ArrayList;

public class MySQLDAO {
    private Connection connect;  // obiekt do laczenia sie z baza
    private Statement statement; // obiekt przechowujacy zapytanie
    private ResultSet resultSet; // obiekt przechowujacy wynik zapytania

    public void connect(String login, String password) {
        // url to tzw. JDBC ENDPOINT
        try {
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/sys?user="+login+"&password="+password+"&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            System.out.println("Nawiazano polaczenie!");
        } catch (SQLException e) {
            System.out.println("Nie udalo sie polaczyc z baza");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connect != null)
                connect.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static String[] resultSetToColumnNames(ResultSet resultSet){
        int columnCount = 0;
        String[] columns = null;
        try {
            columnCount = resultSet.getMetaData().getColumnCount();

            columns = new String[columnCount];

            for (int i = 1 ; i <= columnCount; i++) {
                columns[i-1] = resultSet.getMetaData().getColumnName(i);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return columns;
    }

    public static String[][] resultSetToArray(ResultSet resultSet){
        String[][] result;
        int columnCount = 0;
        ArrayList<String[]> resultAL = new ArrayList<>();

        try {
            columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()){
                String[] colValues = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    colValues[i-1] = resultSet.getString(i);
                }
                resultAL.add(colValues);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        result = resultAL.toArray(new String[resultAL.size()][columnCount]);
        return result;
    }
    
    public static String[] resultSetToTables(ResultSet resultSet){
        String[] result;
        int columnCount = 1;
        ArrayList<String> resultAL = new ArrayList<>();

        try {
            while (resultSet.next()){
                String colValue= resultSet.getString(columnCount);
                resultAL.add(colValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        result = resultAL.toArray(new String[resultAL.size()]);
        return result;
    }

}

