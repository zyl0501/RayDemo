package com.ray.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * 创建时间：2016/12/23
 *
 * @author zyl
 */
public class CaptorSample {

  @Mock
  List<String> mockedList;

  @Before
  public void setup() {
    //初始化@Mock注解的对象 (进行注入)
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCaptor(){
    mockedList.add("Haha");
    ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
    verify(mockedList).add(argument.capture());
    assertEquals("Haha", argument.getValue());
  }

  @Test
  public void testCaptor2(){
    List<String> mock = Mockito.mock(List.class);
    List<String> mock2 = Mockito.mock(List.class);
    mock.add("John");
    mock2.add("Brian");
    mock2.add("Jim");

    ArgumentCaptor<String> argument1 = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<String> argument2 = ArgumentCaptor.forClass(String.class);

    verify(mock).add(argument1.capture());
    assertEquals("John", argument1.getValue());

    verify(mock2, times(2)).add(argument2.capture());

    assertEquals("Jim", argument2.getValue());
    assertArrayEquals(new Object[]{"Brian","Jim"},argument2.getAllValues().toArray());
  }
}
