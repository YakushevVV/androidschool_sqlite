package ru.androidschool.sqliteexample.presentation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import ru.androidschool.sqliteexample.data.converter.BookConverter;
import ru.androidschool.sqliteexample.data.db.BookDatabase;
import ru.androidschool.sqliteexample.data.db.BooksDbCallback;
import ru.androidschool.sqliteexample.data.entity.BooksDbContract;
import ru.androidschool.sqliteexample.data.repository.BooksRepositoryImpl;
import ru.androidschool.sqliteexample.domain.BooksInteractor;

class BooksViewModelFactory implements ViewModelProvider.Factory {

    private final Context mAppContext;

    public BooksViewModelFactory(@NonNull Context context) {
        mAppContext = context.getApplicationContext();
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        BookDatabase bookDatabase = Room.databaseBuilder(mAppContext, BookDatabase.class, BooksDbContract.DB_FILE_NAME)
                .fallbackToDestructiveMigration()
                .addCallback(new BooksDbCallback())
                .build();
        return (T) new MainViewModel(
                new BooksInteractor(
                        new BooksRepositoryImpl(
                                bookDatabase.getBookDao(),
                                new BookConverter())));
    }

}
