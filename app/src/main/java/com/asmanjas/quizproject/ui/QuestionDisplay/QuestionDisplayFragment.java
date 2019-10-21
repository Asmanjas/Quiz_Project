package com.asmanjas.quizproject.ui.QuestionDisplay;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.asmanjas.quizproject.QuestionEntity;
import com.asmanjas.quizproject.R;

import java.util.List;

public class QuestionDisplayFragment extends Fragment implements View.OnClickListener{

    private QuestionDisplayViewModel mViewModel;
    private TextView opt1TextView,opt2TextView,opt3TextView,opt4TextView,questionTitleTextView;
    private CardView opt1CardView,opt2CardView,opt3CardView,opt4CardView;
    private Button nextButton;
    ProgressBar progressBar;
    CountDownTimer countDownTimer;


    private int currentPosition = 1;
    private int progressBarStatus = 0;


    public static QuestionDisplayFragment newInstance() {
        return new QuestionDisplayFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.question_display_fragment, container, false);
        opt1TextView = v.findViewById(R.id.op1_text_view);
        opt2TextView = v.findViewById(R.id.op2_text_view);
        opt3TextView = v.findViewById(R.id.op3_text_view);
        opt4TextView = v.findViewById(R.id.op4_text_view);


        progressBar = v.findViewById(R.id.progressBar);
        progressBar.setProgress(progressBarStatus);

        questionTitleTextView = v.findViewById(R.id.question_title_text_view);
        nextButton = v.findViewById(R.id.next_button);
        nextButton.setText(Html.fromHtml("Next Question<br/><small>question " + String.valueOf(1) + "/15</small>"));

        opt1CardView = v.findViewById(R.id.op1_card_view);
        opt2CardView = v.findViewById(R.id.op2_card_view);
        opt3CardView = v.findViewById(R.id.op3_card_view);
        opt4CardView = v.findViewById(R.id.op4_card_view);
        opt1CardView.setOnClickListener(this);
        opt2CardView.setOnClickListener(this);
        opt3CardView.setOnClickListener(this);
        opt4CardView.setOnClickListener(this);



        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel =  ViewModelProviders.of(this, new QuestionDisplayViewModelFactory("/Questions/Aptitude/Set1")).get(QuestionDisplayViewModel.class);
        LiveData<List<QuestionEntity>> mData = mViewModel.getQuestionList();
       mData.observe(this, new Observer<List<QuestionEntity>>() {
           @Override
           public void onChanged(List<QuestionEntity> questionEntities) {
               if(questionEntities.size()>0){
                   opt1TextView.setText(questionEntities.get(0).getOption1());
                   opt2TextView.setText(questionEntities.get(0).getOption2());
                   opt3TextView.setText(questionEntities.get(0).getOption3());
                   opt4TextView.setText(questionEntities.get(0).getOption4());
                   questionTitleTextView.setText(questionEntities.get(0).getQuestionTitle());

                  // startObjectAnimationTimer();
                   startCountDownTimer();



               }
           }
       });

    }

    private void startCountDownTimer() {
        countDownTimer=new CountDownTimer(120000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress"+ progressBarStatus+ millisUntilFinished);
                progressBarStatus++;
                progressBar.setProgress((int)progressBarStatus*100/(120000/1000));

            }

            @Override
            public void onFinish() {
                //Do what you want
                progressBarStatus++;
                progressBar.setProgress(100);
            }
        };
        countDownTimer.start();
    }

/*
    private void startObjectAnimationTimer(){
        ObjectAnimator animation = ObjectAnimator.ofFloat(progressBar,"progress", 0.0f, 100.0f);
        animation.setDuration(30000);
        animation.setInterpolator(new LinearInterpolator());
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) { }

            @Override
            public void onAnimationEnd(Animator animator) {
                //do something when the countdown is complete
            }

            @Override
            public void onAnimationCancel(Animator animator) { }

            @Override
            public void onAnimationRepeat(Animator animator) { }
        });
        animation.start();
    }
    */

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.op1_card_view:
                break;
            case R.id.op2_card_view:
                break;
            case R.id.op3_card_view:
                break;

            case R.id.op4_card_view:
                break;

                default:
                    break;
        }

    }
}
