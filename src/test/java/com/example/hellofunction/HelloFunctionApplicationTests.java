package com.example.hellofunction;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloFunctionApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		String response = restTemplate.postForObject("/hello", "making", String.class);
		assertThat(response).isEqualTo("Hello making!");
	}
}
