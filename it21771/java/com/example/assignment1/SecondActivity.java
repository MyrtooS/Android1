package com.example.assignment1;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Bundle bundle = getIntent().getExtras();
        String resultName = bundle.getString("searchName");


        DBOpenHelper helper = new DBOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();


        Cursor cursor = db.query(DBOpenHelper.TABLE_NAME,null,
                DBOpenHelper.KEY_F_NAME + "=?"
                , new String[]{resultName}, null, null, null);


        TableLayout table = findViewById(R.id.myTableLayout);

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(0);
                String fname = cursor.getString(1);
                String lname = cursor.getString(2);
                String age = cursor.getString(3);


                TableRow tableRow = new TableRow(this);
                tableRow.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


                TextView textviewID  = new TextView(this);
                textviewID.setText(id);
                tableRow.addView(textviewID);

                TextView textviewFName  = new TextView(this);
                textviewFName.setText(fname);
                tableRow.addView(textviewFName);

                TextView textviewLName = new TextView(this);
                textviewLName.setText(lname);
                tableRow.addView(textviewLName);

                TextView textviewAge = new TextView(this);
                textviewAge.setText(age);
                tableRow.addView(textviewAge);

                table.addView(tableRow);
            } while(cursor.moveToNext());
        }
        if(cursor.moveToFirst() == false){
            Toast.makeText(getApplicationContext(),"There is no such name",Toast.LENGTH_SHORT).show();
        }


    }

}
