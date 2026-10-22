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
    Node Next;

    Node(Company c)
    {
        cmp = c;
        Next = null;
    }
}

class SCLL
{
    private Node Head, Tail;

    public SCLL(){
        Head = null;
        Tail = null;
    }
    public boolean isEmpty(){
        return Head == null;
    }

    // Pehla node khud ko hi point karega
    private void firstNode(Node n)
    {
        Head = Tail = n;
        n.Next = n;
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
        Head = n;
        Tail.Next = Head;
    }

    public void createNodeEnd(Company c)
    {
        Node n = new Node(c);
        if (isEmpty()) {
            firstNode(n);
            return;
        }
        Tail.Next = n;
        Tail = n;
        Tail.Next = Head;
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
        printReverse(Head);
    }

    private void printReverse(Node current)
    {
        if (current != Tail) printReverse(current.Next);
        System.out.println(current.cmp);
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
        Node current = Head;
        while (current.Next != Tail){
            current = current.Next;
        }
        current.Next = Head;
        Tail = current;
    }

    public void deleteBTW(Company found)
    {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        if (Head.cmp == found) {
            deletefirst();
            return;
        }
        Node prev = Head;
        while (prev.Next != Head && prev.Next.cmp != found) {
            prev = prev.Next;
        }
        if (prev.Next == Head) {
            System.out.println("Node not found!");
            return;
        }
        if (prev.Next == Tail) {
            deletelast();
            return;
        }
        prev.Next = prev.Next.Next;
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

public class SinglyCircular
{
    public static void main(String[] args) {
        SCLL list = new SCLL();

        Company c1 = new Company(new Employee(1, 20, "Armaan", "Armaan@mail.com"), new Department(101, "Data Science"));
        Company c2 = new Company(new Employee(2, 22, "Akash", "Akash@mail.com"), new Department(102, "Machine lEarning"));
        Company c3 = new Company(new Employee(3, 21, "Mughal", "Mughal@mail.com"), new Department(103, "AI Automation"));
        Company c4 = new Company(new Employee(4, 20, "Ved", "Ved@mail.com"), new Department(104, "IT Sales"));
        Company c5 = new Company(new Employee(5, 23, "Ayan", "Ayan@mail.com"), new Department(105, "APP developer"));

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
