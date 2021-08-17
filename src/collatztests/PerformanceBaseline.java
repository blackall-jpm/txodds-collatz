package collatztests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PerformanceBaseline {
	String strGetOrPost = "POST";
	String strURL = "http://127.0.0.1:8080/";
	String strCmd = "create";
	String strTmp = "";
	long id = 1, iStartNum = 1, startTime = 0;
	@Before
	public void setUp() {
		// code executed before each test method
		startTime = System.nanoTime();
		/* … The code being measured starts … */
		System.out.println("/* … The code being measured starts … */");  
	}

	@Test
	public void a_testCreate() throws IOException {
		//MAX machines 9223372036854775807L
		for (id = 1; id < 9223372036854775807L; id++) {
			strTmp = strURL + strCmd + "/" + id + "/" + iStartNum; 
			System.out.println(strGetOrPost + " " + strTmp);
			TestMethods tcMethods = new TestMethods();
			int status = tcMethods.getOrpost(strTmp,strGetOrPost);
		}
	}

	@Test
	public void b_testDestroy() throws IOException {
		strCmd = "destroy";
		for (id = 1; id < 9223372036854775807L; id++) {
			strTmp = strURL + strCmd + "/" + id; 
			System.out.println(strGetOrPost + " " + strTmp);
			TestMethods tcMethods = new TestMethods();
			int status = tcMethods.getOrpost(strTmp,strGetOrPost);
		}
	}

	@After
	public void tearDown() {
		// code executed after each test method
		/* … The code being measured ends … */
		System.out.println("/* … The code being measured ends … */");  
		long endTime = System.nanoTime();
		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
	}

}

