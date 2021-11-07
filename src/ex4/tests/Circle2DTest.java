package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Circle2D;
import ex4.geometry.Point2D;

class Circle2DTest {
 Point2D p1;
 Circle2D C1;
 
 	@Test
 	void testget_center()
 	{
 		p1=new Point2D();
 		C1=new Circle2D(p1,5);
 		assertEquals(p1, C1.get_center());
 		
 	}
	@Test
 	void testset_center()
 	{
 		p1=new Point2D();
 		C1=new Circle2D(p1,5);
 		C1.set_center(new Point2D(5,25));
 		p1=new Point2D(5,25);
 		assertEquals(p1, C1.get_center());
 		
 	}
	@Test
 	void testget_radius_setRadius()
 	{
 		p1=new Point2D();
 		C1=new Circle2D(p1,5);
 		assertEquals(5, C1.getRadius());
 		C1.set_radius(80);
 		assertEquals(80, C1.getRadius());
 		assertNotEquals(5, C1.getRadius());
 	}
	@Test
	void testcontains() {
		p1=new Point2D(5,8);
		C1=new Circle2D(p1,5);
		p1=new Point2D(11,8);
		assertFalse(C1.contains(p1));
		p1=new Point2D(9,7);
		assertTrue(C1.contains(p1));	
	}
	@Test
	void TestcenterOfMass()
	{
		p1=new Point2D(10,80);
		C1=new Circle2D(p1,5);
		assertEquals(p1, C1.centerOfMass());
	}
	@Test
	void Testarea()
	{
		p1=new Point2D(10,80);
		C1=new Circle2D(p1,5);
		double area=25*Math.PI;
		assertEquals(area,C1.area());
		C1=new Circle2D(p1,5.52);
		area=5.52*5.52*Math.PI;
		assertEquals(area,C1.area());
		area=5.52*5.522*Math.PI;
		assertNotEquals(area,C1.area());
	}
	@Test
	void Testperimeter()
	{
		p1=new Point2D(30,40);
		C1=new Circle2D(p1,6);
		double area=2*6*Math.PI;
		assertEquals(area,C1.perimeter());
		area=2*6.00000000001*Math.PI;
		assertNotEquals(area,C1.area());
	}
	@Test
	void Testmove()
	{
		p1=new Point2D(30,40);
		C1=new Circle2D(p1,6);
		Point2D vec=new Point2D(5,6);
		C1.move(vec);
		p1=new Point2D(35,46);
		assertEquals(p1,C1.centerOfMass());
		p1=new Point2D(35.2,46.01);
		assertNotEquals(p1,C1.centerOfMass());
	}
	@Test
	void Testcopy()
	{
		p1=new Point2D(25,4.5);
		C1=new Circle2D(p1,6);
		Circle2D C2=(Circle2D) C1.copy();
		assertEquals(C2.centerOfMass(),C1.centerOfMass());
		assertEquals(C2.getRadius(),C1.getRadius());
	}
	@Test
	void TestgetPoints()
	{
		p1=new Point2D(25,2.45);
		C1=new Circle2D(p1,7);
		Point2D[] C1p=C1.getPoints();
		Point2D[] ans=new Point2D[2];
		ans[0]=new Point2D(p1);
		ans[1]=new Point2D(p1.x(),p1.y()+7);
		assertArrayEquals(ans, C1p);
		
	}
}
