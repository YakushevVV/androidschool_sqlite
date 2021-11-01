package ru.androidschool.sqliteexample.data.converter;

import androidx.annotation.NonNull;

import java.util.List;

public interface Converter<T, R> {

    @NonNull
    List<R> convert(@NonNull List<T> item);

    @NonNull
    List<T> reverse(@NonNull List<R> item);
}
