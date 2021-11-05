package ru.androidschool.sqliteexample.data.repository;

import androidx.annotation.NonNull;

import java.util.List;

import ru.androidschool.sqliteexample.data.db.BookDao;
import ru.androidschool.sqliteexample.data.entity.BooksWithAuthors;
import ru.androidschool.sqliteexample.data.entity.converter.EntityConverter;
import ru.androidschool.sqliteexample.domain.BooksRepository;
import ru.androidschool.sqliteexample.domain.model.Book;

public class RoomBooksRepository implements BooksRepository {

    @NonNull
    private final BookDao mBookDao;
    @NonNull
    private final EntityConverter<BooksWithAuthors, Book> mConverter;

    public RoomBooksRepository(@NonNull BookDao bookDao,
                               @NonNull EntityConverter<BooksWithAuthors, Book> converter) {
        mBookDao = bookDao;
        mConverter = converter;
    }

    @Override
    public List<Book> books() {
        return mConverter.convert(mBookDao.books());
    }
}
