package com.example.next.weixin;

import java.util.UUID;

/**
 * Created by Next on 2016/9/8.
 */
public class People {

    private String mPeopleName;
    private UUID mId;
    private int mPeopleIcon;

    public People() {
        mId = UUID.randomUUID();
    }

    public String getPeopleName() {
        return mPeopleName;
    }

    public void setPeopleName(String peopleName) {
        mPeopleName = peopleName;
    }

    public UUID getId() {
        return mId;
    }

    public int getPeopleIcon() {
        return mPeopleIcon;
    }

    public void setPeopleIcon(int peopleIcon) {
        mPeopleIcon = peopleIcon;
    }
}
