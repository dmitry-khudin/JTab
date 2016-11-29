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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import krt.com.jtab.Adapters.SideSelector;
import krt.com.jtab.Adapters.SongsAdapter;
import krt.com.jtab.MainActivity;
import krt.com.jtab.Models.SongModel;
import krt.com.jtab.R;
import krt.com.jtab.Utils.Constants;

import static android.content.ContentValues.TAG;


public class SongsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    List<SongModel> listSongs, listDataSongs = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView titleText;
    public SongsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SongsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SongsFragment newInstance(String param1, String param2) {
        SongsFragment fragment = new SongsFragment();
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
    View mainView;

    SearchView searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_songs, container, false);
        initView();

        return mainView;
    }

    private List<Character> sectionlist = new ArrayList<>();
    private void searchFilter(String str)
    {
        listDataSongs.clear();
        sectionlist.clear();
        for (SongModel songModel : listSongs)
        {


            if (!str.equals("") && !songModel.getTitle().toLowerCase().startsWith(str.toLowerCase())) continue;;
            char prefix = Character.toUpperCase(songModel.getTitle().charAt(0));
            int l = sectionlist.size();
            if (l == 0 || sectionlist.get(l - 1) != prefix)
            {
                listDataSongs.add(new SongModel(String.valueOf(prefix)));
                listDataSongs.add(songModel);
                sectionlist.add(prefix);
            }
            else
            {
                listDataSongs.add(songModel);
            }
        }

        SongsAdapter adapter = new SongsAdapter(listDataSongs, mainView.getContext());
        listView.setAdapter(adapter);
        sideSelector.UpDate(sectionlist);
        sideSelector.setListView(listView);
    }
    SideSelector sideSelector;
    ListView listView;
    private void initView() {
        listView = (ListView) mainView.findViewById(R.id.list_view);
        titleText = (TextView) mainView.findViewById(R.id.textView4);
        listSongs = Constants.listSongs;
        Collections.sort(listSongs);

        searchView = (SearchView) mainView.findViewById(R.id.searchBar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                searchFilter(s);
                return false;
            }
        });
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                searchView.onActionViewExpanded();
                searchView.setIconified(false);
            }

        });
        titleText.setText(mParam2);
        List<String> items = new ArrayList<String>();

        sideSelector = (SideSelector) mainView.findViewById(R.id.side_selector);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.replaceFragment(3, listDataSongs.get(i), null);
            }
        });
        searchFilter("");
    }

    // TODO: Rename method, update argument and hook method into UI event

}
