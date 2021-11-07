package ex4.geometry;
/**
 * This class represents a 2D axis parallel rectangle.
 * @author Ilan Gold ID:315804583
 *
 */ 
public class Rect2D implements GeoShape{
	private Point2D p1,p2; //p1 bottom  p2 top 
	
	public Rect2D()
	{
		this.p1=new Point2D();
		this.p2=new Point2D(1,1);
	}
	/*
	 * create Rect2D making the p2 the top  point of the rect according to the Y value
	 */
	public Rect2D(Point2D p1,Point2D p2)
	{
		if(p1.isbigger(p2)==true)
		{
			this.p1=new Point2D(p2);
			this.p2=new Point2D(p1);
		}
		else
		{
		this.p1=new Point2D(p1);
		this.p2=new Point2D(p2);
		}
	}
	/*
	 * getters and setters to to points of the rect2d points
	 */
	public Point2D getP1() {
		return p1;
	}
	public void setP1(Point2D p1) {
		this.p1 = p1;
	}
	public Point2D getP2() {
		return p2;
	}
	public void setP2(Point2D p2) {
		this.p2 = p2;
	}
	public Rect2D(Rect2D rec1)
	{
		this(rec1.p1,rec1.p2);
	}
	/**
	 * return the half width of the rect2D for the StdDraw rectangle function
	 * the width of the rect assuming the shape if vertical to X axis and y axis
	 * is the average of the 2 X points 
	 * @return the half width of the rectangle
	 */
	public double gethalfWidth()
	{
		double halfwidth=(p2.x()-p1.x())/2;
		return halfwidth;
	}
	/**
	 * return the half height of the rect2D for the StdDraw rectangle function
	 * the height of the rect assuming the shape if vertical to X axis and y axis
	 * is the average of the 2 y points 
	 * @return the half height of the rectangle
	 */
	public double gethalfHeight()
	{
		double halfheight=(p2.y()-p1.y())/2;
		return halfheight;
	}
	/*
	 * check if a point is inside the rectangle by checking if the x and y of the point is in the rectangle  borders.
	 * p2.y() is always bigger then p1.y().
	 * 
	 */
	@Override
	public boolean contains(Point2D ot) {
		boolean x;
		boolean y;
		if(p1.x()<p2.x())
		{
		 x= (ot.x()>=p1.x())&&(ot.x()<=p2.x());
		 y= (ot.y()>=p1.y())&&(ot.y()<=p2.y());
		}
		else
		{
			 x= (ot.x()<=p1.x())&&(ot.x()>=p2.x());
			 y= (ot.y()>=p1.y())&&(ot.y()<=p2.y());
		}
		return (x&&y);
	}
	/*
	 * center of mass of a rectangle is the avrage of the x and y points.
	 */
	@Override
	public Point2D centerOfMass() {
		Point2D RectC=new Point2D(((p2.x()+p1.x())/2),((p2.y()+p1.y())/2));
		return RectC;
	}
	/*
	 * getting the Width and height of the rectangle and return the area. 
	 */
	@Override
	public double area() {
		double ylength=Math.abs(p2.y()-p1.y());
		double xlength=Math.abs(p2.x()-p1.x());
		return (ylength*xlength);
	}

	@Override
	public double perimeter() {
		double ylength=Math.abs(p2.y()-p1.y());
		double xlength=Math.abs(p2.x()-p1.x());
		return ((2*ylength)+(2*xlength));
	}

	@Override
	public void move(Point2D vec) {
		p1.move(vec);
		p2.move(vec);

	}
	@Override
	public GeoShape copy() {
		return new Rect2D(p1,p2);
	}
	/*
	 * return an array with the rectangle 2 points (left-low,right-up)
	 */

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans=new Point2D[2];
		ans[0]=new Point2D(this.p1);
		ans[1]=new Point2D(this.p2);
		return ans;
	}
	@Override
	public String toString() {
		return "Rect2D,"+p1.x()+","+p1.y()+","+p2.x()+","+p2.y();
	}

}
