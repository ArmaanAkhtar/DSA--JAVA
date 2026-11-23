/**
 * Array-based CIRCULAR Queue (FIFO).
 * Indexes wrap around using modulo, so freed front slots are reused.
 * A 'size' counter distinguishes full from empty (no wasted slot).
 * enqueue/dequeue/peek: O(1)
 */
public class CircularQueue
{
    private final int[] arr;
    private int front = 0;
    private int rear = -1;
    private int size = 0;

    public CircularQueue(int capacity)
    {
        arr = new int[capacity];
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == arr.length; }

    public void enqueue(int data)
    {
        if (isFull())
        {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = data;
        size++;
    }

    public int dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue Underflow");
            return -1;
        }
        int data = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return data;
    }

    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    public void display()
    {
        if (isEmpty())
        {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Front -> ");
        for (int i = 0; i < size; i++)
            System.out.print(arr[(front + i) % arr.length] + " ");
        System.out.println("<- Rear");
    }

    public static void main(String[] args)
    {
        CircularQueue q = new CircularQueue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.display();
        System.out.println("Dequeued: " + q.dequeue());
        q.enqueue(4);        // works: freed slot is reused
        q.display();
        q.enqueue(5);        // Queue Overflow (really full)
    }
}
