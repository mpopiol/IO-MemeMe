package com.meme.models;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class MemeTest {
	private Meme meme;
	
	@Before
	public void setUp() throws Exception {
		meme = new Meme();
	}

	@Test
	public void testToString() {
		meme.setTitle("title");
		meme.setContent("content");
		meme.setImgLink("imglink");
		meme.setDetails("details");
		meme.setAuthor("author");
		
		assertEquals(meme.toString(), "'title', 'content', 'imglink', 'details', 'author'");
	}

	@Test
	public void testGetSetId() {
		meme.setId(10);
		assertEquals(meme.getId(), 10);
	}
	
	@Test
	public void testGetSetId2() {
		meme.setId(-1);
		assertEquals(meme.getId(), -1);
	}
	
	@Test
	public void testGetSetId3() {
		meme.setId(2000000);
		assertEquals(meme.getId(), 2000000);
	}
	
	@Test
	public void testGetSetId4() {
		meme.setId(-100000);
		assertEquals(meme.getId(), -100000);
	}

	@Test
	public void testGetSetTitle() {
		meme.setTitle("test");
		assertEquals(meme.getTitle(), "test");
	}
	
	@Test
	public void testGetSetTitle2() {
		meme.setTitle("");
		assertEquals(meme.getTitle(), "");
	}
	
	@Test
	public void testGetSetTitle3() {
		meme.setTitle("zzz123123");
		assertEquals(meme.getTitle(), "zzz123123");
	}
	
	@Test
	public void testGetSetTitle4() {
		meme.setTitle("x123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nur");
		assertEquals(meme.getTitle(), "x123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nurx123ed12s13erx23r234tg378nur");
	}
	
	@Test
	public void testGetSetTitle5() {
		meme.setTitle("t e s t !szxczxZüøπ");
		assertEquals(meme.getTitle(), "t e s t !szxczxZüøπ");
	}

	@Test
	public void testGetSetContent() {
		meme.setContent("testContent");
		assertEquals(meme.getContent(), "testContent");
	}
	
	@Test
	public void testGetSetContent2() {
		meme.setContent("");
		assertEquals(meme.getContent(), "");
	}
	
	@Test
	public void testGetSetContent3() {
		meme.setContent("testContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContent");
		assertEquals(meme.getContent(), "testContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContenttestContent");
	}
	
	@Test
	public void testGetSetContent4() {
		meme.setContent("asxasc xcaszxøücπsπüd13eÊ3234232c34@$@42");
		assertEquals(meme.getContent(), "asxasc xcaszxøücπsπüd13eÊ3234232c34@$@42");
	}

	@Test
	public void testGetSetAuthor() {
		meme.setAuthor("testAuthor");
		assertEquals(meme.getAuthor(), "testAuthor");
	}
	
	@Test
	public void testGetSetAuthor2() {
		meme.setAuthor("");
		assertEquals(meme.getAuthor(), "");
	}
	
	@Test
	public void testGetSetAuthor3() {
		meme.setAuthor("testAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthor");
		assertEquals(meme.getAuthor(), "testAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthortestAuthor");
	}
	
	@Test
	public void testGetSetAuthor4() {
		meme.setAuthor("xú asü πúx πÊπwÍr 233r12!@e!3dè 12ü");
		assertEquals(meme.getAuthor(), "xú asü πúx πÊπwÍr 233r12!@e!3dè 12ü");
	}

	@Test
	public void testGetSetCreateDate() {
		meme.setCreateDate(new Date(1231231231));
		assertEquals(meme.getCreateDate(), new Date(1231231231));
	}
	
	@Test
	public void testGetSetCreateDate2() {
		meme.setCreateDate(new Date(-1));
		assertEquals(meme.getCreateDate(), new Date(-1));
	}
	
	@Test
	public void testGetSetCreateDate3() {
		meme.setCreateDate(new Date(0));
		assertEquals(meme.getCreateDate(), new Date(0));
	}
	
	@Test
	public void testGetSetCreateDate4() {
		meme.setCreateDate(new Date(-99999));
		assertEquals(meme.getCreateDate(), new Date(-99999));
	}
	
	@Test
	public void testGetSetLastEditDate() {
		meme.setLastEditDate(new Date(1231231231));
		assertEquals(meme.getLastEditDate(), new Date(1231231231));
	}
	
	@Test
	public void testGetSetLastEditDate2() {
		meme.setLastEditDate(new Date(-1));
		assertEquals(meme.getLastEditDate(), new Date(-1));
	}
	
	@Test
	public void testGetSetLastEditDate3() {
		meme.setLastEditDate(new Date(0));
		assertEquals(meme.getLastEditDate(), new Date(0));
	}
	
	@Test
	public void testGetSetLastEditDate4() {
		meme.setLastEditDate(new Date(-99999));
		assertEquals(meme.getLastEditDate(), new Date(-99999));
	}

	@Test
	public void testGetSetImgLink() {
		meme.setImgLink("test");
		assertEquals(meme.getImgLink(), "test");
	}
	
	@Test
	public void testGetSetImgLink2() {
		meme.setImgLink("");
		assertEquals(meme.getImgLink(), "");
	}
	
	@Test
	public void testGetSetImgLink3() {
		meme.setImgLink("testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
		assertEquals(meme.getImgLink(), "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
	}
	
	@Test
	public void testGetSetImgLink4() {
		meme.setImgLink("ascaxczüÊπúxasüqc123 312 ev123sdz  123üø2 12 z#!@er123$!@");
		assertEquals(meme.getImgLink(), "ascaxczüÊπúxasüqc123 312 ev123sdz  123üø2 12 z#!@er123$!@");
	}
	
	@Test
	public void testGetSetDetails() {
		meme.setDetails("test");
		assertEquals(meme.getDetails(), "test");
	}
	
	@Test
	public void testGetSetDetails2() {
		meme.setDetails("");
		assertEquals(meme.getDetails(), "");
	}
	
	@Test
	public void testGetSetDetails3() {
		meme.setDetails("testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
		assertEquals(meme.getDetails(), "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
	}
	
	@Test
	public void testGetSetDetails4() {
		meme.setDetails("ascaxczüÊπúxasüqc123 312 ev123sdz  123üø2 12 z#!@er123$!@");
		assertEquals(meme.getDetails(), "ascaxczüÊπúxasüqc123 312 ev123sdz  123üø2 12 z#!@er123$!@");
	}

}
