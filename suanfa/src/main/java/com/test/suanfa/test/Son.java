package com.test.suanfa.test;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/4/29 22:59
 */
public class Son  extends Father{
    public Son() {
        super();
    }
    public Son(int age) {
        this();
    }
    public static void showStatic(String string){
        System.out.println("son static "+string);
    }
    private void showPrivate(String string){
        System.out.println("show private "+string);
    }
    public void show(){
        showStatic("lm"); //子类不能重写父类静态方法
        super.showStatic(" is ");
        showPrivate(" shuai ge ");
        super.showCommon();
        showFinal();
        display(this);
        info();
        MethodInterface methodInterface = null;
        methodInterface.methodA();
    }
    public void info(){ }
    public  void display (Father f){
        f.showCommon();
    }
    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}
