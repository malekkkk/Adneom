package Adneom.Library;

import java.util.ArrayList;
import java.util.List;

public class Functions {
	
	public static <T> List<List<T>> partition( List<T> list, int sizeOfSublists ) throws NullPointerException {	
		if( list == null)
			throw new NullPointerException("the given list is null");
		List<List<T>> result = new ArrayList<List<T>>();
		
		if(sizeOfSublists != 0) {
		
			final int size = list.size();
			final int numberOfFullSubList = size / sizeOfSublists;
			final int sizeOfUncomplitedSublist = size % sizeOfSublists;
			
			for(int i=0; i< numberOfFullSubList; i++) 
				result.add(list.subList(i * sizeOfSublists,  (i+1) * sizeOfSublists ));
			
			if(sizeOfUncomplitedSublist != 0)
				result.add(list.subList(size - sizeOfUncomplitedSublist,  size ) );
		}
		
		return result;
	}
}
