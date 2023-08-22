import java.util.Comparator;
import java.util.PriorityQueue;
public class FCFS{

    static PriorityQueue<Process> processQueue = new PriorityQueue<Process>(10, new
            Comparator<Process>() {
                public int compare(Process process1, Process process2) {
                    return (int)(process1.getArrivalTime()-process2.getArrivalTime());
                }
            });
    static PriorityQueue<Process> readyQueue = new PriorityQueue<Process>(10, new
            Comparator<Process>() {
                public int compare(Process process1, Process process2) {
                    return (int)(process1.getArrivalTime()-process2.getArrivalTime());
                }
            });
    static GlobalTimer globalTimer = new GlobalTimer(0);
    static int timer = 15;
    public static void main(String[] args) {
        processQueue.add(new Process(1,3,2,globalTimer));
        processQueue.add(new Process(2,6,3,globalTimer));
        processQueue.add(new Process(3,1,4,globalTimer));
        processQueue.add(new Process(4,4,5,globalTimer));
        while(true){
            if(timer==0) break;
            timer--;
            if(checkIfNewProcessArrived()){
                while(!processQueue.isEmpty() && processQueue.element().getArrivalTime()<
                        globalTimer.time){
                    readyQueue.add(processQueue.poll());
                }
            }
            if(!readyQueue.isEmpty())
                runProcessInCpu();
            else {
                System.out.println("No process is in Ready Queue");
                System.out.println("Global time: "+globalTimer.time);
                globalTimer.time++;
            }
        }
    }
    public static boolean checkIfNewProcessArrived(){
        if(!processQueue.isEmpty()){
            if(processQueue.element().getArrivalTime()<globalTimer.time)
                return true;
        }
        return false;
    }
    public static void runProcessInCpu(){
        Process process = readyQueue.poll();
        process.runProcess();
    }
}