package ru.androidschool.sqliteexample.data.converter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import ru.androidschool.sqliteexample.data.entity.BookEntity;
import ru.androidschool.sqliteexample.domain.model.Book;

public class BookConverter implements Converter<Book, BookEntity> {

    @NonNull
    @Override
    public List<BookEntity> convert(@NonNull List<Book> item) {
        final List<BookEntity> result = new ArrayList<>();
        for (Book book : item) {
            BookEntity bookEntity = new BookEntity();
            bookEntity.author = book.author;
            bookEntity.title = book.title;
            bookEntity.isbn = book.isbn;
            bookEntity.shelfNumber = book.shelfNumber;
            result.add(bookEntity);
        }
        return result;
    }

    @NonNull
    @Override
    public List<Book> reverse(@NonNull List<BookEntity> item) {
        final List<Book> result = new ArrayList<>();
        for (BookEntity book : item) {
            BookEntity bookEntity = new BookEntity();
            bookEntity.author = book.author;
            bookEntity.title = book.title;
            bookEntity.isbn = book.isbn;
            bookEntity.shelfNumber = book.shelfNumber;
            result.add(new Book(book.id, book.isbn, book.title, book.author, book.shelfNumber));
        }
        return result;
    }
}
