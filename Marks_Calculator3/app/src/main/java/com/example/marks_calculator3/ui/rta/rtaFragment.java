package com.example.marks_calculator3.ui.rta;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.marks_calculator3.R;

public class rtaFragment extends Fragment {

    private RtaViewModel mViewModel;

    public static rtaFragment newInstance() {
        return new rtaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_rta, container, false);

        Button rateNowButton = root.findViewById(R.id.rateNowButton);
        rateNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkInBrowser();
            }
        });

        return root;
    }

    private void openLinkInBrowser() {
        String link = "https://forms.gle/gyraZtdCnfX3ghZg8";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RtaViewModel.class);
        // TODO: Use the ViewModel
    }
}
