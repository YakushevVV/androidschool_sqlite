package ru.androidschool.sqliteexample.data.db;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class BooksCallback extends androidx.room.RoomDatabase.Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);
        db.execSQL(BooksDbHelper.INIT_TABLE_BOOKS);
    }
}
