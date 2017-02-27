package com.bitjini.samplereimburse.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bitjini.samplereimburse.R;

public class HomePage extends DrawerBaseActivity implements View.OnClickListener {

    Button scanBillBtn,pendingBillBtn,historyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        intitViews();



    }

    private void intitViews() {
        scanBillBtn=(Button)findViewById(R.id.scanBill_or_addBill_btn);
        pendingBillBtn=(Button)findViewById(R.id.pendingBill_button);
        historyBtn=(Button)findViewById(R.id.history_button);

        initListener();
    }

    private void initListener() {
        scanBillBtn.setOnClickListener(this);
        pendingBillBtn.setOnClickListener(this);
        historyBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId())
        {
            case R.id.scanBill_or_addBill_btn:
                 intent=new Intent(HomePage.this,ScanAddBill_Activity.class);
                startActivity(intent);
                break;
            case R.id.pendingBill_button:
                break;
            case R.id.history_button:
                intent=new Intent(HomePage.this,History_Activity.class);
                startActivity(intent);
                break;
        }

    }
}
