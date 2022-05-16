package edu.oru.cit352.oluaki870.mytriviaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    // Declare Variables
    private Context context;
    private static final String DATABASE_NAME = "HighScores.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_highscore";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USER = "user_name";
    private static final String COLUMN_HTML = "html_highscore";
    private static final String COLUMN_CSS = "css_highscore";
    private static final String COLUMN_JS = "js_highscore";
    private static final String COLUMN_WD = "wd_highscore";

    // Setup Database
    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    // Create Table in database and define its columns
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_USER + " TEXT, " +
                        COLUMN_HTML + " DOUBLE, " +
                        COLUMN_CSS + " DOUBLE, " +
                        COLUMN_JS + " DOUBLE, " +
                        COLUMN_WD + " DOUBLE)";
        db.execSQL(query);
    }

    @Override
    //On upgrade drop the table and recreate it
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //When a username is added to the database
    void addUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Check if the user exists in the table
        String query = "SELECT * FROM "+ TABLE_NAME +" WHERE user_name = \""+ username + "\"";
        Cursor cursor = db.rawQuery(query,null);

        // If count is <= 0 then username does not exist
        if(cursor.getCount() <= 0){
                cursor.close();
                cv.put(COLUMN_USER, username);
                long result = db.insert(TABLE_NAME, null, cv);
                if (result == -1){
                    //Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show();
                } else{
                    //Toast.makeText(context,"Added Successfully!", Toast.LENGTH_SHORT).show();
                }
        // Otherwise it does and we don't add the user, prevent duplicates
        }else{
                //Toast.makeText(context, " Data Already Exists", Toast.LENGTH_LONG).show();
            }


    }

    //When a html score is added to the database
    void addHTMLHighscore(String user_name, double hs) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_HTML, hs);
        //Since the table at first declares all the highscores as null we update the column at the current username
        //that the app sees
        long result = db.update(TABLE_NAME, cv, "user_name="+ "\'"+user_name+"\'",null);
        if(result == -1){
            //Toast.makeText(context,"Failed to update", Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(context,"Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    //When a css score is added to the database
    void addCSSHighscore(String user_name, double hs) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(COLUMN_CSS, hs);
        //Since the table at first declares all the highscores as null we update the column at the current username
        //that the app sees
        long result = db.update(TABLE_NAME, cv, "user_name="+ "\'"+user_name+"\'",null);
        if(result == -1){
            //Toast.makeText(context,"Failed to update", Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(context,"Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    //When a JS score is added to the database
    void addJSHighscore(String user_name, double hs) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_JS, hs);

        //Since the table at first declares all the highscores as null we update the column at the current username
        //that the app sees
        long result = db.update(TABLE_NAME, cv, "user_name=" + "\'"+user_name+"\'",null);
        if(result == -1){
            //Toast.makeText(context,"Failed to update", Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(context,"Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    //When a WD score is added to the database
    void addWDHighscore(String user_name, double hs) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_WD, hs);

        //Since the table at first declares all the highscores as null we update the column at the current username
        //that the app sees
        long result = db.update(TABLE_NAME, cv, "user_name="+ "\'"+user_name+"\'",null);
        if(result == -1){
            //Toast.makeText(context,"Failed to update", Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(context,"Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    // Reads the user data from the database of the current user to be outputed in the highscore recycler view
    Cursor readAllData(String username) {
        String query = "SELECT user_name, html_highscore, css_highscore, js_highscore, wd_highscore  FROM " + TABLE_NAME + " WHERE user_name = \"" + username + "\"";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        //checks if database is empty
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
