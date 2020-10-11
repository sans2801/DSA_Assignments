/*
PRASAD THAKARE
BATCH 2
COMPUTER ENGINEERING
191070004
*/
class LinkedList<t extends Comparable<t>>
{
  static class Node<t>
  {
    t data;
    Node<t> next;
    Node(t data)
    {
      this.data=data;
      next=null;
    }
  }

/*********************ATTRIBUTES*********************/

  Node<t> head;
  private Node<t> sortedHead;
  private Node<t> mergeSortHead;
  LinkedList<t> frontSplit;
  LinkedList<t> backSplit;

/***********************METHODS*********************/

  LinkedList()
  {
    head=null;
    mergeSortHead=sortedHead=null;
  }
  void pushBack(t data)
  {
    Node<t> toAdd=new Node<>(data);
    if(head==null)
      head=toAdd;
    
    else{
      Node<t> temp=head;
      while(temp.next!=null)
        temp=temp.next;
      temp.next=toAdd;
    }
  }

  void pushFront(t data)
  {
    Node<t> toAdd=new Node<>(data);
    if(head==null)
      head=toAdd;

    else{
      toAdd.next=head;
      head=toAdd;
    }
  }

  void insert(int poss,t data) //insertion in the middle
  {
    if(poss==0)
    {
      Node<t> toAdd=new Node<>(data);
      toAdd.next=head;
      head=toAdd;
    }
    else{
      Node<t> temp=head;
      while(poss>1)
      {
        temp=temp.next;
        poss--;
      }
      if(temp!=null)
      {
        Node<t> toAdd=new Node<>(data);
        toAdd.next=temp.next;
        temp.next=toAdd; 
      }
      else
        System.out.println("List overflow");
    }
  }

  void ascOrder(t data) //adding in ascending sorted list
  {
    Node<t> toAdd=new Node<>(data);
    if(head==null) head=toAdd;

    if(head.data.compareTo(data)==1)
    {
      toAdd.next=head;
      head=toAdd;
    }
    else
    {
      Node<t>temp=head;
      while((temp.next!=null) && (data.compareTo(temp.next.data)==1))
        temp=temp.next;
      
      toAdd.next=temp.next;
      temp.next=toAdd;
    }
  }

  void descOrder(t data) //adding in descending sorted list
  {
    Node<t> toAdd=new Node<>(data);
    if(head==null) head=toAdd;
    if(head.data.compareTo(data)==-1)
    {
      toAdd.next=head;
      head=toAdd;
    }
    else
    {
      Node<t>temp=head;
      while((temp.next!=null) && (data.compareTo(temp.next.data)==-1))
        temp=temp.next;
      
      toAdd.next=temp.next;
      temp.next=toAdd;
    }
  }

  /*********************** DELETION ***************/

  void deleteHead()
  {
    if(head!=null)
      head=head.next;
  }

  void deleteLast()
  {
    Node<t>temp=head;
    while(temp.next.next!=null)
      temp=temp.next;
    temp.next=null;
  }

  void removeAll(t data) //Removes all occurence of an element
  {
    while(head!=null && head.data==data)
      head=head.next;
    Node<t> temp=head;
    while(temp!=null)
    {
      if(temp.next!=null && temp.next.data==data)
      {
      Node<t> end=temp.next;
      while(end!=null && end.data==data)
        end=end.next;
      temp.next=end;
      }
      temp=temp.next;
    }  
  }

  void removeOrdered(t data)//removes all occurence of an element from sorted list
  {
    if(head!=null&&head.data==data)
      while(head!=null && head.data==data)
        head=head.next;
    else
    {
      Node<t> temp=head;
      while(temp!=null)
      {
        if(temp.next.data==data)
        {
          Node<t> end=temp.next;
          while(end!=null && end.data==data)
            end=end.next;
          temp.next=end;
          break;
        }
        temp=temp.next; 
      }
    }
  }

  /**************SORTING METHODS*****************/

  void InsertionSort() //Insertion sort algo
  {
    Node<t> temp=head;
    sortedHead=null;
    while(temp!=null)
    {
      Node<t> next=temp.next;
      if(sortedHead==null||temp.data.compareTo(sortedHead.data)!=1)
        {temp.next=sortedHead;
         sortedHead=temp;}
      else{
        Node<t> curr=sortedHead;
        while(curr.next!=null && curr.next.data.compareTo(temp.data)==-1)
          curr=curr.next;
        temp.next=curr.next;
        curr.next=temp;
      }
      temp=next;
    }
    head=sortedHead;
  }

