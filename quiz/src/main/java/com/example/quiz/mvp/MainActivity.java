package com.example.quiz.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.example.quiz.R;
import com.example.quiz.mvp.fragments.WheelFragment;
import com.example.quiz.quiz.QuizFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener, WheelFragment.NextFragListener{

    private TextView mTextView;

    private MainPresenter mPresenter;

    @Override
    public void onClick(View view) {

//        int id = view.getId();
//
//        if(id == R.id.button){
//            action1();
//        } else if (id == R.id.button2){
//            action2();
//        }

        //mPresenter.loadHelloText();
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDestroy();
        mPresenter.detach();
    }

//    @Override
//    public void onTextLoaded(String text) {
//        mTextView.setText(text);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //setContentView(R.layout.greeting_screen);

        setInitView(savedInstanceState);

    }

    public void setInitView(Bundle savedInstanceState) {
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            WheelFragment firstFragment = new WheelFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }


    @Override
    public void gotoQuizFrag() {
        QuizFragment newFragment = new QuizFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_container, newFragment,"QuizFrag");
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
