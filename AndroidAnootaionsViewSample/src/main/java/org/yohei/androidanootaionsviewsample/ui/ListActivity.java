package org.yohei.androidanootaionsviewsample.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import org.androidannotations.annotations.EActivity;
import org.yohei.androidanootaionsviewsample.R;
import org.yohei.androidanootaionsviewsample.ui.view.ListFragment_;

@EActivity(R.layout.activity_list)
public class ListActivity extends ActionBarActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, ListFragment_.builder().build())
                    .commit();
        }
    }
}
