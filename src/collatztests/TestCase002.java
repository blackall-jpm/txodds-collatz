package collatztests;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
tc002-post-destroy-odd-1-3 	
curl -X POST "http://127.0.0.1:8080/destroy/1"
*/

public class TestCase002 {
	String strGetOrPost = "POST";
	String strURL = "http://127.0.0.1:8080/";
	String strCmd = "destroy";
	long id = 1, iStartNum = 3;
	
	@Before
	public void setUp() {
		strURL = strURL + strCmd + "/" + id ; 
		System.out.println(strGetOrPost + " " + strURL);
	}

	@Test
	public void test() throws IOException {
		TestMethods tcMethods = new TestMethods();
		int status = tcMethods.getOrpost(strURL,strGetOrPost);
		assertEquals(200, status);
		// put in a short delay so we can see data stream
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}

	@After
	public void tearDown() {
		// code executed after each test method

	}

}