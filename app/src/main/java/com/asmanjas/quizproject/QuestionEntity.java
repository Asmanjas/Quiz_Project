package com.asmanjas.quizproject;

import android.os.Build;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class QuestionEntity {
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String duration;
    private String explanation;
    private int marksForQuestion;
    private String correctAnswer;

    public QuestionEntity() {
    }

    public QuestionEntity(Builder builder){
        this.questionTitle = builder.questionTitle;
        this.option1 = builder.option1;
        this.option2 = builder.option2;
        this.option3 = builder.option3;
        this.option4 = builder.option4;
        this.duration = builder.duration;
        this.explanation = builder.explanation;
        this.marksForQuestion = builder.marksForQuestion;
        this.correctAnswer = builder.correctAnswer;
    }


    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getDuration() {
        return duration;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getMarksForQuestion() {
        return marksForQuestion;
    }

    public static class Builder{
        private String questionTitle;
        private String option1;
        private String option2;
        private String option3;
        private String option4;
        private String duration;
        private String explanation;
        private int marksForQuestion;
        private String correctAnswer;

        public Builder() {
        }

        public Builder setQuestionTitle(String questionTitle) {
            this.questionTitle = questionTitle;
            return this;
        }

        public Builder setOption1(String option1) {
            this.option1 = option1;
            return this;
        }

        public Builder setOption2(String option2) {
            this.option2 = option2;
            return this;
        }

        public Builder setOption3(String option3) {
            this.option3 = option3;
            return this;
        }

        public Builder setOption4(String option4) {
            this.option4 = option4;
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public Builder setExplanation(String explanation) {
            this.explanation = explanation;
            return this;

        }

        public Builder setMarksForQuestion(int marksForQuestion) {
            this.marksForQuestion = marksForQuestion;
            return this;
        }

        public Builder setCorrectAnswer(String correctAnswer) {
            this.correctAnswer = correctAnswer;
            return this;
        }

        public QuestionEntity build(){
            return new QuestionEntity(this);
        }
    }
}
