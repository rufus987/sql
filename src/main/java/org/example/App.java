package org.example;

import java.sql.*;



public class App {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/staff", "root", "hsd475H2l9qhg&");
            Statement stat = connection.createStatement();
            String sqlCommand = "CREATE TABLE animal" +
                    "(id INTEGER not NULL," +
                    " name VARCHAR(255)," +
                    " kind VARCHAR(255), " +
                    " age INTEGER," +
                    " PRIMARY KEY(id)" +
                    ");";
            stat.execute(sqlCommand);
            String insertCommand = "INSERT INTO animal(id,name,kind,age) VALUES(2, 'tiger', 'koshka', 4);";
            int i = stat.executeUpdate(insertCommand);
            System.out.println("Успешно применена " + i + " строка");
            String selectCommand = "SELECT * FROM animal";
            ResultSet resultSet = stat.executeQuery(selectCommand);


            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " ");
                System.out.println(resultSet.getString(2) + " ");
                System.out.println(resultSet.getString(3) + " ");
                System.out.println(resultSet.getString(4) + " ");
                System.out.println();
            }

            connection.setAutoCommit(false);
//            stat.execute("DELETE TABLE animal WHERE kind = "ring"");
            System.out.println("Выполнение удаления");
            System.out.println("Удаление прошло успешно");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

