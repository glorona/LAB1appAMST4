package com.example.appamst4.ui.video;


import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.appamst4.R;

import com.example.appamst4.databinding.FragmentVideoBinding;
import com.example.appamst4.ui.video.VideoViewModel;

public class VideoFragment extends Fragment {

    private FragmentVideoBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        VideoViewModel slideshowViewModel =
                new ViewModelProvider(this).get(VideoViewModel.class);

        binding = FragmentVideoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textVideo;
        //slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final VideoView videoView = binding.videoView;
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.iphone;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(getActivity());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}