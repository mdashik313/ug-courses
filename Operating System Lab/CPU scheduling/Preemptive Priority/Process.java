public class Process {
    int id;
    int arrivalTime;
    int duration;
    GlobalTimer globalTimer;
    int priority;

    public Process(int id,int arrivalTime, int duration, GlobalTimer globalTimer, int priority){
        this.id=id;
        this.arrivalTime=arrivalTime;
        this.duration=duration;
        this.globalTimer=globalTimer;
        this.priority = priority;
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
    public int getPriority(){
        return  priority;
    }
}