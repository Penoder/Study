package com.penoder.study.rxJava2.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.penoder.study.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 在RxJava中, 已经内置了很多线程选项供我们选择, 例如有
 *      Schedulers.io() 代表io操作的线程, 通常用于网络,读写文件等io密集型的操作
 *      Schedulers.computation() 代表CPU计算密集型的操作, 例如需要大量计算的操作
 *      Schedulers.newThread() 代表一个常规的新线程
 *      AndroidSchedulers.mainThread() 代表Android的主线程
 *
 *  作者：Season_zlc
 *  链接：http://www.jianshu.com/p/8818b98c44e2
 */
public class ThreadDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvShowScreen;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;

    private Observable observable;
    private Observer observer;
    private Consumer consumer;

    /**
     * 注意，所有的线程信息是 放在 TextView 中显示的，但是 main 线程之外不能更新 UI 操作
     * 所以建议将 TextView 换成 Log 打印日志信息
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_one);

        tvShowScreen = (TextView) findViewById(R.id.tvShowScreen);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);

        initRxJava();
    }

    private void initRxJava() {
        observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                tvShowScreen.setText(tvShowScreen.getText() + "\n\nObservable 的线程是: " + Thread.currentThread().getName());
                emitter.onNext(1);
            }
        });

        observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                tvShowScreen.setText(tvShowScreen.getText() + "\n\nObserver 的线程是: " + Thread.currentThread().getName() );
            }

            @Override
            public void onNext(Object value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        consumer = new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                tvShowScreen.setText(tvShowScreen.getText() + "\n\nConsumer 的线程是: " + Thread.currentThread().getName() );
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOne:
                tvShowScreen.setText("");
                /**
                 * 默认都是处在 main 线程中
                 */
                observable.subscribe(observer);
                break;
            case R.id.btnTwo:
                tvShowScreen.setText("");
                /**
                 * Observer 线程是 main
                 * Observable 线程是 RxCachedThreadScheduler - 1
                 */
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(observer);
                break;
            case R.id.btnThree:
                tvShowScreen.setText("");
                /**
                 * Observer 线程是 main
                 * Observable 线程是 RxNewThreadScheduler - 1
                 */
                observable.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(observer);
                break;
            case R.id.btnFour:
                tvShowScreen.setText("");
                /**
                 * 问题：是因为观察者和被观察者不能够同时在非主线程中吗？
                 * 下面的观察者和被观察者在 io() 线程和 newThread() 中去组合，
                 * 无论怎么样搭配都是打印的 Observer 在主线程 main 中，
                 * 而 Observable 在对应设置的 io() 或 newThread() 中
                 */
                observable.subscribeOn(Schedulers.newThread())
                        .observeOn(Schedulers.newThread())
                        .subscribe(observer);
                break;
            case R.id.btnFive:  // 多次指定 Observable 线程
                tvShowScreen.setText("");
                /**
                 * Observer 线程是 main
                 * Observable 线程是 RxCachedThreadScheduler - 1
                 * 所以表示的是 Observable 切换线程之后，采用的还是第一次指定的线程
                 */
                observable.subscribeOn(Schedulers.io())
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(observer);
                break;
            case R.id.btnSix:   // 多次指定 Observer 线程
                tvShowScreen.setText("");
                /**
                 * 关于 Observer 的线程切换，没调用一次 observeOn() 都会切换一次线程，
                 * 所以下面打印出来的是
                 * Observable 线程 main
                 * consumer 1 线程 RxNewThreadScheduler
                 * consumer 2 线程 main
                 * consumer 3 线程 RxCachedThreadScheduler
                 * 最后 subscribe() 订阅的 consumer 线程 RxCachedThreadScheduler
                 * 如果 subscribe() 订阅的是 Observer， 那么打印的 Observer 线程是 main
                 * so,,,,,,,, why consumer is different from Observer
                 */
                observable.subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(Schedulers.newThread())
                        .doOnNext(new Consumer() {
                            @Override
                            public void accept(Object o) throws Exception {
                                tvShowScreen.setText(tvShowScreen.getText() + "\n\nConsumer11111 的线程是: " + Thread.currentThread().getName() );
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(new Consumer() {
                            @Override
                            public void accept(Object o) throws Exception {
                                tvShowScreen.setText(tvShowScreen.getText() + "\n\nConsumer22222 的线程是: " + Thread.currentThread().getName() );
                            }
                        })
                        .observeOn(Schedulers.io())
                        .doOnNext(new Consumer() {
                            @Override
                            public void accept(Object o) throws Exception {
                                tvShowScreen.setText(tvShowScreen.getText() + "\n\nConsumer33333 的线程是: " + Thread.currentThread().getName());
                            }
                        })
                        .subscribe(observer);
                break;
            case R.id.btnSeven:   // 多次指定 Observer 线程
                tvShowScreen.setText("");
                observable.subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(Schedulers.newThread())
                        .doOnNext(new Consumer() {
                            @Override
                            public void accept(Object o) throws Exception {
                                tvShowScreen.setText(tvShowScreen.getText() + "\n\nConsumer11111 的线程是: " + Thread.currentThread().getName() );
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(new Consumer() {
                            @Override
                            public void accept(Object o) throws Exception {
                                tvShowScreen.setText(tvShowScreen.getText() + "\n\nConsumer22222 的线程是: " + Thread.currentThread().getName() );
                            }
                        })
                        .observeOn(Schedulers.io())
                        .doOnNext(new Consumer() {
                            @Override
                            public void accept(Object o) throws Exception {
                                tvShowScreen.setText(tvShowScreen.getText() + "\n\nConsumer33333 的线程是: " + Thread.currentThread().getName());
                            }
                        })
                        .subscribe(consumer);
                break;
        }
    }

    /**
     * 关于RxJava的线程，有很多的应用场景，例如操作数据库、网络请求等，main线程更新UI操作；
     * 但是在请求的过程中 如果 Activity 已经退出, 这个时候如果回到主线程去更新UI,
     * 那么APP肯定就崩溃了, 关于 Observer中的Disposable , 说它是个开关,
     * 调用它的dispose()方法时就会切断水管, 使得下游收不到事件, 既然收不到事件,
     * 那么也就不会再去更新UI了. 因此我们可以在Activity中将这个Disposable 保存起来, 当Activity退出时, 切断它即可.
     *
     * 那如果有多个Disposable 该怎么办呢, RxJava中已经内置了一个容器CompositeDisposable,
     * 每当我们得到一个Disposable时就调用CompositeDisposable.add()将它添加到容器中,
     * 在退出的时候, 调用CompositeDisposable.clear() 即可切断所有的水管.
     *
     * 作者：Season_zlc
     * 链接：http://www.jianshu.com/p/8818b98c44e2
     */
}
