package collatztests;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
tc006-post-create-increment-destroy-even
curl -X POST "http://127.0.0.1:8080/create/1/8"
curl -X POST "http://127.0.0.1:8080/increment/1/20"
curl -X POST "http://127.0.0.1:8080/destroy/1"
*/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCase006 {
	String strGetOrPost = "POST";
	String strURL = "http://127.0.0.1:8080/";
	String strCmd = "create";
	int id = 1, iStartNum = 8;
	
	@Before
	public void setUp() {
		// code executed before
		}

	@Test
	public void a_testCreate() throws IOException {
		strCmd = "create";
		id = 1;
		iStartNum = 3;
		
		strURL = strURL + strCmd + "/" + id + "/" + iStartNum; 
		System.out.println(strGetOrPost + " " + strURL);
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

	@Test
	public void b_testIncrement() throws IOException {
		strCmd = "increment";
		id = 1;
		iStartNum = 20;
		strURL = strURL + strCmd + "/" + id + "/" + iStartNum; 
		System.out.println(strGetOrPost + " " + strURL);
		
		TestMethods tcMethods = new TestMethods();
		int status = tcMethods.getOrpost(strURL,strGetOrPost);
		assertEquals(202, status); //increment accepted
		// put in a short delay so we can see data stream
		try
		{
			Thread.sleep(15000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
	
	@Test
	public void c_testDestroy() throws IOException {
		strCmd = "destroy";
		id = 1;
		strURL = strURL + strCmd + "/" + id ; 
		System.out.println(strGetOrPost + " " + strURL);
		
		TestMethods tcMethods = new TestMethods();
		int status = tcMethods.getOrpost(strURL,strGetOrPost);
		assertEquals(200, status);
	}
	@After
	public void tearDown() {
		// code executed after each test method

	}

}
