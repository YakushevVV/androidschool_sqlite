package ru.androidschool.sqliteexample.data.repository;

import androidx.annotation.NonNull;

import java.util.List;

import ru.androidschool.sqliteexample.data.converter.BookConverter;
import ru.androidschool.sqliteexample.data.db.BookDao;
import ru.androidschool.sqliteexample.domain.BooksRepository;
import ru.androidschool.sqliteexample.domain.model.Book;

public class BooksRepositoryImpl implements BooksRepository {

    @NonNull
    private final BookDao mBookDao;
    @NonNull
    private final BookConverter mConverter;

    public BooksRepositoryImpl(@NonNull BookDao bookDao, @NonNull BookConverter converter) {
        mBookDao = bookDao;
        mConverter = converter;
    }

    @Override
    public List<Book> books() {
        return mConverter.reverse(mBookDao.books());
    }
}
