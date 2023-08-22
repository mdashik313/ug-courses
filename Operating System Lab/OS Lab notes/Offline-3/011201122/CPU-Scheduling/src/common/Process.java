package common;

public class Process {
    private final int id;
    private final int arrivalTime;
    private int duration;
    private int priority;
    private final GlobalTimer globalTimer;

    public Process(int id, int arrivalTime, int duration, GlobalTimer globalTimer) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.globalTimer = globalTimer;
    }

    public Process(int id, int arrivalTime, int duration, GlobalTimer globalTimer, int priority) {
        this(id, arrivalTime, duration, globalTimer);
        this.priority = priority;
    }

    public void runProcess() {
        System.out.print("PID: " + this.id);
        System.out.println("\tGlobal time: " + this.globalTimer.time);
        globalTimer.time++;
        this.duration--;

        if (duration == 0)
            System.out.println("*****Process ID:" + this.id + " completed it's job.*****");
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDuration() {
        return duration;
    }

    public GlobalTimer getGlobalTimer() {
        return globalTimer;
    }

    public int getPriority() {
        return priority;
    }
}
