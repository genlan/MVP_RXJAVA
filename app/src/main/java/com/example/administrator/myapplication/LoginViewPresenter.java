package com.example.administrator.myapplication;

import android.text.TextUtils;
import android.util.Log;

import com.example.bean.UserInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
<<<<<<< Updated upstream
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
=======
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
>>>>>>> Stashed changes


/**
 * Created by Administrator on 2015/12/22.
 */
public class LoginViewPresenter implements ILoginViewPresenter {
    private static final String WEATHRE_API_URL = "http://apistore.baidu.com/microservice/weather?cityid=101230201";
    private Views loginView;
    public LoginViewPresenter(Views loginView) {
        this.loginView = loginView;

    }
    @Override
    public void clear() {
        loginView.clearUserName();
        loginView.clearPassword();
    }


    @Override
    public void login(final String username, final String pwd) {
        loginView.showLoading();


<<<<<<< Updated upstream


=======
        /**
         * 以下是Observable不同的例子  可以先跳过  start
         */
>>>>>>> Stashed changes
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e("observer", "onCompleted " );
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String o) {
                loginView.setUserName(o.toString()) ;
                Log.e("observer", "Item: " + o.toString());
            }
        };
        Subscriber subscriber = new Subscriber() {
            @Override
            public void onCompleted() {
                Log.e("subscriber", "onCompleted ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                loginView.setUserName(o.toString()) ;
                Log.e("subscriber", "Item: " + o.toString());
            }
        };
        observable.subscribe(observer);
        observable.subscribe(subscriber);



        Observable observable1 = Observable.just("123","456","789");
        observable1.subscribe(observer);
        observable1.subscribe(subscriber);//此方法不行

        String[] word = {"a","b","c"};
        Observable observable2 = Observable.from(word);
        observable2.subscribe(observer);
        observable2.subscribe(subscriber);//此方法不行



        Observable.just("123").map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return Integer.parseInt(s);
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer o) {
                loginView.setUserName(o + "");
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        }, new Action0() {
            @Override
            public void call() {

            }
        });




        ArrayList<UserInfo> userInfoArrayList = new ArrayList<UserInfo>();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("aaa");
        userInfoArrayList.add(userInfo);
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUsername("bbb");
        userInfoArrayList.add(userInfo2);
        Observable.from(userInfoArrayList).flatMap(new Func1<UserInfo, Observable<String>>() {
            @Override
            public Observable<String> call(UserInfo userInfo) {
                return Observable.just(userInfo.getUsername());
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                loginView.setUserName(s.toString());
                Log.e("subscriber  onNext", "Item: " + s.toString());
            }
        });



        Observable.merge(new Iterable<Observable<?>>() {
            @Override
            public Iterator<Observable<?>> iterator() {
                return null;
            }
        });
<<<<<<< Updated upstream

//        rx.Observable.create(new OnSubscribe<Object>() {
//            @Override
//            public void call(Subscriber<? super Object> subscriber) {
//
//                if (subscriber.isUnsubscribed()) return;
//
//                try {
//                    //1 发布事件通知订阅者
//                    subscriber.onNext(getWeather());
//                    //2 事件通知完成
//                    subscriber.onCompleted();
//                } catch (Exception e) {
//                    //3 出现异常，通知订阅者
//                    subscriber.onError(e);
//                }
//            }
//        }).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Object>() {
//                    @Override
//                    public void onCompleted() {
//                        //对应上面的第2点：subscriber.onCompleted();
//                        //这里写事件发布完成后的处理逻辑
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        //对应上面的第3点：subscriber.onError(e);
//                        //这里写出现异常后的处理逻辑
//                        loginView.showFailedError();
//                        loginView.hideLoading();
//                    }
//
//                    @Override
//                    public void onNext(Object o) {
//                        //对应上面的第1点：subscriber.onNext(weather);
//                        //这里写获取到某一个事件通知后的处理逻辑
//                        if (o != null){
//                            loginView.setUserName(o.toString()) ;
//                            loginView.hideLoading();
//                        }
//
//
//                    }
//                });
=======
    /****end******************************************************************************************/

        rx.Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {

                if (subscriber.isUnsubscribed()) return;

                try {
                    //1 发布事件通知订阅者
                    subscriber.onNext(getWeather());
                    //2 事件通知完成
                    subscriber.onCompleted();
                } catch (Exception e) {
                    //3 出现异常，通知订阅者
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {
                        //对应上面的第2点：subscriber.onCompleted();
                        //这里写事件发布完成后的处理逻辑
                    }

                    @Override
                    public void onError(Throwable e) {
                        //对应上面的第3点：subscriber.onError(e);
                        //这里写出现异常后的处理逻辑
                        loginView.showFailedError();
                        loginView.hideLoading();
                    }

                    @Override
                    public void onNext(Object o) {
                        //对应上面的第1点：subscriber.onNext(weather);
                        //这里写获取到某一个事件通知后的处理逻辑
                        if (o != null){
                            loginView.setUserName(o.toString()) ;
                            loginView.hideLoading();
                        }


                    }
                });
>>>>>>> Stashed changes



    }




    private String getWeather() throws Exception {
        BufferedReader reader = null;
        HttpURLConnection connection = null;
        try {

            String urlString = String.format(WEATHRE_API_URL );
            URL url = new URL(urlString);
            connection = (HttpURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestMethod("GET");
            connection.setReadTimeout(6000);
            //连接
            connection.connect();

            //处理返回结果
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while (!TextUtils.isEmpty(line = reader.readLine()))
                buffer.append(line);
            return buffer.toString();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
