/**
 * Searching algorithms: Linear Search (int, float, String) and Binary Search.
 * Linear: O(n) time, O(1) space, works on unsorted data.
 * Binary: O(log n) time, O(1) space, array MUST be sorted.
 */
public class Search
{
    // ---------- Linear Search ----------
    public static void Linear(int[] arr, int data)
    {
        int loc = -1;
        for (int i = 0; i < arr.length; i++)
        {
            if (data == arr[i])
            {
                System.out.println("Data " + arr[i] + " at index " + i);
                loc = i;
                break;
            }
        }
        if (loc == -1)
            System.out.println("Data Not Found");
    }

    public static void Linear(float[] arr, float data)
    {
        int loc = -1;
        for (int i = 0; i < arr.length; i++)
        {
            if (data == arr[i])
            {
                System.out.println("Data " + arr[i] + " at index " + i);
                loc = i;
                break;
            }
        }
        if (loc == -1)
            System.out.println("Data Not Found");
    }

    // Case-sensitive String search (uses custom compare)
    public static void Linear(String[] arr, String data)
    {
        int loc = -1;
        for (int i = 0; i < arr.length; i++)
        {
            if (compare(arr[i], data))
            {
                System.out.println("Data " + arr[i] + " at index " + i);
                loc = i;
                break;
            }
        }
        if (loc == -1)
            System.out.println("Data Not Found");
    }

    // Case-INSENSITIVE String search (the "Home Work" version)
    public static void LinearIgnoreCase(String[] arr, String data)
    {
        int loc = -1;
        for (int i = 0; i < arr.length; i++)
        {
            if (compareIgnoreCase(arr[i], data))
            {
                System.out.println("Data " + arr[i] + " at index " + i);
                loc = i;
                break;
            }
        }
        if (loc == -1)
            System.out.println("Data Not Found");
    }

    public static boolean compare(String str1, String str2)
    {
        if (str1.length() != str2.length())
            return false;
        for (int i = 0; i < str1.length(); i++)
        {
            if (str1.charAt(i) != str2.charAt(i))
                return false;
        }
        return true;
    }

    public static boolean compareIgnoreCase(String str1, String str2)
    {
        if (str1.length() != str2.length())
            return false;
        for (int i = 0; i < str1.length(); i++)
        {
            if (toLower(str1.charAt(i)) != toLower(str2.charAt(i)))
                return false;
        }
        return true;
    }

    // 'A'-'Z' (65-90) -> 'a'-'z' (97-122): add 32
    private static char toLower(char c)
    {
        return (c >= 'A' && c <= 'Z') ? (char) (c + 32) : c;
    }

    // ---------- Binary Search (array must be sorted) ----------
    public static void Binary(int[] arr, int data)
    {
        int l = 0, h = arr.length - 1;
        while (l <= h)
        {
            int m = l + (h - l) / 2;   // avoids int overflow
            if (arr[m] == data)
            {
                System.out.println("Data " + arr[m] + " at index " + m);
                return;
            }
            else if (data > arr[m])
                l = m + 1;
            else
                h = m - 1;
        }
        System.out.println("Not Found");
    }

    public static void main(String[] args)
    {
        Search.Binary(new int[]{2,4,5,7,8,10,22,25,45,56,58,96}, 10);
        Search.Binary(new int[]{2,4,5,7,8,10,22,25,45,56,58,96}, 99);

        String[] name = {"Zohra","Maryam","Yousuf","Prinka","Madiha"};
        Search.Linear(name, "madiha");            // case-sensitive -> Not Found
        Search.LinearIgnoreCase(name, "madiha");  // homework version -> found

        Search.Linear(new int[]{20,10,30,40,11,51,2,1,8,9,23}, 10);
        Search.Linear(new float[]{1.5f,50.2f,8.5f,2.3f,45.6f}, 8.5f);
    }
}
