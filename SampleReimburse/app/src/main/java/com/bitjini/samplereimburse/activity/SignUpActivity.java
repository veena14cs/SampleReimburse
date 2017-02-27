package com.bitjini.samplereimburse.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.bitjini.samplereimburse.R;
import com.bitjini.samplereimburse.adapter.SignUpAdapter;
import com.bitjini.samplereimburse.data_model.BeanSignUpField;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    Button signInBtn;
    ListView listView;

    SignUpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initViews();

    }

    private void initViews() {
        listView=(ListView) findViewById(R.id.signUp);
        signInBtn=(Button) findViewById(R.id.loginBtn);

        initListener();
        enterDataInList();
    }

    private void initListener() {
        signInBtn.setOnClickListener(this);
    }

    private void enterDataInList() {
        ArrayList<String > values=new ArrayList<>();
        ArrayList<BeanSignUpField> arrayList=new ArrayList<>();
        values.add("Name");
        values.add("");
        values.add("Mobile");
        values.add("Email");
        values.add("Employee Id");
        values.add("");

        for (int i=0;i<values.size();i++)
        {
            BeanSignUpField beanSignUpField=new BeanSignUpField();
            beanSignUpField.setValue(values.get(i));
            arrayList.add(beanSignUpField);
        }
        SignUpAdapter adapter=new SignUpAdapter(getApplicationContext(),arrayList);
        listView.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.loginBtn:
                Intent intent=new Intent(SignUpActivity.this,HomePage.class);
                startActivity(intent);
                break;
        }
    }
}
