package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Triangle2D;

class Triangle2DTest {
	static final double EPS = 0.0001;
	Point2D p2,p1,p3,check;
	Triangle2D p123;
	
		@Test
	void areaTest() {
		p123=new Triangle2D();
		double ans=1;
		assertEquals(ans, p123.area(),EPS);
		p1=new Point2D(5,3);
		p2=new Point2D(-4,2);
		p3=new Point2D(3,-3);
		p123=new Triangle2D(p1,p2,p3);
		ans=26;
		assertEquals(ans, p123.area(),EPS);
		ans=26.2;
		assertNotEquals(ans, p123.area(),EPS);	
		p1=new Point2D(1,1);
		p2=new Point2D(2,2);
		p3=new Point2D(3,3);
		p123=new Triangle2D(p1,p2,p3);
		ans=0;
		assertEquals(ans, p123.area(),EPS);
	}
		
		@Test
		void containsTest()
		{
			p1=new Point2D(5,3);
			p2=new Point2D(-4,2);
			p3=new Point2D(3,-3);
			p123=new Triangle2D(p1,p2,p3);
			check=new Point2D(2,1);
			assertTrue(p123.contains(check));
			check=new Point2D(-4,2);
			assertTrue(p123.contains(check));
			check=new Point2D(-5.1,3.01);
			assertFalse(p123.contains(check));
			p1=new Point2D(0,0);
			p2=new Point2D(1,1);
			p3=new Point2D(3,3);
			p123=new Triangle2D(p1,p2,p3);
			check=new Point2D(2,2);
			assertTrue(p123.contains(check));
			check=new Point2D(3,0);
			assertFalse(p123.contains(check));
			p1=new Point2D(-2,0);
			p2=new Point2D(1,0);
			p3=new Point2D(3,0);
			p123=new Triangle2D(p1,p2,p3);
			check=new Point2D(-2.1,0);
			assertFalse(p123.contains(check));
			check=new Point2D(3.1,0);
			assertFalse(p123.contains(check));
		}
		@Test
		void centerofMassTest()
		{
			p1=new Point2D(5,3);
			p2=new Point2D(-4,2);
			p3=new Point2D(3,3);
			p123=new Triangle2D(p1,p2,p3);
			check=new Point2D(1.33333,2.66666);
			assertEquals(check.x(), p123.centerOfMass().x(),EPS);
			assertEquals(check.y(), p123.centerOfMass().y(),EPS);
			check=new Point2D(1.43333,2.65666);
			assertNotEquals(check.x(), p123.centerOfMass().x(),EPS);
			assertNotEquals(check.y(), p123.centerOfMass().y(),EPS);
			p1=new Point2D(0,0);
			p2=new Point2D(2,0);
			p3=new Point2D(-2,0);
			p123=new Triangle2D(p1,p2,p3);
			check=new Point2D(0.22,0);
			assertNotEquals(check.x(), p123.centerOfMass().x());
			assertEquals(check.y(), p123.centerOfMass().y());
			
		}
		@Test
		void perimeterTest()
		{
			p1=new Point2D(5,7);
			p2=new Point2D(2,3);
			p3=new Point2D(11,13);
			p123=new Triangle2D(p1,p2,p3);
			double prei=26.939;
			assertEquals(prei,p123.perimeter(),EPS);
			 prei=26.9359;
			 assertNotEquals(prei,p123.perimeter(),EPS);
		}
		@Test
		void moveTest()
		{
			p1=new Point2D(5,7);
			p2=new Point2D(2,3);
			p3=new Point2D(11,13);
			p123=new Triangle2D(p1,p2,p3);
			check=new Point2D(20,30);
			p123.move(check);
			p1=new Point2D(25,37);
			p2=new Point2D(22,33);
			p3=new Point2D(31,43);
			Triangle2D ans=new Triangle2D(p1,p2,p3);
			Point2D[] p123move=p123.getPoints();
			Point2D[]  ans1=ans.getPoints();
			assertArrayEquals(ans1, p123move);
			
		}
		@Test
		void copyTest()
		{
			p1=new Point2D(5,7);
			p2=new Point2D(2,3);
			p3=new Point2D(11,13);
			p123=new Triangle2D(p1,p2,p3);
			Triangle2D ans=(Triangle2D) p123.copy();
			Point2D[] p123move=p123.getPoints();
			Point2D[]  ans1=ans.getPoints();
			assertArrayEquals(ans1, p123move);
		}
		@Test
		void getPointsTest()
		{
			p1=new Point2D(5,7);
			p2=new Point2D(2,3);
			p3=new Point2D(11,13);
			p123=new Triangle2D(p1,p2,p3);
			Point2D[] p123move=p123.getPoints();
			Point2D[]  ans1=new Point2D[3];
			ans1[0]=p1;
			ans1[1]=p2;
			ans1[2]=p3;
			assertArrayEquals(ans1, p123move);
		}
		
}
