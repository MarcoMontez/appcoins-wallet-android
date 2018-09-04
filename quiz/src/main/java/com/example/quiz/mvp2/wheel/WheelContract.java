package com.example.quiz.mvp2.wheel;


import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.example.quiz.mvp2.BasePresenter;
import com.example.quiz.mvp2.BaseView;
import com.example.quiz.mvp2.MainActivity;

public interface WheelContract {

    interface View extends BaseView<Presenter> {
        void setRewardText(String Text);
        void onClickNextButton();
        void setNextFragButtonVisibility(boolean visibility);
        void onClickWheelButton();
        void animateWheel();
        void setRewardTextVisibility(boolean visibility);
        public void showRewardAdder(double reward, TextView textView);
        public void setRewardWalletVisibility(boolean visibility);
        public TextView getTextView(String text);

    }

    interface Presenter extends BasePresenter {
        void loadRewardText();
        void changeFragment();
        void runWheel();

    }
}
