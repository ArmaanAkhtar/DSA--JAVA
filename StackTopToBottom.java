/**
 * Array-based Stack, grows TOP -> BOTTOM.
 * The bottom of the stack is the LAST index; top starts at arr.length (empty)
 * and moves toward index 0. push: top-- then store.
 * push/pop/peek: O(1)
 */
public class StackTopToBottom
{
    private final int[] arr;
    private int top;

    public StackTopToBottom(int size)
    {
        arr = new int[size];
        top = size;               // empty
    }

    public boolean isEmpty() { return top == arr.length; }
    public boolean isFull()  { return top == 0; }

    public void push(int data)
    {
        if (isFull())
        {
            System.out.println("Stack Overflow");
            return;
        }
        arr[--top] = data;
    }

    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top++];
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
        for (int i = top; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("<- Bottom");
    }

    public static void main(String[] args)
    {
        StackTopToBottom s = new StackTopToBottom(3);
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
