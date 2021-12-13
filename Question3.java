public class Question3 { 
    
    // returns 1 if key is in list and -1 if key is not in list.
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) { 
      for(E e: list){

        if(e.equals(key)){

            return 1;

        }

      }
      return -1;
    } 
     
    public static void main(String[] args) { 
      Integer[] list = {3, 4, 5, 1, -3, -5, -1}; 
      System.out.println(linearSearch(list, 2)); 
      System.out.println(linearSearch(list, 5));  
    } 
  }