package com.penoder.study.rxJava2;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by asus on 2017/8/22.
 */

public class RxDemo_1 {

    public RxDemo_1() {     // 使用RxJava三部曲
        new Observable<String>() {  // 1.初始化一个 被观察者
            @Override
            protected void subscribeActual(Observer<? super String> observer) {
                observer.onNext("6666666666666666");
                observer.onNext("2333333333333333");
                observer.onNext("5555555555555555");
                observer.onComplete();
            }
            // 3.被观察者 订阅 观察者
        }.subscribe(new Observer<String>() {    // 2.创建一个观察者
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("Pen:RxDemo_1", "Rocoder：onSubscribe：");
            }

            @Override
            public void onNext(String value) {
                Log.i("Pen:RxDemo_1", "Rocoder：onNext：----  " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("Pen:RxDemo_1", "Rocoder：onError： ---  " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i("Pen:RxDemo_1", "Rocoder：onComplete：");
            }
        });
    }

}
