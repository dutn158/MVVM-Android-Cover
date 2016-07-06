package trandu.horical.com.mvvm_android_cover.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import trandu.horical.com.mvvm_android_cover.R;
import trandu.horical.com.mvvm_android_cover.databinding.ActivityMainBinding;
import trandu.horical.com.mvvm_android_cover.model.People;
import trandu.horical.com.mvvm_android_cover.viewmodel.PeopleViewModel;
import trandu.horical.com.mvvm_android_cover.viewmodel.PeopleViewModelContract;

public class MainActivity extends AppCompatActivity implements PeopleViewModelContract.MainView {

    ActivityMainBinding activityMainBinding;
    PeopleViewModel peopleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        peopleViewModel = new PeopleViewModel(this, this);
        activityMainBinding.setMainViewModel(peopleViewModel);
        setSupportActionBar(activityMainBinding.toolbar);

        PeopleAdapter adapter = new PeopleAdapter();
        activityMainBinding.listPeople.setAdapter(adapter);
        activityMainBinding.listPeople.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public Context getContext() {
        return MainActivity.this;
    }

    @Override
    public void loadData(List<People> peoples) {
        PeopleAdapter peopleAdapter = (PeopleAdapter) activityMainBinding.listPeople.getAdapter();
        peopleAdapter.setPeopleList(peoples);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        peopleViewModel.destroy();
    }
}
