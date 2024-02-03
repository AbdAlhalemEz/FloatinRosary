package ha.tw.masbaha;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper1 extends SQLiteOpenHelper {
    public DBHelper1(Context context) {
        super(context, "Userdata1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(name INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");

        onCreate(DB);
    }




    public Boolean insertuserdata(Integer name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);


        long result=DB.insert("Userdetails", null, contentValues);



        if(result==-1){
            return false;
        }else{
            return true;
        }
    }




























    public Boolean updateuserdata(Integer name, Integer contact) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{String.valueOf(name)});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{String.valueOf(name)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}




 public Boolean deletedata (Integer name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{String.valueOf(name)});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "name=?", new String[]{String.valueOf(name)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);

        return cursor;

    }




}
