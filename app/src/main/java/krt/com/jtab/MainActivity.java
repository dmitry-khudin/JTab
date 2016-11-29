package krt.com.jtab;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import krt.com.jtab.Fragments.ArtistsFragment;
import krt.com.jtab.Fragments.DetailArtists;
import krt.com.jtab.Fragments.DetailSongFragment;
import krt.com.jtab.Fragments.FeedbackFragment;
import krt.com.jtab.Fragments.SongsFragment;
import krt.com.jtab.Models.ArtistModel;
import krt.com.jtab.Models.SongModel;
import krt.com.jtab.Utils.Constants;

public class MainActivity extends AppCompatActivity {

    BottomBar bottomBar;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        Constants.initData();
        fragmentManager = getSupportFragmentManager();

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId)
                {
                    case R.id.tab_song :
                    {
                        replaceFragment(0, null, null);
                        break;
                    }
                    case R.id.tab_artist:
                    {
                        replaceFragment(1, null, null);
                        break;
                    }
                    case R.id.tab_feedback :
                    {
                        replaceFragment(2, null, null);
                        break;
                    }
                    default:
                        break;

                }
            }
        });
    }

    public void replaceFragment(int id, SongModel songModel, ArtistModel artistModel)
    {
        if (id == 0)
        {
          //  FragmentTransaction ft = fragmentManager.beginTransaction();
            replaceFrag(SongsFragment.newInstance("", "Songs"));
        //    ft.commit();
        }
        else if (id == 1)
        {
          //  FragmentTransaction ft = fragmentManager.beginTransaction();
            replaceFrag(ArtistsFragment.newInstance("", "Artists"));
          //  ft.commit();
        }
        else if (id == 2)
        {
          //  FragmentTransaction ft = fragmentManager.beginTransaction();
            replaceFrag( FeedbackFragment.newInstance("", ""));
           // ft.commit();
        }
        else if (id == 3)
        {
       //     FragmentTransaction ft = fragmentManager.beginTransaction();
//            DetailSongFragment.
            replaceFrag(DetailSongFragment.newInstance(songModel, ""));
       //     ft.commit();
        }
        else if (id == 4)
        {
         //   FragmentTransaction ft = fragmentManager.beginTransaction();
//            DetailSongFragment.
            replaceFrag(DetailArtists.newInstance(artistModel, ""));
        //    ft.commit();
        }
    }

    private void replaceFrag (Fragment fragment){
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped){ //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.contentContainer, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    public void FragmentBack()
    {
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack();
    }
}
