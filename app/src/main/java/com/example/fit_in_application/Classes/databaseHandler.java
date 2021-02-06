package com.example.fit_in_application.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class databaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Foodmanager";

    // Food table name
    private static final String TABLE_FOOD = "Food";
    private static databaseHandler dbhelper;

    // Food Table Columns names
    private static final String KEY_ID= "id";
    private static final String FOOD_CATEGORY = "Food_category";
    private static final String FOOD_ITEM = "Food_item";
    private static final String  PROTEINS = "Proteins";
    private static final String  FAT = "Fats";
    private static final String  CARB = "Carbon";
    private static final String  CALORIES = "Calories";

    public static synchronized databaseHandler getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.

        if (dbhelper == null) {
            dbhelper = new databaseHandler(context.getApplicationContext());
        }
        return dbhelper;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FOOD_TABLE = "CREATE TABLE " + TABLE_FOOD + " (id INTEGER PRIMARY KEY AUTOINCREMENT,Food_category TEXT,Food_item TEXT,Proteins REAL,Fat REAL,carb REAL,calories REAL)";
        db.execSQL(CREATE_FOOD_TABLE);

        addfood(new food_items_model("Dairy and Egg Products", "Boiled Egg (1 piece)", 5.51f, 4.65f, 0.49f, 68f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Curd (1 mk)", 7.88f, 2.32f, 10.56f, 94f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Cutlets (1 piece)", 4.6f, 8.5f, 11.5f, 140f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg and Potato Curry (1 mk)", 7f, 15f, 3f, 200f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Burji (1 mk)", 9f, 12.5f, 7.5f, 195f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Cheese Toast (1 Slice)", 12f, 9f, 9f, 170f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Flip (1 glass)", 9.5f, 8.8f, 17.6f, 189f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Fried Rice (1 plate)", 4f, 3f, 28f, 161f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Masala (1 mk)", 13.4f, 15.2f, 6.6f, 216f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Molee (1 mk)", 16.35f, 0.26f, 1.1f, 78f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Omlette (100 g.)", 11f, 12f, 0.6f, 154f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Omlette Sandwich (1 plate)", 27f, 9.4f, 56.1f, 392.7f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg on Potatoes (1 mk)", 7f, 13f, 42f, 320f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg on Tomatoes (1 mk)", 21f, 7f, 9f, 320f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Pattice (1 piece)", 4f, 4f, 1f, 60f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Sandwich (1 plate)", 11f, 13f, 18f, 233f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Egg Stew (1 bowl)", 26f, 21f, 41f, 400f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Fried Egg (1 piece)", 14f, 15f, 0.8f, 196f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Sweet Omlette (1 piece)", 17.79f, 23.02f, 35.7f, 405f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Pan Rolls with Eggs (1 piece)", 3.32f, 2.24f, 18.2f, 107f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Plain Omlette (1 piece)", 11f, 7f, 0f, 160f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Poached Eggs (1 piece)", 5.51f, 4.36f, 0.34f, 64f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Scrambled Egg (1 piece)", 6.5f, 7.5f, 0.75f, 100f), db);
        addfood(new food_items_model("Dairy and Egg Products", "Orange Souffle (1 piece)", 2f, 10f, 3.2f, 110f), db);
    }

    public void addfood(food_items_model food_item) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(FOOD_CATEGORY, food_item.getfood_category());
            values.put(FOOD_ITEM, food_item.getfood_item());
            values.put(PROTEINS, food_item.getproteins());
            values.put(FAT, food_item.getfat());
            values.put(CARB, food_item.getcarb());
            values.put(CALORIES, food_item.getcalorie());

            db.insertOrThrow(TABLE_FOOD, null, values);
