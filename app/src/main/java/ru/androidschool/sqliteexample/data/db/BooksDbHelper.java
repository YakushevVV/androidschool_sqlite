package ru.androidschool.sqliteexample.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import ru.androidschool.sqliteexample.data.entity.BooksDbContract;
import ru.androidschool.sqliteexample.data.entity.BooksDbContract.BooksEntry;

public class BooksDbHelper extends SQLiteOpenHelper {

    private static final String CREATE_TABLE_BOOKS = "CREATE TABLE IF NOT EXISTS " + BooksEntry.TABLE_NAME +
            "(" +
            BooksEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            BooksEntry.ISBN + " TEXT NOT NULL UNIQUE ON CONFLICT FAIL," +
            BooksEntry.TITLE + " TEXT," +
            BooksEntry.AUTHOR + " TEXT," +
            BooksEntry.SHELF_NUMBER + " INTEGER DEFAULT 1" +
            ")";

    private static final String DROP_TABLE_BOOKS = "DROP TABLE IF EXISTS " + BooksEntry.TABLE_NAME;

    static final String INIT_TABLE_BOOKS = "INSERT INTO " + BooksEntry.TABLE_NAME +
            "(" + BooksEntry.ISBN + ", " + BooksEntry.TITLE + ", " + BooksEntry.AUTHOR + ", " + BooksEntry.SHELF_NUMBER + ") " +
            "VALUES " +
            "(\"978-1260440225\", \"Java: A Beginner's Guide\", \"Herbert Schildt\", 1), " +
            "(\"978-0134685991\", \"Effective Java\", \"Joshua Bloch\", 1), " +
            "(\"978-0132350884\", \"Clean Code\", \"Robert C. Martin\", 2), " +
            "(\"978-1590596739\", \"The Definitive Guide to SQLite\", \"Mike Owens\", 3), " +
            "(\"978-0321349606\", \"Java Concurrency in Practice\", \"Brian Goetz\", 1)";

    public BooksDbHelper(@Nullable Context context) {
        super(context, BooksDbContract.DB_FILE_NAME, null, BooksDbContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BOOKS);
        db.execSQL(INIT_TABLE_BOOKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_BOOKS);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
