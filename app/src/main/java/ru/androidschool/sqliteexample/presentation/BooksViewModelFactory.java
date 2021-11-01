package ru.androidschool.sqliteexample.presentation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.androidschool.sqliteexample.data.db.BooksDbHelper;
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
        BooksDbHelper booksDbHelper = new BooksDbHelper(mAppContext);
        return (T) new MainViewModel(new BooksInteractor(new BooksRepositoryImpl(booksDbHelper)));
    }
}
