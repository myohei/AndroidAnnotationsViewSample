package org.yohei.androidanootaionsviewsample.ui.widger;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.*;
import org.yohei.androidanootaionsviewsample.model.SampleModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maedayouhei on 2/17/14.
 */
@EBean
public class SampleAdapter extends BaseAdapter {

    private List<SampleModel> items;

    @RootContext
    Context mContext;

    @AfterInject
    void initAdapter () {
        items = new ArrayList<SampleModel>();
    }

    public void add (SampleModel model) {
        items.add(model);
    }

    public void addAll (List<SampleModel> items) {
        this.items.addAll(items);
    }

    @Override
    public int getCount () {
        return items.size();
    }

    @Override
    public Object getItem (int position) {
        return items.get(position);
    }

    @Override
    public long getItemId (int position) {
        return position;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        ViewListItem viewListItem = null;
        if (convertView == null) {
            viewListItem = ViewListItem_.build(mContext);
            convertView = viewListItem;
        } else {
            viewListItem = (ViewListItem) convertView;
        }
        final SampleModel model = (SampleModel) getItem(position);
        viewListItem.setValue(model);
        return convertView;
    }
}