//            db.close(); // Closing database connection
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void addfood(food_items_model food_item, SQLiteDatabase db ) {
//        db=getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FOOD_CATEGORY, food_item.getfood_category());
        values.put(FOOD_ITEM, food_item.getfood_item());
        values.put(PROTEINS, food_item.getproteins());
        values.put(FAT, food_item.getfat());
        values.put(CARB, food_item.getcarb());
        values.put(CALORIES, food_item.getcalorie());

        db.insert(TABLE_FOOD, null, values);
    }

    public databaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        SQLiteDatabase db=this.getWritableDatabase();
    }

    // Getting single food item
    public food_items_model getfood_item(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FOOD, new String[] { KEY_ID, FOOD_CATEGORY,
                        FOOD_ITEM, PROTEINS, FAT, CARB, CALORIES }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        assert cursor != null;
        food_items_model food_item = new food_items_model(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),Float.parseFloat(cursor.getString(3)),
                Float.parseFloat(cursor.getString(4)),Float.parseFloat(cursor.getString(5)),Float.parseFloat(cursor.getString(6)));
        // return contact
        return food_item;
    }

    public List<String> getfood_category_list() {

        List<String> food_category_list=new ArrayList<>();
        food_category_list.add("Dairy and Egg Products");   //done//
        food_category_list.add("Spices and Herbs");//done//
        food_category_list.add("Fats and Oils");//done//
        food_category_list.add("Soups and Sauces");//done//
        food_category_list.add("Fruits");//done//
        food_category_list.add("Vegetables");//done//
        food_category_list.add("Nut and Seed Products");//done//
        food_category_list.add("Restaurant Foods");
        food_category_list.add("Baby Foods");//done//
        food_category_list.add("Beverages");//done//
        food_category_list.add("Legumes and Legume Products");
        food_category_list.add("Sausages and Luncheon Meats");
        food_category_list.add("Baked Products");
        food_category_list.add("Fast Food");//done//
        food_category_list.add("Poultry Products");
        food_category_list.add("Snacks");
        food_category_list.add("Sweets");//done//
        food_category_list.add("Cereals ,Grains and Pasta");

        return food_category_list;
    }


    public databaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<food_items_model> getAllfood_items(String food_category) {
        List<food_items_model> food_item_list = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOOD;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        while(cursor.moveToNext())
        {

            Log.i("Cursor row value",cursor.getPosition()+"");
            if(cursor.getString(cursor.getColumnIndex(FOOD_CATEGORY)).
                    equals(food_category))
            {

                while (cursor.getString(cursor.getColumnIndex(FOOD_CATEGORY)).
                        equals(food_category))
                {
                    food_items_model food_item = new food_items_model();
                    food_item.setfood_category(cursor.getString(cursor.getColumnIndex(FOOD_CATEGORY)));
                    food_item.setfood_item(cursor.getString(cursor.getColumnIndex(FOOD_ITEM)));
                    food_item.setproteins(Float.parseFloat(cursor.getString(cursor.getColumnIndex(PROTEINS))));
                    food_item.setfat(Float.parseFloat(cursor.getString(cursor.getColumnIndex(FAT))));
                    food_item.setcarb(Float.parseFloat(cursor.getString(cursor.getColumnIndex(CARB))));
                    food_item.setcalorie(Float.parseFloat(cursor.getString(cursor.getColumnIndex(CALORIES))));
                    food_item_list.add(food_item);
                    cursor.moveToNext();
                    if(cursor.getPosition()==cursor.getCount()) break;

                }
            }
            if(food_item_list.size()!=0) return food_item_list;
        }

        return food_item_list;
    }


    public List<food_items_model> getAllfooditems() {
        List<food_items_model> food_itemList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOOD;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                food_items_model food_item = new food_items_model();
                food_item.setfood_category(cursor.getString(cursor.getColumnIndex(FOOD_CATEGORY)));
                food_item.setfood_item(cursor.getString(cursor.getColumnIndex(FOOD_ITEM)));
                food_item.setproteins(Float.parseFloat(cursor.getString(cursor.getColumnIndex(PROTEINS))));
                food_item.setfat(Float.parseFloat(cursor.getString(cursor.getColumnIndex(FAT))));
                food_item.setcarb(Float.parseFloat(cursor.getString(cursor.getColumnIndex(CARB))));
                food_item.setcalorie(Float.parseFloat(cursor.getString(cursor.getColumnIndex(CALORIES))));
                // Adding contact to list
                food_itemList.add(food_item);
            } while (cursor.moveToNext());
        }

        // return contact list
        return food_itemList;
    }


    public String getFoodCategory(String FoodItem)
    {
        Cursor cursor=null;
        String food_Catg="";
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            cursor = db.rawQuery("SELECT Food_category FROM Food WHERE Food_item=?", new String[] {FoodItem + ""});
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                food_Catg = cursor.getString(cursor.getColumnIndex("Food_category"));
            }
            return food_Catg;
        }finally {
            cursor.close();
        }
    }

    public int getFoodItemId(String FoodItem)
    {
        Cursor cursor=null;
        int food_item_id=0;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            cursor = db.rawQuery("SELECT id FROM Food WHERE Food_item=?", new String[] {FoodItem + ""});
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                food_item_id = cursor.getInt(cursor.getColumnIndex("id"));
            }
            return food_item_id;
        }finally {
            cursor.close();
        }
    }



    // Updating single contact
    public int updatefood(food_items_model food_item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FOOD_CATEGORY, food_item.getfood_category());
        values.put(FOOD_ITEM, food_item.getfood_item());
        values.put(PROTEINS, food_item.getproteins());
        values.put(FAT, food_item.getfat());
        values.put(CARB, food_item.getcarb());
        values.put(CALORIES, food_item.getcalorie());

        // updating row
        return db.update(TABLE_FOOD, values, FOOD_CATEGORY + " = ?",
                new String[] { food_item.getfood_category() });
    }

    // Deleting single contact
    public void deletefood(food_items_model food_item) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FOOD, FOOD_CATEGORY + " = ?",
                new String[] { food_item.getfood_category() });
        db.close();
    }


    // Getting contacts Count
    public int getfoodCount() {
        String countQuery = "SELECT  * FROM " + TABLE_FOOD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
