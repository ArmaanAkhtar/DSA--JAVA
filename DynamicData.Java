class Employee{
    int Id;
    String name;
}

class DynamicData{

    private Employee Employees[];
    private int size;

    public DynamicData(){
        Employees = new Employee[3];
        size = 0;
    }

    public int DataSize(){
        return size;
    }

    public void Indexof(int i){
        if(i >= 0 && i < size)
        {
            System.out.println("Employee at index " + i + " Id: " + Employees[i].Id + " Name: " + Employees[i].name);
        }
        else
        {
            System.out.println("Error: Invalid index");
        }
    }

    public void add(Employee data){
        if(size == Employees.length){
            Employee temp[]= new Employee[Employees.length+3];
            for(int i=0;i<size;i++){
                temp[i]=Employees[i];
            }
            Employees = temp;
        }
        Employees[size] = data;
        size++;
    }

    public void display(){
        for(int i = 0; i < size; i++)
        {
            System.out.println("Id: " + Employees[i].Id + ", Name: " + Employees[i].name);
        }
    }

    public void InsertBetween(int index,Employee data){
        if(index >= 0 && index <= size)
        {
            if(size == Employees.length)
            {
                Employee[] temp = new Employee[Employees.length + 3];

                for(int i = 0; i < size; i++)
                {
                    temp[i] = Employees[i];
                }
                Employees = temp;
            }
            for(int i = size - 1; i >= index; i--)
            {
                Employees[i + 1] = Employees[i];
            }
            Employees[index] = data;
            size++;
        }
        else
        {
            System.out.println("Error: Invalid index");
        }
    }

    public void delete(int index){
        if(index >= 0 && index < size)
        {
            for(int i = index; i < size - 1; i++)
            {
                Employees[i] = Employees[i + 1];
            }

            size--;
        }
        else
        {
            System.out.println("Error: Invalid index");
        }
    }

    public static void main(String[] args){

        DynamicData Data = new DynamicData();

        Employee e1  = new Employee();
        e1.Id=10;
        e1.name="Armaan";

        Employee e2  = new Employee();
        e2.Id=11;
        e2.name="Suleman";

        Employee e3  = new Employee();
        e3.Id=12;
        e3.name="Ashraf";

        Data.add(e1);
        Data.add(e2);
        Data.add(e3);

        System.out.println("After Adding:");
        Data.display();
        System.out.println("Size: " + Data.DataSize());

        Employee e4  = new Employee();
        e4.Id=13;
        e4.name = "Ali";
        Employee e5  = new Employee();
        e5.Id = 14;
        e5.name ="Ahmed";

        Data.InsertBetween(3,e4);
        Data.InsertBetween(1,e5);

        System.out.println("\nAfter Inserting:");
        Data.display();
        System.out.println("Size: " + Data.DataSize());

        Data.delete(2);

        System.out.println("\nAfter Deleting Index 2:");
        Data.display();
        System.out.println("Size: " + Data.DataSize());
    }
}