interface CircularQueue<t>
{
  public void enqueue(t data);
  public void dequeue();
}

class cqueue<t> implements CircularQueue<t>{

 public static class node<t>{
    t data;
    node<t> next;
    node(t data)
    {
      this.data=data;
      next=null;
    }
  }

  public node<t> head;

  cqueue()
  {
    head=null;
  }

  public void enqueue(t data)
  {
    node<t> toAdd=new node<>(data);
    if(head==null)
    {
      head=toAdd;
      head.next=head;
    }
    else{
      node<t> temp = head;
      while(temp.next!=head)
        temp=temp.next;
      temp.next=toAdd;
      toAdd.next=head;
    }
  }

  public void dequeue()
  {
    if(head.next==head)
    {
      head=null;
    }
    else 
    {
    node<t> temp=head;
    while(temp.next!=head)
      temp=temp.next;
    head=head.next;
    temp.next.next=null;
    temp.next=head;
    } 
  }

  public void printList()
  {
    node<t> temp=head;
    if(head.next==head)
      System.out.print(head.data);
    else
    do
    {
      System.out.print(temp.data+" ");
      temp=temp.next;
    }while(temp!=head);
  }
} 

class Main {
  public static void main(String[] args) {
    cqueue<String> signal = new cqueue<>();
    signal.enqueue("STOP!");
    signal.enqueue("WAIT!");
    signal.enqueue("GO!");

    cqueue.node<String> itr = signal.head;
    int t=0;
    while(true)
    {
    	System.out.println('\n'+itr.data+" "+t+" sec");
    	itr=itr.next;
      try{
    	Thread.sleep(3000);
      t+=3;
      }catch(InterruptedException e){
        e.printStackTrace();

      }

  }
}}