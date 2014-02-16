package org.yohei.androidanootaionsviewsample.ui.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.ListView;

import org.androidannotations.annotations.*;
import org.yohei.androidanootaionsviewsample.R;
import org.yohei.androidanootaionsviewsample.loader.StubLoader;
import org.yohei.androidanootaionsviewsample.model.SampleModel;
import org.yohei.androidanootaionsviewsample.ui.widger.SampleAdapter;

import java.util.List;

/**
 * Created by maedayouhei on 2/17/14.
 */
@EFragment(R.layout.fragment_list)
public class ListFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<SampleModel>> {

    @ViewById(android.R.id.list)
    ListView listView;

    @Bean
    SampleAdapter adapter;


    @AfterInject
    void initLoader () {
        getActivity().getSupportLoaderManager().initLoader(1, null, this).forceLoad();
    }

    @AfterViews
    void initListView () {
        listView.setAdapter(adapter);
    }


    @Override
    public Loader<List<SampleModel>> onCreateLoader (int i, Bundle bundle) {
        return new StubLoader(getActivity().getApplicationContext());
    }

    @Override
    public void onLoadFinished (Loader<List<SampleModel>> listLoader, List<SampleModel> sampleModels) {
        if (sampleModels != null) {
            adapter.addAll(sampleModels);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset (Loader<List<SampleModel>> listLoader) {
    }
}
