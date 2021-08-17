package collatztests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RunHttpClientSSE.class, TestCase000BoundaryChecks.class, TestCase000Create.class, TestCase000Destroy.class,
		TestCase000Increment.class, TestCase001.class, TestCase002.class, TestCase003.class, TestCase004.class,
		TestCase005.class, TestCase006.class })

public class RunBasics {

	
}
