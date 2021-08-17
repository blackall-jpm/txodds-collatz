package collatztests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCaseHttpClientSSE {

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
		iStartNum = 8;

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
	public void b_receiveEvents() throws URISyntaxException, IOException, InterruptedException {
		var uri = new URI("http://127.0.0.1:8080/messages/1");
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(uri).GET().build();
		var lines = client.send(request, BodyHandlers.ofLines()).body();
		//lines.forEach(System.out::println);

		/*
		System.out.println("Printing lines contains"); 
		lines.filter(s -> s.contains("\"machineId\":2")) 
		.forEach(System.out::println);
		 */
		
		fail("I am unable to parse continuous stream of server sent events");
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
}
