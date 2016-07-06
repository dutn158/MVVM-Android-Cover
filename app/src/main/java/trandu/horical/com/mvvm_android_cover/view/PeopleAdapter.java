package trandu.horical.com.mvvm_android_cover.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import trandu.horical.com.mvvm_android_cover.R;
import trandu.horical.com.mvvm_android_cover.databinding.ItemPeopleBinding;
import trandu.horical.com.mvvm_android_cover.model.People;
import trandu.horical.com.mvvm_android_cover.viewmodel.ItemPeopleViewModel;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleAdapterViewHolder> {

    private List<People> mPeopleList;

    public PeopleAdapter() {
        this.mPeopleList = Collections.emptyList();
    }

    @Override
    public PeopleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPeopleBinding itemPeopleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_people, parent, false);
        return new PeopleAdapterViewHolder(itemPeopleBinding);
    }

    @Override
    public void onBindViewHolder(PeopleAdapterViewHolder holder, int position) {
        holder.bindPeople(mPeopleList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }

    public void setPeopleList(List<People> peopleList) {
        mPeopleList = peopleList;
        notifyDataSetChanged();
    }

    public static class PeopleAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemPeopleBinding mItemPeopleBinding;

        public PeopleAdapterViewHolder(ItemPeopleBinding itemPeopleBinding) {
            super(itemPeopleBinding.itemPeople);
            mItemPeopleBinding = itemPeopleBinding;
        }

        public void bindPeople(People people) {
            if (mItemPeopleBinding.getPeopleViewModel() == null) {
                mItemPeopleBinding.setPeopleViewModel(new ItemPeopleViewModel(people, itemView.getContext()));
            } else {
                mItemPeopleBinding.getPeopleViewModel().setPeople(people);
            }
        }

    }

}
