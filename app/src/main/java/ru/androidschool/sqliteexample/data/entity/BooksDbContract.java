package ru.androidschool.sqliteexample.data.entity;

import android.provider.BaseColumns;

public interface BooksDbContract {

    String DB_FILE_NAME = "books.db";
    int DB_VERSION = 1;

    interface BooksEntry extends BaseColumns {
        String TABLE_NAME = "books";
        String ISBN = "isbn";
        String TITLE = "title";
        String AUTHOR = "author";
        String SHELF_NUMBER = "shelf_number";
    }
}
