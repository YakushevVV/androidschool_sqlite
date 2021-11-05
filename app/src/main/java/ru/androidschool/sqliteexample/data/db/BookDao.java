package ru.androidschool.sqliteexample.data.db;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import ru.androidschool.sqliteexample.data.entity.BooksDbContract.BooksEntry;
import ru.androidschool.sqliteexample.data.entity.BooksWithAuthors;

@Dao
public interface BookDao {

    @Query("SELECT * FROM " + BooksEntry.TABLE_NAME)
    List<BooksWithAuthors> books();
}
