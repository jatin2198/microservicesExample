package java_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List email=Arrays.asList("xyz@gmail.com","y2j@gmail.com","shiv@gmail.com","shera@gmail.com");
List mobile=Arrays.asList(9676557,12345,465859,997698);
Employee e=new Employee("Rocky", "Delhi", 24, email, mobile);
Employee e2=new Employee("Roc", "Delhi", 24, email, mobile);
List<Employee> list=new ArrayList<Employee>();
list.add(e);
list.add(e2);

List i=list.stream().flatMap(item->item.getEmail().stream()).collect(Collectors.toList());
System.out.println(i);

Map<String, List<Employee>> map=list.stream().collect(Collectors.groupingBy(Employee::getAddress));
	
	System.out.println(map);
	}

}
