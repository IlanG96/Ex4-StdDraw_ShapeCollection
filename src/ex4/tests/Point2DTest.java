package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;

class Point2DTest {
Point2D p1,p2,checkpoint;
public static final double EPS = 0.001;
	
	@Test
	void testXYIxIy() {
		p1=new Point2D(5.5,25.6);
		double xy=5.5;
		assertEquals(xy,p1.x());
		assertEquals((int)xy,p1.ix());
		 xy=25.6;
		assertEquals(xy,p1.y());
		assertEquals((int)xy,p1.iy());
		 xy=25.3;
		 assertNotEquals(xy,p1.y());
		
	}

	@Test
	void testIsbigger() {
		p1=new Point2D(0,5);
		p2=new Point2D(6,2);
		assertTrue(p1.isbigger(p2));
		p1=new Point2D(0,1.99);
		assertFalse(p1.isbigger(p2));
	}

	@Test
	void testAdd() {
		p1=new Point2D(1,2);
		p2=new Point2D(5,8);
		checkpoint = new Point2D(6,10);
		assertEquals(checkpoint, p1.add(p2));
	}


	@Test
	void testDistancePoint2DandtestDistance() { //test distance and distance(Point2D p2)
		p1=new Point2D(5,5);
		p2=new Point2D(5,8);
		double distance=3;
		double distancex=Math.sqrt(89);
		assertEquals(distance, p1.distance(p2));
		assertEquals(distancex, p2.distance());

	}

	@Test
	void testEqualsObject() {
		p1=new Point2D(5,5);
		Point2D p2 = new Point2D("5,5");
		assertEquals(p1, p2);
		p1=new Point2D (5,5.01);
		assertNotEquals(p1, p2);
	}

	@Test
	void testClose2equalsPoint2DDouble_testClose2equalsPoint2D() {
		p1=new Point2D(5,5);
		Point2D p2=new Point2D (5.1,5.8);
		double EPS=0.81;
		assertTrue(p2.close2equals(p1, EPS));
		 p2=new Point2D (5.000000000011,5.0000000000011);
		assertTrue(p2.close2equals(p1));	
		
	}

	@Test
	void testVector() {
		p1=new Point2D(8.4,3.3);
		p2=new Point2D(12.3,8.5);
		p2=p1.vector(p2);
		Point2D checkpoint=new Point2D(3.9,5.2);
		assertEquals(checkpoint.x(),p2.x(),EPS);
		
	}

	@Test
	void testContains() {
		p1=new Point2D(5,4.9);
	  Point2D p2 = new Point2D(5,4.9);
	  assertTrue(p1.contains(p2));
	}

	@Test
	void testCenterOfMass() {
		p1=new Point2D(58,85);
		assertEquals(p1.centerOfMass(), p1);
	}

	@Test
	void testMove() {
		p1=new Point2D(4,8);
		Point2D p2 = new Point2D(20,4);
		Point2D checkpoint=new Point2D(24,12);
		p2.move(p1);
		assertEquals(checkpoint, p2);
	}

	@Test
	void testCopy() {
		p1=new Point2D(8,44);
		GeoShape x=p1.copy();
		assertEquals(p1, x);
	}

	@Test
	void testGetPoints() {
		p1=new Point2D(5,8);
		Point2D[]x=p1.getPoints();
		assertEquals(p1, x[0]);
	}

}
