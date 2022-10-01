import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class InnerMultiThreading extends Thread {

    int threadNum;

    public int getValue() {
        return threadNum;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        this.threadNum = 10;

    }

}

public class MultiThreading {
// 
    static class Task implements Callable<Integer> {
        int num;

        Task(int n) {
            this.num = n;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(num * 1000);
            return num;
            //hoga kyaaaaa
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<Integer> result1 = service.submit(new Task(5));
        Future<Integer> result2 = service.submit(new Task(2));

        System.out.println(result1.get() + result2.get());
        // comment 222ssssaaa
    }
}