// Consider a student database of SY COMP class (at least 15 records). Database contains different 
// fields of every student like Roll No, Name and SGPA.  
// a. Design a roll call list, arrange list of students according to roll numbers in ascending order 
// using Insertion Sort 
// b. Arrange list of students alphabetically using shell sort 
// c. Arrange list of students to find out first ten toppers from a class using Radix sort   
import java.util.*;

class student
{
    private String name ;
    private int rollno;
    private double gpa; 
    student(String n,int r,double g)
    {
        name = n;
        rollno = r;
        gpa = g;
    }
    static void insertionSort(student [] s, int n)
    {
        for(int i=1;i<n;i++)
        {
            int j = i-1;
            student val = s[i];
            while(j>=0 && val.rollno < s[j].rollno)
            {
               // s[j+1].rollno = s[j].rollno;
                s[j+1] = s[j];
                j--;
            }
           // s[j+1].rollno = val;
            s[j+1]  = val;
        }
    }
    static void shellSort(student [] s,int n)
    {
        int gap = n/2;
        while(gap>=1)
        {
            for(int j=gap;j<n;j++)
            {
                for(int i=j-gap;i>=0;i=i-gap)
                {
                    if(s[i+gap].name.compareTo(s[i].name)>0)
                   // if(s[i+gap].name>s[i+gap].name) can,t use in java bcoz ">" can't compare strings
                      break;
                    else
                    {
                       student temp = s[i+gap];
                       s[i+gap]=s[i];
                       s[i] = temp;
                    }
                }
            }
            gap = gap/2;
        }
    }
   
    void display()
    {
        System.out.println(rollno+"] name : "+name +"  gpa : "+gpa);
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of students : ");
        int n = sc.nextInt();
        sc.nextLine();
        student [] s = new student[n];
        System.out.println("Enter the student data \nname rollno marks : ");

        for(int i=0;i<n;i++)
        {
            String name = sc.next();
            int r = sc.nextInt();
            double d = sc.nextDouble();
            sc.nextLine();
            s[i] = new student (name,r,d); 
        }
        System.out.println("\n1.Sort using insertion sort(according to roll nuumber.)\n2.Sort using shell sort(according to name)");
        
        
        String con = "y";
        while(con.equals("y"))
        {
            System.out.print("Enter the choice : ");
            int choice = sc.nextInt();
            sc.nextLine();
        switch(choice)
        {
            case 1 :
            student.insertionSort(s,n);
            for(int i=0;i<n;i++)
            {
               s[i].display();
            }
            break;

            case 2:
            student.shellSort(s,n);
            for(int i=0;i<n;i++)
            {
                s[i].display();
            }
            break;

            default :
            System.out.print("enter a valid choice.");
        }
        System.out.print("press y if wish to continue : ");
        con = sc.nextLine();
        } 
    sc.close();     
    }
}