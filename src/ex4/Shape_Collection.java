package ex4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;
/**
 * This class represents a collection of GUI_Shape.
 * @author Ilan Gold ID:315804583
 *
 */
public class Shape_Collection implements GUI_Shape_Collection{
	private ArrayList<GUI_Shape> Shapes;
	
	
	public  Shape_Collection()
	{
		Shapes = new ArrayList<GUI_Shape>();
		
		
	}
	public  Shape_Collection(GUI_Shape[] s)
	{
		ArrayList<GUI_Shape> Shapes1 = new ArrayList<GUI_Shape>();
		for (int i = 0; i < s.length; i++) {
			Shapes1.add(s[i]);
		}
		
	}
	public  Shape_Collection(ArrayList<GUI_Shape> Shapes1)
	{
		 Shapes=new ArrayList<GUI_Shape>();
		Shapes.addAll(Shapes1);	
		
		
	}
	public  Shape_Collection(Shape_Collection shapes1)
	{
		    Shapes=new ArrayList<GUI_Shape>();
			this.Shapes.addAll(shapes1.Shapes);
		
		
	}
	/*
	 * get the Shape from the shape collection and @return it as a GUIShape
	 * 
	 */
	@Override
	public GUI_Shape get(int i) {
		GUI_Shape x= Shapes.get(i);
		return x;
	}

	@Override
	public int size() {
		
		return Shapes.size();
		
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		
		return Shapes.remove(i);
	}

	@Override
	public void addAt(GUI_Shape s, int i) {
	Shapes.add(i, s);
	}
	@Override
	public void add(GUI_Shape s) {
			Shapes.add(s);
			
			
	}

	@Override
	public GUI_Shape_Collection copy() {
	
		return new Shape_Collection(this.Shapes);
	}

	@Override
	public void sort(Comparator<GUI_Shape> comp) {
	Shapes.sort(comp);
		
	}

	@Override
	public void removeAll() {
	Shapes.removeAll(Shapes);
	}

	@Override
	public void save(String file) {
		 try {
		
		 FileWriter mywriter= new FileWriter(file);
		 for(int i=0;i<Shapes.size();i++)
		 {
			
				mywriter.write(Shapes.get(i).toString());
		 }
		 mywriter.close();
		 }
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void load(String file) {
		 try {
		File myfile= new File(file);
		Scanner reader=new Scanner(myfile);
		int i=0;
		while(reader.hasNextLine()) {
			String data=reader.nextLine();
			//System.out.println(data);
			GUIShape try2=new GUIShape(data); // sending the text to  create a GUIShape according to the shapes and the text.
			Shapes.add(try2);	//adding the GUIShape created by the text to the collection.
			i=i+1;
		}
		reader.close();
		 }
		
		 catch(Exception e) {
			 e.printStackTrace();
		 }	 
	}
	/*
	 * In this method i created 2 ArrayList for the x points of the collection and the y points of the collection
	 * i added all the x and y points to the arrays and then sort them by natural order and took the max and min x and y points a crated the minimum rect2d for the gui draw.
	 */
	@Override
	public Rect2D getBoundingBox() {
		
		ArrayList<Double> Xpoints=new ArrayList<Double>();
		ArrayList<Double> Ypoints=new ArrayList<Double>();
		
		for (int i = 0; i < Shapes.size(); i++) {
			if (Shapes.get(i).getShape() instanceof Point2D) {
				 Point2D XY=(Point2D)Shapes.get(i).getShape();
				 Xpoints.add(XY.x());
				 Ypoints.add(XY.y());
			}
			if (Shapes.get(i).getShape() instanceof Segment2D) {
				Segment2D XY=(Segment2D)Shapes.get(i).getShape();
				 Xpoints.add(XY.getP1().x());
				 Ypoints.add(XY.getP1().y());
				 Xpoints.add(XY.getP2().x());
				 Ypoints.add(XY.getP2().y());
				
			}
			if (Shapes.get(i).getShape() instanceof Circle2D) {
				Circle2D XY=(Circle2D)Shapes.get(i).getShape();
				 Xpoints.add(XY.get_center().x());
				 Ypoints.add(XY.get_center().y());
				 Xpoints.add(XY.get_center().x()+XY.getRadius());
				 Xpoints.add(XY.get_center().x()-XY.getRadius());
				 Ypoints.add(XY.get_center().y()+XY.getRadius());
				 Ypoints.add(XY.get_center().y()-XY.getRadius());					
			}
			if (Shapes.get(i).getShape() instanceof Rect2D) {
				Rect2D XY=(Rect2D)Shapes.get(i).getShape();
				Xpoints.add(XY.getP1().x());
				Ypoints.add(XY.getP1().y());
				Xpoints.add(XY.getP2().x());
				Ypoints.add(XY.getP2().y());
			}
			if (Shapes.get(i).getShape() instanceof Triangle2D) {
				Triangle2D XY=(Triangle2D)Shapes.get(i).getShape();
				Xpoints.add(XY.getP1().x());
				Ypoints.add(XY.getP1().y());
				Xpoints.add(XY.getP2().x());
				Ypoints.add(XY.getP2().y());
				Xpoints.add(XY.getP3().x());
				Ypoints.add(XY.getP3().y());
			}			
		}
		Xpoints.sort(Comparator.naturalOrder());
		Ypoints.sort(Comparator.naturalOrder());
		double minx=Xpoints.get(Xpoints.size()-1);
		double miny=Ypoints.get(Ypoints.size()-1);
		double maxx=Xpoints.get(0);
		double maxy=Ypoints.get(0);
		Rect2D bb=new Rect2D(new Point2D(minx,miny),new Point2D(maxx,maxy));
		return bb;
	}
	@Override
	public String toString() {
		return Shapes.toString();
	}
}
