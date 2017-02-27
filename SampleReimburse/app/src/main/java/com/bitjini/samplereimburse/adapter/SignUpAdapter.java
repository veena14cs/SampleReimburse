package com.bitjini.samplereimburse.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.bitjini.samplereimburse.R;
import com.bitjini.samplereimburse.data_model.BeanSignUpField;

import java.util.ArrayList;

/**
 * Created by bitjini on 23/2/17.
 */

public class SignUpAdapter extends BaseAdapter {
    Holder holder;
    Context mContext;
    String company,gender,ade;
    ArrayList<BeanSignUpField> arrayList=new ArrayList<>();

    LayoutInflater inflater;

    public SignUpAdapter(Context mContext, ArrayList<BeanSignUpField> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(final int i, View rowView, ViewGroup viewGroup)
    {
        final Holder vHolder;
        if (rowView == null) {
            vHolder = new Holder();

            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.signup_info, null);

            vHolder.editText = (EditText) rowView.findViewById(R.id.edit_query);
            vHolder.companyPicker = (Spinner) rowView.findViewById(R.id.companyPicker);
            vHolder.genderPicker = (Spinner) rowView.findViewById(R.id.gender);
            vHolder.agePicker = (Spinner) rowView.findViewById(R.id.age);
            vHolder.layout=(LinearLayout) rowView.findViewById(R.id.layout1);

            rowView.setTag(vHolder);
        }
        else {
            vHolder = (Holder) rowView.getTag();
        }

        vHolder.ref=i;

        switch (i) {
            case 1:
                vHolder.editText.setVisibility(View.GONE);
                vHolder.companyPicker.setVisibility(View.VISIBLE);
                getCompanyPicker(vHolder.companyPicker);
                break;

            case 5:
                vHolder.editText.setVisibility(View.GONE);
                 vHolder.layout.setVisibility(View.VISIBLE);
                getGenderPicker(vHolder.genderPicker);
                getAgePicker(vHolder.agePicker);
                break;

        }

        if (vHolder.textWatcher != null)
            vHolder.editText.removeTextChangedListener(vHolder.textWatcher);

        final BeanSignUpField listItem = arrayList.get(i);
        vHolder.editText.setTag(vHolder.ref);
        vHolder.companyPicker.setTag(vHolder.ref);
        // Keep a reference to the TextWatcher so that we can remove it later
        vHolder.textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int pos = (int) vHolder.editText.getTag();
                if(pos==1)
                {
                    vHolder.editText.setVisibility(View.GONE);
                    vHolder.companyPicker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?>parent, View view, int position, long arg3) {

                            company= parent.getItemAtPosition(position).toString();
                            listItem.value=company;
                            Log.e("country=",""+listItem.value);
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                            // TODO Auto-generated method stub
                        }
                    });
                }
                if(pos==5)
                {
                    vHolder.editText.setVisibility(View.GONE);
                    vHolder.genderPicker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?>parent, View view, int position, long arg3) {
                           String gender= parent.getItemAtPosition(position).toString();
                            listItem.value=gender;
                            Log.e("gender=",""+listItem.value);

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                            // TODO Auto-generated method stub
                        }
                    });
                    vHolder.agePicker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?>parent, View view, int position, long arg3) {
                           String age= parent.getItemAtPosition(position).toString();
                            listItem.value=age;
                            Log.e("age=",""+listItem.value);
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                            // TODO Auto-generated method stub
                        }
                    });
                }
                else {
                    listItem.value=s.toString();
                    System.out.print("address fields="+listItem.value);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        vHolder.editText.addTextChangedListener(vHolder.textWatcher);
        vHolder.editText.setHint(listItem.value);
        System.out.println("List item values : " + listItem.value);
        return rowView;
    }
    private void getCompanyPicker(Spinner companyPicker)
    {
        String []  array_spinner = mContext.getResources().getStringArray(R.array.company_arrays);
        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_spinner_item, array_spinner);
        companyPicker.setAdapter(adapter);
        companyPicker.setSelection(adapter.getPosition("Bitjini"));
    }
    private void getGenderPicker(Spinner companyPicker)
    {
        String []  array_spinner = mContext.getResources().getStringArray(R.array.gender);
        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_spinner_item, array_spinner);
        companyPicker.setAdapter(adapter);
        companyPicker.setSelection(adapter.getPosition("Male"));
    }
    private void getAgePicker(Spinner companyPicker)
    {
        String []  array_spinner = mContext.getResources().getStringArray(R.array.age);
        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_spinner_item, array_spinner);
        companyPicker.setAdapter(adapter);
        companyPicker.setSelection(adapter.getPosition("24"));
    }
    class Holder {
        EditText editText;
        TextWatcher textWatcher;
        Spinner companyPicker,genderPicker,agePicker;
        LinearLayout layout;
        int ref;
    }

}
