package NoteBody;

import Instuments.*;


// todo надо разобраться с модификаторами доступа: чтобы нельзя было тут ничего править - все через интерфейс
public class NoteObject extends Priority {
    private String NoteId;
    private String NoteText;
    private Priority.NotePriority priority;
//  конструктор
    public NoteObject(String text, int prior){
        this.NoteId =RandomIntGenerator.intID(); // сразу задали айдишник
        this.NoteText =text;
        setPriority(prior);
//        NotePriority priority =pior; // сразу задали  приоритет заметки
    }

    //сеттер приоритета
    public void setPriority(int priority) {
        if (0<priority && priority<4) {
            switch (priority){
                case 1:
                    this.priority = Priority.NotePriority.HIGH;
                    break;
                case 2:
                    this.priority = Priority.NotePriority.MEDIUM;
                    break;
                case 3:
                    this.priority = Priority.NotePriority.LOW;
                    break;
            }
        }
        else {
            System.out.println("Note priority can be 1,2 or 3");
        }
    }
    // сетттер текста
    public void setNoteText(String noteText) {
        this.NoteText = noteText;
    }

    // геттер айди
    public String getNoteId() {
        return this.NoteId;
    }

    // геттер текста заметки
    public String getNoteText() {
        return this.NoteText;
    }
    // геттер приоритета
    public Priority.NotePriority getPriority() {
        return this.priority;
    }
}

