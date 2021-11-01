package ru.androidschool.sqliteexample.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.androidschool.sqliteexample.data.entity.BookEntity;
import ru.androidschool.sqliteexample.data.entity.BooksDbContract;

@Database(
        entities = BookEntity.class,
        version = BooksDbContract.DB_VERSION
)
public abstract class BookDatabase extends RoomDatabase {

    public abstract BookDao getBookDao();
}
