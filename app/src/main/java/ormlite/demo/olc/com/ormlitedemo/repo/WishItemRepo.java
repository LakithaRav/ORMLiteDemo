package ormlite.demo.olc.com.ormlitedemo.repo;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import ormlite.demo.olc.com.ormlitedemo.db.DatabaseManager;
import ormlite.demo.olc.com.ormlitedemo.db.DatabaseHelper;
import ormlite.demo.olc.com.ormlitedemo.model.WishItem;

public class WishItemRepo implements Crud{
	
	private DatabaseHelper helper;
	
	public WishItemRepo(Context context)
	{
		DatabaseManager.init(context);
		helper = DatabaseManager.getInstance().getHelper();
	}

	@Override
	public int create(Object item) {
		
		int index = -1;
		
		WishItem object = (WishItem) item;
		try {
			index = helper.getWishItemDao().create(object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return index;

	}
	

	@Override
	public int update(Object item) {
		
		int index = -1;
		
		WishItem object = (WishItem) item;
		
		try {
			helper.getWishItemDao().update(object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return index;
	}



	@Override
	public int delete(Object item) {
		
		int index = -1;
		
		WishItem object = (WishItem) item;
		
		try {
			helper.getWishItemDao().delete(object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return index;
	}


	@Override
	public Object findById(int id) {
		
		WishItem wishList = null;
		try {
			wishList = helper.getWishItemDao().queryForId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wishList;
	}


	@Override
	public List<?> findAll() {
		
		List<WishItem> items = null;
		
		try {
			items =  helper.getWishItemDao().queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;
	}
	
}
