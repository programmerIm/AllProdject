package com.test.suanfa.threadDemo;

import java.util.concurrent.Phaser;

public class PhaserTest {


    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser();
        myPhaser.bulkRegister(4);

        for (int i = 0; i < 4; i++) {
            final int num = i;
            new Thread(()->{

                Person person = new Person(num);
                person.arrived(num);
                myPhaser.arriveAndAwaitAdvance();


                person.eat(num);
                myPhaser.arriveAndAwaitAdvance();

                person.leavl(num);
                myPhaser.arriveAndAwaitAdvance();


            }).start();
        }
    }

  static   class MyPhaser extends Phaser{

      @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase){
                case 0:
                    System.out.println("所有人到齐了");
                    return false;
                case 1:
                    System.out.println("所有人吃完了");
                    return false;
                case 2:
                    System.out.println("所有人走了");
                    System.out.println("结束了");
                    return true;
                default:
                    return true;
            }
        }
    }


  static   class  Person{

        private Integer num;

      public Person(Integer num) {
          this.num = num;
      }

      public void eat(Integer num)  {
          try {
              Thread.sleep(100);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          System.out.println(num+"吃饭");
        }
        
        public void arrived(Integer num)  {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(num+"到达了");
        }
        
        public void leavl(Integer num)  {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(num+"离开了");
        }
    }
}
