import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;



class Task {
  int id , time , staff ;
  String name ;
  int earliestStart = 0 , latestStart = 9999;
  ArrayList<Task> outEdges = new ArrayList<Task>();
  int cntPredecessors = 0;
  boolean visited = false;
  boolean outEdgesVisited = false;
  boolean isStartNode = false;
  Task latestStartPast = null;

  static int optimalTimeSchedule;



  public boolean visit(ArrayList<Integer> visitors){

    try {
         PrintStream out = new PrintStream(new FileOutputStream(
             "output.txt", true));


    if (visitors.contains(id)){
      out.print("\n fant en loop på [");
      for(int talla : visitors){
        out.print(talla + ", ");
      }
      out.print(id +"]");
      out.println("");
      return false;
    }
    out.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
    if(outEdgesVisited){
      return true;
    }
    visitors.add(id);
    visited = true;
    Boolean result = true;
    for(Task task : outEdges){
      result = task.visit(visitors);
      if (!result){
        return false;
      }
    }
    outEdgesVisited = true;
    int lastRemove = visitors.size()-1;
    visitors.remove(lastRemove);
    return result;


  }

  public void setEarly(){
    for(Task neste : this.outEdges){
      if(neste.earliestStart < (this.earliestStart + this.time)){
        neste.earliestStart = this.earliestStart + this.time;
        neste.setEarly();
      }
    }
    if((this.earliestStart+this.time) > optimalTimeSchedule){
      optimalTimeSchedule = this.earliestStart + this.time;
    }
  }


  public void setLate(){
    for(Task neste : this.outEdges){ //siste tasken har ingen outedges, så den kommer ikke inn her
      neste.setLate();
      if(this.latestStart > neste.latestStart - this.time){
        this.latestStart = neste.latestStart - this.time;

      }
    }
    if(this.outEdges.size() == 0){
      this.latestStart = optimalTimeSchedule - time;

    }
  }

}
