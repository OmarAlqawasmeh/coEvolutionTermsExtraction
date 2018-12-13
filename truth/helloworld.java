package truth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class helloworld {
	
	public static void main(String[] args){
		
		 List<String> lista =new ArrayList<String>();
         List<String> listb =new ArrayList<String>();

         lista.add("Isabella");
         lista.add("Angelina");
         lista.add("Pille");
         lista.add("Hazem");

         listb.add("Isabella");
         listb.add("Angelina");
         listb.add("Bianca");

         // Create an aplusb list which will contain both list (list1 and list2) in which common element will occur twice 
         List<String> listapluslistb =new ArrayList<String>(lista);    
         listapluslistb.addAll(listb);

         // Create an aunionb set which will contain both list (list1 and list2) in which common element will occur once
         Set<String> listaunionlistb =new HashSet<String>(lista);
         listaunionlistb.addAll(listb);

         for(String s:listaunionlistb)
         {
             listapluslistb.remove(s);
         }
         System.out.println(listapluslistb);
		 
		
		 

		
	}

}
