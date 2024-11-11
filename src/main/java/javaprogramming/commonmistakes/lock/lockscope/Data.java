package javaprogramming.commonmistakes.lock.lockscope;

import lombok.Getter;

class Data {
    @Getter
    private static int counter = 0;
    private static final Object locker = new Object();

    public static int reset() {
        counter = 0;
        return counter;
    }

    // 非静态方法加锁，只能确保多个线程不能同时访问同一个对象的非静态方法，并不能阻止静态方法被多个线程同时访问
    public synchronized void wrong() {
        counter++;
    }

    public void right() {
        synchronized (locker) {
            counter++;
        }
    }
}
