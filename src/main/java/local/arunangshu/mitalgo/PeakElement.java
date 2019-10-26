package local.arunangshu.mitalgo;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
/***
 * This a generic java class which returns peak element of an array of object using recursion.  
 * Given that all the left elements and the right elements of the peak element is lesser than the peak element and 
 * left elements are in increasing order and right elements are in decreasing order
 *
 * @author arunangshu
 *
 * @param <T>
 */

/*- Lets take an sample Integer array 1, 3, 6, 11, 4, 0 
 * Here 11 is the peak element
 *
 * 
 *      11    
 *     /  \ 
 *    6    4
 *   /       \
 *  3         0
 * /
 *1
 */

public class PeakElement<T> {

  /***
   * 
   * @param elements Array of object
   * @param comparator comparator to identify which item is greater
   * @param startIndex start index of array
   * @param endIndex end index of array 
   * @return 
   */
  private Optional<T> getPeakElelement(
      T[] elements, 
      Comparator<T> comparator, 
      int startIndex,
      int endIndex){
    int middleElementPosition =  (endIndex + startIndex)/2;
    if( endIndex - startIndex >= 2 ) { // when number of elements more than 2  
      // If the number is greater than left element and right element
      if((comparator.compare(elements[middleElementPosition],elements[middleElementPosition-1]) > 0)
          && (comparator.compare(elements[middleElementPosition],elements[middleElementPosition+1]) > 0)) {
        return Optional.of(elements[middleElementPosition]);
        // If the number is greater than left and lesser than right element.
      }else if((comparator.compare(elements[middleElementPosition],elements[middleElementPosition-1]) > 0)
          && (comparator.compare(elements[middleElementPosition],elements[middleElementPosition+1]) < 0)) {
        return getPeakElelement(elements, comparator, middleElementPosition+1, endIndex);
        // If the number is lesser than left and greater than right element.
      }else if((comparator.compare(elements[middleElementPosition],elements[middleElementPosition-1]) < 0)
          && (comparator.compare(elements[middleElementPosition],elements[middleElementPosition+1]) > 0)) {
        return getPeakElelement(elements, comparator, startIndex, middleElementPosition-1);
      }else {
        return Optional.empty();
      }
    }else {
      if( startIndex == endIndex)
        return Optional.of(elements[startIndex]);
      else {
        return Optional.of( (comparator.compare(elements[startIndex], elements[endIndex]) > 0 )
            ? elements[startIndex]
                : elements[endIndex]);
      }

    }
  }


  /***
   * 
   * @param elements Array of object
   * @param comparator  to identify which item is greater
   * @return Peak item of the array if found, or else return {@code Optional.empty()}
   */
  public Optional<T> getPeakElelement(T[] elements, Comparator<T> comparator){
    if ( Objects.nonNull(elements) 
        && elements.length > 0
        && Objects.nonNull(comparator)) {
      return getPeakElelement(elements, comparator,0,elements.length-1);
    }else {
      return Optional.empty();
    }
  }
  
  //TODO: write getPeakFinding Algo for 2D array

}
