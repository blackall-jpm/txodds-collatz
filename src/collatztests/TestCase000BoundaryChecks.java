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
tc000-boundary checks (negative tests)
m/c id cannot be less than 1
m/c id MAX = 9223372036854775807L;  MAX m/c Id allowed
m/c id MAX + 1 = -9223372036854775808 Should not be allowed
*/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCase000BoundaryChecks {
	String strGetOrPost = "POST";
	String strURL = "http://127.0.0.1:8080/";
	String strCmd = "create";
	long id = 1, iStartNum = 1, iIncrement=1;
	
	@Before
	public void setUp() {
		// code executed before
		}

	@Test
	public void a_testMCiD() throws IOException {
		strCmd = "create";
		id = -1; //negative number
		iStartNum = 1;
		
		strURL = strURL + strCmd + "/" + id + "/" + iStartNum; 
		System.out.println(strGetOrPost + " " + strURL);
		//TestMethods tcMethods = new TestMethods();
		//int status = tcMethods.getOrpost(strURL,strGetOrPost);
		//assertNotEquals(200, status);
		fail("machine Id cannot be < 1 or negative");

	}

	@Test
	public void b_testMCiD() throws IOException {
		strCmd = "create";
		id = 9223372036854775807L; /// MAX m/c Id allowed
		iStartNum = 1;
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
	public void c_testDestroy() throws IOException {
		strCmd = "destroy";
		id = 9223372036854775807L; /// MAX m/c Id allowed
		strURL = strURL + strCmd + "/" + id ; 
		System.out.println(strGetOrPost + " " + strURL);
		
		TestMethods tcMethods = new TestMethods();
		int status = tcMethods.getOrpost(strURL,strGetOrPost);
		assertEquals(200, status);
	}

	@Test
	public void d_testMCiD() throws IOException {
		strCmd = "create";
		id = 9223372036854775807L; /// MAX allowed
		id = id + 1; // MAX + 1 - Not allowed for m/c Id
		
		iStartNum = 1;
		strURL = strURL + strCmd + "/" + id + "/" + iStartNum; 
		System.out.println(strGetOrPost + " " + strURL);
		/*
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
		}*/
		
		fail("machine Id cannot be -9223372036854775808");
	}
	
	@Test
	public void e_testDestroy() throws IOException {
		strCmd = "destroy";
		id = 9223372036854775807L; /// MAX allowed
		id = id + 1; // MAX + 1 - Not allowed for m/c Id
		strURL = strURL + strCmd + "/" + id ; 
		System.out.println(strGetOrPost + " " + strURL);
		/*
		TestMethods tcMethods = new TestMethods();
		int status = tcMethods.getOrpost(strURL,strGetOrPost);
		assertEquals(200, status);
		*/
		fail("Nothing to destroy -  machine Id cannot be -9223372036854775808");

	}
	
	@Test
	public void f_testStartNum() throws IOException {
		strCmd = "create";
		id = 1; 
		iStartNum = 9223372036854775807L; //MAX value long can take
		strURL = strURL + strCmd + "/" + id + "/" + iStartNum; 
		System.out.println(strGetOrPost + " " + strURL);
		//TestMethods tcMethods = new TestMethods();
		//int status = tcMethods.getOrpost(strURL,strGetOrPost);
		//assertNotEquals(200, status);
		fail("start number cannot cannot be 9223372036854775807 for collatz");

	}

	@Test
	public void g_testIncrement() throws IOException {
		strCmd = "create";
		id = 1;
		iStartNum = 1;
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
	public void h_testIncrement() throws IOException {
		strCmd = "increment";
		id = 1;
		iStartNum = 1;
		iIncrement = 9223372036854775807L;
		strURL = strURL + strCmd + "/" + id + "/" + iIncrement; 
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
		fail("Increment cannot cannot be 9223372036854775807 for collatz");

	}
	
	@Test
	public void i_testDestroy() throws IOException {
		strCmd = "destroy";
		id = 1;
		iStartNum = 1;
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
