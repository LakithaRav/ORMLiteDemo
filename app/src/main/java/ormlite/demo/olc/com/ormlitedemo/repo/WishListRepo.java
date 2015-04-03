package ormlite.demo.olc.com.ormlitedemo.repo;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import ormlite.demo.olc.com.ormlitedemo.db.DatabaseHelper;
import ormlite.demo.olc.com.ormlitedemo.db.DatabaseManager;
import ormlite.demo.olc.com.ormlitedemo.model.WishList;

public class WishListRepo implements Crud {

	private DatabaseHelper helper;

	public WishListRepo(Context context) {
		DatabaseManager.init(context);
		helper = DatabaseManager.getInstance().getHelper();
	}

	@Override
	public int create(Object item) {
		
		int index = -1;
		
		WishList object = (WishList) item;
		try {
			index = helper.getWishListDao().create(object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return index;
	}

	@Override
	public int update(Object item) {
		
		int index = -1;
		
		WishList object = (WishList) item;
		
		try {
			helper.getWishListDao().update(object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return index;
	}

	@Override
	public int delete(Object item) {
		
		int index = -1;
		
		WishList object = (WishList) item;
		
		try {
			helper.getWishListDao().delete(object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return index;
		
	}

	@Override
	public Object findById(int id) {
		
		WishList wishList = null;
		try {
			wishList = helper.getWishListDao().queryForId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wishList;
		
	}

	@Override
	public List<?> findAll() {
		
		List<WishList> items = null;
		
		try {
			items =  helper.getWishListDao().queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

        helper.getWishListDao().queryRaw("");
		
		return items;
	}
	
}
