package com.example.next.weixin;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Next on 2016/8/9.
 */
public class Chat {

    private UUID mId;
    private String mChatName;
    private String mChatLast;
    private int mChatIcon;
    private Date mLastTime;

    public Date getLastTime() {
        return mLastTime;
    }

    public void setLastTime(Date lastTime) {
        mLastTime = lastTime;
    }

    public String getChatLast() {
        return mChatLast;
    }

    public void setChatLast(String chatLast) {
        mChatLast = chatLast;
    }


    public int getChatIcon() {
        return mChatIcon;
    }

    public void setChatIcon(int chatIcon) {
        mChatIcon = chatIcon;
    }


    public Chat() {
        mId = UUID.randomUUID();
        mLastTime = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public void setChatName(String chatName) {
        mChatName = chatName;
    }

    public String getChatName() {
        return mChatName;
    }

    public String toString() {
        return mChatName;
    }

}
