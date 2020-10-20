import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Oblig2{

  public static void main(String[] args){

    Task teit = new Task();
    String filnavn = null;
    if (args.length > 0) {
        filnavn = args[0];
    } else {
        System.out.println("FEIL! Riktig bruk av programmet: "+"java Oblig2 <projectName>.txt");
        return;
    }

    Project prosjekt = new Project();


    File fil = new File(filnavn);
    try {
        prosjekt.lesFraFil(fil);
    } catch (FileNotFoundException e) {
        System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", filnavn);
        System.exit(1);
    }
  //  prosjekt.printTasks();
    if(prosjekt.isRealizable()){
      prosjekt.setStartNode();
      prosjekt.setEarly();
      prosjekt.setLate();
      prosjekt.optimalTimeSchedule();

    }


  }



}
