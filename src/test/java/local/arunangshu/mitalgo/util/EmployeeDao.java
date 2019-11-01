package local.arunangshu.mitalgo.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;

public class EmployeeDao {
  public Collection<Employee> getEmployees(){
    return Arrays.<Employee>asList(   
        new Employee("Mortal",22.5f,100000,new GregorianCalendar(2018, 10, 23)),
        new Employee("Dynamo",26f,150000,new GregorianCalendar(2018, 1, 3)),
        new Employee("Regaltos",18.1f,1000,new GregorianCalendar(2019, 8, 10)),
        new Employee("Viper",22f,10000,new GregorianCalendar(2018, 12, 17))
        );
  }
}