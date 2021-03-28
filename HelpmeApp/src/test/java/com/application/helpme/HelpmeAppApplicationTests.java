package com.application.helpme;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;
import com.application.helpme.controlleur.*;
@SpringBootTest
@AutoConfigureMockMvc

public class HelpmeAppApplicationTests {
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void getmission() throws Exception{
		 mockMvc.perform(get("/getmission/3"))
         .andExpect(status().isOk())
         .andExpect(jsonPath("nomMission", is("Aller En COURS")));
	}
	
	@Test
	public void getlistmission() throws Exception{
		 mockMvc.perform(get("/listeMission"))
         .andExpect(status().isOk())
       
	}
	
	@Test
	public void getuser() throws Exception{
		 mockMvc.perform(get("/listeUser"))
         .andExpect(status().isOk());
		
	}

}
