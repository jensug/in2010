import java.util.ArrayList;


public class BSTree implements BSTOper {

  Node rot = null;

 private class Node {
  Node left, right, parent;
  // verdier i venstre subtre er < verdien i noden selv
  // verdier i høyre subtre er > verdien i noden selv
  int value;
  // konstruktører, programmer disse
  Node( ) {

   }
  Node( int v ) {
    this.value = v;

  }


 }
 // konstruktører til BSTree

 private Node findParent( Node n ){
   if(n.parent != null){
     return n.parent;
   }
   return null; }

 private Node findGrandparent( Node n ){
   if(n.parent.parent != null){
     return n.parent.parent;
   }
  return null;}

 private Node find( int value ){
   if (rot == null){
     return null;
   }
   return findLoop(value, rot);
  }

  private Node findLoop(int value, Node node){

    if (node.value == value) {
      return node;
    }
      Node retur = null;
      if (node.left != null){
        retur = findLoop(value, node.left);
          if(retur != null)
          return retur;
      }
      if(node.right != null){
        retur = findLoop(value, node.right);
        if (retur != null){
          return retur;
        }
      }
      return retur;
  }

 // metoder fra BSTOper

public void add(Node node, Node newNode){
  if(newNode.value <= node.value){
    if(node.left == null){
      newNode.parent = node;
      node.left = newNode;
      return;
    }
    add(node.left, newNode);
    return;
  }
    if(node.right == null){
      newNode.parent = node;
      node.right = newNode;
      return;
    }
    add(node.right, newNode);
}

 public void add( int value ){

   Node newNode = new Node(value);

   if (rot == null){
     this.rot = newNode;
     return;
   }
   add(rot, newNode);
 }


 public boolean remove( int value ){
   this.rot = remove(value, this.rot);
   return true;
}

public Node remove(int value, Node node){
  //søk
  if (node == null){
    return node;}
  if (value < node.value){
    node.left = remove(value, node.left);
  }
  else if(value > node.value){
    node.right = remove(value,node.right);
  }
  else{
    //2 barn
    if (node.left != null && node.right != null){
      Node minNode = findMin(node.right);
      node.value = minNode.value;
      node.right = remove(minNode.value, node.right);
    }

    //hvis venstre barn
    else if (node.left != null){
      node.left.parent = node.parent;
      node = node.left;
    }
    //hvis høyre barn
    else if (node.right != null){
      node.right.parent = node.parent;
      node = node.right;

    }
    //hvis ingen barn
    else{
      node = null;
    }

  }
return node;
}

public Node findMin(Node node){
  while(node.left != null){
    node = node.left;
  }
  return node;
}


  public int sizeNodes ( Node node){
    if (node == null){
      return 0;
    }
    return 1 + sizeNodes(node.left) + sizeNodes(node.right);
  }

 public int size(){
   return sizeNodes(this.rot);

 }


 public boolean existsInTree( int value ){
   if (find(value) == null){
     return false;}


   return true;
 }


 public int findNearestSmallerThan( int value ){
//går utifra at man bruker et tall som faktisk er større enn minste tallet i arrayen.
   int teller = value-1;
   while (find(teller) == null){
     teller -= 1;
   }
   return find(teller).value;
 }

 public void addAll( int[] integers ){
   int i;
   for(i = 0; i < integers.length; i++){
     add(integers[i]);
   }
 }

 public int[] sortedArray(){
   int [] BSTarray = new int [size()];
   int i = lagSortedArray(rot, 0, BSTarray);
   return BSTarray;
 } // inorder

 public int lagSortedArray(Node node, int i, int[] BSTarray ){
   if(node.left != null){
      i = lagSortedArray(node.left, i, BSTarray);
    }
   BSTarray[i] = node.value;
   i = i+1;
   if(node.right != null){
     i = lagSortedArray(node.right, i, BSTarray);
   }
  return i;
 }

 public int[] findInRange (int low, int high){

   int[] sortedArray = sortedArray();
   int index = 0;
   int inRangeLenght = 0;

   while(index != size()){
    if(sortedArray[index] >= low && sortedArray[index] <= high){
      inRangeLenght += 1;
    }
    index +=1;
   }

   int [] inRangeArray = new int [inRangeLenght];
   index = 0;
   int inRangeIndex = 0;

   while(index != size()){
    if(sortedArray[index] >= low && sortedArray[index] <= high){
      inRangeArray[inRangeIndex] = sortedArray[index];
      inRangeIndex +=1;
    }
    index +=1;
   }
   return inRangeArray;
}

 // brukes til rød-svarte trær (tilleggsoppgave)
 private static byte BLACK = 1;
 private static byte RED = 2;

 private class RBNode extends Node {
  private byte colour = 0;
  boolean isRed( ) { return colour == RED; }
  boolean isBlack( ) { return colour == BLACK; }
  void setToRed( ) { colour = RED; }
  void setToBlack( ) { colour = BLACK; }
 }


//printer methoden min

public void printNoder(){
    printNoder(rot);
}


public void printNoder( Node node){

  if (node == null){
    return;
  }

  System.out.println(node.value);

  if(node.left != null){
  printNoder(node.left);
  }

  if(node.right != null){
  printNoder(node.right);
  }


}



}
