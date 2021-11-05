package ru.androidschool.sqliteexample.data.entity.converter;

import androidx.annotation.NonNull;

import java.util.List;

public interface EntityConverter<T, U> {
    @NonNull
    List<U> convert(@NonNull List<T> entities);
}
