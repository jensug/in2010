import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

 class kjoretid{


public static void main(String[] args) {

int arrayLengde = 500000;

int[] randomArray = new int[arrayLengde];
Random ran = new Random();
for(int i = 0; i < randomArray.length; i++){
  randomArray[i] = ran.nextInt(randomArray.length-1);
}
int[] originalRandom = randomArray;

int[] stigendeArray = new int[arrayLengde];
for(int i = 0; i < stigendeArray.length; i++){
  stigendeArray[i] = i;
}
int[] originalStigende = stigendeArray;

int[] synkendeArray = new int[arrayLengde];
for(int i = 0; i < synkendeArray.length; i++){
  synkendeArray[i] = synkendeArray.length-i-1;
}
int[] originalSynkende = synkendeArray;

long t = System.nanoTime(); // nanosek
Arrays.sort(randomArray);
double tid = (System.nanoTime()-t)/10000000.0; // millisek
System.out.println(tid);

 t = System.nanoTime(); // nanosek
Arrays.sort(stigendeArray);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);

 t = System.nanoTime(); // nanosek
Arrays.sort(synkendeArray);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);


/*
long t = System.nanoTime(); // nanosek
selectionSort(randomArray);
double tid = (System.nanoTime()-t)/10000000.0; // millisek
System.out.println(tid);

 t = System.nanoTime(); // nanosek
selectionSort(stigendeArray);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);

 t = System.nanoTime(); // nanosek
selectionSort(synkendeArray);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);

randomArray = originalRandom;
stigendeArray = originalStigende;
synkendeArray = originalSynkende;

System.out.println("");
 t = System.nanoTime(); // nanosek
insertionSort(randomArray);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);

 t = System.nanoTime(); // nanosek
insertionSort(stigendeArray);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);

 t = System.nanoTime(); // nanosek
insertionSort(synkendeArray);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);

randomArray = originalRandom;
stigendeArray = originalStigende;
synkendeArray = originalSynkende;

System.out.println("");
 t = System.nanoTime(); // nanosek
quickSort(randomArray, 0, arrayLengde-1);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);

 t = System.nanoTime(); // nanosek
quickSort(stigendeArray, 0, arrayLengde-1);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);

 t = System.nanoTime(); // nanosek
quickSort(synkendeArray, 0, arrayLengde-1);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);

randomArray = originalRandom;
stigendeArray = originalStigende;
synkendeArray = originalSynkende;

System.out.println("");
 t = System.nanoTime(); // nanosek
bucketSort(randomArray, arrayLengde-1);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);

 t = System.nanoTime(); // nanosek
bucketSort(stigendeArray, arrayLengde-1);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);

 t = System.nanoTime(); // nanosek
bucketSort(synkendeArray, arrayLengde-1);
 tid = (System.nanoTime()-t)/10000000.0; // millisek
 System.out.println(tid);



System.out.println("Random array: ");
skrivUt(randomArray);
System.out.println("Stigende array: ");
skrivUt(stigendeArray);
System.out.println("Synkende array: ");
skrivUt(synkendeArray);
System.out.println("");


System.out.println("Selection sort: ")
int[] selectionSortRandom = randomArray;
int[] selectionSortStigende = stigendeArray;
int[] selectionSortSynkende = synkendeArray;
selectionSort(selectionSortRandom);
selectionSort(selectionSortStigende);
selectionSort(selectionSortSynkende);
skrivUt(selectionSortRandom);
skrivUt(selectionSortStigende);
skrivUt(selectionSortSynkende);

*/

}





public static void skrivUt(int[] array){
  System.out.print("[");
  for(int i = 0; i < array.length; i++){
    if(i != array.length-1){
      System.out.print(array[i] + ", ");
    } else{

      System.out.print(array[i]);
    }

  }
  System.out.print("]");
  System.out.println("");
}


 public static void selectionSort(int[] array){

//skrivUt(array);
         int n = array.length;
         for(int i = 0; i < n-1; i++){
           int minIndex = i;
           for(int j = i+1; j < n; j++){
             if(array[j]  < array[minIndex]){
               minIndex = j;
             }
           }
           int temp = array[minIndex];
           array[minIndex] = array[i];
           array[i] = temp;
           //skrivUt(array);
           //tester koden
         }
       }


  public static void insertionSort(int[] array){

    //  int teller = 0;
               int n = array.length;
               for(int i=1; i < n; i++){
                 int key = array[i];
                 int j = i-1;
                 while(j >= 0 && array[j] > key){
                   array[j+1] = array[j];
                   j = j-1;
                   //skrivUt(array);
                  // teller++;
                 }
                 array[j+1] = key;
                 //skrivUt(array);
                 //teller++;
                 //tester koden
               }
               //System.out.println(teller);
             }


public static void swap(int array[], int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
        //skrivUt(array);
          }


 public static void quickSort( int[] array, int low, int high){

   int pivot = array[(low+(high-low)/2)];

   int i = low, j = high;
   while(i <= j){
     while(array[i] < pivot){ i++; }
     while(array[j] > pivot){ j--; }
     if(i <= j){
       swap(array, i, j);
       i++;
       j--;
     }
   }
   if(low < j){ quickSort(array, low, j); }
   if(high > i){ quickSort(array, i, high); }
 }


 public static void bucketSort(int[] array, int maxValue) {

            int[] bucket = new int[maxValue+1];
            for (int i = 0; i < bucket.length; i++) {
               bucket[i]=0;
               //skrivUt(bucket);
               //tester koden
            }
            for (int i = 0; i < array.length; i++) {
               bucket[array[i]]++;
               //skrivUt(bucket);
            }
            int outPosition = 0;
            for (int i = 0; i < bucket.length; i++) {
               for (int j = 0; j < bucket[i]; j++) {
                  array[outPosition++] = i;
                 //skrivUt(array);
               }
            }
         }




}
