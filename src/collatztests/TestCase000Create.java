package collatztests;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
tc000-post-create-missing start number (negative test)
curl -X POST "http://127.0.0.1:8080/create/1"
*/

public class TestCase000Create {
	String strGetOrPost = "POST";
	String strURL = "http://127.0.0.1:8080/";
	String strCmd = "create";
	long id = 1, iStartNum = 3;
	
	@Before
	public void setUp() {
		//strURL = strURL + strCmd + "/" + id + "/" + iStartNum;
		strURL = strURL + strCmd + "/" + id ; // Missing start number
		System.out.println(strGetOrPost + " " + strURL);
	}

	@Test
	public void test() throws IOException {
		TestMethods tcMethods = new TestMethods();
		int status = tcMethods.getOrpost(strURL,strGetOrPost);
		assertEquals(404, status);

	}

	@After
	public void tearDown() {
		// code executed after each test method

	}

}
