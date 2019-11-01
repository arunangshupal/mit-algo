package local.arunangshu.mitalgo.util;

import java.util.Calendar;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
  String name;
  float age;
  long salary;
  Calendar dateOfJoining;
}
