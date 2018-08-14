package com.example.quiz.mvp2.wheel;


import android.support.v4.app.FragmentActivity;

import com.example.quiz.mvp2.BasePresenter;
import com.example.quiz.mvp2.BaseView;
import com.example.quiz.mvp2.MainActivity;

public interface WheelContract {

    interface View extends BaseView<Presenter> {
        void setRewardText(String Text);
        void onClickNextButton();
    }

    interface Presenter extends BasePresenter {
        void loadRewardText();
        void changeFragment();
        void saveRewardOnActivity( double rewardValue);

    }
}
