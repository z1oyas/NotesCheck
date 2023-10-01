package templates;

public interface INotesActions {
    /**
     * добавление заметки, на выходе объект заметки, к которому можно обратиться по айдишнику (он выводится)
     */
    String  addNote(String text,int priority);

    /**
     * удаление заметки ( по айдишнику)
     */
    void deleteNote(String NoteId);

    /**
     * просмотр рейтинга заметки - не приоритет? еще одна градация?
     */
    String findNote(String NoteId);

    /**
     *  редактирование заметки -  можно и приоритет менять и текст
     */
    void changeNote(String NoteId);

}
