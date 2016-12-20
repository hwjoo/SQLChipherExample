package com.muhanbit.sqlchipherexample;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        SQLiteDatabase.loadLibs(this);
        insertSthToDb();
        textView.setText("ButterKnife success");
    }

    private void insertSthToDb() {
        SQLiteDatabase db =
                FeedReaderDbHelper.getInstance(this).getWritableDatabase("muhan!@34");

        ContentValues values= new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID, 1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "Easter Bunny has escaped!");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "A thrilling story which proves how fragile out hearts are...");

        long check = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
        if(check >0){
            Cursor cursor = db.rawQuery("SELECT * FROM '"+
                    FeedReaderContract.FeedEntry.TABLE_NAME +"';", null);
            Log.d("TEST", "Rows count: " + cursor.getCount());
            cursor.close();
            db.close();
        }else{
            Toast.makeText(MainActivity.this, " fail ",Toast.LENGTH_SHORT).show();
        }


    }
}
