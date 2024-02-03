package ha.tw.masbaha;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper2 extends SQLiteOpenHelper {
    public DBHelper2(Context context) {super(context, "Userdata2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(ID TEXT , size TEXT, trans TEXT, type TEXT, color TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(String ID, String size, String trans, String type,String color)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", ID);
        contentValues.put("size", size);
        contentValues.put("trans", trans);
        contentValues.put("type", type);
        contentValues.put("color", color);
        long result=DB.insert("Userdetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public Boolean updateuserdata(String ID, String size, String trans, String type,String color) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("size", size);
        contentValues.put("trans", trans);
        contentValues.put("type", type);
        contentValues.put("color", color);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where ID = ?", new String[]{ID});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "ID=?", new String[]{ID});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}


    public Boolean deletedata (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
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