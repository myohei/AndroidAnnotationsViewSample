package org.yohei.androidanootaionsviewsample.ui.widger;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.*;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.yohei.androidanootaionsviewsample.R;
import org.yohei.androidanootaionsviewsample.model.SampleModel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by maedayouhei on 2/17/14.
 */
@EViewGroup(R.layout.view_list_item)
public class ViewListItem extends RelativeLayout {

    @ViewById
    TextView title, date;


    public ViewListItem(Context context) {
        super(context);
    }

    public ViewListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setValue(SampleModel model) {
        this.title.setText(model.getTitle());
        this.date.setText(dateToString(model.getDate()));
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();

    private static final String dateToString(Date date) {
        DATE_FORMAT.applyPattern("yyyy/MM/dd hh:mm:ss");
        return DATE_FORMAT.format(date);
    }

}
