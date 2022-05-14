package org.geekbang.time.commonmistakes.lock.lockscope;

import lombok.Getter;

class Data {
    @Getter
    private static int counter = 0;
    /**
     * counter为类层面
     * 需要类层面的锁
     */
    private static Object locker = new Object();

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