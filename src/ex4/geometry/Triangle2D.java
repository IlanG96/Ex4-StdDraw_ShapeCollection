package ex4.geometry;
/**
 * This class represents a 2D Triangle in the plane.
 * 
 * @author Ilan Gold
 *
 */
public class Triangle2D implements GeoShape{
	private Point2D p1,p2,p3;
	public static final double EPS1 = 0.00001;
	public Triangle2D()
	{
		this.p1=new Point2D(0,0);
		this.p2=new Point2D(1,1);
		this.p3=new Point2D(-1,1);
	}

	public Triangle2D(Point2D p1,Point2D p2,Point2D p3)
	{
		this.p1=new Point2D(p1);
		this.p2=new Point2D(p2);
		this.p3=new Point2D(p3);
		
	}

	public Triangle2D(Triangle2D O)
	{
		this(O.p1,O.p2,O.p3);
	}
	/*
	 * 
	 * getters and setters for the 3 points of the Triangle2D 
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
	public Point2D getP3() {
		return p3;
	}
	public void setP3(Point2D p3) {
		this.p3 = p3;
	}
	@Override
	public Point2D centerOfMass() {                   //according to Averaged Coordinates
		double xaverage=(this.p1.x()+this.p2.x()+this.p3.x())/3;
		double yaverage=(this.p1.y()+this.p2.y()+this.p3.y())/3;
		
		return new Point2D(xaverage,yaverage);
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 */
	@Override
	public double area() {
		Segment2D p1p2=new Segment2D(this.p1,this.p2);
		Segment2D p2p3=new Segment2D(this.p2,this.p3);
		Segment2D p1p3=new Segment2D(this.p1,this.p3);
		
		double d=(p1p2.distance()+p2p3.distance()+p1p3.distance())/2;
		double area = Math.sqrt(d*(d-p1p2.distance())*(d-p2p3.distance())*(d-p1p3.distance()));
		return area;
	}
	@Override
	public boolean contains(Point2D ot) {//if the area of the 3 triangle created by ot equal the big triangle then the triangle contains it 
		Triangle2D p1p2p3=new Triangle2D(this.p1,this.p2,this.p3);
		Triangle2D p1p2ot=new Triangle2D(this.p1,this.p2,ot);
		Triangle2D p1otp3=new Triangle2D(this.p1,ot,this.p3);
		Triangle2D otp2p3=new Triangle2D(ot,this.p2,this.p3);
		
		double sumofot=p1p2ot.area()+p1otp3.area()+otp2p3.area(); //sum of the areas of the three triangle created from ot and the 3 other points
		double sumofp1p2p3=p1p2p3.area();
		if(sumofp1p2p3==0 && sumofot==0) {
			Segment2D p1p2=new Segment2D(this.p1,this.p2);
			Segment2D p2p3=new Segment2D(this.p2,this.p3);
			Segment2D p1p3=new Segment2D(this.p1,this.p3);
			if(p1p2.contains(ot)&&p2p3.contains(ot)&&p1p3.contains(ot)) // a special case when the three point has the same x or y
			{return true;}												//create 3 segments and see if they contain the point
			else return false;
		}
		else if(Math.abs(sumofp1p2p3-sumofot)<=EPS1) {return true;}
		
		else	
		return false;
	}

	@Override
	public double perimeter() {
		
		Segment2D p1p2=new Segment2D(this.p1,this.p2);
		Segment2D p2p3=new Segment2D(this.p2,this.p3);
		Segment2D p1p3=new Segment2D(this.p1,this.p3);
		double d;
		if(p1p2.contains(p3)) {d=p1p2.distance();}   //if the triangle has 3 points on the same X axis or y axis the perimeter will be as a distance of a segment
			
		if(p1p3.contains(p2)) { d=p1p3.distance();}
			
		if(p2p3.contains(p1)) { d=p2p3.distance();}
		
		else {
		 d=(p1p2.distance()+p2p3.distance()+p1p3.distance());
		}
		return d;
	}
/*
 * moving the 3 points of the Triangle2D accrording to the vec.
 */
	@Override
	public void move(Point2D vec) {
		this.p1.move(vec);
		this.p2.move(vec);
		this.p3.move(vec);
	}

	@Override
	public GeoShape copy() {
		
		
		return new Triangle2D(p1,p2,p3);
	}
/*
 * return an array with the 3 points of the Triangle 
 */
	@Override
	public Point2D[] getPoints() {
		Point2D[] getPoints=new Point2D[3];
		getPoints[0]=new Point2D(this.p1);
		getPoints[1]=new Point2D(this.p2);
		getPoints[2]=new Point2D(this.p3);
		return getPoints;
	}
	
	@Override
	public String toString() {
		return "Triangle2D,"+p1.x()+","+p1.y()+"," +p2.x()+","+p2.y()+","+p3.x()+","+p3.y();
	}
}
