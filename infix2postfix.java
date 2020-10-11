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

		myStack<Character> test=new myStack<>();
		
    String s=sc.nextLine();
    String postFix="";

    for(int i=0;i<s.length();i++)
    {
      char a = s.charAt(i);

      if((a>='A'&&a<='Z')||(a>='a'&&a<='z'))
      {
        postFix+=a;
      }

      else if(a=='(')
      {
        test.push(a);
      }

      else if(a==')')
      {
        while(test.top()!='(')
        {
          postFix+=test.pop();
        }
        test.pop();
      }

      else
      {
        if(a=='*'||a=='/'||a=='%')
        {
          while((!test.isEmpty())&&!(test.top()=='('||test.top()=='+'||test.top()=='-'))
          postFix+=test.pop();

          test.push(a);
        }

        else{
          while(!test.isEmpty()&&test.top()!='(')
          postFix+=test.pop();

          test.push(a);
        }
      }

    }

    while(!test.isEmpty())
    {
      postFix+=test.pop();
    }

    System.out.println(postFix);
	}
}