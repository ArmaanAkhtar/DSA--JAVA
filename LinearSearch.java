class LinearSearch{

    public static void linear(String[] arr, String data){
        int loc = -1;

        for (int i = 0; i<arr.length; i++){
            if(compare(arr[i], data)){
                System.out.println("Data:"+arr[i]+" is at "+i);
                loc = i;
                break;
            }
        }

        if(loc == -1){
            System.out.println("Data not found");
        }
    }

    public static char tolower(char c){
        if(c>='A' && c<='Z'){
            return (char)(c+32);
        }
        return c;
    }

    public static boolean compare(String str1, String str2){
        if(str1.length() == str2.length()){
            for(int i = 0; i<str1.length(); i++){
                if(tolower(str1.charAt(i)) != tolower(str2.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        String[] name = {"Armaan","Akhtar","ARMAan","Akash","mughal","MUghal"};
        LinearSearch.linear(name, "armaan");
        LinearSearch.linear(name, "AKHTAR");
        LinearSearch.linear(name, "akash");
        LinearSearch.linear(name, "MUGHAL");
        LinearSearch.linear(name, "ved");
    }
}
