package com.education.WeatherApi;

import com.education.WeatherApi.model.Location;
import com.education.WeatherApi.model.Weather;
import com.education.WeatherApi.service.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class WeatherApiApplicationTests {

	@MockBean
	public WeatherService weatherService;

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void addTopicTest_Valid_200() throws Exception {
		Weather weather = new Weather(1L,new Date(1985-02-10),
				new Location("Nashville", "Tennessee", 36.19F, -86.68F),
				new Float[]{37.5F, 37.0F, 36.3F});

		String weatherJson = objectMapper.writeValueAsString(weather);
		when(weatherService.add(weather)).thenReturn(weather);
		mvc.perform(post("/weather").contentType(MediaType.APPLICATION_JSON).content(weatherJson)).
				andExpect(status().isCreated());
	}

}
