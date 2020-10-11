import java.util.Scanner;
class Main {

  public static int[] SelectionSort(int[] a)
  {
    for(int i=0;i<a.length-1;i++)
    {
      int min=i;
      for(int j=i+1;j<a.length;j++)
      {
        if(a[j]<a[min])
        min=j;

      }
      if(min==i) continue;
      else{
        int temp=a[i];
        a[i]=a[min];
        a[min]=temp;
      }
    }
    return a;
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] a=new int[n];
    for(int i=0;i<n;i++)
    {
      a[i]=sc.nextInt();
    }

    a=SelectionSort(a);
    for(int i:a){
      System.out.print(i+" ");
    }
  }
}