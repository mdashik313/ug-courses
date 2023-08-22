import java.util.Comparator;
import java.util.PriorityQueue;

class Process {
    private String id;
    private int priority;
    private int time;

    public Process(String id, int priority, int time) {
        this.id = id;
        this.priority = priority;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public int getTime() {
        return time;
    }
}

public class PrioritySortingExample {
    public static void main(String[] args) {
        PriorityQueue<Process> processQueue = new PriorityQueue<>(Comparator.comparingInt(Process::getPriority)
                .thenComparingInt(Process::getTime));

        processQueue.add(new Process("1",0,2));
        processQueue.add(new Process("2",2,5));
        processQueue.add(new Process("3",1,8));
        processQueue.add(new Process("4",2,4));
        processQueue.add(new Process("5",4,5));

        while (!processQueue.isEmpty()) {
            Process process = processQueue.poll();
            System.out.println("Process ID: " + process.getId() + " - Priority: " + process.getPriority() +
                    " - Time: " + process.getTime());
        }
    }
}