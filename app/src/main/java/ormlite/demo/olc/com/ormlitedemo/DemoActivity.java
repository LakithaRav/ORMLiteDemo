package ormlite.demo.olc.com.ormlitedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import ormlite.demo.olc.com.ormlitedemo.db.DatabaseManager;
import ormlite.demo.olc.com.ormlitedemo.repo.*;
import ormlite.demo.olc.com.ormlitedemo.model.*;
import java.util.List;
import com.j256.ormlite.dao.ForeignCollection;
import android.util.Log;

public class DemoActivity extends Activity {

    WishListRepo lrepo = null;
    WishItemRepo irepo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        this.initDB();
        this.addDummyItems();
        this.viewDummyData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Private Methods
     */

    //Database Init

    private void initDB()
    {
        DatabaseManager.init(this);
        lrepo = new WishListRepo(this);
        irepo = new WishItemRepo(this);
    }

    // Adding dummy items

    private void addDummyItems()
    {
        WishList list = new WishList();
        list.setName("Test List");
        list.setItems(null);

        int index = lrepo.create(list);

        if(index > -1)
        {
            Log.d("ORMLiteDemo", "WishList item created");

            List<WishList> lists = (List<WishList>) lrepo.findAll();

            WishList list1 = lists.get(0);

            WishItem item = new WishItem();
            item.setName("List Item" + Double.toString(Math.random()));
            item.setList(list1);

            int i = irepo.create(item);

            if(i > -1)
            {
                Log.d("ORMLiteDemo", "WishItem item created");
            }
        }
    }

    // Querying db items

    private void viewDummyData()
    {
        List<WishItem> items = (List<WishItem>) irepo.findAll();

        WishItem i1 = items.get(0);

        WishList theParent = i1.getList();

        ForeignCollection<WishItem> myitems = theParent.getItems();

        for(WishItem a : myitems)
        {
            Log.d("WishItem item name from parent", a.getName());
        }

        Log.d("WishItem item name", i1.getName());
        Log.d("WishItem parent name", theParent.getName());
    }
}
