package ex4.geometry;

//import ex4.Ex4_Const;
/**
 * This class represents a 2D segment on the plane, 
 * @author Ilan Gold
 *
 */
public class Segment2D implements GeoShape{
	private Point2D p1,p2; //p2 the higher point
	
	
	public Segment2D()
	{
		this.p1=new Point2D();
		this.p2=new Point2D(1,1);
	}
	
/*
 * create a segment making p2 the higher point according to her y
 */
	public Segment2D(Point2D f1,Point2D f2)
	{
		if(f1.isbigger(f2)==true) {
		this.p1=new Point2D(f2);
		this.p2=new Point2D(f1);
		}
		else
		{
			this.p1=new Point2D(f1);
			this.p2=new Point2D(f2);
		}
	}
	public Segment2D(Segment2D s1)
	{
		this(s1.p1,s1.p2);
	}
	/*
	 * getters and setters for the 2 points of the segment 
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
	/*
	 * calculate the distance of the 2 end points of the segment
	 */
	public double distance()
	{
		double distance=Math.sqrt((Math.pow((p2.x()-p1.x()), 2))+(Math.pow((p2.y()-p1.y()), 2)));
		return distance;
	}
/*
 * if the point is on the liner equation of the segment so the segment contain the point.
 */

	@Override
	public boolean contains(Point2D ot) {
		double slope=0;
		if(p1.x()-p2.x()!=0)
		{
			slope=((p2.y()-p1.y())/(p2.x()-p1.x()));
			
		}
		if(p1.contains(ot)||p2.contains(ot)) {return true;}
		double n=-slope*p2.x()+p2.y();   //y=slope*x+n equation
		
		boolean in =(ot.y()==slope*ot.x()+n)&&(ot.x()==((ot.y()-n)/slope));  //check if the y value and the x value of ot is in the segment equation
	    boolean inside=((ot.x()<=p2.x())&&(ot.x()>=p1.x()))&&((ot.y()<=p2.y())&&(ot.y()>=p1.y())); //check if the point is between the 2 points of the segment
	    	if((inside&&in)==true)
		{return true;}		
		
		else
		return false;
	}
/*
 * the override method are basic and the description is inside the interface.
 */
	@Override
	public Point2D centerOfMass() {
		Point2D MidPoint=new Point2D((p2.x()+p1.x())/2,(p2.y()+p1.y())/2);
		return MidPoint;
	}


	
	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		double distance=Math.sqrt((Math.pow((p2.x()-p1.x()), 2))+(Math.pow((p2.y()-p1.y()), 2)));
		
		return 2*distance;
	}

	@Override
	public void move(Point2D vec) {
		p1.move(vec);
		p2.move(vec);
		
	}

	@Override
	public GeoShape copy() {
		
		return new Segment2D(p1,p2);
	}
	/*
	 * return an array with the 2 points of the segment 
	 */
	@Override
	public Point2D[] getPoints() {
		Point2D[] getPoints=new Point2D[2];
		getPoints[0]=new Point2D(this.p1);
		getPoints[1]=new Point2D(this.p2);
		return getPoints;
	}
	@Override
	public String toString() {
		return "Segment2D,"+p1.x()+","+p1.y()+","+p2.x()+","+p2.y();
	}
}