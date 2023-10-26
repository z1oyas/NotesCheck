package Instuments;
import java.sql.*;
public class DbConnector {
/*
тут одноразовая дб поэтому все время слетает регистрация, надо что то придумать с этим..
 */
    public Statement connect(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            // Создание соединения с базой данных
            conn = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11656955", "sql11656955", "KrhlVzsDgY");

            // Создание объекта Statement для выполнения запросов к базе данных
            stmt = conn.createStatement();

            // Выполнение SQL-запроса
//            rs = stmt.executeQuery("SELECT * FROM NoteBook");
//
//            // Обработка результатов запроса
//            while (rs.next()) {
//                String id = rs.getString("DateId");
//                String name = rs.getString("Note_text");
//                String age =  rs.getString("Priority");
//
//                System.out.println("DateId: " + id + ", Note_text: " + name + ", Priority: " + age);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  stmt;
    }

    public void closeConnection(Connection conn){
        try {
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
