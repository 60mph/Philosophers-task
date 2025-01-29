package org.example;
import java.lang.Thread;
import java.time.LocalDateTime;
public class Philosopher extends Thread {
    LocalDateTime finish;
    boolean running = true;
    int eating_counter;
    int id;
    Fork l_fork;
    Fork r_fork;
    Philosopher(int id, Fork l_fork, Fork r_fork) {
        this.id = id;
        this.r_fork = r_fork;
        this.l_fork = l_fork;
        this.eating_counter = 0;
        this.finish = LocalDateTime.now().plusSeconds(10);
    }
    public Fork getL_fork() {
        return l_fork;
    }
    public Fork getR_fork() {
        return r_fork;
    }
    public int getEating_counter() {
        return eating_counter;
    }
    public void setL_fork(Fork l_fork) {
        this.l_fork = l_fork;
    }
    public void setR_fork(Fork r_fork) {
        this.r_fork = r_fork;
    }
    public void Think() throws InterruptedException {
        System.out.println("Philosopher " + this.id + " is thinking");
        Thread.sleep(5000);
    }
    public void Eat() throws InterruptedException {
        System.out.println("Philosopher " + this.id + " is eating");
        eating_counter++;
        Thread.sleep(5000);
    }
    public void takeLeftFork() throws InterruptedException {
        System.out.println("Philosopher " + this.id + " take left fork");
    }
    public void takeRightFork() throws InterruptedException {
        System.out.println("Philosopher " + this.id + " take right fork");
    }
    public void Stop() {
        this.running = false;
    }

    public void run() {
        try
        {
            while (this.running)
            {
                Think();
                synchronized (l_fork) {
                    synchronized (r_fork) {
                        if(this.running) Eat();
                    }
                }

                //if(LocalDateTime.now().isAfter((finish)))
                //{
                //    break;
                //}
            }
        } catch (InterruptedException e)
            {
            throw new RuntimeException(e);
            }
    }
}
