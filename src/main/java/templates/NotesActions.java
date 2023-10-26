package templates;
import NoteBody.*;
import Instuments.*;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.*;
// todo надо сделать так, чтобы предварительно создавалось соединение с бд и потом все действия выполялись
public class NotesActions implements INotesActions {
    private  Statement setUp(){
        DbConnector newConnection = new DbConnector();
        return newConnection.connect();
    }

    private  void  end(Statement stmt){
        try {
            //if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String addNote_1(String text,int priority) {
        NoteObject note2 = new NoteObject(text, priority);
        String newNote = note2.getNoteId()+ " "+ note2.getNoteText()+ " "+ note2.getPriority() + "\n";

        String filePath = "C:\\Users\\muzaz\\Desktop\\NotesCheckApp\\NotesDB.txt"; // типа в этой папке будет файлик
        try{
            Files.write(Paths.get(filePath),newNote.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println(e);
        }
        return note2.getNoteId();
    }

    @Override
    public String addNote(String text, int priority) {
        Statement query = setUp();
        NoteObject note = new NoteObject(text,priority);
        int rs = 0;
        String result = "";
        //INSERT INTO `NoteBook` (`DateID`, `Note_text`, `Priority`) VALUES ('s43ts', 'note new 30.09', 'MEDIUM');
        try {
           rs =query.executeUpdate("INSERT INTO `NoteBook` (`NoteID`, `Note_text`, `Priority`) VALUES ('" + note.getNoteId() + "', '" + note.getNoteText() + "', '" + note.getPriority() + "')");
           result="Added "+rs+" rows";
        }
        catch (Exception e){
            System.out.println("Connection failed..."+ e);
        }
        end(query);
        return result;
    }

    @Override
    public String deleteNote(String NoteId) {
        Statement query = setUp();
        String result = "";
        //INSERT INTO `NoteBook` (`DateID`, `Note_text`, `Priority`) VALUES ('s43ts', 'note new 30.09', 'MEDIUM');
        try {
            query.executeUpdate("DELETE FROM `NoteBook` WHERE `NoteID` = '"+ NoteId+"'");
            result="deleted row with ID "+NoteId;
        }
        catch (Exception e){
            System.out.println("Connection failed..."+ e);
        }
        end(query);
        return result;
//DELETE FROM `NoteBook` WHERE `Priority` = 'HIGH'
    }

    @Override
    public String findNote(String NoteId){
        Map<String,String> db=new LinkedHashMap<>();
        try {
            FileReader fr = new FileReader("C:\\Users\\muzaz\\Desktop\\NotesCheckApp\\NotesDB.txt");
            Scanner scan = new Scanner(fr);
            int i=0;
            String id;
            String note;
            while (scan.hasNextLine()){
                String str = scan.nextLine();
                int separator= str.indexOf(" ");
                id = str.substring(0,separator);
                note =str.substring(separator);
                db.put(id,note);
                i++;
            }
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        String targetLine = db.get(NoteId);
        return targetLine;
    }
    @Override
    public void changeNote(String NoteId) {

    }
}
