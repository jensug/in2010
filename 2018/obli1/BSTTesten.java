class BSTTesten{


  public static void main(String[] args) {

    Node node = new Node(1);
    Node nodeTo = new Node(2);
    Node nodeTre = new Node(3);
    Node nodeFire = new Node(4);
    nodeTo.right = nodeTre;
    node.right = nodeTo;
    nodeTre.right = nodeFire;


    System.out.println(node.value);
    System.out.println(nodeTo.value);
    System.out.println(nodeTre.value);
    System.out.println(nodeFire.value);
    System.out.println("");

    Node peker = nodeFire;
    peker = null;
    System.out.println(nodeTo.value);
    System.out.println(nodeTo.right.right.value);
  }


}
