package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.GUI_Shape_Collection;
import ex4.Shape_Collection;
import ex4.Shape_Comp;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Triangle2D;

class Shape_CollectionTest {
	Shape_Collection Shapestest=new Shape_Collection();
	Point2D p1,p2; //(8,12)(4,8)
	Rect2D r1=new Rect2D(new Point2D(8,8),new Point2D(4,12));
	Triangle2D t1=new Triangle2D(new Point2D(8,8),new Point2D(4,8),new Point2D(6,10));

	@Test
	void testGetAndAdd() {
		GUIShape x=new GUIShape(r1,true,Color.BLUE,0);
		Shapestest.add(x);
		GUIShape y=new GUIShape(t1,false,Color.orange,1);
		Shapestest.add(y);
		assertEquals(y, Shapestest.get(1));
		assertNotEquals(y, Shapestest.get(0));
	}

	@Test
	void testSize() {
		GUI_Shape geo1 = new GUIShape(r1,false, Color.CYAN, 0);
		GUI_Shape geo2= new GUIShape(t1,true, Color.GRAY, 1);
		Shapestest.add(geo1);
		Shapestest.add(geo2);
		assertEquals(2, Shapestest.size());
	}

	@Test
	void testRemoveElementAt() {
		p1=new Point2D(5,8);
		p2=new Point2D(52,18);
		r1=new Rect2D(p1,p2);
		 t1=new Triangle2D(p1,p2,new Point2D());
		GUI_Shape geo1 = new GUIShape(r1,false, Color.CYAN, 0);
		GUI_Shape geo2= new GUIShape(t1,true, Color.GRAY, 1);
		Shapestest.add(geo1);
		Shapestest.add(geo2);
		assertEquals(geo1,Shapestest.removeElementAt(0));

	}

	@Test
	void testAddAt() {
		GUI_Shape geo1 = new GUIShape(r1,false, Color.CYAN, 0);
		GUI_Shape geo2= new GUIShape(t1,true, Color.GRAY, 1);
		GUI_Shape geo3= new GUIShape(p1,true, Color.GRAY, 1);
		Shapestest.add(geo1);
		Shapestest.add(geo2);
		GUI_Shape geo8 = new GUIShape();
		GUI_Shape geo4 = new GUIShape();
		Shapestest.add(geo8);
		Shapestest.add(geo4);
		Shapestest.addAt(geo3, 3);
		assertEquals(geo3,Shapestest.get(3));
	}


	@Test
	void testCopy() {
		GUI_Shape geo1 = new GUIShape(r1,false, Color.CYAN, 0);
		Shapestest.add(geo1);
		p1=new Point2D(6,2);
		GUI_Shape geo8= new GUIShape(t1,true, Color.GRAY, 1);
		GUI_Shape geo4= new GUIShape(p1,true, Color.lightGray, 3);
		Shapestest.add(geo8);
		Shapestest.add(geo4);
		GUI_Shape_Collection test=Shapestest.copy();
		for (int i = 0; i < test.size(); i++) {
			assertEquals(Shapestest.get(i), test.get(i));
		}
	}

	@Test
	void testSort() {
		GUI_Shape geo1 = new GUIShape(r1,false, Color.CYAN, 0);
		GUI_Shape geo2= new GUIShape(t1,true, Color.GRAY, 1);
		p1=new Point2D();
		GUI_Shape geo3= new GUIShape(p1,true, Color.lightGray, 3);
		Shapestest.add(geo1);
		Shapestest.add(geo2);
		Shapestest.add(geo3);
		Shape_Collection Shapestest124=new Shape_Collection();
		Shapestest124.add(geo1);
		Shapestest124.add(geo2);
		Shapestest124.add(geo3);
		Shape_Collection Shapestest035=new Shape_Collection();
		Shapestest035.add(geo3);
		Shapestest035.add(geo2);
		Shapestest035.add(geo1);
		Shape_Collection StringSort=new Shape_Collection();
		StringSort.add(geo3);
		StringSort.add(geo1);
		StringSort.add(geo2);
		
		
		for (int i = 0; i < 7; i++) {
			 Shape_Comp comp = new Shape_Comp(i);
			 Shapestest.sort(comp);
			 for (int j = 0; j < Shapestest.size(); j++) {
				
			
			 if(i==1||i==2||i==4)
			 {assertEquals(Shapestest124.get(j), Shapestest.get(j));}
			 else if(i==0||i==3||i==5)
			 {assertEquals(Shapestest035.get(j), Shapestest.get(j));}
			 else if(i==6)
			 {assertEquals(StringSort.get(j), Shapestest.get(j));}
				 
			 } 
			 
		}
		
	}

	@Test
	void testRemoveAll() {
		GUI_Shape geo1 = new GUIShape(r1,false, Color.CYAN, 0);
		GUI_Shape geo2= new GUIShape(t1,true, Color.GRAY, 1);
		GUI_Shape geo3= new GUIShape(p1,true, Color.lightGray, 3);
		Shapestest.add(geo1);
		Shapestest.add(geo2);
		Shapestest.add(geo3);
		Shape_Collection nullcollection=new Shape_Collection();
		Shapestest.removeAll();
		assertEquals(nullcollection.toString(),Shapestest.toString());
	
	}

	@Test
	void testSaveload() {
		p1=new Point2D();
		GUI_Shape geo1 = new GUIShape(r1,false, Color.CYAN, 0);
		GUI_Shape geo2= new GUIShape(t1,true, Color.GRAY, 1);
		GUI_Shape geo3= new GUIShape(p1,true, Color.lightGray, 3);
		Shapestest.add(geo1);
		Shapestest.add(geo2);
		Shapestest.add(geo3);
		Shapestest.save("saveloadtest.txt");
		Shape_Collection loadtest=new Shape_Collection();
		loadtest.load("saveloadtest.txt");
		assertEquals(Shapestest.toString(),loadtest.toString());
	}

	@Test
	void testGetBoundingBox() {
		p1=new Point2D(6,2);
		GUI_Shape geo1 = new GUIShape(r1,false, Color.CYAN, 0);
		GUI_Shape geo2= new GUIShape(t1,true, Color.GRAY, 1);
		GUI_Shape geo3= new GUIShape(p1,true, Color.lightGray, 3);
		
		Shapestest.add(geo1);
		Shapestest.add(geo2);
		Shapestest.add(geo3);
		Rect2D bb=Shapestest.getBoundingBox();
		r1=new Rect2D(new Point2D(4,2),new Point2D(8,12));
		assertEquals(r1.getP1(), bb.getP1());
		
	}

}