  void MergeSort() //Merge Sort Algo
  {
    mergeSortHead=null;
    frontSplit.InsertionSort();
    backSplit.InsertionSort();
    if(frontSplit.head.data.compareTo(backSplit.head.data)!=1)
    {
      mergeSortHead=new Node<>(frontSplit.head.data);
      frontSplit.head=frontSplit.head.next;
    }
    else
    {
      mergeSortHead=new Node<>(backSplit.head.data);
      backSplit.head=backSplit.head.next;
    }
    Node<t> curr=mergeSortHead;
    while(true)
    {
    
    if(frontSplit.head==null)
    {
      curr.next=backSplit.head;
      head=mergeSortHead;
      break;
    }
    else if(backSplit.head==null)
    {
      curr.next=frontSplit.head;
      head=mergeSortHead;
      break;
    }
    else if(frontSplit.head.data.compareTo(backSplit.head.data)!=1)
    {
      curr.next=frontSplit.head;
      frontSplit.deleteHead();
    }
    else
    {
      curr.next=backSplit.head;
      backSplit.deleteHead();
    }
    curr=curr.next;
    }

  }

  /**********************************/
  void printList()
  {
    Node<t>temp=head;
    System.out.print("List: ");
    while(temp!=null) 
    {
      System.out.print(temp.data+" ");
      temp=temp.next;
    }
  }

  /***************************************/

  void frontBackSplit() //Splits in two halves
  { 
    frontSplit=new LinkedList<>();
    backSplit = new LinkedList<>();
    Node<t> temp=head;int size=0;
    while(temp!=null)
    {
      size++;
      temp=temp.next;
    }
    temp=head;
    for(int i=0;i<(size/2);i++)
    {
      frontSplit.pushBack(temp.data);
      temp=temp.next;
    }
    if(size%2==1)
    {
      frontSplit.pushBack(temp.data);
      temp=temp.next;
    }
    while(temp!=null)
    {
        backSplit.pushBack(temp.data);
        temp=temp.next;
    }
      
  }
}

class Main {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
//Adding elements
    list.pushBack(3);
    list.pushBack(4);
    list.pushBack(6);
    list.pushBack(7);
    list.pushBack(1);
    list.pushBack(4);
    list.pushBack(5);
    list.pushBack(3);

    list.printList();
    System.out.println();

    System.out.println();

//Adding to the front

list.pushFront(9);
System.out.println("Adding to '9' the front");
list.printList();
System.out.println();

System.out.println();

//Inserting in between
list.insert(4, 18);
System.out.println("Inserting '18' at 4th Position");
list.printList();
System.out.println();

System.out.println();

//Inserting in sorted List
LinkedList<Integer>list2=new LinkedList<>();

list2.pushBack(3);
list2.pushBack(4);
list2.pushBack(6);
list2.pushBack(7);
list2.pushBack(1);
list2.pushBack(4);
list2.pushBack(5);
list2.pushBack(3);

list2.InsertionSort();
System.out.println("Adding to sorted list");
list2.printList();
System.out.println();
System.out.println("Adding '5' to this list");
list2.ascOrder(5);
list2.printList();
System.out.println();

System.out.println();

//Deleting the head
System.out.println("Current list:");
list.printList();
System.out.println();
System.out.println("Deleting head:");
list.deleteHead();
list.printList();
System.out.println();

System.out.println();

//Deleting Last element
System.out.println("Deleting last element");
list.deleteLast();
list.printList();
System.out.println();

System.out.println();

//Deleting All occurrence of an element
System.out.println("Deleting All occurrences of an element -> 3");

list.pushBack(3);
list.pushBack(4);
list.pushBack(3);
list.pushFront(3);

System.out.print("Current ");
list.printList();
System.out.println();
list.removeAll(3);
System.out.println("After");
list.printList();
System.out.println();

System.out.println();

//Deleting from Sorted List:
System.out.println("Deleting element from Sorted List -> 5");
list2.ascOrder(5);
list2.ascOrder(5);
list2.printList();
System.out.println();
list2.removeOrdered(5);
System.out.println("After");
list2.printList();
System.out.println();

System.out.println();

//Splitting into two sub-lists
System.out.println("Splitting into two sub-lists");
System.out.print("Current ");
list.printList();
System.out.println();
list.frontBackSplit();
System.out.print("Front ");
list.frontSplit.printList();
System.out.println();
System.out.print("Back ");
list.backSplit.printList();
System.out.println();

System.out.println();

//Merging the two sub-lists in sorted order
System.out.println("Merging the two lists in sorted order");
list.frontSplit.InsertionSort();
list.backSplit.InsertionSort();
System.out.print("Sorted Front ");
list.frontSplit.printList();
System.out.println();
System.out.print("Sorted Back ");
list.backSplit.printList();
System.out.println();
System.out.println("After Merging: ");
list.MergeSort();
list.printList();
System.out.println();

  }
}