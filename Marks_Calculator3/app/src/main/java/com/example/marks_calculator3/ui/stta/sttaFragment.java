package com.example.marks_calculator3.ui.stta;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.marks_calculator3.R;

public class sttaFragment extends Fragment {

    private SttaViewModel mViewModel;
    ImageView imageview;

    public static sttaFragment newInstance() {
        return new sttaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stta, container, false);

        // Find the Button in the layout
        Button sendLinkButton = rootView.findViewById(R.id.sendLinkButton);

        // Set click listener for the button to open the app link
        sendLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAppLink();
            }
        });

        return rootView;
    }

    // Method to open the app link
    private void openAppLink() {
        // Replace 'APP_LINK' with the actual link to your app on the app store
        String appLink = "https://www.mediafire.com/file/nqzhhav0n8ay6mw/updated_calc.apk/file";
        Uri uri = Uri.parse(appLink);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
   /* BitmapFactory.Options options = new BitmapFactory.Options();
    options.inSampleSize=4;
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.qrr,options);
    imageview.setImageBitmap(bitmap);*/



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SttaViewModel.class);
        // TODO: Use the ViewModel
    }
}
