public class Process {
    int id;
    int arrivalTime;
    int duration;
    GlobalTimer globalTimer;

    public Process(int id,int arrivalTime, int duration, GlobalTimer globalTimer){
        this.id=id;
        this.arrivalTime=arrivalTime;
        this.duration=duration;
        this.globalTimer=globalTimer;
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
}