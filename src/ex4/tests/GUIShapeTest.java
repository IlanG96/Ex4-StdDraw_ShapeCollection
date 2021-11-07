package ex4.tests;


import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

class GUIShapeTest {
	GUIShape testGUIShape;
	Color color;
	int tag;
	boolean filled;
	GeoShape tryshapes;
	
	@Test
	void testGetShape() {
		tryshapes=new Circle2D(new Point2D(22,5),5);
		testGUIShape= new GUIShape(tryshapes,true,Color.BLUE,0);
		assertEquals(tryshapes, testGUIShape.getShape());
		tryshapes=new Rect2D(new Point2D(22,5),new Point2D(44,3));
		testGUIShape= new GUIShape(tryshapes,true,Color.BLUE,0);
		assertEquals(tryshapes, testGUIShape.getShape());
		tryshapes=new Rect2D(new Point2D(21,5),new Point2D(44,3));
		assertNotEquals(tryshapes, testGUIShape.getShape());
		tryshapes=new Triangle2D(new Point2D(21,5),new Point2D(44,3),new Point2D());
		testGUIShape= new GUIShape(tryshapes,true,Color.BLUE,0);
		assertEquals(tryshapes, testGUIShape.getShape());
	}

	@Test
	void testSetShape() {
		tryshapes=new Triangle2D(new Point2D(13,13),new Point2D(23,2),new Point2D(5,5));
		testGUIShape= new GUIShape(tryshapes,true,Color.BLUE,0);
		tryshapes=new Rect2D(new Point2D(21,5),new Point2D(43,21));
		testGUIShape.setShape(tryshapes);
		assertEquals(tryshapes, testGUIShape.getShape());
		tryshapes=new Triangle2D(new Point2D(13,13),new Point2D(23,2),new Point2D(5,5));
		assertNotEquals(tryshapes, testGUIShape.getShape());
	}

	@Test
	void testIsFilledSetFilled() {
		testGUIShape= new GUIShape(tryshapes,true,Color.BLUE,0);
		assertTrue(testGUIShape.isFilled());
		testGUIShape.setFilled(false);
		assertFalse(testGUIShape.isFilled());
		testGUIShape.setFilled(true);
		assertTrue(testGUIShape.isFilled());
	
		
	}

	@Test
	void testGetColorAndSetColor() {
		testGUIShape= new GUIShape(tryshapes,true,Color.BLUE,0);
		assertEquals(Color.BLUE, testGUIShape.getColor());
		testGUIShape.setColor(Color.gray);
		assertEquals(Color.gray, testGUIShape.getColor());
		assertNotEquals(Color.yellow, testGUIShape.getColor());

	}
		
	@Test
	void testGetTagAndSetTag() {
		testGUIShape= new GUIShape(tryshapes,true,Color.BLUE,0);
		assertEquals(0, testGUIShape.getTag());
		testGUIShape.setTag(80);
		assertNotEquals(0, testGUIShape.getTag());
		assertEquals(80, testGUIShape.getTag());
	}
	
	@Test
	void testCopy() {
		tryshapes=new Circle2D(new Point2D(22,5),5);
		testGUIShape= new GUIShape(tryshapes,true,Color.BLUE,0);
		GUI_Shape test1=testGUIShape.copy();
		assertEquals(test1.getShape(),testGUIShape.getShape());
		assertEquals(test1.getColor(),testGUIShape.getColor());
		assertEquals(test1.isFilled(),testGUIShape.isFilled());
		assertEquals(test1.getTag(),testGUIShape.getTag());
		test1.setShape(new Triangle2D(new Point2D(13,13),new Point2D(23,2),new Point2D(5,5)));
		assertNotEquals(test1.getShape(),testGUIShape.getShape());	
	}
	@Test
	void testGUIShapestring()
	{
		String s="GUIShape,8421504,true,4,Triangle2D,0.8,0.7,0.3,0.65,0.1,0.1";
		testGUIShape=new GUIShape(s);
		Triangle2D Stringshape=new Triangle2D(new Point2D(0.8,0.7),new Point2D(0.3,0.65),new Point2D(0.1,0.1));
		GUIShape test1=new GUIShape(Stringshape,true,Color.decode("8421504"),4);
		assertEquals(test1.getShape().toString(),testGUIShape.getShape().toString());
		assertEquals(test1.getColor(),testGUIShape.getColor());
		assertEquals(test1.isFilled(),testGUIShape.isFilled());
		assertEquals(test1.getTag(),testGUIShape.getTag());
		
	}

}
