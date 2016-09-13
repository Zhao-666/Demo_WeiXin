package com.example.next.weixin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;

/**
 * Created by Next on 2016/8/8.
 */

public class ChatFragment extends Fragment {

    private ArrayList<Chat> mChats;
    private ChatAdapter mChatAdapter;
    private ListView mListView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mChats = ChatLab.get(getActivity()).getChats();
        mChatAdapter = new ChatAdapter(mChats);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        mListView = (ListView) view.findViewById(R.id.id_list_view_chat);
        mListView.setAdapter(mChatAdapter);
        return view;
    }

    private class ChatAdapter extends ArrayAdapter<Chat> {
        public ChatAdapter(ArrayList<Chat> chats) {
            super(getActivity(), 0, chats);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_chat, null);
            }

            Chat chat = getItem(position);

            ImageView iconImageView = (ImageView) convertView.findViewById(R.id.id_chat_list_item_icon);
            iconImageView.setImageResource(chat.getChatIcon());
            TextView nameTextView = (TextView) convertView.findViewById(R.id.id_chat_list_item_name);
            nameTextView.setText(chat.getChatName());
            TextView lastTextView = (TextView) convertView.findViewById(R.id.id_chat_list_item_last);
            lastTextView.setText(chat.getChatLast());
            TextView timeTextView = (TextView) convertView.findViewById(R.id.id_chat_list_item_time);
            DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            timeTextView.setText(shortDateFormat.format(chat.getLastTime()));
            return convertView;
        }
    }

}
