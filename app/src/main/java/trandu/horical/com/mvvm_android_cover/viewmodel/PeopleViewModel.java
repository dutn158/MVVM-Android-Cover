package trandu.horical.com.mvvm_android_cover.viewmodel;

import android.content.Context;
import android.util.Log;
import android.view.View;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import trandu.horical.com.mvvm_android_cover.MainApplication;
import trandu.horical.com.mvvm_android_cover.data.PeopleResponse;
import trandu.horical.com.mvvm_android_cover.data.PeopleService;

public class PeopleViewModel implements PeopleViewModelContract.ViewModel {

    private static final String TAG = "PeopleViewModel";
    private PeopleViewModelContract.MainView mMainView;
    private Context mContext;
    private Subscription mSubscription;

    public PeopleViewModel(PeopleViewModelContract.MainView mainView, Context context) {
        mMainView = mainView;
        mContext = context;
    }

    public void onClickFabLoad (View view) {
        Log.d(TAG, "onClickFabLoad() called with: view = [" + view + "]");
        fetchPeopleList();
    }

    @Override
    public void destroy() {

    }

    private void fetchPeopleList() {
        final String URL = "http://api.randomuser.me/?results=10&nat=en";
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        MainApplication peopleApplication = MainApplication.create(mContext);
        PeopleService peopleService = peopleApplication.getPeopleService();
        mSubscription = peopleService.fetchPeople(URL)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(peopleApplication.subscribeScheduler())
                .subscribe(new Action1<PeopleResponse>() {
                    @Override
                    public void call(PeopleResponse peopleResponse) {
                        mMainView.loadData(peopleResponse.getPeopleList());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d(TAG, "call() called with: throwable = [" + throwable + "]");
                    }
                });

    }

}
