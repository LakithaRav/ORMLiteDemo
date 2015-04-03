package ormlite.demo.olc.com.ormlitedemo.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class WishItem {
	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField
	private String name;
	
	@DatabaseField(foreign=true,foreignAutoRefresh=true)
	private WishList list;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WishList getList() {
		return list;
	}

	public void setList(WishList list) {
		this.list = list;
	}
	
	
}
