package com.hkbea.tacocloud.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DesignTacoController.class)
public class DesignTacoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testShowDesignForm() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/design"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("design"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("design"));
	}
}
