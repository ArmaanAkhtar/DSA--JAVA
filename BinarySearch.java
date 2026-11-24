class BinarySearch{

    public static void binary(String[] arr, String data){
        int l = 0, h = arr.length-1;

        while(l<=h){
            int m = (l+h)/2;
            int r = compare(arr[m], data);

            if(r == 0){
                System.out.println("Data:"+arr[m]+" is at "+m);
                return;
            }
            else if(r < 0){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }

        System.out.println("Data not found");
    }

    public static char tolower(char c){
        if(c>='A' && c<='Z'){
            return (char)(c+32);
        }
        return c;
    }

    public static int compare(String str1, String str2){
        int i = 0;

        while(i<str1.length() && i<str2.length()){
            char c1 = tolower(str1.charAt(i));
            char c2 = tolower(str2.charAt(i));

            if(c1 != c2){
                return c1-c2;
            }
            i++;
        }

        return str1.length()-str2.length();
    }

    public static void main(String[] args){
        String[] name = {"Akash","Akhtar","Armaan","ARMAan","mughal","MUghal"};
        BinarySearch.binary(name, "armaan");
        BinarySearch.binary(name, "AKHTAR");
        BinarySearch.binary(name, "akash");
        BinarySearch.binary(name, "MUGHAL");
        BinarySearch.binary(name, "Ved");
    }
}
