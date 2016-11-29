package krt.com.jtab.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.List;

import krt.com.jtab.Models.ArtistModel;
import krt.com.jtab.Models.SongModel;
import krt.com.jtab.R;
import krt.com.jtab.Utils.Constants;

import static android.content.ContentValues.TAG;

/**
 * Created by bryden on 11/28/16.
 */

public class ArtistsAdapter extends BaseAdapter implements SectionIndexer {
    List<ArtistModel> list;
    Context mContext;
    LayoutInflater layoutInflater;

    public ArtistsAdapter(List<ArtistModel> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ArtistModel getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textTitle, textDesc, textHeader;
        ImageView imageView;
        LinearLayout headerView, contentView;
        if (view == null)
        {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.artist_item, null);
        }
        textHeader = (TextView) view.findViewById(R.id.textView);
        headerView = (LinearLayout)  view.findViewById(R.id.header_view);
        contentView = (LinearLayout)  view.findViewById(R.id.content_view);
        textDesc = (TextView) view.findViewById(R.id.textView2);
        textTitle = (TextView)view.findViewById(R.id.textView3);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        ArtistModel artistModel = getItem(i);
        if (artistModel.isHeader() == true)
        {
            headerView.setVisibility(View.VISIBLE);
            textHeader.setText(artistModel.getName());
            contentView.setVisibility(View.GONE);
        }
        else
        {
            headerView.setVisibility(View.GONE);
            contentView.setVisibility(View.VISIBLE);
            textDesc.setText(artistModel.getArraySong().length + " songs");
            textTitle.setText(artistModel.getName());
            imageView.setImageBitmap(Constants.getBitmapFromAsset(mContext, artistModel.getImageURL()));
        }
        return view;
    }

    @Override
    public String[] getSections() {
        String[] chars = new String[SideSelector.ALPHABET.size()];
        for (int i = 0; i < SideSelector.ALPHABET.size(); i++) {
            chars[i] = String.valueOf(SideSelector.ALPHABET.get(i));
        }
        return chars;
    }

    @Override
    public int getPositionForSection(int i) {
        Log.d(TAG, "getPositionForSection " + i);
        int pos = 0;
        if (i < 0) i = 0;
        if (i >= getSections().length) i = getSections().length - 1;

        for (ArtistModel songModel : list)
        {
            if (songModel.getName().startsWith(getSections()[i])) return pos;
            pos++;
        }
        return (int) (getCount() * ((float)i/(float)getSections().length));
    }

    @Override
    public int getSectionForPosition(int i) {
        return 0;
    }
}
