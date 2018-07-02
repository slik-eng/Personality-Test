package com.slikengsoft.personalitytest.ui.question;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.slikengsoft.personalitytest.R;
import com.slikengsoft.personalitytest.data.model.Question;
import com.slikengsoft.personalitytest.ui.base.BaseRecyclerViewAdapter;

import java.security.InvalidParameterException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

class QuestionAdapter extends BaseRecyclerViewAdapter<QuestionAdapter.QuestionViewHolder> {
    private View view;

    class QuestionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.main_container_cl)
        ConstraintLayout mMainContainer_cl;
        @BindView(R.id.question_text_tv)
        TextView mQuestionText_tv;
        @BindView(R.id.question_category_tv)
        TextView mQuestionCategory_tv;
        @BindView(R.id.answers_rb)
        RadioGroup mAnswers_rb;
        @BindView(R.id.extra_question_ll)
        LinearLayout mExtraQuestion_ll;
        @BindView(R.id.question2_text_tv)
        TextView mQuestion2Text_tv;
        @BindView(R.id.answer2_et)
        EditText mAnswer2_et;

        public QuestionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    private List<Question> questions;

    public QuestionAdapter(@NonNull List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_question_item, viewGroup, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        QuestionViewHolder vh = (QuestionViewHolder) viewHolder; //safe cast
        Question question = questions.get(i);
        vh.mQuestionText_tv.setText(question.getQuestion());
        vh.mQuestionCategory_tv.setText(question.getCategory());
        if (question.getQuestionType().getType().equalsIgnoreCase(view.getContext().getString(R.string.single_choice))) {
            vh.mAnswers_rb.removeAllViews();
            for (String str : question.getQuestionType().getOptions()) {
                AppCompatRadioButton radioButtonView = new AppCompatRadioButton(view.getContext());
                radioButtonView.setText(str);
                vh.mAnswers_rb.addView(radioButtonView);
            }
        } else if (question.getQuestionType().getType().equalsIgnoreCase(view.getContext().getString(R.string.single_choice_conditional))) {
            vh.mAnswers_rb.removeAllViews();
            for (String str : question.getQuestionType().getOptions()) {
                AppCompatRadioButton radioButtonView = new AppCompatRadioButton(view.getContext());
                radioButtonView.setText(str);
                vh.mAnswers_rb.addView(radioButtonView);
                radioButtonView.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    if (isChecked && buttonView.getText().toString().equalsIgnoreCase(question.getQuestionType().getCondition().getPredicate().getExactEquals().get(1))){
                        vh.mExtraQuestion_ll.setVisibility(View.VISIBLE);
                        vh.mQuestion2Text_tv.setText(question.getQuestionType().getCondition().getIfPositive().getQuestion());
                        vh.mAnswer2_et.setHint("Range in " + question.getQuestionType().getCondition().getIfPositive().getQuestionType().getRange().getFrom() + ":" + question.getQuestionType().getCondition().getIfPositive().getQuestionType().getRange().getTo());
                    } else
                        vh.mExtraQuestion_ll.setVisibility(View.GONE);
                    Log.d(QuestionAdapter.class.getSimpleName(), "isChecked" + isChecked);
                });

            }
        }
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public void replaceData(List<Question> questions) {
        this.questions.clear();
        this.questions.addAll(questions);
        notifyDataSetChanged();
    }

    public Question getItem(int position) {
        if (position < 0 || position >= questions.size()) {
            throw new InvalidParameterException("Invalid item index");
        }
        return questions.get(position);
    }

    public void clearData() {
        questions.clear();
        notifyDataSetChanged();
    }
}
