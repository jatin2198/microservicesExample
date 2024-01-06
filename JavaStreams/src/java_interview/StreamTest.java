package java_interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		  List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
		  
		 // myList.stream().filter(item->item.toString().substring(0,1).equals("1")).forEach(i->System.out.println(i));
	
		  List<Integer> dup = Arrays.asList(10,15,8,49,25,98,98,32,15);
		  Set<Integer> set=new HashSet<>();
		 // dup.stream().filter(item->Collections.frequency(dup, item)>1).forEach(i->System.out.println(i));
		  //System.out.println("10".substring(0,1));
		  
		  //dup.stream().filter(i->!set.add(i)).forEach(j->System.out.println(j));
		  //set.addAll(dup);
		  
		  //dup.forEach(i->set.stream().filter(i));
		  
		  String input = "ttttk".replaceAll(" ", "").toLowerCase();
		  
		//char c=  input.chars().;
		
		  List<Character> c=new ArrayList<Character>();
		  
		  for(int i=0;i<input.length();i++) {
		  
		  c.add(input.charAt(i)); }
		 
		  
		 // c.stream().distinct().forEach(i->System.out.print(i+" "));
		  
		//char item=  c.stream().filter(i->!(Collections.frequency(c, i)>1)).findFirst().get();
		  
	//System.out.println(item);
		  
		  List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
		  
		  Map<String,Long> namesCount =  names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	//System.out.println(namesCount);
	
	 Map<String,Long> namesCount2 =  names.stream().filter(i->Collections.frequency(names, i)>1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		/*
		 * System.out.println(namesCount); System.out.println(namesCount2);
		 */
	
int sum=		myList.stream().reduce(0,(a,b)->a+b);

//System.out.println(sum);

String s=names.parallelStream().reduce((a,b)->a+"-"+b).get();
System.out.println(s);

List str=Arrays.asList("Jatin","Shivam","Ram","Sham");
//str.sort(Comparator.reverseOrder() );

//System.out.println(str);



	}
	
	
}





