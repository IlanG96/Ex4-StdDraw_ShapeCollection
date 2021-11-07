package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;

class Segment2DTest {
	Point2D p2,p1,check;
	Segment2D p1p2;
	static final double EPS = 0.0001;
	@Test
	void ContainsTest() {
		p2=new Point2D(2,5);
		p1=new Point2D(1,2);
		check=new Point2D(1.5,3.5); //y=3x-1
		Segment2D p1p2=new Segment2D(p1,p2);
		assertTrue(p1p2.contains(check));
		p2=new Point2D(3,2);  //y=0.5x+0.5
		p1=new Point2D(1,1);
		check=new Point2D(2,1.5);
		p1p2=new Segment2D(p1,p2);
		assertTrue(p1p2.contains(check));
		check=new Point2D(3,2);
		assertTrue(p1p2.contains(check));
		check=new Point2D(3,2.5);
		assertFalse(p1p2.contains(check));
		p2=new Point2D(3,3);  
		p1=new Point2D(3,3);
		check=new Point2D(3,3);
		p1p2=new Segment2D(p1,p2);
		assertTrue(p1p2.contains(check));
			}
	
	@Test
	void centerOfMassTest()
	{
		p2=new Point2D(20,58);
		p1=new Point2D(16,27);
		check=new Point2D(18,42.5); 
		p1p2=new Segment2D(p1,p2);
		assertEquals(check, p1p2.centerOfMass());
		p2=new Point2D(14458,8000);
		p1=new Point2D(-80,-84);
		check=new Point2D(7189,3958);
		p1p2=new Segment2D(p1,p2);
		assertEquals(check, p1p2.centerOfMass());
		check=new Point2D(-80,-84); 
		p1p2=new Segment2D(p1,p1);
		assertEquals(check, p1p2.centerOfMass());
	}
	
	@Test
	void perimeterTest()
	{
		p2=new Point2D(850,580);
		p1=new Point2D(416,-27);
		double prei=1492.387349;
		p1p2=new Segment2D(p1,p2);
		assertEquals(prei, p1p2.perimeter(),EPS);
		prei=1492.389;
		assertNotEquals(prei,  p1p2.perimeter(),EPS);
		p2=new Point2D(850,580);
		p1=new Point2D(850,580);
		p1p2=new Segment2D(p1,p2);
		prei=0;
		assertEquals(prei, p1p2.perimeter());
		
	}
	@Test
	void moveTest()
	{
		p2=new Point2D(5,8);
		p1=new Point2D(3,2);
		check=new Point2D(3,5);
		p1p2=new Segment2D(p1,p2);
		p2=new Point2D(8,13);
		p1=new Point2D(6,7);
		Segment2D ans=new Segment2D(p1,p2);
		p1p2.move(check);
		Point2D[] p1p2g=p1p2.getPoints();
		Point2D[] anss=ans.getPoints();
		assertArrayEquals(anss, p1p2g);	
	}
	@Test
	void copyTest()
	{
		 p2=new Point2D(1,1);
		 p1=new Point2D(-1,-1);
		 p1p2 = new Segment2D(p1,p2); 
		 Segment2D check = (Segment2D) p1p2.copy();
		Point2D[] p1p2g=p1p2.getPoints();
		Point2D[] anss=check.getPoints();
		assertArrayEquals(p1p2g, anss);
	}

}
