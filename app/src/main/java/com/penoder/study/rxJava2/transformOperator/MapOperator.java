package com.penoder.study.rxJava2.transformOperator;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * map是RxJava中最简单的一个变换操作符了,
 * 它的作用就是对上游发送的每一个事件应用一个函数,
 * 使得每一个事件都按照指定的函数去变化
 *
 * Created by dell on 2017/9/18.
 */
public class MapOperator {

    /**
     * 采用 Map 操作符 将上游发送的 Integer 类型的数据转换成为 String 类型的数据 传递给下游
     *
     * 但是怎么对应每一个 onNext() 执行一个 map 的方法呢？
     */
    public void methodOne() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(23333);
                emitter.onNext(55555);
                emitter.onNext(66666);
                emitter.onComplete();
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "噜啦啦撸啦咧噜啦噜啦咧 " + integer;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Log.i("MapOperator", "onNext:--------   " + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

}
