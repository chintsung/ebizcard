package tw.kerwin.ebizcard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    private static final String ITEM_TITLE = "Item title";
    private static final String ITEM_ICON = "Item icon";
    private ImageButton mImgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        CharSequence[] spinnerList = getResources().getStringArray(R.array.photo_selection_spinner_list);
        mImgButton = (ImageButton) findViewById(R.id.imgButtonPhotoSelection);
        mImgButton.setOnClickListener(imgBtnOnClick);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener imgBtnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String[] photoSelectionList = getResources().getStringArray(R.array.photo_selection_spinner_list);
            TypedArray photoSelectionIconList =
                    getResources().obtainTypedArray(R.array.photo_selection_spinner_icon_list);
            List<Map<String, Object>> itemList = new ArrayList<>();

            for (int i=0; i<photoSelectionList.length; i++) {
                Map<String, Object> item = new HashMap<>();
                item.put(ITEM_TITLE, photoSelectionList[i]);
                item.put(ITEM_ICON, photoSelectionIconList.getResourceId(i, 0));
                itemList.add(item);
            }

            SimpleAdapter simAdapListView = new SimpleAdapter(
                    AddActivity.this, itemList,
                    R.layout.list_view_photo_selection,
                    new String[] {ITEM_TITLE, ITEM_ICON},
                    new int[] {R.id.txtViewPhotoSelctionItem, R.id.imgViewPhotoSelectionIcon});

            AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
            builder.setTitle(R.string.spinner_photo_selection);
            builder.setAdapter(simAdapListView, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
        }
    };
}
