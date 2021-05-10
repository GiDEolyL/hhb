package junit;

import static org.junit.Assert.*;

import org.junit.*;

public class AddTest {
	Add a;

	@Before
	public void setup() {
		a = new Add();
		System.out.println("ø™ º≤‚ ‘");
	}

	@After
	public void shutdown() {
		System.out.println("Ω· ¯≤‚ ‘");
	}

	@Test
	public void test() {
		int sum = a.add(5, 6);
		assertEquals(10, sum);
	}

	@Test
	public void test1() {
		String str1 = "hello world!!";
		String str2 = "hello world!!";
		assertSame(str2, str1);
	}
	@Test
	public void test2() {
		String str1 = new String("hello world!!");
		String str2 = "hello world!!";
		assertSame(str2, str1);
	}

	@Ignore
	public void testIgnore() {
		Add a = new Add();
		int sum = a.add(5, 6);
		assertEquals(10, sum);
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("AfterClass");
	}

	@BeforeClass
	public static void tesBeforeClass() {
		System.out.println("BeforeClass");
	}

}
