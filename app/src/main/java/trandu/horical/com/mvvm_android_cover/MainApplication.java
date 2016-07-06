package trandu.horical.com.mvvm_android_cover;

import android.app.Application;
import android.content.Context;

import rx.Scheduler;
import rx.schedulers.Schedulers;
import trandu.horical.com.mvvm_android_cover.data.PeopleFactory;
import trandu.horical.com.mvvm_android_cover.data.PeopleService;

public class MainApplication extends Application {

    private PeopleService mPeopleService;
    private Scheduler mScheduler;

    private static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    public static MainApplication create(Context context) {
        return MainApplication.get(context);
    }

    public PeopleService getPeopleService() {
        if (mPeopleService == null) {
            mPeopleService = PeopleFactory.create();
        }
        return mPeopleService;
    }

    public Scheduler subscribeScheduler() {
        if (mScheduler == null) {
            mScheduler = Schedulers.io();
        }
        return mScheduler;
    }

    public void setPeopleService(PeopleService peopleService) {
        mPeopleService = peopleService;
    }

    public void setScheduler(Scheduler scheduler) {
        mScheduler = scheduler;
    }

}
