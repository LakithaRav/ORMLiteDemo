package ormlite.demo.olc.com.ormlitedemo.db;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.j256.ormlite.dao.Dao;

import ormlite.demo.olc.com.ormlitedemo.model.WishItem;
import ormlite.demo.olc.com.ormlitedemo.model.WishList;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	// name of the database file for your application -- change to something appropriate for your app
	private static final String DATABASE_NAME = "WishListDB.sqlite";

	// any time you make changes to your database objects, you may have to increase the database version
	private static final int DATABASE_VERSION = 1;

	// the DAO object we use to access the SimpleData table
    //pressure
	private Dao<WishItem, Integer> wishItemDao = null;
	private Dao<WishList, Integer> wishListDao = null;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database,ConnectionSource connectionSource) {
		try {
			
			TableUtils.createTable(connectionSource, WishItem.class);
			TableUtils.createTable(connectionSource, WishList.class);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db,ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			List<String> allSql = new ArrayList<String>(); 
			switch(oldVersion) 
			{
			  case 1: 
				  //allSql.add("alter table AdData add column `new_col` VARCHAR");
				  //allSql.add("alter table AdData add column `new_col2` VARCHAR");
			}
			for (String sql : allSql) {
				db.execSQL(sql);
			}
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade", e);
			throw new RuntimeException(e);
		}
		
	}

	public Dao<WishItem, Integer> getWishItemDao() {
		if (null == wishItemDao) {
			try {
				wishItemDao = getDao(WishItem.class);
			}catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return wishItemDao;
	}
	
	public Dao<WishList, Integer> getWishListDao() {
		if (null == wishListDao) {
			try {
				wishListDao = getDao(WishList.class);
			}catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return wishListDao;
	}

}
