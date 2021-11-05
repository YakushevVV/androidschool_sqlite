package ru.androidschool.sqliteexample.data.db.migration;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ru.androidschool.sqliteexample.data.entity.BooksDbContract;

public class EmptyMigration extends Migration {

    /**
     * Creates a new migration between {@code startVersion} and {@code endVersion}.
     */
    public EmptyMigration() {
        super(1, BooksDbContract.DB_VERSION);
    }

    @Override
    public void migrate(@NonNull SupportSQLiteDatabase database) {

    }
}
