import java.util.Scanner;

class myStack<t>
{
	static class node<t>
	{
		t data;
		node next;
		node(t data)
		{
			this.data=data;
			next=null;
		}
	}

	node<t> head;

	myStack()
	{
		head = null;
	}

  boolean isEmpty()
  {
    return head==null;
  }

	void push(t data)
	{
		if(head==null)
		{
			head=new node<t>(data);
		}
		else
		{
			node<t> toAdd = new node(data);
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

  t top()
  {
    return head.data;
  }
}

class Main{
	public static void main (String[] args)
	{ 
    Scanner sc = new Scanner(System.in);
    myStack<Integer>test = new myStack<>();

    String s = sc.nextLine();

    for(int i=0;i<s.length();i++)
    { 
      char a=s.charAt(i);
      if(a>='0'&&a<='9')
      {
        String num = "";num+=a;
        i++;
        while(s.charAt(i)!=' ')
        {
          num+=s.charAt(i);
          i++;
        }
        test.push(Integer.parseInt(num));
      }

      else
      {
        if(a=='+')
        {
          int b=test.pop();
          test.push(test.pop()+b);
        }
        else if(a=='-')
        {
          int b =test.pop();
          test.push(test.pop()-b);
        }
        else if(a=='*')
        {
          int b =test.pop();
          test.push(test.pop()*b);
        }
        else if(a=='/')
        {
          int b =test.pop();
          test.push(test.pop()/b);
        }
        else if(a=='%')
        {
          int b =test.pop();
          test.push(test.pop()%b);
        }
      }
    }

    System.out.print(test.pop());


		
	}
}