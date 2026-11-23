/**
 * Array-based LINEAR Queue (FIFO).
 * enqueue at rear, dequeue at front.
 * Drawback: after dequeues, freed slots at the front are never reused
 * (queue can say "full" while space exists) -> solved by CircularQueue.
 * enqueue/dequeue/peek: O(1)
 */
public class SimpleQueue
{
    private final int[] arr;
    private int front = 0;
    private int rear = -1;

    public SimpleQueue(int size)
    {
        arr = new int[size];
    }

    public boolean isEmpty() { return front > rear; }
    public boolean isFull()  { return rear == arr.length - 1; }

    public void enqueue(int data)
    {
        if (isFull())
        {
            System.out.println("Queue Overflow");
            return;
        }
        arr[++rear] = data;
    }

    public int dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue Underflow");
            return -1;
        }
        return arr[front++];
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
        for (int i = front; i <= rear; i++)
            System.out.print(arr[i] + " ");
        System.out.println("<- Rear");
    }

    public static void main(String[] args)
    {
        SimpleQueue q = new SimpleQueue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.display();
        System.out.println("Dequeued: " + q.dequeue());
        q.enqueue(4);        // Queue Overflow (freed slot is NOT reused)
        q.display();
    }
}
