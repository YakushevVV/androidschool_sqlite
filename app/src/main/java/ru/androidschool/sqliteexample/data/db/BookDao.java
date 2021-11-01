package ru.androidschool.sqliteexample.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.androidschool.sqliteexample.data.entity.BookEntity;

import static ru.androidschool.sqliteexample.data.entity.BooksDbContract.BooksEntry.TABLE_NAME;

@Dao
public interface BookDao {

    @Insert
    void addBooks(List<BookEntity> entity);

    @Update
    void updateBook(BookEntity item);

    @Query("SELECT * FROM " + TABLE_NAME)
    List<BookEntity> books();

}
