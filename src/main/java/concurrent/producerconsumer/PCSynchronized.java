package concurrent.producerconsumer;

public class PCSynchronized {

    public static void main(String[] args) {
        Container container = new Container();
        Thread p1 = new Thread(() -> {
            while (true) {
                container.putOne("张三");
            }
        });
        Thread p2 = new Thread(() -> {
            while (true) {
                container.putOne("李四");
            }

        });
        Thread c1 = new Thread(() -> {
            while (true) {
                container.takeOne();
            }
        });
        Thread c2 = new Thread(() -> {
            while (true) {
                container.takeOne();
            }
        });
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}

class Container {
    private String name;
    private boolean isFull;


    public synchronized void putOne(String name) {
        while (isFull) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.name = name;
        System.out.println("生产者：产生了 " + name);
        isFull = true;
        this.notifyAll();
    }

    public synchronized void takeOne() {
        while (!isFull) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("消费者：消费了" + name);
        isFull = false;
        this.notifyAll();
    }
}
