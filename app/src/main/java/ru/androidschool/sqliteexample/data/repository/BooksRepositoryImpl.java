package ru.androidschool.sqliteexample.data.repository;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import ru.androidschool.sqliteexample.data.entity.BooksDbContract.BooksEntry;
import ru.androidschool.sqliteexample.domain.BooksRepository;
import ru.androidschool.sqliteexample.domain.model.Book;

public class BooksRepositoryImpl implements BooksRepository {

    @NonNull
    private final SQLiteOpenHelper mBooksDbHelper;

    public BooksRepositoryImpl(@NonNull SQLiteOpenHelper booksDbHelper) {
        mBooksDbHelper = booksDbHelper;
    }

    @Override
    public List<Book> books() {
        String[] columns = {BooksEntry._ID, BooksEntry.ISBN, BooksEntry.TITLE, BooksEntry.AUTHOR, BooksEntry.SHELF_NUMBER};
        SQLiteDatabase db = mBooksDbHelper.getReadableDatabase();
        List<Book> result = new ArrayList<>();
        try (Cursor cursor = db.query(
                BooksEntry.TABLE_NAME, columns, null, null, null, null, BooksEntry.TITLE, null)) {
            while (cursor.moveToNext()) {
                result.add(new Book(
                        cursor.getInt(cursor.getColumnIndex(BooksEntry._ID)),
                        cursor.getString(cursor.getColumnIndex(BooksEntry.ISBN)),
                        cursor.getString(cursor.getColumnIndex(BooksEntry.TITLE)),
                        cursor.getString(cursor.getColumnIndex(BooksEntry.AUTHOR)),
                        cursor.getInt(cursor.getColumnIndex(BooksEntry.SHELF_NUMBER))));
            }
        }
        return result;
    }
}
