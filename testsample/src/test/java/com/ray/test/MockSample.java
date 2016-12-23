package com.ray.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * 创建时间：2016/12/23
 *
 * @author zyl
 */
public class MockSample {
  @Mock
  List<String> mockedList;

  @Before
  public void setup() {
    //初始化@Mock注解的对象 (进行注入)
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testAdd() {
    //使用Mock对象
    mockedList.add("one");
    mockedList.clear();

    //验证函数的调用次数
    verify(mockedList).add("one");
//    verify(mockedList).add("two"); //无此操作，验证 failed
    verify(mockedList).clear();
  }

  @Test
  public void testWhen() {
    //测试桩，在调用get(0)时返回"first"
    when(mockedList.get(0)).thenReturn("first");
    //调用get(1)时抛出异常
    when(mockedList.get(1)).thenThrow(new RuntimeException());

    System.out.println(mockedList.toString());
    System.out.println("size: " + mockedList.size());
    //输出first
    System.out.println(mockedList.get(0));
    //抛出异常
//    System.out.println(mockedList.get(1));
    //因为get(999)没有打桩，因此输出null
    System.out.println(mockedList.get(999));
  }

  @Test
  public void testAny() {
    //使用内置的anyInt()参数匹配器，当调用get(int)时都返回"element"
    when(mockedList.get(anyInt())).thenReturn("element");
    //使用自定义的参数器(在inValid()函数中返回你自己的匹配器实现)
    //when(mockedList.get(isValid())).thenReturn("element");

    //输出element
    System.out.println(mockedList.get(999));
    //也可以验证匹配器
    verify(mockedList).get(anyInt());
  }

  @Test
  public void testTimes() {
    mockedList.add("once");

    mockedList.add("twice");
    mockedList.add("twice");

    mockedList.add("three times");
    mockedList.add("three times");
    mockedList.add("three times");

    //下面两个的验证结果一样，因为verify默认验证的就是times(1)
    verify(mockedList).add("once");
    verify(mockedList, times(1)).add("once");

    //验证具体的执行次数
    verify(mockedList, times(2)).add("twice");
    verify(mockedList, times(3)).add("three times");

    //使用never验证，never相当于time(0)
    verify(mockedList, never()).add("never happened");

    //使用atLeast()/atMost
    verify(mockedList, atLeastOnce()).add("three times");
    verify(mockedList, atLeast(2)).add("twice");
    verify(mockedList, atMost(5)).add("three times");

    List mockTwo = mock(List.class);
    //验证Mock对象没有交互过
    //如果mockedList在@Before已交互过，验证则不通过
    verifyZeroInteractions(mockedList);
    verifyZeroInteractions(mockTwo); //mockTwo没有交互过
  }

  @Test
  public void testChain() {
    when(mockedList.get(anyInt()))
        .thenReturn("one")
        .thenReturn("two")
        .thenReturn("three");
    //另外，连续调用的另一种更简短的方式
    when(mockedList.get(anyInt()))
        .thenReturn("one", "two", "three");

    //第一次调用:输出"one"
    System.out.println(mockedList.get(0));
    //第二次调用:输出"two"
    System.out.println(mockedList.get(1));
    //第三次调用:输出"three"
    System.out.println(mockedList.get(2));
    //第四次调用:输出"three"
    System.out.println(mockedList.get(3));
  }

  @Test
  public void testAnswer() {
    when(mockedList.get(anyInt())).thenAnswer(new Answer<String>() {
      @Override
      public String answer(InvocationOnMock invocation) throws Throwable {
        //获取函数调用的参数
        Object[] args = invocation.getArguments();
        //获得Mock对象本身
        Object mock = invocation.getMock();
        return "answer===>" + args[0] + " " + mock.toString();
      }
    });
    System.out.println(mockedList.get(50));
    //doReturn(),doThrow(),doAnswer(),doNothing(),noCallRealMethod()
  }

  @Test
  public void testSpy() {
    //spy应尽量少用，可用来处理遗留代码 (没有使用mock生成的对象)
    List list = new LinkedList();

    //监控一个真实的对象
    List spy = Mockito.spy(list);
    //可以为某些函数打桩
    when(spy.size()).thenReturn(100);

    //在监控真实对象上使用when会报错，可以使用onReturn、Answer、Throw()函数族来进行打桩
    //不能:因为当调用spy.get(0)时会调用真实对象的get(0)函数，此时会发生IndexOutOfBoundsException异常，因为真实List对象是空的
//    when(spy.get(0)).thenReturn("foo");
    doReturn("foo").when(spy).get(0);
    System.out.println(spy.get(0));

    //Mockito并不会为真实对象代理函数(Method)调用，实际上它会复制真实对象。
    //当你在监控一个真实对象时，你想为这个真实对象的函数做测试桩，那么就是在自找麻烦。

    //通过spy对象调用真实对象的函数
    spy.add("one");
    spy.add("two");

    System.out.println(spy.get(0));
    System.out.println(spy.size());

    //交互验证
    verify(spy).add("one");
    verify(spy).add("two");
  }
}
