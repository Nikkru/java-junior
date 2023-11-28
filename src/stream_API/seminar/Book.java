package stream_API.seminar;

public class Book {

    //region Getter
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
    //endregion

    @Override

    //region toString
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
    //endregion

    //region Конструктор
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    //endregion

    //region Поля
    /**
     * Название
     */
    private final String title;
    /**
     * Автор
     */
    private final String author;
    /**
     * издвание
     */
    private final int year;
    //endregion

}
