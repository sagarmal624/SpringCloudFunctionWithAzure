package com.example.hellofunction;

import java.util.function.Function;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class HelloTest {
	@Test
	public void hello() {
		Function<String, String> hello = new HelloFunctionApplication().hello();
		Assertions.assertThat(hello.apply("making")).isEqualTo("Hello making!");
	}
}
