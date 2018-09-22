package com.karawalaya.alliantbankapp.ACTIVITIES_FRAGMENTS.user_management;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

;
import com.karawalaya.alliantbankapp.DAO_SERVICE.user_management.UserManagementDAO;
import com.karawalaya.alliantbankapp.POJO_MODEL.user_management.UMValidator;
import com.karawalaya.alliantbankapp.POJO_MODEL.user_management.User;
import com.karawalaya.alliantbankapp.R;

/**
 * Created by delaroy on 3/27/17.
 */
public class Register extends AppCompatActivity implements View.OnClickListener {

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutAccountNo;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;

    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextAccountNo;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;

    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView appCompatTextViewLoginLink;

    UserManagementDAO umdao = null;
    UMValidator umv = null;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutAccountNo = (TextInputLayout) findViewById(R.id.textInputLayoutAccountNo);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmPassword = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextAccountNo = (TextInputEditText) findViewById(R.id.textInputEditTextAccountNo);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);

        appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);
    }

    private void initListeners() {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);
    }

    private void initObjects() {
        umv = new UMValidator(this);
        umdao = new UserManagementDAO(this);
        user = new User();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonRegister:
                postDataToSQLite();
                break;
            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
        }
    }

    private void postDataToSQLite() {
        if (!umv.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, "name not filled")) {
            return;
        }
        if (!umv.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, "email not filled")) {
            return;
        }
        if (!umv.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, "wrong email")) {
            return;
        }
        if (!umv.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, "password not filled")) {
            return;
        }
        if (!umv.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                textInputLayoutConfirmPassword, "passwords do not match")) {
            return;
        }
        if(umdao.seeWhetherPhysicallyRegistered(textInputEditTextEmail.getText().toString().trim(), textInputEditTextAccountNo.getText().toString())){
            Toast.makeText(this, "FOUNDDDD!", Toast.LENGTH_LONG).show();
        }

/*        if (!umdao.checkUser(textInputEditTextEmail.getText().toString().trim())) {

            user.setName(textInputEditTextName.getText().toString().trim());
            user.setEmail(textInputEditTextEmail.getText().toString().trim());
            user.setPassword(textInputEditTextPassword.getText().toString().trim());

            boolean bool = umdao.addUser(user);

            if(bool) {
                // Snack Bar to show success message that record saved successfully
                Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
                emptyInputEditText();

            } else {
                // Snack Bar to show success message that record saved successfully
                Snackbar.make(nestedScrollView, "NOPE", Snackbar.LENGTH_LONG).show();
                emptyInputEditText();
            }


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }*/


    }

    private void emptyInputEditText() {
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
    }
}