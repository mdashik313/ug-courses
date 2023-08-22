import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
public class RoundRobin{

    static PriorityQueue<Process> processQueue = new PriorityQueue<>(Comparator.comparingInt(Process::getArrivalTime));
    static Queue<Process> readyQueue = new LinkedList<>();
    static int quantumTime = 4;
    static GlobalTimer globalTimer = new GlobalTimer(0);

    public static void main(String[] args) {
        processQueue.add(new Process(1,0,5,globalTimer));
        processQueue.add(new Process(2,1,6,globalTimer));
        processQueue.add(new Process(3,2,3,globalTimer));
        processQueue.add(new Process(4,3,1,globalTimer));
        processQueue.add(new Process(5,4,5,globalTimer));
        processQueue.add(new Process(6,6,4,globalTimer));

        while(true){
            if(checkIfNewProcessArrived()){
                while(!processQueue.isEmpty() && processQueue.peek().getArrivalTime()<
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
            if(processQueue.peek().getArrivalTime()<globalTimer.time)
                return true;
        }
        return false;
    }
    public static void runProcessInCpu(){
        Process P = readyQueue.poll();
        int d = P.getDuration();
        for(int i=0;i<Math.min(quantumTime, d);i++){
            System.out.println("Running process -> "+P.id+". Global time -> "+globalTimer.time+". burst time remain -> "+(P.getDuration()-1));
            //deduct burst time by 1 unit
            P.duration -= 1;
            globalTimer.time++;

            if(checkIfNewProcessArrived()){
                while(!processQueue.isEmpty() && processQueue.peek().getArrivalTime()<
                        globalTimer.time){
                    readyQueue.add(processQueue.poll());
                }
            }
        }

        if(P.getDuration() > 0){
            readyQueue.add(P);
        }
        else {
            System.out.println("********Process -> "+P.getId() + ", completed its job. at global time -> "+globalTimer.time);
        }

    }
}