package collatztests;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
tc000-post-destroy-non-existing machine id
curl -X POST "http://127.0.0.1:8080/destroy/1"
*/

public class TestCase000Destroy {
	String strGetOrPost = "POST";
	String strURL = "http://127.0.0.1:8080/";
	String strCmd = "destroy";
	long id = 1,iStartNum = 3, iIncrement = 9;
	
	@Before
	public void setUp() {
		// code executed after before test method
	}
	
	@Test
	public void testDestroy() throws IOException {
		strCmd = "destroy";
		strURL = strURL + strCmd + "/" + id ; 
		System.out.println(strGetOrPost + " " + strURL);

		TestMethods tcMethods = new TestMethods();
		int status = tcMethods.getOrpost(strURL,strGetOrPost);
		//assertNotEquals(200, status); //The machine id does not exist, this request should not succeed
		fail("The machine id does not exist, this request should not succeed");
	}


	@After
	public void tearDown() {
		// code executed after each test method

	}

}