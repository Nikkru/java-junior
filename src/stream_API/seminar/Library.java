package stream_API.seminar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Идиот", "Достоевский", 1971),
                new Book("В степи", "Чехов",  1997),
                new Book("Гроза", "Гончаров", 2001),
                new Book("Дуэль", "Паустовкий", 2001));

        List<Book> authorBooks = books.stream()
                .filter(book -> "Чехов".equals(book.getAuthor()))
                .toList();
        System.out.println("Чехов: " + authorBooks);

        List<Book> dateBooks = books.stream()
                .filter(book -> book.getYear() > 1998)
                .toList();
        System.out.println("Книги после 1998 года: " + dateBooks);

        List<String> uniqueTitleBooks = books.stream()
                .map(Book::getTitle).distinct().toList();
        System.out.println("Названия книг: " + uniqueTitleBooks);
    }

}
