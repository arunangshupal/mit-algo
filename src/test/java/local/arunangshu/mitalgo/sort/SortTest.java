package local.arunangshu.mitalgo.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import junit.framework.TestCase;
import local.arunangshu.mitalgo.util.Employee;
import local.arunangshu.mitalgo.util.EmployeeDao;

public class SortTest extends TestCase{

  private static <T> void sort(T[] array,Sort<T> sortAlgo,Comparator<T> comparator ){
    sortAlgo.sort(array, comparator);
  }

  public void testInsertionSort() {
    Collection<Employee> employees = new EmployeeDao().getEmployees();
    Employee[] employeesArr = employees.toArray(new Employee[employees.size()]);
    

    System.out.println("Employees Before sorting by name");
    employees.forEach(e -> System.out.println(e.getName()));
    Comparator<Employee> compareByName = (e1,e2) -> e1.getName().compareTo(e2.getName());
    sort(
        employeesArr, 
        new InsertionSortImpl<Employee>(), 
        compareByName);

    System.out.println("Employees after sorting by name");
    Arrays.asList(employeesArr)
    .stream()
    .forEach(e -> System.out.println(e.getName()));
    
    
    
    
    System.out.println("Employees Before sorting by DOJ");
    employees.forEach(e -> System.out.println(
        e.getName() + "-- DOJ:"+ e.getDateOfJoining().getTime().toString()));
    Comparator<Employee> compareByDoj = 
        (e1,e2) -> e1.getDateOfJoining().compareTo(e2.getDateOfJoining());
    sort(
        employeesArr, 
        new InsertionSortImpl<Employee>(), 
        compareByDoj);

    System.out.println("Employees after sorting by DOJ");
    Arrays.asList(employeesArr)
    .stream()
    .forEach(e -> System.out.println( 
        e.getName() + "-- DOJ:"+ e.getDateOfJoining().getTime().toString()));
    
  }

}
