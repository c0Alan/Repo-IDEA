package com.demo.java.designpatterns.behaviour.state;

/**
 * State 状态模式是指定一个对象在其内部状态发生改变时改变它的行为，对象看起来似乎修改了它的类。
 * 场景如qq上线离线状态变化，设备在线离线状态变化等
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class StateDemo {
  
    public static void main(String[] args) {  
          
        State state = new State();  
        Context context = new Context(state);  
          
        //设置第一种状态  
        state.setValue("state1");  
        context.method();  
          
        //设置第二种状态  
        state.setValue("state2");  
        context.method();  
    }  
}