class Employee {
    int ID, Age;
    String Name, Email;

    Employee(int id, int age, String name, String email) {
        ID = id;
        Age = age;
        Name = name;
        Email = email;
    }
}

class Department {
    int ID;
    String Name;

    Department(int id, String name) {
        ID = id;
        Name = name;
    }
}

class Company {
    Employee Emp;
    Department Dpt;

    Company(Employee emp, Department dpt) {
        Emp = emp;
        Dpt = dpt;
    }
}

class Node {
    Company cmp;
    Node Next, Prev;

    Node(Company c) {
        cmp = c;
        Next = null;
        Prev = null;
    }
}

class DLL {
    private Node Head, Tail;

    public DLL() {
        Head = null;
        Tail = null;
    }

    public boolean isEmpty() {
        return Head == null;
    }

    public void createNodeStart(Company c) {
        Node newNode = new Node(c);

          if (isEmpty()) {
                Head = newNode;
                Tail = newNode;
          }
          else {
              newNode.Next = Head;
              Head.Prev = newNode;
              Head = newNode;
          }
    }
     public void createNodeEnd(Company c) {
         Node newNode = new Node(c);

        if (isEmpty()) {
            Head = newNode;
            Tail = newNode;
        }
        else {
            newNode.Prev = Tail;
            Tail.Next = newNode;
            Tail = newNode;
        }
    }


    public void createNodeBTW(Company found, Company add)
    {
        Node temp = Head;

        while(temp != null)
        {
            if(temp.cmp.Emp.ID == found.Emp.ID)
            {
                Node newNode = new Node(add);
                newNode.cmp = add;

                newNode.Next = temp.Next;
                newNode.Prev = temp;

                if(temp.Next != null)
                    temp.Next.Prev = newNode;
                else
                    Tail = newNode;

                temp.Next = newNode;
                return;
            }

            temp = temp.Next;
        }

        System.out.println("Company not found");
    }


    private void displayCompany(Company c) {
        System.out.println("Employee ID: " + c.Emp.ID + ", Name: " + c.Emp.Name + ", Age: " + c.Emp.Age + ", Email: " + c.Emp.Email + ", Department ID: " + c.Dpt.ID + ", Department: " + c.Dpt.Name);
    }


    public void DisplayLTOR() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node Current = Head;

        while (Current != null) {
            displayCompany(Current.cmp);
            Current = Current.Next;
        }
    }

    public void DisplayRTOL() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node Current = Tail;

        while (Current != null) {
            displayCompany(Current.cmp);
            Current = Current.Prev;
        }
    }


    public void deletefirst() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        if (Head == Tail) {
            Head = null;
            Tail = null;
        } else {
            Node Current = Head;
            Head = Head.Next;
            Head.Prev = null;
            Current.Next = null;
        }
    }

     public void deletelast() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        if (Head == Tail) {
            Head = null;
            Tail = null;
        } else {
            Node Current = Tail;
            Tail = Tail.Prev;
            Tail.Next = null;
            Current.Prev = null;
        }
    }


    public void deleteBTW(Company found)
    {
        Node temp = Head;

        while(temp != null)
        {
            if(temp.cmp.Emp.ID == found.Emp.ID)
            {
                if(temp == Head)
                    Head = temp.Next;
                else
                    temp.Prev.Next = temp.Next;

                if(temp == Tail)
                    Tail = temp.Prev;
                else
                    temp.Next.Prev = temp.Prev;

                return;
            }

            temp = temp.Next;
        }

        System.out.println("Company not found");
    }


    public void update(Company found, Company replace)
    {
        Node temp = Head;

        while(temp != null)
        {
            if(temp.cmp.Emp.ID == found.Emp.ID)
            {
                temp.cmp = replace;
                return;
            }

            temp = temp.Next;
        }

        System.out.println("Company not found");
    }
}

public class LinkedList {
    public static void main(String[] args) {

        DLL list = new DLL();

        Employee e1 = new Employee(100, 20, "Armaan", "armaan@gmail.com");
        Department d1 = new Department(1, "Data Science");
        Company c1 = new Company(e1, d1);

        Employee e2 = new Employee(101, 22, "Mughal", "Mughal@gmail.com");
        Department d2 = new Department(2, "AI Automation");
        Company c2 = new Company(e2, d2);

        Employee e3 = new Employee(102, 20, "Akash", "Akash@gmail.com");
        Department d3 = new Department(3, "Machine Learning");
        Company c3 = new Company(e3, d3);

        Employee e4 = new Employee(103, 23, "Ved", "ved@gmail.com");
        Department d4 = new Department(4, "Web Development");
        Company c4 = new Company(e4, d4);


        list.createNodeStart(c1);
        list.createNodeEnd(c2);
        list.createNodeEnd(c3);
        list.createNodeBTW(c2, c4);
        System.out.println("List Left to Right:");
        list.DisplayLTOR();
        System.out.println("\nList Right to Left:");
        list.DisplayRTOL();

        Employee e5 = new Employee(104, 19, "Yousuf", "Yousuf@gmail.com");
        Department d5 = new Department(3, "App Development");
        Company c5 = new Company(e5, d5);

        list.update(c3, c5);
        System.out.println("\nAfter Update:");
        list.DisplayLTOR();
        list.deleteBTW(c4);
        System.out.println("\nAfter Deleting Employee ID 104:");
        list.DisplayLTOR();
        list.deletefirst();
        list.deletelast();
        System.out.println("\nFinal List:");
        list.DisplayLTOR();
    }
}

