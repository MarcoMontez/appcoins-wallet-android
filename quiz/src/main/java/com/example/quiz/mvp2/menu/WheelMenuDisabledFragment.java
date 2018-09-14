package com.example.quiz.mvp2.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.mvp2.MainActivity;

public class WheelMenuDisabledFragment extends Fragment implements MenuContract.View{

    private MainActivity myActivity;
    TextView playBtn;
    ImageView prevBtn;
    MenuContract.Presenter mPresenter;
    TextView rewardText;
    Button walletBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_wheel_disabled, container, false);

        myActivity= (MainActivity) getActivity();
        rewardText = (TextView) view.findViewById(R.id.reward_text);
        walletBtn = (Button) view.findViewById(R.id.wallet_btn);
        prevBtn = (ImageView) view.findViewById(R.id.left_arrow_menu);

        mPresenter.setMenuDisabledText();

        walletBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadNextFragment();
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myActivity.finish();
            }
        });

        return view;
    }

    public void loadNextFragment(){
        myActivity.finish();
    }

    @Override
    public void setPresenter(MenuContract.Presenter presenter) {
        mPresenter=presenter;
    }

    public void setRewardText(String str) {
        rewardText.setText(str);
    }

}