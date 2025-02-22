package dam.pmdm.spyrothedragon.egg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

import dam.pmdm.spyrothedragon.R;


public class video extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("OnCreate Video");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        System.out.println("OnCreate Video");

        VideoView videov=view.findViewById(R.id.video);
        videov.setVideoPath("android.resource://"+getActivity().getPackageName()+"/"+R.raw.videospyro);
        videov.start();



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("OnResume Video");

        VideoView videov = getActivity().findViewById(R.id.video);
        videov.setVideoPath("android.resource://"+getActivity().getPackageName()+"/"+R.raw.videospyro);
        videov.start();
    }
}