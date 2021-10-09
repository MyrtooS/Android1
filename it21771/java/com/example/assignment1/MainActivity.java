package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1 = findViewById(R.id.editText1);
        final EditText editText2 = findViewById(R.id.editText2);
        final EditText editText3 = findViewById(R.id.editText3);
        final EditText searchEditText = findViewById(R.id.SearchEditText);

        final DBOpenHelper insertHelper = new DBOpenHelper(this);

        Button InsertButton = findViewById(R.id.InsertButton);
        InsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = editText1.getText().toString();
                String lname = editText2.getText().toString();
                String age = editText3.getText().toString();

                if(fname.equals("") || lname.equals("") || age.equals("")){
                    Toast.makeText(getApplicationContext(),"Please fill all elements",Toast.LENGTH_SHORT).show();
                } else {

                    SQLiteDatabase db = insertHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(DBOpenHelper.KEY_F_NAME, fname);
                    values.put(DBOpenHelper.KEY_L_NAME, lname);
                    values.put(DBOpenHelper.KEY_AGE, age);
                    db.insert(DBOpenHelper.TABLE_NAME, null, values);
                    Toast.makeText(getApplicationContext(),"Row Inserted",Toast.LENGTH_SHORT).show();
                }

            }
        });


        Button SearchButton = findViewById(R.id.SearchButton);
        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchName = searchEditText.getText().toString();
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("searchName",searchName);
                if(searchName.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter a name",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    startActivity(i);
                }

            }
        });

    }

}
