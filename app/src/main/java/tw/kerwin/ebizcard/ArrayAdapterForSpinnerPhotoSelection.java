package tw.kerwin.ebizcard;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by chintsung on 2015/9/15.
 */
public class ArrayAdapterForSpinnerPhotoSelection extends ArrayAdapter<CharSequence> {

    private LayoutInflater mLayInf;
    private Spinner mSpinner;
    private TypedArray mTypeArr;

    public ArrayAdapterForSpinnerPhotoSelection(Context context,
                                                int textViewResourceId,
                                                CharSequence[] object,
                                                Spinner spinner) {
        super(context, textViewResourceId, object);

        mLayInf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mSpinner = spinner;
        mTypeArr = context.getResources().obtainTypedArray(R.array.photo_selection_spinner_icon_list);
    }

    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mLayInf.inflate(R.layout.spinner_select_photo_item, parent, false);

        ImageView imgView = (ImageView) v.findViewById(R.id.imgViewPhotoSelection);
        imgView.setImageResource(R.drawable.ic_local_see_black_24dp);

        return v;
    }*/

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v = mLayInf.inflate(R.layout.spinner_select_photo_dropdown_item, parent, false);
        TextView txt = (TextView) v.findViewById(R.id.txtSpnDropDown);
        txt.setText(getItem(position).toString());

        ImageView imgView = (ImageView) v.findViewById(R.id.imgViewSpnDropDown);
        imgView.setImageResource(mTypeArr.getResourceId(position, 0));

        return v;
    }
}
