package concurency;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class StopThread {

    public static void flagThread() {
        FlagThread flagThread = new FlagThread();
        flagThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.next();
        flagThread.stopThread();
    }

    public static void interruptThread() {
        Thread thread = new InterThread();
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.next();
        thread.interrupt();
    }

    public static void dummyThread() {
        Thread thread = new DummyThread();
        thread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        thread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        //flagThread();
        interruptThread();
        //dummyThread();
    }

    static class FlagThread extends Thread {
        private volatile boolean pleaseStop;

        @Override
        public void run() {
            while (!pleaseStop) {
                try {
                    System.out.println("Task->sleep()");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void stopThread() {
            System.out.println("Stopping...");
            pleaseStop = true;
        }
    }

    static class InterThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("Task->sleep()");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();

                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        return;
                    } else {
                        System.out.println("not interrupted");
                        return;
                    }
                }
            }
        }
    }

    static class DummyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("q");
//                try {
//                    System.out.println("Task::sleep()");
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                }
            }
        }
    }
}