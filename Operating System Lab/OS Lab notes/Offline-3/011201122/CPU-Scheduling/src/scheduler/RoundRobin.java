package scheduler;

import common.GlobalTimer;
import common.Process;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RoundRobin {
    static PriorityQueue<Process> processQueue = new PriorityQueue<>(10, Comparator.comparingInt(Process::getArrivalTime));
    static PriorityQueue<Process> readyQueue = new PriorityQueue<>(10, Comparator.comparingInt(Process::getPriority));

    static GlobalTimer globalTimer = new GlobalTimer(0);
    static int timeQunatum = 8;

    public static void main(String[] args) {
        processQueue.add(new Process(1, 0, 2, globalTimer, 2));
        processQueue.add(new Process(2, 2, 1, globalTimer, 1));
        processQueue.add(new Process(3, 1, 8, globalTimer, 4));
        processQueue.add(new Process(4, 5, 4, globalTimer, 2));
        processQueue.add(new Process(5, 4, 5, globalTimer, 3));

        while (true) {
            if (checkIfNewProcessArrived()) {
                while (!processQueue.isEmpty() && processQueue.element().getArrivalTime() <
                        globalTimer.time) {
                    readyQueue.add(processQueue.poll());
                }
            }

            if (!readyQueue.isEmpty())
                runProcessInCPU();
            else {
                globalTimer.time++;
            }
        }
    }

    public static boolean checkIfNewProcessArrived() {
        if (!processQueue.isEmpty()) {
            return processQueue.element().getArrivalTime() < globalTimer.time;
        }
        return false;
    }

    public static void runProcessInCPU() {
        Process process = readyQueue.poll();
        int counter = timeQunatum;

        if (process != null) {
            while (counter > 0 && process.getDuration() > 0) {
                process.runProcess();
                counter--;

                if (process.getDuration() > 0)
                    readyQueue.add(process);

            }
        }
    }
}
