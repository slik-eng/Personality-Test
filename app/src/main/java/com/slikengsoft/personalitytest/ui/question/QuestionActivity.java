package com.slikengsoft.personalitytest.ui.question;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.slikengsoft.personalitytest.R;
import com.slikengsoft.personalitytest.data.model.Question;
import com.slikengsoft.personalitytest.di.component.AppComponent;
import com.slikengsoft.personalitytest.di.component.DaggerQuestionComponent;
import com.slikengsoft.personalitytest.di.module.QuestionModule;
import com.slikengsoft.personalitytest.ui.base.BaseActivity;
import com.slikengsoft.personalitytest.ui.base.Presenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionActivity extends BaseActivity implements QuestionPresenter.View {
    @BindView(R.id.question_rv)
    RecyclerView mQuestionRecyclerView;
    @BindView(R.id.progress)
    ProgressBar mProgressBar;
    @BindView(R.id.category_s)
    Spinner mCategory_s;
    Toast toast;
    ArrayList<Question> questionArrayList = null;
    private static final String TAG = QuestionActivity.class.getSimpleName();


    private QuestionAdapter mQuestionAdapter;
    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerQuestionComponent.builder()
                .appComponent(appComponent)
                .questionModule(new QuestionModule(this))
                .build()
                .inject(this);
    }

    private void init() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mQuestionRecyclerView.setVisibility(View.INVISIBLE);
        mCategory_s.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mQuestionRecyclerView.setVisibility(View.VISIBLE);
        mCategory_s.setVisibility(View.VISIBLE);
    }

    @Override
    public void showQuestions(List<Question> questions) {
        questionArrayList = (ArrayList<Question>) questions;
        mQuestionAdapter = new QuestionAdapter(new ArrayList<>());
        mQuestionAdapter.setQuestions(questions);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mQuestionRecyclerView.setLayoutManager(layoutManager);
        Collections.sort(questions, (o1, o2) -> o1.getCategory().compareTo(o2.getCategory()));
        mQuestionRecyclerView.setAdapter(mQuestionAdapter);
        mQuestionRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mQuestionAdapter.setOnItemClickListener((view, position) -> presenter.onItemSelected(mQuestionAdapter.getItem(position), position));
    }

    @Override
    public void showMessage(String message) {
        toast = new Toast(this);
        toast.cancel();
        toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCategories(List<String> categories) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categories);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCategory_s.setAdapter(adapter);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.questions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_reset:
                mQuestionAdapter.clearData();
                presenter.onResume();
                return true;
            case R.id.action_submit:
                Toast.makeText(this, "To submit the data to api once available", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
