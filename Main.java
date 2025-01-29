package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Fork[] forks = new Fork[5];
        Philosopher[] philosophers = new Philosopher[5];
        for(int id = 0; id < 5; id++) {
            forks[id] = new Fork(id + 1);
        }
        for(int id = 0; id < 5; id++) {
            philosophers[id] = new Philosopher(id + 1, forks[id], forks[id < 5? id+1 : 0 ]);
            philosophers[id].start();
        }
        //for(int id = 0; id < 5; id++) {
        //    philosophers[id].join();
        //}
        Thread.sleep(30);
        for(int id = 0; id < 5; id++) {
            philosophers[id].Stop();
        }
        for(int id = 0; id < 5; id++) {
            System.out.println("Philosopher " + philosophers[id].id + " ate " + philosophers[id].getEating_counter());
        }
    }
}
