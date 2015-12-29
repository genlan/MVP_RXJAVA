package com.example.administrator.myapplication;

import com.example.bean.UserInfo;

/**
 * Created by Administrator on 2015/12/22.
 */
public interface ILoginViewPresenter {

    void login(String username,String pwd );

    void clear();

    interface Views {
        String getUserName();

        String getPwd();

        void setUserName(String userName);

        void setPwd(String pwd);

        void clearUserName();

        void clearPassword();

        void showLoading();

        void hideLoading();

        void toMainActivity(UserInfo user);

        void showFailedError();

    }

}
