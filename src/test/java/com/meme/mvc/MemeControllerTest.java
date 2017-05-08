package com.meme.mvc;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyCollectionOf;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.validation.BindingResult;
 
import com.meme.dao.IRepository;
import com.meme.enums.Result;
import com.meme.models.Meme;


public class MemeControllerTest {

	private MemeController controller;
    
	private IRepository<Meme> mockRepo;

	@Before
	public void setUp() throws Exception {
		mockRepo = (IRepository<Meme>)mock(IRepository.class);
		this.controller = new MemeController(mockRepo);
	}

	@After
	public void tearDown() throws Exception {
		this.controller = null;
	}

	@Test
	public void testAddGETReturnsAddView() {
		ModelAndView mav = this.controller.add();
		
		String viewName = mav.getViewName();
		String expectedView = "add";
		
		assertEquals(expectedView, viewName);
	}
	
	@Test
	public void testAddGETReturnsEmptyMemeModel(){
		ModelAndView mav = this.controller.add();
		
		Object model = mav.getModel().values().toArray()[0];
		
		assertEquals(Meme.class, model.getClass());
	}
	
	@Test
	public void testAddPOSTUsesAddMethodOfRepository(){
		Meme testMeme = new Meme();
		BindingResult stubResult = mock(BindingResult.class);
		when(stubResult.hasErrors()).thenReturn(false);
		
		this.controller.add(testMeme, stubResult, new ModelMap());
		
		verify(stubResult).hasErrors();
		verify(this.mockRepo).add(testMeme);
	}
	
	@Test
	public void testAddPOSTResultErrorsReturnsErrorView(){
		Meme testMeme = new Meme();
		BindingResult stubResult = mock(BindingResult.class);
		when(stubResult.hasErrors()).thenReturn(true);
		
		String viewName = this.controller.add(testMeme, stubResult, new ModelMap());
		
		verify(stubResult).hasErrors();
		assertEquals("error", viewName);
	}
	
	@Test
	public void testAddPOSTNoErrorsRedirectsToMainPage(){
		Meme testMeme = new Meme();
		BindingResult stubResult = mock(BindingResult.class);
		when(stubResult.hasErrors()).thenReturn(false);
		when(mockRepo.add(any(Meme.class))).thenReturn(Result.SUCCESS);
		
		String viewName = this.controller.add(testMeme, stubResult, new ModelMap());
		
		verify(stubResult).hasErrors();
		assertEquals("redirect:/", viewName);
	}
	
	@Test
	public void testListUsesToListMethodOfRepository(){
		Model mockModel = mock(Model.class);			
		this.controller.list(mockModel);
		
		verify(mockRepo).toList();
	}
	
	@Test
	public void testListAddsListOfMemesToModel(){
		Model mockModel = mock(Model.class);	
		List<Meme> stubList = new ArrayList<Meme>();
		when(mockRepo.toList()).thenReturn(stubList);
		
		this.controller.list(mockModel);
		
		verify(mockModel).addAttribute(anyString(), eq(stubList));
	}
	
	@Test
	public void testDetailsUsesFirstOrDefaultMethodOfRepository(){
		Model mockModel = mock(Model.class);
		this.controller.details(1, mockModel);
		
		verify(mockRepo).firstOfDefault(anyString());
	}
	
	@Test
	public void testDetailsAddsMemeToModel(){
		Model mockModel = mock(Model.class);	
		Meme stubMeme = new Meme();
		when(mockRepo.firstOfDefault(anyString())).thenReturn(stubMeme);
		
		this.controller.details(1 ,mockModel);
		
		verify(mockModel).addAttribute(anyString(), eq(stubMeme));
	}
	
	@Test
	public void testRandomUsesToListMethodOfRepository(){
		Model mockModel = mock(Model.class);	
		List<Meme> stubList = new ArrayList<Meme>();
		Meme stubMeme = new Meme();
		stubList.add(stubMeme);
		when(mockRepo.toList()).thenReturn(stubList);	
		
		this.controller.random(mockModel);
		
		verify(mockRepo).toList();
	}
	
	@Test
	public void testRandomAddsMemeToModel(){
		Model mockModel = mock(Model.class);	
		List<Meme> stubList = new ArrayList<Meme>();
		Meme stubMeme = new Meme();
		stubList.add(stubMeme);
		when(mockRepo.toList()).thenReturn(stubList);
		
		this.controller.random(mockModel);
		
		verify(mockModel).addAttribute(anyString(), eq(stubMeme));
	}
}
