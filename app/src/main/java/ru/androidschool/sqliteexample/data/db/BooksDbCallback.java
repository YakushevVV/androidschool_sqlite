package ru.androidschool.sqliteexample.data.db;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import static ru.androidschool.sqliteexample.data.entity.BooksDbContract.BooksEntry.AUTHOR;
import static ru.androidschool.sqliteexample.data.entity.BooksDbContract.BooksEntry.ISBN;
import static ru.androidschool.sqliteexample.data.entity.BooksDbContract.BooksEntry.SHELF_NUMBER;
import static ru.androidschool.sqliteexample.data.entity.BooksDbContract.BooksEntry.TITLE;

public class BooksDbCallback extends RoomDatabase.Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);
        db.execSQL("INSERT INTO books (" + ISBN + ", " + TITLE + ", " + AUTHOR + ", " + SHELF_NUMBER + ") " +
                "VALUES " +
                "(\"978-1260440225\", \"Java: A Beginner's Guide\", \"Herbert Schildt\", 1)," +
                "(\"978-0134685991\", \"Effective Java\", \"Joshua Bloch\", 1)," +
                "(\"978-0132350884\", \"Clean Code\", \"Robert C. Martin\", 2)," +
                "(\"978-1590596739\", \"The Definitive Guide to SQLite\", \"Mike Owens\", 3)," +
                "(\"978-0321349606\", \"Java Concurrency in Practice\", \"Brian Goetz\", 1)");
    }
}
