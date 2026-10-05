class DynamicIntArray{

        private int array[], size;

        public DynamicIntArray(){
            array = new int[3];
            size = 0;
        }

        public int ArraySize(){
            return size;
        }

        public void add(int data){
            if(size == array.length){
                int temp[] = new int[array.length+3];
                for(int i=0; i<size; i++){
                    temp[i]=array[i];
                }
            }
            array[size]=data;
            size++;
        }

        public void display(){
            System.out.print("Array:[");
            for(int i=0; i<size;i++){
                System.out.print(array[i]);
                if(i< size-1){
                    System.out.print(", ");
                }
            }
            System.out.print("]\n");
        }

        public void indexof(int i){
            if(i >=0 && i<size){
                System.out.println("\nArray data on index "+i+" is: "+array[i]);
            }
            else{
                System.out.print("Invalid index Error");
            }
        }

        public void InsertBetween(int index,int data){
            if(index>=0 && index<=size){
                if(size == array.length){
                    int temp[] = new int[array.length+3];
                    for(int i=0;i<size;i++){
                        temp[i]=array[i];
                    }
                    array = temp;
                }
                for(int i = size-1; i>=index; i--){
                    array[i+1] = array[i];
                }
                array[index] = data;
                size++;
            }
            else{
                System.out.println("Invalid");
            }
        }

        public void delete(int index){
            if (index >= 0 && index < size) {

                for (int i = index; i < size - 1; i++) {
                    array[i] = array[i + 1];
                }

                size--;

            } else {
                System.out.println("Error: Invalid index");
            }
        }


        public static void main(String[] args){
            DynamicIntArray arr = new DynamicIntArray();
            arr.add(5);
            arr.add(15);
            arr.add(25);
            arr.display();
            arr.indexof(2);
            arr.InsertBetween(1,60);
            arr.display();
            arr.delete(2);
            arr.display();
        }
    }

