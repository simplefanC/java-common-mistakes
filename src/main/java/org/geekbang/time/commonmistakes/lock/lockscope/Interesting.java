package org.geekbang.time.commonmistakes.lock.lockscope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

@Slf4j
public class Interesting {
    /**
     * 需要加volatile
     */
    volatile int a = 1;
    volatile int b = 1;

    public synchronized void add() {
        log.info("add start");
        for (int i = 0; i < 1000000; i++) {
            a++;
            b++;
        }
        log.info("add done");
    }

    public void compare() {
        log.info("compare start");
        for (int i = 0; i < 1000000; i++) {
            if (a < b) {
                log.info("a:{},b:{},{}", a, b, a > b);
                //最后的a>b应该始终是false的吗？
            }
        }
        log.info("compare done");
    }

    public synchronized void compareRight() {
        log.info("compare start");
        for (int i = 0; i < 1000000; i++) {
            Assert.isTrue(a == b, "a!=b");
            if (a < b) {
                log.info("a:{},b:{},{}", a, b, a > b);
            }
        }
        log.info("compare done");
    }
}
