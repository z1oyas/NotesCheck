import NoteBody.NoteObject;
import templates.*;
import  Instuments.DbConnector;

import javax.imageio.IIOException;
import java.util.HashMap;

// нужно где то хранить созданные объекты. а так они каждый раз перезаписываются при запуске майна
// база данных
public class Main {
    public static void main(String[] args) {
        INotesActions noteBook = new NotesActions();
        //DbConnector newConnection = new DbConnector();
        //newConnection.connect();
       String p =  noteBook.deleteNote("vs0NY");
        System.out.println(p);
//        try {
//            if (args[0].equals("start")) {
//                System.out.println("Это программа для создания заметок-напоминалок" +
//                        "\n" + "для взаимодействия с заметками можно выполнить следующие команды:" +
//                        "\n" + "Для просмотра заметки: find <<ID заметки>" +
//                        "\n" + "Для создания заметки: add <текст заметки> <приоритет заметки: 1,2,3>" +
//                        "\n" + "Для удаления заметки: delete <ID заметки>" +
//                        "\n" + "Для изменения существующей заметки: change <ID заметки> <параметр text/priority>" +
//                        "\n" + "Для просмотра всех заметок: view_all" +
//                        "\n" + "Для просмота меню команд: start");
//            }
//            if (args[0].equals("add")) {
//                String newNote = noteBook.addNote(args[1], Integer.parseInt(args[2]));
//                System.out.println("заметка создана! ее ID:  " + newNote);
//            }
//            if (args[0].equals("find")) {
//                String result =noteBook.findNote(args[1]);
//                if (result.isEmpty()){
//                    System.out.println("заметка не найдена!");
//                }
//                if (!result.isEmpty()) {
//                    System.out.println("заметка найдена!\n"+result);
//                }
//            }
//
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("введены ошибочные данные.вызвана некорректная команда");
//        }
//        System.out.println(noteBook.findNote("x4fts"));
    }
}