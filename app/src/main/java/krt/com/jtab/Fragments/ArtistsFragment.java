package krt.com.jtab.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import krt.com.jtab.Adapters.ArtistsAdapter;
import krt.com.jtab.Adapters.SideSelector;
import krt.com.jtab.Adapters.SongsAdapter;
import krt.com.jtab.MainActivity;
import krt.com.jtab.Models.ArtistModel;
import krt.com.jtab.Models.SongModel;
import krt.com.jtab.R;
import krt.com.jtab.Utils.Constants;

import static android.content.ContentValues.TAG;


public class ArtistsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View mainView;
    SideSelector sideSelector;
    ListView listView;
    List<ArtistModel> artistModelList;
    List<ArtistModel> listDataArtists = new ArrayList<>();
    List<Character> sectionlist = new ArrayList<>();
    SearchView searchView;
    public ArtistsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArtistsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArtistsFragment newInstance(String param1, String param2) {
        ArtistsFragment fragment = new ArtistsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView =  inflater.inflate(R.layout.fragment_artists, container, false);
        initView();
        return mainView;
    }

    private void initView() {
        listView = (ListView) mainView.findViewById(R.id.list_view);
        TextView titleText = (TextView) mainView.findViewById(R.id.textView4);
        artistModelList = Constants.listArtists;
        Collections.sort(artistModelList);

        searchView = (SearchView) mainView.findViewById(R.id.searchView);
        List<String> items = new ArrayList<String>();
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                searchView.onActionViewExpanded();
                searchView.setIconified(false);
            }

        });
        titleText.setText(mParam2);
        sideSelector = (SideSelector) mainView.findViewById(R.id.side_selector);
        searchFilter("");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity mainActivity = (MainActivity) getActivity();
                if (!listDataArtists.get(i).isHeader()) mainActivity.replaceFragment(4, null, listDataArtists.get(i));
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchFilter(s);
                return false;
            }
        });
    }

    private void searchFilter(String str) {
        listDataArtists.clear();
        sectionlist.clear();
        for (ArtistModel songModel : artistModelList)
        {
            if (!str.equals("") && !songModel.getName().toLowerCase().startsWith(str.toLowerCase())) continue;;
            char prefix = Character.toUpperCase(songModel.getName().charAt(0));
            int l = sectionlist.size();
            if (l == 0 || sectionlist.get(l - 1) != prefix)
            {
                listDataArtists.add(new ArtistModel(String.valueOf(prefix)));
                listDataArtists.add(songModel);
                sectionlist.add(prefix);
            }
            else
            {
                listDataArtists.add(songModel);
            }
        }

        ArtistsAdapter adapter = new ArtistsAdapter(listDataArtists, mainView.getContext());
        listView.setAdapter(adapter);
        sideSelector.UpDate(sectionlist);
        sideSelector.setListView(listView);
    }



}
