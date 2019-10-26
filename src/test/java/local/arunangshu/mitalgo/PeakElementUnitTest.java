package local.arunangshu.mitalgo;

import java.util.Comparator;
import junit.framework.TestCase;

public class PeakElementUnitTest extends TestCase {

  public void testGetPeakElement() {
    PeakElement<Integer> peakElementFinder = new PeakElement<Integer>();
    Comparator<Integer> comparator = (a,b) -> a.compareTo(b);
    Integer [] input1 = new Integer[] {1,2,3,4,5,6,4,3,0};
    assertTrue("Peak element should be 6",6 == peakElementFinder.getPeakElelement(input1, comparator).get());
    Integer [] input2 = new Integer[] {1,2,3};
    assertTrue("Peak element should be 3",3 == peakElementFinder.getPeakElelement(input2, comparator).get());
    Integer [] input3 = new Integer[] {3,2,1};
    assertTrue("Peak element should be 3",3 == peakElementFinder.getPeakElelement(input3, comparator).get());
    
    Integer [] input4 = new Integer[] {2,1};
    assertTrue("Peak element should be 2",2 == peakElementFinder.getPeakElelement(input4, comparator).get());
    Integer [] input5 = new Integer[] {1,2};
    assertTrue("Peak element should be 2",2 == peakElementFinder.getPeakElelement(input5, comparator).get());
    Integer [] input6 = new Integer[] {1};
    assertTrue("Peak element should be 1",1 == peakElementFinder.getPeakElelement(input6, comparator).get());
    Integer [] input7 = new Integer[] {};
    assertFalse(peakElementFinder.getPeakElelement(input7, comparator).isPresent());
    assertFalse(peakElementFinder.getPeakElelement(null, comparator).isPresent());
    assertFalse(peakElementFinder.getPeakElelement(input1,null).isPresent());
    
    
  }
}
