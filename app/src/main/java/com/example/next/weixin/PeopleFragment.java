package com.example.next.weixin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Next on 2016/8/8.
 */
public class PeopleFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private PeopleListAdapter mPeopleListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_recycler_view_people);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI() {
        PeopleLab peopleLab = PeopleLab.get(getActivity());
        List<People> peopleList = peopleLab.getPeoples();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mPeopleListAdapter = new PeopleListAdapter(peopleList);
        mRecyclerView.setAdapter(mPeopleListAdapter);
        mRecyclerView.addItemDecoration(new MyDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
    }

    public class PeopleListHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;
        private People mPeople;

        public PeopleListHolder(View view) {
            super(view);

            mImageView = (ImageView) view.findViewById(R.id.id_people_list_item_icon);
            mTextView = (TextView) view.findViewById(R.id.id_people_list_item_name);
        }

        public void bindPeople(People people) {
            mPeople = people;
            mImageView.setImageResource(mPeople.getPeopleIcon());
            mTextView.setText(mPeople.getPeopleName());
        }

    }

    public class PeopleListAdapter extends RecyclerView.Adapter<PeopleListHolder> {

        private List<People> mPeoples;

        public PeopleListAdapter(List<People> peoples) {
            mPeoples = peoples;
        }

        @Override

        public PeopleListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_people, parent, false);
            return new PeopleListHolder(view);
        }

        @Override
        public void onBindViewHolder(PeopleListHolder holder, int position) {
            People people = mPeoples.get(position);
            holder.bindPeople(people);
        }

        @Override
        public int getItemCount() {
            return mPeoples.size();
        }
    }
}
