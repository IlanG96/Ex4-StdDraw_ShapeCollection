package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

class Rect2DTest {

	@Test
	void testcontains() {
		Point2D p2=new Point2D(100,5);
		Point2D p1=new Point2D(-50,-20);
		Rect2D rect = new Rect2D(p1,p2);
		Point2D check=new Point2D(0,0);
		assertTrue(rect.contains(check));
		p2=new Point2D(20.6,1.5);
		p1=new Point2D(1,-2);
		rect = new Rect2D(p1,p2);
		check=new Point2D(5,0.2);
		assertTrue(rect.contains(check));
		check=new Point2D(10000,22222);
		assertFalse(rect.contains(check));
		check=new Point2D(20.7,1.5);
		assertFalse(rect.contains(check));
		
	}
	@Test
	void testcenterOfMass()
	{
		Point2D p2=new Point2D(20,5.5);
		Point2D p1=new Point2D(-10,-15.2);
		Rect2D rect = new Rect2D(p1,p2);
		Point2D check=new Point2D(5,-4.85);
		assertEquals(check, rect.centerOfMass());
		check=new Point2D(5.1,-4.851);
		assertNotEquals(check, rect.centerOfMass());
	}
	@Test
	void testarea()
	{
		Point2D p2=new Point2D(20,5.5);
		Point2D p1=new Point2D(-10,-15.2);
		Rect2D rect = new Rect2D(p1,p2);
		double check=621;
		assertEquals(check, rect.area());
		rect = new Rect2D();
		check=0;
		assertNotEquals(check, rect.area());
	}
	@Test
	void testperimeter()
	{
		Point2D p2=new Point2D(840.84,420.64);
		Point2D p1=new Point2D(-1,-66);
		Rect2D rect = new Rect2D(p1,p2);
		double check=2656.96;
		assertEquals(check, rect.perimeter());
		check=2656.96000001;
		assertNotEquals(check, rect.perimeter());
	}
	@Test
	void testmove()
	{
		Point2D p2=new Point2D(800,400.80);
		Point2D p1=new Point2D(-145,-58);
		Rect2D rect = new Rect2D(p1,p2);
		Point2D vec=new Point2D(5,-0.80);
		rect.move(vec);
		Point2D p2c=new Point2D(805,400);
		Point2D p1c=new Point2D(-140,-58.80);
		Rect2D checkrect = new Rect2D(p1c,p2c);
		Point2D[] rect1=rect.getPoints();
		Point2D[] checkrect1=checkrect.getPoints();
		assertArrayEquals(rect1, checkrect1);
		
	}
	@Test
	void testcopy()
	{		
		Point2D p2=new Point2D(1,1);
		Point2D p1=new Point2D(-1,-1);
		Rect2D rect = new Rect2D(p1,p2);
		Rect2D checkrect = (Rect2D) rect.copy();
		Point2D[] rect1=rect.getPoints();
		Point2D[] checkrect1=checkrect.getPoints();
		assertArrayEquals(rect1, checkrect1);
		
	}
	@Test
	void testgetPoints()
	{
		Point2D p2=new Point2D(200,408);
		Point2D p1=new Point2D(-105,-37);
		Rect2D rect = new Rect2D(p1,p2);
		Point2D[] checkrect1=new Point2D[2];
		checkrect1[0]=p1;
		checkrect1[1]=p2;
		Point2D[] rect1=rect.getPoints();
		assertArrayEquals(checkrect1, rect1);
	}


}
