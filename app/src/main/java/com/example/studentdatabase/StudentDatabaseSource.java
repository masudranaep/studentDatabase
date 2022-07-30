package com.example.studentdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class StudentDatabaseSource {
    StudentDatabaseHelper studentDatabaseHelper;
    StudentModel studentModel;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public StudentDatabaseSource(Context context){

        studentDatabaseHelper = new StudentDatabaseHelper (context);

    }
    public void open(){
        sqLiteDatabase = studentDatabaseHelper.getWritableDatabase ();
    }
    public void close(){
        studentDatabaseHelper.close ();
    }
    public boolean AddStudent(StudentModel studentModel){
         this.open ();

        ContentValues contentValues = new ContentValues ();
        contentValues.put (StudentDatabaseHelper.COL_NAME, studentModel.getName ());
        contentValues.put (StudentDatabaseHelper.COL_AGE, studentModel.getAge ());
        contentValues.put (StudentDatabaseHelper.COL_ADDRESS, studentModel.getAddress ());
        long insertRow = sqLiteDatabase.insert (StudentDatabaseHelper.STUDENT_TABLE, null, contentValues);
        this.close ();
        if(insertRow > 0){
            return true;
        }else
            return false;
    }
    //table show coding
    public ArrayList<StudentModel> getAllStudent() {
        ArrayList<StudentModel> arrayList = new ArrayList<> ();
        // select from the student_table
        Cursor cursor = sqLiteDatabase.query (StudentDatabaseHelper.STUDENT_TABLE, null, null, null, null, null, null, null);


        if (cursor.moveToFirst ()) {
            do {
                String name = cursor.getString (cursor.getColumnIndex (StudentDatabaseHelper.COL_NAME));
                String age = cursor.getString (cursor.getColumnIndex (StudentDatabaseHelper.COL_AGE));
                String address = cursor.getString (cursor.getColumnIndex (StudentDatabaseHelper.COL_ADDRESS));

                StudentModel studentModel = new StudentModel (name, age, address);
                arrayList.add (studentModel);

            } while (cursor.moveToNext ());

        }
        this.close ();
        cursor.close ();
        return arrayList;

    }
    }


