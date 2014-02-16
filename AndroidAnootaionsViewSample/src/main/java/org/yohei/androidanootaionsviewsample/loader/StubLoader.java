package org.yohei.androidanootaionsviewsample.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import org.yohei.androidanootaionsviewsample.model.SampleModel;

import java.util.*;

/**
 * Created by maedayouhei on 2/17/14.
 */
public class StubLoader extends AsyncTaskLoader<List<SampleModel>> {

    public StubLoader (Context context) {
        super(context);
    }

    @Override
    public List<SampleModel> loadInBackground () {
        List<SampleModel> items = new ArrayList<SampleModel>();
        for (int i = 0; i < 100; i++) {
            final SampleModel model = new SampleModel();
            model.setTitle("title" + (i + 1));
            model.setDate(new Date());
            items.add(model);
        }

        // heavy
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        return items;
    }

}
