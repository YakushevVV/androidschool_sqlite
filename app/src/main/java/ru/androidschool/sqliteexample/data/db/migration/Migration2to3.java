package ru.androidschool.sqliteexample.data.db.migration;

import android.content.ContentValues;
import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.room.OnConflictStrategy;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ru.androidschool.sqliteexample.data.entity.BooksDbContract.AuthorEntry;
import ru.androidschool.sqliteexample.data.entity.BooksDbContract.BooksEntry;

public class Migration2to3 extends Migration {

    public Migration2to3() {
        super(2, 3);
    }

    @Override
    public void migrate(@NonNull SupportSQLiteDatabase database) {

        try {
            database.beginTransaction();

            database.execSQL(
                    "CREATE TABLE IF NOT EXISTS " + AuthorEntry.TABLE_NAME + " (" +
                            AuthorEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            AuthorEntry.NAME + " TEXT, `url` TEXT, " +
                            AuthorEntry.BOOK_ID + " INTEGER NOT NULL)");

            try (Cursor cursor = database.query("SELECT * FROM " + BooksEntry.TABLE_NAME)) {
                while (cursor.moveToNext()) {
                    long bookId = cursor.getLong(cursor.getColumnIndex(BooksEntry._ID));
                    String[] authorsList = cursor.getString(cursor.getColumnIndex(BooksEntry.AUTHOR)).split(",");
                    for (String item : authorsList) {
                        ContentValues values = new ContentValues();
                        values.put(AuthorEntry.BOOK_ID, bookId);
                        values.put(AuthorEntry.NAME, item.trim());
                        database.insert(AuthorEntry.TABLE_NAME, OnConflictStrategy.IGNORE, values);
                    }
                }
            }

            database.setTransactionSuccessful();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            database.endTransaction();
        }
    }
}
