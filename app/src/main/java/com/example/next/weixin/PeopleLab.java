package com.example.next.weixin;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Next on 2016/9/8.
 */
public class PeopleLab {

    private static PeopleLab sPeopleLab;
    private ArrayList<People> mPeoples;
    private Context mContext;

    private PeopleLab(Context c) {
        mContext = c;
        mPeoples = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            People people = new People();
            people.setPeopleName("People #" + i);
            people.setPeopleIcon(R.drawable.p1);
            mPeoples.add(people);
        }
    }

    public static PeopleLab get(Context c) {
        if (sPeopleLab == null) {
            sPeopleLab = new PeopleLab(c.getApplicationContext());
        }
        return sPeopleLab;
    }

    public ArrayList<People> getPeoples() {
        return mPeoples;
    }

    public People getPeople(UUID id) {
        for (People people : mPeoples) {
            if (people.getId() == id) {
                return people;
            }
        }
        return null;
    }
}
