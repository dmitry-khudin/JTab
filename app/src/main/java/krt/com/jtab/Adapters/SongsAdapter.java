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

import de.halfbit.pinnedsection.PinnedSectionListView;
import krt.com.jtab.Models.SongModel;
import krt.com.jtab.R;
import krt.com.jtab.Utils.Constants;

import static android.content.ContentValues.TAG;

/**
 * Created by bryden on 11/26/16.
 */

public class SongsAdapter extends BaseAdapter implements SectionIndexer, PinnedSectionListView.PinnedSectionListAdapter {
    List<SongModel> list;
    Context mContext;
    LayoutInflater layoutInflater;

    public SongsAdapter(List<SongModel> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public SongModel getItem(int i) {
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
            view = layoutInflater.inflate(R.layout.song_item, null);
        }
        textHeader = (TextView) view.findViewById(R.id.textView);
        headerView = (LinearLayout)  view.findViewById(R.id.header_view);
        contentView = (LinearLayout)  view.findViewById(R.id.content_view);
        textDesc = (TextView) view.findViewById(R.id.textView2);
        textTitle = (TextView)view.findViewById(R.id.textView3);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        SongModel songModel = getItem(i);
        if (songModel.isHeader() == true)
        {
            headerView.setVisibility(View.VISIBLE);
            textHeader.setText(songModel.getTitle());
            contentView.setVisibility(View.GONE);
        }
        else
        {
            headerView.setVisibility(View.GONE);
            contentView.setVisibility(View.VISIBLE);
            textDesc.setText(songModel.getArtistModel().getName());
            textTitle.setText(songModel.getTitle());
            imageView.setImageBitmap(Constants.getBitmapFromAsset(mContext, songModel.getArtistModel().getImageURL()));
        }
        return view;
    }
    @Override public int getViewTypeCount() {
        return 2;
    }

    @Override public int getItemViewType(int position) {
        return (getItem(position).isHeader() ? 1 : 0);
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

        int pos = 0;
        if (i < 0 ) i = 0;
        if (i >= getSections().length) i = getSections().length - 1;
        Log.d(TAG, "getPositionForSection " + i + " " + getSections().length + " " + getCount());
        for (SongModel songModel : list)
        {
            if (songModel.getTitle().startsWith(getSections()[i])) return pos;
            pos++;
        }
        return (int) (getCount() * ((float)i/(float)getSections().length));
    }

    @Override
    public int getSectionForPosition(int i) {
        return 0;
    }

    @Override
    public boolean isItemViewTypePinned(int viewType) {

        return (viewType == 1);
    }
}
