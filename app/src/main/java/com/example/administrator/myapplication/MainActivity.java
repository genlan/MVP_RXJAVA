package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bean.UserInfo;

public class MainActivity extends AppCompatActivity implements ILoginViewPresenter.Views, View.OnClickListener {

    private EditText mTVUserName,mEDPwd;
    private  View mProBar;
    private ILoginViewPresenter mLoginViewPresenter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginViewPresenter = new LoginViewPresenter(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initUI();

    }


//初始化
    private void initUI() {
        mTVUserName = (EditText) findViewById(R.id.editText);
        mEDPwd = (EditText)findViewById(R.id.editText2);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        mProBar = findViewById(R.id.progressBar);

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public String getUserName() {
        return mTVUserName.getText().toString();
    }

    @Override
    public String getPwd() {
        return mEDPwd.getText().toString();
    }

    @Override
    public void setUserName(String userName) {
        mTVUserName.setText(userName);
    }

    @Override
    public void setPwd(String pwd) {

    }

    @Override
    public void clearUserName() {
        mTVUserName.setText("");
    }

    @Override
    public void clearPassword() {
        mEDPwd.setText("");
    }

    @Override
    public void showLoading() {
        mProBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(UserInfo user) {
        Toast.makeText(this, user.getUsername()+user.getPwd(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                mLoginViewPresenter.login(getUserName(),getPwd());
                break;
            case R.id.button2:
                mLoginViewPresenter.clear();
                break;
            default:
                break;
        }
    }
}
