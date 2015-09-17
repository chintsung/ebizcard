package tw.kerwin.ebizcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddActivity extends AppCompatActivity {

    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        CharSequence[] spinnerList = getResources().getStringArray(R.array.photo_selection_spinner_list);
        mSpinner = (Spinner) findViewById(R.id.spnPhotoSelect);
        ArrayAdapterForSpinnerPhotoSelection arrAdapSpinner =
                new ArrayAdapterForSpinnerPhotoSelection(
                        AddActivity.this, R.layout.spinner_select_photo_item,
                        spinnerList, mSpinner);
        arrAdapSpinner.setDropDownViewResource(R.layout.spinner_select_photo_dropdown_item);
        mSpinner.setAdapter(arrAdapSpinner);
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
}
