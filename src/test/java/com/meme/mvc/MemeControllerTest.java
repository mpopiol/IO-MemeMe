package com.meme.mvc;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
 

import com.meme.dao.IDAOManager;
import com.meme.models.Meme;


public class MemeControllerTest {

	private MemeController controller;
    
	private IDAOManager mockDao;

	@Before
	public void setUp() throws Exception {
		
		this.controller = new MemeController(mockDao);
	}

	@After
	public void tearDown() throws Exception {
		this.controller = null;
	}

	@Test
	public void testAddReturnsAddView() {
		ModelAndView mav = this.controller.add();
		
		String viewName = mav.getViewName();
		String expectedView = "add";
		
		assertEquals(expectedView, viewName);
	}
	
	@Test
	public void testAddReturnsEmptyMemeModel(){
		ModelAndView mav = this.controller.add();
		
		Object model = mav.getModel().values().toArray()[0];
		
		assertEquals(Meme.class, model.getClass());
	}

}
