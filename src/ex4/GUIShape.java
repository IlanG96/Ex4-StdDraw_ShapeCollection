package ex4;
/**
 * This class implements the GUI_shape.
 * @author Ilan Gold
 */
import java.awt.Color;
import ex4.geometry.*;

public class GUIShape implements GUI_Shape{
	private GeoShape shape;
	private Color color;
	private int tag;
	private boolean filled;
	
	/*
	 * 4 diffrent method to create a GUIShape
	 */
	public GUIShape()
	{
		this.shape=null;
		this.color=null;
		this.filled=false;
		this.tag=0;
		
		
	}
	public GUIShape(GeoShape shape,boolean filled,Color c,int tag)
	{
		this.shape=shape;
		this.color=c;
		this.filled=filled;
		this.tag=tag;
	}
	public GUIShape(Color c,boolean filled,int tag,GeoShape shape)
	{
		this.shape=shape;
		this.color=c;
		this.filled=filled;
		this.tag=tag;
	}
	public GUIShape(GUIShape s)
	{
		this.shape=s.shape;
		this.color=s.color;
		this.filled=s.filled;
		this.tag=s.tag;
	}
	/*
	 * This method get a string with a info and create a GUIShape according to the info inside the String.
	 * 
	 */
	public GUIShape(String s) {
		try {
		String[] loadtest=s.split(",");
		this.color=Color.decode(loadtest[1]);
		this.filled=Boolean.parseBoolean(loadtest[2]);
		this.tag=Integer.parseInt(loadtest[3]);
		if(loadtest[4].equals("Circle2D"))
		{
			double radius=Double.parseDouble(loadtest[7]);
			this.shape=new Circle2D(new Point2D(loadtest[5]+","+loadtest[6]),radius);
		}
		else if(loadtest[4].equals("Rect2D"))
		{
			this.shape=new Rect2D(new Point2D(loadtest[5]+","+loadtest[6]),new Point2D(loadtest[7]+","+loadtest[8]));
		}
		else if(loadtest[4].equals("Triangle2D"))
		{
			this.shape=new Triangle2D(new Point2D(loadtest[5]+","+loadtest[6]),new Point2D(loadtest[7]+","+loadtest[8]),new Point2D(loadtest[9]+","+loadtest[10]));
		}
		else if(loadtest[4].equals("Segment2D"))
		{
			this.shape=new Segment2D(new Point2D(loadtest[5]+","+loadtest[6]),new Point2D(loadtest[7]+","+loadtest[8]));
		}
		else if(loadtest[4].equals("Point2D"))
		{this.shape=new Point2D(Double.parseDouble(loadtest[5]),Double.parseDouble(loadtest[6]));}
		else
		{System.err.println("Cant Reconize the shape:"+loadtest[4]);}
		}
		catch(IllegalArgumentException e)
		{
			System.err.println("ERR: The String that enterd got the wrong format. \n please enter the String GUIShape,color RGB,Boolean isfilled,tag,name of tha shape,the points of the shape each point sepertated by ,. ");
			throw(e);
		}			
	}
	/*
	 * returning the GeoShape of the GUIShape .
	 * @return the shape
	 */
	@Override
	public GeoShape getShape() {
		return shape;
	}
/*
 * in this method you can change the shape of the GUIShape to any Shape you want from the available collecton
 */
	@Override
	public void setShape(GeoShape g) {
		shape=g;
	}
/*
 * Getter if to check if the GUIShape need to be filled at the STD Drawing
 * @return true if fiiled false if not
 */
	@Override
	public boolean isFilled() {
		
		return this.filled;	}
/*
 * Setter if the isfilled need a change.
 * 
 */
	@Override
	public void setFilled(boolean filled) {
		this.filled=filled;
	}
/*
 * getter for the color to check what color you the Shape to be at the STDDraw
 * @return Color
 */
	@Override
	public Color getColor() {
		return this.color;
	}
/*
 * setter for the color if the user want to change the color of the GUIShape
 */
	@Override
	public void setColor(Color cl) {
		this.color=cl;
	}
/*
 * tag getter
 * @return the tag of the GUIShape
 */
	@Override
	public int getTag() {
		return this.tag;
	}
/*
 * tag setter set the tag of the GUIShape
 */
	@Override
	public void setTag(int tag) {
		this.tag=tag;
	}
/*
 * create a deep copy of the GUIShape.
 * @return GUI_Shape a copy of the GUIShape as an interface
 */
	@Override
	public GUI_Shape copy() {
		return new GUIShape(this.shape,this.filled,this.color,this.tag);
	} 
	/*
	 * Print the full details of the GUIShape as seen in the Ex4.test
	 */
	@Override
	public String toString() {
		return "GUIShape," +(this.color.getRGB()&0xffffff)+","+this.filled+","+this.tag+","+shape.toString()+"\n" ;
	}
}
