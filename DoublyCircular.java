class Employee
{
    int ID, Age;
    String Name, Email;

    Employee(int ID, int Age, String Name, String Email)
    {
        this.ID = ID;
        this.Age = Age;
        this.Name = Name;
        this.Email = Email;
    }
}

class Department
{
    int ID;
    String Name;

    Department(int ID, String Name)
    {
        this.ID = ID;
        this.Name = Name;
    }
}

class Company
{
    Employee Emp;
    Department Dpt;

    Company(Employee Emp, Department Dpt)
    {
        this.Emp = Emp;
        this.Dpt = Dpt;
    }

    public String toString()
    {
        return "[Emp ID: " + Emp.ID + ", Name: " + Emp.Name + ", Age: " + Emp.Age + ", Email: " + Emp.Email + " | Dept ID: " + Dpt.ID + ", Dept: " + Dpt.Name + "]";
    }
}

class Node
{
    Company cmp;
    Node Next, Prev;

    Node(Company c)
    {
        cmp = c;
        Next = null;
        Prev = null;
    }
}

class DCLL
{
    private Node Head, Tail;
    public DCLL(){
        Head = null;
        Tail = null;
    }
    public boolean isEmpty(){
        return Head == null;
    }

    // Pehla node: Next aur Prev dono khud ko point karenge
    private void firstNode(Node n)
    {
        Head = Tail = n;
        n.Next = n;
        n.Prev = n;
    }

    private Node search(Company found)
    {
        if (isEmpty()){
            return null;
        }
        Node current = Head;
        do
        {
            if (current.cmp == found){
                return current;
            }
            current = current.Next;
        }
        while (current != Head);
        return null;
    }

    public void createNodeStart(Company c)
    {
        Node n = new Node(c);
        if (isEmpty()) {
            firstNode(n);
            return;
        }
        n.Next = Head;
        n.Prev = Tail;
        Head.Prev = n;
        Tail.Next = n;
        Head = n;
    }

    public void createNodeEnd(Company c)
    {
        Node n = new Node(c);
        if (isEmpty()) {
            firstNode(n);
            return;
        }
        n.Prev = Tail;
        n.Next = Head;
        Tail.Next = n;
        Head.Prev = n;
        Tail = n;
    }

    public void createNodeBTW(Company found, Company add)
    {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node current = search(found);
        if (current == null) {
            System.out.println("Node not found!");
            return;
        }
        if (current == Tail) {
            createNodeEnd(add);
            return;
        }
        Node n = new Node(add);
        n.Next = current.Next;
        n.Prev = current;
        current.Next.Prev = n;
        current.Next = n;
    }

    public void DisplayLTOR()
    {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node current = Head;
        do
        {
            System.out.println(current.cmp);
            current = current.Next;
        }
        while (current != Head);
    }

    public void DisplayRTOL()
    {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node current = Tail;
        do
        {
            System.out.println(current.cmp);
            current = current.Prev;
        }
        while (current != Tail);
    }

    public void deletefirst()
    {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        if (Head == Tail) {
            Head = Tail = null;
            return;
        }
        Head = Head.Next;
        Head.Prev = Tail;
        Tail.Next = Head;
    }

    public void deletelast()
    {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        if (Head == Tail) {
            Head = Tail = null;
            return;
        }
        Tail = Tail.Prev;
        Tail.Next = Head;
        Head.Prev = Tail;
    }

    public void deleteBTW(Company found)
    {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node current = search(found);
        if (current == null) {
            System.out.println("Node not found!");
            return;
        }
        if (current == Head) {
            deletefirst();
            return;
        }
        if (current == Tail) {
            deletelast();
            return;
        }

        current.Prev.Next = current.Next;
        current.Next.Prev = current.Prev;
    }

    public void update(Company found, Company replace)
    {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node current = search(found);
        if (current == null) {
            System.out.println("Node not found!");
            return;
        }
        current.cmp = replace;
    }
}

public class DoublyCircular
{
    public static void main(String[] args) {
        DCLL list = new DCLL();

        Company c1 = new Company(new Employee(1, 20, "Armaan", "armaan@mail.com"), new Department(101, "Data Science"));
        Company c2 = new Company(new Employee(2, 21, "Ved", "Ved@mail.com"), new Department(102, "IT sales"));
        Company c3 = new Company(new Employee(3, 23, "Mughal", "Mughal@mail.com"), new Department(103, "AI Automation"));
        Company c4 = new Company(new Employee(4, 20, "Akash", "Akash@mail.com"), new Department(104, "Machine lEarning"));
        Company c5 = new Company(new Employee(5, 22, "Ayan", "Ayan@mail.com"), new Department(105, "APP development"));

        list.createNodeStart(c2);
        list.createNodeEnd(c3);
        list.createNodeBTW(c2, c4);
        list.DisplayLTOR();
        list.DisplayRTOL();
        list.update(c4, c5);
        list.DisplayLTOR();
        list.deletefirst();
        list.deletelast();
        list.DisplayLTOR();
        list.deleteBTW(c5);
        list.DisplayLTOR();
    }
}
