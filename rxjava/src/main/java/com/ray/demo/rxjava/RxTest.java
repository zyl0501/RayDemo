package com.ray.demo.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 创建时间：2016/8/25
 *
 * @author zyl
 */
public class RxTest {
  public static void main(String[] args) {
    Observable<String> disk = Observable.just("d1")
        .doOnNext(new Action1<String>() {
          @Override
          public void call(String s) {
            System.out.println("disk do on next " + s);
          }
        });

    Observable<String> remote = Observable.just(1)
        .map(new Func1<Integer, String>() {
          @Override
          public String call(Integer integer) {
            return "remote "+ integer;
          }
        })
        .doOnNext(new Action1<String>() {
          @Override
          public void call(String s) {
            System.out.println("remote do on next " + s);
          }
        });

    Observable<String> obs = Observable.concat(disk, remote);
    obs.first(new Func1<String, Boolean>() {
          @Override
          public Boolean call(String s) {
            return "d1".equals(s);
          }
        })
        .subscribe(new Subscriber<String>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {

          }

          @Override
          public void onNext(String s) {
            System.out.println("concat do on next " + s);
          }
        });
  }
}
