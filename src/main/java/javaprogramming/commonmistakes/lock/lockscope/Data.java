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

    public synchronized void wrong() {
        counter++;
    }

    public void right() {
        synchronized (locker) {
            counter++;
        }
    }
}
