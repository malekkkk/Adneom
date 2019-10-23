package Test;
import static Adneom.Library.Functions.partition;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class partitionTest {

	@Test
	void test() {
		assertThrows(NullPointerException.class, () -> {partition(null, 5);},"partition should throws a NullPointerException.");
		
		List<Object> testList = new ArrayList<Object>();

		assertEquals(0, partition(testList, 5).size(), "testList is empty, partition should return an emptyList!");
		
		// Initiating the testList
		final int sizeOfTestList = 10;
		for(int i = 0 ; i< sizeOfTestList ; i++) testList.add(i);
		
		
		// check for sizeOfSublists = 0
		assertEquals(0, partition(testList, 0).size(), "sizeOfSublists = 0, partition should return an emptyList");
		
		// check for sizeOfSublists = 1
		final List<List<Object>> listOfSubListsWithOneStep = partition(testList, 1);
		assertEquals(sizeOfTestList, listOfSubListsWithOneStep.size(), "sizeOfSublists = 1, partition should return a list of ten subList.");
		for(int i=0 ; i< sizeOfTestList ; i ++) {
			assertEquals(1, listOfSubListsWithOneStep.get(i).size(), "sizeOfSublists = 1, each subList contains a single element.");
			assertEquals(testList.get(i), listOfSubListsWithOneStep.get(i).get(0), " sizeOfSublists = 1, subList[i] has be equal to testList[i].");
		}
		
		
		// check for sizeOfSublists = 2
		final List<List<Object>> listOfSubListsWithTowSteps = partition(testList, 2);
		assertEquals(5, listOfSubListsWithTowSteps.size(), "sizeOfSublists = 2, partition should return a list of five subList.");
		for(int i=0 ; i< listOfSubListsWithTowSteps.size(); i++ ) {
			assertEquals(2, listOfSubListsWithTowSteps.get(i).size(), "sizeOfSublists = 2, each subList contains tow elements.");
			assertEquals(testList.get(2*i), listOfSubListsWithTowSteps.get(i).get(0));
			assertEquals(testList.get(2*i + 1), listOfSubListsWithTowSteps.get(i).get(1));
		}
		
		
		// check for sizeOfSublists = 3
		final List<List<Object>> listOfSubListsWithThreeSteps = partition(testList, 3);
		assertEquals(4, listOfSubListsWithThreeSteps.size(), "sizeOfSublists = 3, partition should return a list of four subList.");
		for(int i=0 ; i< listOfSubListsWithThreeSteps.size() - 1; i++ ) {
			assertEquals(3, listOfSubListsWithThreeSteps.get(i).size(), "sizeOfSublists = 3, the first three subList contains three elements.");
			assertEquals(testList.get(3*i), listOfSubListsWithThreeSteps.get(i).get(0));
			assertEquals(testList.get(3*i + 1), listOfSubListsWithThreeSteps.get(i).get(1));
			assertEquals(testList.get(3*i + 2), listOfSubListsWithThreeSteps.get(i).get(2));
		}
		
		final int indexOfLastSublist = listOfSubListsWithThreeSteps.size() - 1;
		assertEquals(1, listOfSubListsWithThreeSteps.get(indexOfLastSublist).size(), "sizeOfSublists = 3, the last subList contains a single element.");
		assertEquals(testList.get(testList.size() - 1), listOfSubListsWithThreeSteps.get(indexOfLastSublist).get(0));


		// check for sizeOfSublists = sizeOfTestList
		assertEquals(1,partition(testList, sizeOfTestList).size(), "sizeOfSublists = sizeOfTestList, partition should return a list of a single subList.");
		assertEquals(testList,partition(testList, sizeOfTestList).get(0), "sizeOfSublists = sizeOfTestList, partition should return a list of the testing list.");
	
		// check for sizeOfSublists > sizeOfTestList
				assertEquals(1,partition(testList, sizeOfTestList).size(), "sizeOfSublists > sizeOfTestList, partition should return a list of a single subList.");
				assertEquals(testList,partition(testList, sizeOfTestList).get(0), "sizeOfSublists > sizeOfTestList, partition should return a list of the testing list.");
	}
}
