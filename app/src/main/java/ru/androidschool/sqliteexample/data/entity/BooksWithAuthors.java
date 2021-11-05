package ru.androidschool.sqliteexample.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class BooksWithAuthors {
    @Embedded
    public BookEntity mBookEntity;
    @Relation(
            parentColumn = BooksDbContract.BooksEntry._ID,
            entityColumn = BooksDbContract.AuthorEntry.BOOK_ID
    )
    public List<AuthorsEntity> mAuthorsEntities;
}
