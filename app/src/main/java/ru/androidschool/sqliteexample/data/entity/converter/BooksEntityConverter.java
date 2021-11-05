package ru.androidschool.sqliteexample.data.entity.converter;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import ru.androidschool.sqliteexample.data.entity.BooksWithAuthors;
import ru.androidschool.sqliteexample.domain.model.Book;

public class BooksEntityConverter implements EntityConverter<BooksWithAuthors, Book> {

    @Override
    @NonNull
    public List<Book> convert(@NonNull List<BooksWithAuthors> entities) {
        List<Book> result = new ArrayList<>();
        for (BooksWithAuthors entity : entities) {
            result.add(new Book(
                    entity.mBookEntity._id,
                    entity.mBookEntity.isbn,
                    entity.mBookEntity.title,
                    TextUtils.join(", ", entity.mAuthorsEntities),
                    entity.mBookEntity.shelfNumber));
        }
        return result;
    }
}
