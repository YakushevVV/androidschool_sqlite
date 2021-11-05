package ru.androidschool.sqliteexample.presentation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import ru.androidschool.sqliteexample.data.db.BooksCallback;
import ru.androidschool.sqliteexample.data.db.BooksDatabase;
import ru.androidschool.sqliteexample.data.db.migration.EmptyMigration;
import ru.androidschool.sqliteexample.data.db.migration.Migration2to3;
import ru.androidschool.sqliteexample.data.entity.BooksDbContract;
import ru.androidschool.sqliteexample.data.entity.converter.BooksEntityConverter;
import ru.androidschool.sqliteexample.data.repository.RoomBooksRepository;
import ru.androidschool.sqliteexample.domain.BooksInteractor;

class BooksViewModelFactory implements ViewModelProvider.Factory {

    private final BooksDatabase mBooksDatabase;

    public BooksViewModelFactory(@NonNull Context context) {
        mBooksDatabase = Room.databaseBuilder(context.getApplicationContext(), BooksDatabase.class, BooksDbContract.DB_FILE_NAME)
                .addCallback(new BooksCallback())
                .addMigrations(new EmptyMigration())
                .addMigrations(new Migration2to3())
                .build();
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new MainViewModel(
                new BooksInteractor(
                        new RoomBooksRepository(mBooksDatabase.booksDao(), new BooksEntityConverter())));
    }
}
