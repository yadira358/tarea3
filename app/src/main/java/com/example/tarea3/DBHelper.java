package com.example.tarea3;

public class DBHelper

{

    import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

    public class DBHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "personas.db";
        private static final int DATABASE_VERSION = 1;

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE personas (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombres TEXT, " +
                    "apellidos TEXT, " +
                    "edad INTEGER, " +
                    "correo TEXT, " +
                    "direccion TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS personas");
            onCreate(db);
        }

        public void insertarPersona(String nombres, String apellidos, int edad, String correo, String direccion) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombres", nombres);
            values.put("apellidos", apellidos);
            values.put("edad", edad);
            values.put("correo", correo);
            values.put("direccion", direccion);
            db.insert("personas", null, values);
            db.close();
        }
    }

}
