package ru.androidschool.sqliteexample.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import ru.androidschool.sqliteexample.data.entity.BooksDbContract.BooksEntry;

@Entity(
        tableName = BooksEntry.TABLE_NAME,
        indices = {
                @Index(value = {BooksEntry.ISBN}, name = "isbn", unique = true)
        })
public class BookEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BooksEntry._ID)
    public Long id;
    @ColumnInfo(name = BooksEntry.ISBN, index = true)
    public String isbn;
    @ColumnInfo(name = BooksEntry.TITLE)
    public String title;
    @ColumnInfo(name = BooksEntry.AUTHOR)
    public String author;
    @ColumnInfo(name = BooksEntry.SHELF_NUMBER)
    public int shelfNumber;

}
