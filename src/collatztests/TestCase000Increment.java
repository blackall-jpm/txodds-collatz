package collatztests;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
tc000-post-increment-non-existing machine id
curl -X POST "http://127.0.0.1:8080/destroy/1"
 */

public class TestCase000Increment {
	String strGetOrPost = "POST";
	String strURL = "http://127.0.0.1:8080/";
	String strCmd = "destroy";
	long id = 1,iStartNum = 3, iIncrement = 9;

	@Before
	public void setUp() {
		// code executed after before test method
	}

	@Test
	public void testIncrement() throws IOException {
		strCmd = "increment";
		strURL = strURL + strCmd + "/" + id+ "/" + iIncrement ; 
		System.out.println(strGetOrPost + " " + strURL);

		TestMethods tcMethods = new TestMethods();
		int status = tcMethods.getOrpost(strURL,strGetOrPost);
		//assertNotEquals(200, status); //The machine id does not exist, this request should not succeed
		//assertNotEquals(202, status); //The machine id does not exist, this request should be accepted
		fail("The machine id does not exist, this request should not succeed");

	}

	@After
	public void tearDown() {
		// code executed after each test method

	}

}