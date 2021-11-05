package ru.androidschool.sqliteexample.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import ru.androidschool.sqliteexample.data.entity.BooksDbContract.AuthorEntry;

@Entity(tableName = AuthorEntry.TABLE_NAME)
public class AuthorsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = AuthorEntry._ID)
    public Long _id;
    @ColumnInfo(name = AuthorEntry.NAME)
    public String name;
    @ColumnInfo(name = AuthorEntry.URL)
    public String url;
    @ColumnInfo(name = AuthorEntry.BOOK_ID)
    public long bookId;

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
