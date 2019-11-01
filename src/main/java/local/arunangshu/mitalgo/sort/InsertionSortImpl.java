package local.arunangshu.mitalgo.sort;

import java.util.Comparator;
import java.util.Objects;

public class InsertionSortImpl<T> implements Sort<T> {

  @Override
  public void sort(T[] array, Comparator<T> comparator) {
    if( Objects.isNull(array) || Objects.isNull(comparator)) {
      //Array and comparator should not be null
      return;
    }
    for(int i=0; i < array.length; i++) {
      T key = array[i];
      int j = i-1;
      
      /* Move elements of arr[0..i-1], that are  
      greater than key, to one position ahead  
      of their current position */
      while (j >= 0 && comparator.compare(array[j], key) > 0){
        array[j+1] = array[j]; 
        j--;
      }
      array[j+1] = key;
    }
  }

}
  