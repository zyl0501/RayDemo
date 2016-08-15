package com.ray.demo.rxjava;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Ray on 16/2/16.
 */
public class RxJavaMainActivity extends AppCompatActivity {
    private static final String tag = "RxJavaMainActivity";

    TextView consoleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_main);
        consoleTv = (TextView) findViewById(R.id.console_tv);
        Observable.create(Observer::onCompleted);
    }

    public void click_Subscribe(View view) {
        consoleTv.setText(null);
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
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
            public void onNext(String s) {
                consoleTv.append("Item: " + s);
                consoleTv.append("\n");
            }

            @Override
            public void onCompleted() {
                consoleTv.append("Completed!");
                consoleTv.append("\n");
            }

            @Override
            public void onError(Throwable e) {
                consoleTv.append("Error!");
                consoleTv.append("\n");
            }
        };
        //observable.subscribe(observer);

        Action1<String> onNextAction = new Action1<String>() {
            // onNext()
            @Override
            public void call(String s) {
                consoleTv.append(s);
                consoleTv.append("\n");
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            // onError()
            @Override
            public void call(Throwable throwable) {
                // Error handling
            }
        };
        Action0 onCompletedAction = new Action0() {
            // onCompleted()
            @Override
            public void call() {
                consoleTv.append("Completed!");
                consoleTv.append("\n");
            }
        };

        // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
        observable.subscribe(onNextAction);
        // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
        observable.subscribe(onNextAction, onErrorAction);
        // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);
    }

    public void click_Schedule(View view) {
        consoleTv.setText(null);
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        consoleTv.append("number:" + number);
                        consoleTv.append("\n");
                    }
                });


        final int drawableRes = R.mipmap.ic_android;
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getResources().getDrawable(drawableRes);
                drawable.setBounds(0, 0, 200, 200);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Observer<Drawable>() {
                    @Override
                    public void onNext(Drawable drawable) {
                        consoleTv.append("[img]");
                        consoleTv.append("\n");
                        SpannableString spannableString = new SpannableString(consoleTv.getEditableText());
                        int index = consoleTv.getEditableText().toString().indexOf("[img]");
                        spannableString.setSpan(new ImageSpan(drawable), index, index + 5, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                        consoleTv.setText(spannableString);
                        consoleTv.setMovementMethod(LinkMovementMethod.getInstance());
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RxJavaMainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void click_Map(View view) {
        consoleTv.setText(null);
        Observable.just("images/logo.png") // 输入类型 String
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String filePath) { // 参数类型 String
                        return R.mipmap.ic_android; // 返回类型 Bitmap
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer drawableRes) { // 参数类型 Bitmap
                        consoleTv.append("[img]");
                        consoleTv.append("\n");
                        Drawable drawable = getResources().getDrawable(drawableRes);
                        drawable.setBounds(0, 0, 200, 200);
                        SpannableString spannableString = new SpannableString(consoleTv.getEditableText());
                        int index = consoleTv.getEditableText().toString().indexOf("[img]");
                        spannableString.setSpan(new ImageSpan(drawable), index, index + 5, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                        consoleTv.setText(spannableString);
//                        consoleTv.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                });
    }

    public void click_FlatMap(View view) {
        consoleTv.setText(null);

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer course) {
                consoleTv.append("" + course);
            }
        };

        Observable.from(new String[]{"a", "b"})
                .flatMap(new Func1<String, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(String str) {
                        if ("a".equals(str)) {
                            return Observable.from(new Integer[]{11, 12});
                        }
                        if ("b".equals(str)) {
                            return Observable.from(new Integer[]{21, 22});
                        }

                        return null;
                    }
                })
                .subscribe(subscriber);
    }

    public void click_Defer(View view){
        Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just("a", "b");
            }
        });
    }

    public void click_Timer(View view){
        Observable.timer(2, TimeUnit.SECONDS,AndroidSchedulers.mainThread())
                .map(new Func1<Long, Object>() {
                    @Override
                    public Object call(Long aLong) {
                        return null;
                    }
                });

        Observable.interval(2,2,TimeUnit.SECONDS);
    }

    public void click_Repeat(View view){
        Observable.range(3,3).repeat(new Scheduler() {
            @Override
            public Worker createWorker() {
                return null;
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Sequence complete.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error:" + e.getMessage());
            }

            @Override
            public void onNext(Integer i) {
                System.out.println("Next:" + i.toString());
            }
        });
    }
}
