package krt.com.jtab.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import krt.com.jtab.Adapters.SimpleSongAdapter;
import krt.com.jtab.MainActivity;
import krt.com.jtab.Models.ArtistModel;
import krt.com.jtab.Models.SongModel;
import krt.com.jtab.R;


public class DetailArtists extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static SongModel[] arraySong;
    // TODO: Rename and change types of parameters
    private ArtistModel mParam1;
    private String mParam2;

    TextView textView;
    View mainView;


    public DetailArtists() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailArtists.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailArtists newInstance(ArtistModel param1, String param2) {
        DetailArtists fragment = new DetailArtists();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelable(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_detail_artists, container, false);
        initView();
        return mainView;
    }

    private void initView() {
//        String[] arrayTitle
        ListView listView = (ListView) mainView.findViewById(R.id.list_view);
        textView = (TextView) mainView.findViewById(R.id.textView6);

        textView.setText("Songs By " + mParam1.getName());

        mainView.findViewById(R.id.textView5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.FragmentBack();
            }
        });
        SimpleSongAdapter adapter = new SimpleSongAdapter(mParam1.getArraySong(), mainView.getContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.replaceFragment(3, mParam1.getArraySong()[i], null);
            }
        });
    }



}
