public class StackBottomToTop
{
    private final int[] arr;
    private int top = -1;

    public StackBottomToTop(int size)
    {
        arr = new int[size];
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull()  { return top == arr.length - 1; }

    public void push(int data)
    {
        if (isFull())
        {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = data;
    }

    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }

    public void display()
    {
        if (isEmpty())
        {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.print("Top -> ");
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i] + " ");
        System.out.println("<- Bottom");
    }

    public static void main(String[] args)
    {
        StackBottomToTop s = new StackBottomToTop(3);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);          // Stack Overflow
        s.display();
        System.out.println("Popped: " + s.pop());
        System.out.println("Peek: " + s.peek());
        s.display();
    }
}
