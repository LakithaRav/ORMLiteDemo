package ormlite.demo.olc.com.ormlitedemo.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class WishList {

	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField
	private String name;
	
	@ForeignCollectionField
	private ForeignCollection<WishItem> items;

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

	public ForeignCollection<WishItem> getItems() {
		return items;
	}

	public void setItems(ForeignCollection<WishItem> items) {
		this.items = items;
	}
	
	
}
