package com.example.checkboxcherepanov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        buttonAct();
    }

    private void init() {
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        mBtnOk = findViewById(R.id.btnOK);
        mBankCardChkBx = findViewById(R.id.bankCardChB);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChB);
        mCashAddressChkBx = findViewById(R.id.cashAddressChB);

        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
    }

    private void resetCheckBoxes() {
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.bankCardChB:
                        resetCheckBoxes();
                        mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        mBankCardChkBx.setChecked(true);
                        break;
                    case R.id.mobilePhoneChB:
                        resetCheckBoxes();
                        mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        mMobilePhoneChkBx.setChecked(true);
                        break;
                    case R.id.cashAddressChB:
                        resetCheckBoxes();
                        mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        mCashAddressChkBx.setChecked(true);
                        break;
                    default:
                        mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        mCashAddressChkBx.setChecked(true);
                }
            }
        }
    };

    private void buttonAct() {

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast();
            }
        });
    }

    private void makeToast() {
        mBankCardChkBx = findViewById(R.id.bankCardChB);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChB);
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        String messageTransferredBy;

        if (mBankCardChkBx.isChecked() == true) {
            messageTransferredBy = "card";
        }
        else if (mMobilePhoneChkBx.isChecked() == true) {
            messageTransferredBy = "phone";
        }
        else {
            messageTransferredBy = "cash to typed address";
        }

        final Toast toast = Toast.makeText(this,
                getString(R.string.toast_message,
                        mInputMoney.getText().toString(),
                        mInputInfo.getText().toString(),
                        messageTransferredBy),
                Toast.LENGTH_LONG);
        toast.show();
    }
}
