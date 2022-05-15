import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThat;

class TestDemoTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean exceptException) {
		
		
		{
	}
		if(!exceptException) { 

			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected); 

			} else {
				assertThatThrownBy(() -> testDemo.addPositive(a,b))
				.isInstanceOf(IllegalArgumentException.class);
			
				
			}
	}
	

	static Stream<Arguments> argumentsForAddPositive() {
		return(Stream.of
			   (arguments(6, -8, -2, true), 
				arguments(-18, 4, -14, true),
				arguments(-8, -10, -18, true),
				arguments(2, 4, 6, false), 
				arguments(10, 6, 16, false),
				arguments(26, 400, 426, false)));
		
	}
	@Test
	void assertThatNumberSquaredIsCorrect() {
		
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	}

}
