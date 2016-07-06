package trandu.horical.com.mvvm_android_cover.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import trandu.horical.com.mvvm_android_cover.model.People;

public class ItemPeopleViewModel extends BaseObservable {

    private static final String TAG = "ItemPeopleViewModel";

    private People mPeople;
    private Context mContext;

    public ItemPeopleViewModel(People people, Context context) {
        this.mPeople = people;
        this.mContext = context;
    }

    public String getFullName() {
        mPeople.mFullName =
                mPeople.mName.mTitle + "." + mPeople.mName.mFirts + " " + mPeople.mName.mLast;
        return mPeople.mFullName;
    }

    public String getCell() {
        return mPeople.mCell;
    }

    public String getMail() {
        return mPeople.mMail;
    }

    public String getPictureProfile() {
        return mPeople.mPicture.large;
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    public void onItemClick(View view) {
        Log.d(TAG, "onItemClick() called with: view = [" + view + "]");
        Toast.makeText(mContext, getFullName(), Toast.LENGTH_LONG).show();
    }

    public void setPeople(People people) {
        mPeople = people;
        notifyChange();
    }

}
