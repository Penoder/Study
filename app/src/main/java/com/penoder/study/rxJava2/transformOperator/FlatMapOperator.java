package com.penoder.study.rxJava2.transformOperator;

import android.util.Log;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/9/18.
 */
public class FlatMapOperator {

    /**
     * FlatMap 将一个发送事件的上游 Observable 变换为多个发送事件的 Observables，
     * 然后将它们发射的事件合并后放进一个单独的Observable里.
     *
     * 上游每发送一个事件, flatMap都将创建一个新的水管, 然后发送转换之后的新的事件,
     * 下游接收到的就是这些新的水管发送的数据. 这里需要注意的是,
     * flatMap并不保证事件的顺序, 如果需要保证顺序则需要使用concatMap.
     *
     * 作者：Season_zlc
     * 链接：http://www.jianshu.com/p/128e662906af
     */
    public void method() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(23333);
                e.onNext(66666);
                e.onNext(55555);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {   // 重载方法很多啊
            @Override
            public ObservableSource apply(Integer integer) throws Exception {
                List<String> arr = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    arr.add("嗡嘛呢呗咪吽  ॐ मणि पद्मे हूँ  " + integer);
                }
                return Observable.fromIterable(arr);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i("FlatMapOperator", "accept: +++++++++++++++     " + s);
            }
        });
    }
}
