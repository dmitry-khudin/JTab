package krt.com.jtab.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import krt.com.jtab.Models.SongModel;
import krt.com.jtab.R;

/**
 * Created by bryden on 11/29/16.
 */

public class SimpleSongAdapter extends BaseAdapter {

    SongModel[] listSongs;
    Context m_context;

    public SimpleSongAdapter(SongModel[] listSongs, Context m_context) {
        this.listSongs = listSongs;
        this.m_context = m_context;
    }

    @Override
    public int getCount() {
        return listSongs.length;
    }

    @Override
    public SongModel getItem(int i) {
        return listSongs[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
        {
            view = layoutInflater.inflate(R.layout.simple_song_item, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(getItem(i).getTitle());
        return view;
    }
}
