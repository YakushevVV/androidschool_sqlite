package ru.androidschool.sqliteexample.data.entity;

import android.provider.BaseColumns;

public interface BooksDbContract {

    String DB_FILE_NAME = "books.db";
    int DB_VERSION = 3;

    interface BooksEntry extends BaseColumns {
        String TABLE_NAME = "books";
        String ISBN = "isbn";
        String TITLE = "title";
        String AUTHOR = "author";
        String SHELF_NUMBER = "shelf_number";
    }

    interface AuthorEntry extends BaseColumns {
        String TABLE_NAME = "author";
        String NAME = "name";
        String URL = "url";
        String BOOK_ID = "book_id";
    }
}
