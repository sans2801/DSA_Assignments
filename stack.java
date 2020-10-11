import java.util.Scanner;

class node<t>
{
  t data;
  node<t> next;
  node(t data)
  {
    this.data=data;
    next=null;
  }
}

class myStack<t>
{
	node<t> head;

	myStack()
	{
		head = null;
	}

	t top()
  {
    return head.data;
  }

	void push(t data)
	{
		if(head==null)
		{
			head=new node<>(data);
		}
		else
		{
			node<t> toAdd = new node<>(data);
			toAdd.next=head;
			head=toAdd;
		}
	}

	t pop()
	{
		if(head==null)
		{
			System.out.println("Stack empty");
		}

		else{
		node<t> toRem = head;
		head=head.next;
		toRem.next=null;
		return toRem.data;
		}
    return null;
	}
}

class Main{
	public static void main (String[] args)
	{
		myStack<Integer> test=new myStack<>();
		test.push(1);
		System.out.println(test.top());
		test.push(2);
		System.out.println(test.top());
    	System.out.println(test.pop());
    	System.out.println(test.top());
    	

	}
}