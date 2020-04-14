package com.challenge.lanchonete.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class LanchoneteSQLiteOpenHelper(context: Context, name: String?, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {

    object IngredientTable {
        const val TABLE_NAME = "ingredient"

        const val COLUMN_INGREDIENT_ID = "ingredient_id"
        const val COLUMN_INGREDIENT_NAME = "ingredient_name"
        const val COLUMN_INGREDIENT_VALUE = "ingredient_value"

        const val CREATE =
            "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_INGREDIENT_ID INTEGER PRIMARY KEY," +
                "$COLUMN_INGREDIENT_NAME TEXT," +
                "$COLUMN_INGREDIENT_VALUE INTEGER NOT NULL)"

        const val DROP = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    object LancheTable {
        const val TABLE_NAME = "lanche"

        const val COLUMN_LANCHE_ID = "lanche_id"
        const val COLUMN_LANCHE_NAME = "lanche_name"
        const val COLUMN_LANCHE_PRICE = "lanche_price"

        const val CREATE =
            "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_LANCHE_ID INTEGER PRIMARY KEY," +
                "$COLUMN_LANCHE_NAME TEXT," +
                "$COLUMN_LANCHE_PRICE INTEGER NOT NULL)"

        const val DROP = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    object LancheIngredientTable {
        const val TABLE_NAME = "lanche_ingredient"

        const val COLUMN_LANCHE_INGREDIENT_ID = "id"
        const val COLUMN_LANCHE_ID = "lanche_id"
        const val COLUMN_INGREDIENT_ID = "ingredient_id"

        const val CREATE =
            "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_LANCHE_INGREDIENT_ID INTEGER PRIMARY KEY," +
                "$COLUMN_LANCHE_ID INTEGER," +
                "$COLUMN_INGREDIENT_ID INTEGER)"

        const val DROP = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(IngredientTable.CREATE)
        db?.execSQL(LancheTable.CREATE)
        db?.execSQL(LancheIngredientTable.CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(IngredientTable.DROP)
        db?.execSQL(LancheTable.DROP)
        db?.execSQL(LancheIngredientTable.DROP)

        onCreate(db)
    }
}
