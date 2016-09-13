package com.example.next.weixin;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Next on 2016/8/9.
 */
public class ChatLab {

    private ArrayList<Chat> mChats;
    private static ChatLab sChatLab;
    private Context mContext;


    private ChatLab(Context context) {
        mContext = context;
        mChats = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Chat c = new Chat();
            c.setChatName("Chat #" + i);
            c.setChatIcon(R.drawable.p1);
            c.setChatLast("Lastchat #"+i);
            mChats.add(c);
        }
    }

    public static ChatLab get(Context c) {
        if (sChatLab == null) {
            sChatLab = new ChatLab(c.getApplicationContext());
        }
        return sChatLab;
    }

    public ArrayList<Chat> getChats() {
        return mChats;
    }

    public Chat getChat(UUID id) {
        for (Chat c : mChats) {
            if (id.equals(c.getId())) {
                return c;
            }
        }
        return null;
    }
}
