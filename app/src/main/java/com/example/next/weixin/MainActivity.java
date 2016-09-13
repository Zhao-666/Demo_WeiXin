package com.example.next.weixin;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragments;

    private TextView mChatTextView;
    private TextView mPeopleTextView;
    private TextView mFindTextView;
    private TextView mMeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createData();

        mViewPager = (ViewPager) findViewById(R.id.id_view_pager);

        mChatTextView = (TextView) findViewById(R.id.id_bottom_weixin_textview);
        mPeopleTextView = (TextView) findViewById(R.id.id_bottom_tongxunlu_textview);
        mFindTextView = (TextView) findViewById(R.id.id_bottom_faxian_textview);
        mMeTextView = (TextView) findViewById(R.id.id_bottom_wo_textview);

        View.OnClickListener bottomTextViewListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.id_bottom_weixin_textview:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.id_bottom_tongxunlu_textview:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.id_bottom_faxian_textview:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.id_bottom_wo_textview:
                        mViewPager.setCurrentItem(3);
                        break;
                }
            }
        };
        mChatTextView.setOnClickListener(bottomTextViewListener);
        mPeopleTextView.setOnClickListener(bottomTextViewListener);
        mFindTextView.setOnClickListener(bottomTextViewListener);
        mMeTextView.setOnClickListener(bottomTextViewListener);

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetColor();
                switch (position) {
                    case 0:
                        mChatTextView.setTextColor(0xff008000);
                        break;
                    case 1:
                        mPeopleTextView.setTextColor(0xff008000);
                        break;
                    case 2:
                        mFindTextView.setTextColor(0xff008000);
                        break;
                    case 3:
                        mMeTextView.setTextColor(0xff008000);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createData() {
        mFragments = new ArrayList<>();
        mFragments.add(new ChatFragment());
        mFragments.add(new PeopleFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new MeFragment());
    }

    private void resetColor() {
        mChatTextView.setTextColor(Color.BLACK);
        mPeopleTextView.setTextColor(Color.BLACK);
        mFindTextView.setTextColor(Color.BLACK);
        mMeTextView.setTextColor(Color.BLACK);
    }

}
