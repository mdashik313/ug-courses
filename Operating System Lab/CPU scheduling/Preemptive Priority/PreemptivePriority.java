import java.util.Comparator;
import java.util.PriorityQueue;
public class PreemptivePriority{

    static PriorityQueue<Process> processQueue = new PriorityQueue<>(Comparator.comparingInt(Process::getArrivalTime));

    static PriorityQueue<Process> readyQueue = new PriorityQueue<>(Comparator.comparingInt(Process::getPriority));


    static GlobalTimer globalTimer = new GlobalTimer(0);
    public static void main(String[] args) {
        processQueue.add(new Process(1,0,1,globalTimer,2));
        processQueue.add(new Process(2,1,7,globalTimer,6));
        processQueue.add(new Process(3,2,3,globalTimer,3));
        processQueue.add(new Process(4,3,6,globalTimer,5));
        processQueue.add(new Process(5,4,5,globalTimer,4));
        processQueue.add(new Process(6,5,15,globalTimer,10));
        processQueue.add(new Process(7,15,8,globalTimer,9));


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
        System.out.println("Running process -> "+P.id+". Global time -> "+globalTimer.time+". burst time remain -> "+(P.getDuration()-1));
        //deduct burst time by 1 unit
        P.duration -= 1;
        globalTimer.time++;

        //idea: after 1 unit of execution if the process is not completed then insert it again to ready queue
        // to compare with others
        if(P.getDuration() > 0){
            readyQueue.add(P);
        }
        else {
            System.out.println("********Process -> "+P.getId() + ", completed its job. at global time -> "+globalTimer.time);
        }

    }
}