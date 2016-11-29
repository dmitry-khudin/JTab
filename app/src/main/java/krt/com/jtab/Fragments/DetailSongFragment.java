package krt.com.jtab.Fragments;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import krt.com.jtab.MainActivity;
import krt.com.jtab.Models.SongModel;
import krt.com.jtab.R;


public class DetailSongFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View mainView;
    TextView textView;

    LinearLayout titlebar;
    LinearLayout adjustBar;

    WebView webView;
    ScrollView scrollView;
    int posy = 0, dy = 10;
    // TODO: Rename and change types of parameters
    private SongModel mParam1;
    private String mParam2;


    public static DetailSongFragment newInstance(SongModel param1, String param2) {
        DetailSongFragment fragment = new DetailSongFragment();
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
            mParam1 = (SongModel) getArguments().get(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_detail_song, container, false);


        initView();
        return mainView;
    }



   Timer timer;
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initView() {
//        textView = (TextView) mainView.findViewById(R.id.textView);
        TextView textView1 = (TextView) mainView.findViewById(R.id.textView6);
//        textView.setMovementMethod(new ScrollingMovementMethod());

        scrollView = (ScrollView) mainView.findViewById(R.id.scrollView) ;

        webView = (WebView) mainView.findViewById(R.id.webView);
//        wv = (WebView) findViewById(R.id.webView1);
        String path = "file:///android_asset/" + mParam1.getDescription() + ".html";
        webView.loadUrl(path);
        ImageButton imageButtonPlay = (ImageButton) mainView.findViewById(R.id.imageButton);
        ImageButton imageButtonClose = (ImageButton) mainView.findViewById(R.id.imageButton2);
        imageButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titlebar.setVisibility(View.GONE);
                adjustBar.setVisibility(View.VISIBLE);
                startTimer();
            }
        });
        imageButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titlebar.setVisibility(View.VISIBLE);
                adjustBar.setVisibility(View.GONE);
                webView.scrollTo(0, 0);
                stopTimer();
            }
        });
        mainView.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dy > 100) {dy = 100; return;}
                dy += 4;

            }
        });
        mainView.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dy <= 10) {dy = 10; return;}
                dy -= 4;
            }
        });
        mainView.findViewById(R.id.textView5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.FragmentBack();
            }
        });

        webView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                int height = (int) Math.floor(webView.getContentHeight() * webView.getScale());
                int webViewHeight = webView.getMeasuredHeight();
                if(webView.getScrollY() + webViewHeight >= height){
                    Log.d("THE END", "reached");
                    stopTimer();
                }
            }
        });

//        textView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
//
//                // Calculate the scrolldiff
//                int diff = (view.getBottom()-(view.getHeight()+view.getScrollY()));
//
//                // if diff is zero, then the bottom has been reached
//                if( diff == 0 )
//                {
//                    // notify that we have reached the bottom
//                    Log.d("TAG", "MyScrollView: Bottom has been reached" );
//                }
//                Log.d("scroll", view.getScrollY() + " " + view.getBottom() + " " + view.getHeight());
//
//                Log.d("POS", " " + i + " " + i1 + " " + i2 + " " + i3);
//
//            }
//        });
        titlebar = (LinearLayout) mainView.findViewById(R.id.titlebar);
        adjustBar = (LinearLayout) mainView.findViewById(R.id.adjust_bar);
        titlebar.setVisibility(View.VISIBLE);
        adjustBar.setVisibility(View.GONE);
        textView1.setText(mParam1.getTitle());
        AssetManager assetManager = getContext().getAssets();
        InputStream istr = null;
        String contents = "";
        if (mParam1 != null) {
            contents = mParam1.getDescription();
        }
//        try{
//            InputStream inputStream = getResources().getAssets().open("achtovvachesed_copy.html");
//            // I also try "UTF-8" but none of them worked
//            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
//            StringBuilder total = new StringBuilder();
//            String html;
//            while ((html = r.readLine()) != null) {
//                total.append(html);
//            }
//            // total contains incorrect characters
////            textView.setText(Html.fr(total.toString()));
//        }
//        catch (IOException exception)
//        {
//            textView.setText("Failed loading HTML.");
//        }
/*
        try {
            InputStream is = getContext().getAssets().open(mParam1.getDescription() + ".txt");

            // We guarantee that the available method returns the total
            // size of the asset...  of course, this does mean that a single
            // asset can't be more than 2 gigs.
            int size = is.available();

            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the buffer into a string.
            String text = new String(buffer);

            // Finally stick the string into the text view.
            // Replace with whatever you need to have the text into.

//            TextView tv = (TextView)findViewById(R.id.text);
            textView.setText(text);

        } catch (FileNotFoundException e)
        {
            Toast.makeText(getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            // Should never happen!
            Toast.makeText(getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }*/
    }

    private void startTimer() {
        timer = new Timer();
        initialTimerTask();
        dy = 10;
        timer.schedule(timertask, 20, 500);
    }

    private void stopTimer()
    {
        if (timer != null)
        {
            timer.cancel();
            timer = null;

        }

    }

    final Handler hander = new Handler();
    TimerTask timertask;
    private void initialTimerTask()
    {
        timertask = new TimerTask() {
            @Override
            public void run() {
                hander.post(new Runnable() {
                    @Override
                    public void run() {
                        webView.scrollBy(0, dy);
                   //     posy += dy;
                        Log.d("posy", dy + " " );
                    }
                });
            }
        };
    }

    // TODO: Rename method, update argument and hook method into UI event

}
