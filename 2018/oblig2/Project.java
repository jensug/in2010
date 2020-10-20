import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


class Project{

ArrayList<Task> tasks = new ArrayList<Task>();
ArrayList<Task> startTasks = new ArrayList<Task>();


public Project(){

}


public void lesFraFil(File fila) throws FileNotFoundException{
//error hvis fil er feil
  Scanner filleser;
    try{
      filleser = new Scanner(fila);
    } catch(FileNotFoundException e) {
        throw new FileNotFoundException("Error.");
        }

//øverste linje er antall tasks, så lager antall tasks
  int totalTasks = Integer.parseInt(filleser.nextLine());
  for (Integer i = 0; i < totalTasks; i++){
    Task newTask = new Task();
    tasks.add(i, newTask);
  }

  String linje = "";
//etterfølgt av en tom linje
    linje = filleser.nextLine();



  int taskIndex = 0;
  while(taskIndex < totalTasks){
    linje = filleser.nextLine();
    String[] delt = linje.split("\\s+");
      tasks.get(taskIndex).id = Integer.parseInt(delt[0]);
      tasks.get(taskIndex).time = Integer.parseInt(delt[2]);
      tasks.get(taskIndex).staff = Integer.parseInt(delt[3]);
      tasks.get(taskIndex).name = delt[1];
      int predecessors = 0;
      if(Integer.parseInt(delt[4]) == 0){
        predecessors++;
        tasks.get(taskIndex).isStartNode = true;
      }
      tasks.get(taskIndex).cntPredecessors = predecessors;
      int outEdgeIndex = 4;

      while(Integer.parseInt(delt[outEdgeIndex]) != 0){
// legger til enne noden som outedge i nodens predecessors
      (tasks.get(Integer.parseInt(delt[outEdgeIndex])-1)).outEdges.add(tasks.get(taskIndex));
      outEdgeIndex++;
      }
    taskIndex++;
  }

}

public void printTasks(){

for (Task task : tasks){
  System.out.print("Task " + task.id + ", "  + task.name + ", Outedges: [");
  for(Task tasken : task.outEdges){
    System.out.print(tasken.id + ", ");
  }
  System.out.print("]");
  System.out.println("");
}

}


public boolean isRealizable(){
for (Task task : tasks){
  ArrayList<Integer> visitors = new ArrayList<Integer>();
  if(!task.visited){
    if(!task.visit(visitors)){
      return false;
    }
  }
}
  return true;
}



public void setEarly(){
for(Task task : startTasks){
        task.setEarly();

  }
}



public void setLate(){
  for(Task task : startTasks){
      task.setLate();
    }
}


public void setStartNode(){
  for (Task task : tasks){
    if(task.isStartNode){
      startTasks.add(task);
    }
  }
}


public void optimalTimeSchedule(){

  try {
       PrintStream out = new PrintStream(new FileOutputStream(
           "output.txt", true));





int time = 0;

int optimalTimeSchedule = 0;
for (Task aTask : tasks){
  if (aTask.earliestStart+aTask.time > optimalTimeSchedule){
    optimalTimeSchedule = aTask.earliestStart+aTask.time;
  }
}
  int currentStaff = 0;
while(time <= optimalTimeSchedule){

  boolean found = false;

  String startMessages = "";
  String finishedMessages = "";
  for(Task tasken : tasks){
    if(time == tasken.earliestStart){
      startMessages += (" \n Starting: " + tasken.name);
      currentStaff =  currentStaff + tasken.staff;

    }
    if((tasken.time+tasken.earliestStart) == time){
      finishedMessages += ("\n Finished: " + tasken.name);
      currentStaff = currentStaff - tasken.staff;
    }
  }

    if(startMessages != "" || finishedMessages != ""){
      out.print("\n Time :" + time);
      out.println(startMessages + finishedMessages);
      if(currentStaff != 0){
        out.println("Current staff: " + currentStaff);
      }
    }

    startMessages = "";
    finishedMessages = "";

    time++;
}
tasks.get(0).optimalTimeSchedule = optimalTimeSchedule;
out.println("\n **** Shortest possible project execution is " + optimalTimeSchedule + " ****");

out.close();
} catch (FileNotFoundException e) {
  e.printStackTrace();
}
}










}
