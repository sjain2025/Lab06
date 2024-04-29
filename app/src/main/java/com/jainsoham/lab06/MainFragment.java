package com.jainsoham.lab06;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment extends Fragment {
    Button mButton;
    ViewPager2 viewPager2;
    ImageView imageView;

    public static MainFragment newInstance(ViewPager2 mViewPager) {
        MainFragment fragment = new MainFragment();
        fragment.viewPager2 = mViewPager;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = getActivity().findViewById(R.id.tab_layout);
        imageView = view.findViewById(R.id.imageview);
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position)->tab.setText("I am " + (position + 1))).attach();
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.dog1);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.dog2);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.dog3);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.dog4);
                        break;
                    default:
                        imageView.setImageResource(R.drawable.dog5);
                        break;
                }
            }
        });
        mButton = view.findViewById(R.id.button_pressme);
        mButton.setText("Press" + viewPager2.getCurrentItem());
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "toasting" + viewPager2.getCurrentItem(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
