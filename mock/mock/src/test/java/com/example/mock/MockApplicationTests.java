package com.example.mock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(HomeController.class)
class MockApplicationTests {

	@Autowired
	HomeController homeController;

	@MockBean
	private HomeService service;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
		assertNotNull(homeController);
		when(service.print()).thenCallRealMethod();
		homeController.test();
	}

	@Test
	void getCall() throws Exception{
		mockMvc.perform(get("/")).andDo(print()).andExpect(content().string(containsString("Hello World!")));

	}




}

