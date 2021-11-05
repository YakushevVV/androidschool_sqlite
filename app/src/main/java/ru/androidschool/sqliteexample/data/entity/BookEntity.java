package ru.androidschool.sqliteexample.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import ru.androidschool.sqliteexample.data.entity.BooksDbContract.BooksEntry;

@Entity(
        tableName = BooksEntry.TABLE_NAME,
        indices = {
                @Index(value = {BooksEntry.ISBN}, unique = true, name = "isbn")
        }
)
public class BookEntity {
    @PrimaryKey(autoGenerate = true)
    public Long _id;
    @ColumnInfo(index = true)
    public String isbn;
    public String title;
    public String author;
    @ColumnInfo(name = BooksEntry.SHELF_NUMBER)
    public int shelfNumber;
}
