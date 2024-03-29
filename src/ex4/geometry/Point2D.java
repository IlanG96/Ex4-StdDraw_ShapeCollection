package ex4.geometry;

public class Point2D implements GeoShape{
    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    public static final Point2D ORIGIN = new Point2D(0,0);
    
    private double _x,_y;
    
    
    public Point2D() {
		this._x=0;
		this._y=0;
	}
    public Point2D(double x,double y) {
    	this._x=x; this._y=y;
    }
    public Point2D(Point2D p) {
       this(p.x(), p.y());
    }
    public Point2D(String s) {
        try {
            String[] a = s.split(",");
            _x = Double.parseDouble(a[0]);
            _y = Double.parseDouble(a[1]);
        }
        catch(IllegalArgumentException e) {
            System.err.println("ERR: got wrong format string for Point2D init, got:"+s+"  should be of format: x,y");
            throw(e);
        }
    }
    
   /*
    * getters for x and y value of the point
    * x(),y() return the double value of the points
    * ix(),iy() return the int value of the points
    */
	public double x() {return _x;}
    public double y() {return _y;}
 
    
    
    public int ix() {return (int)_x;}
    public int iy() {return (int)_y;}
  
    /*
     * this method check if the y value of the point is bigger then the p1 point.
     * @return false if p1 y value is bigger
     */
    public boolean isbigger(Point2D p1)
    {
    	
    	if(this._y>=p1.y()) return true;
    	else
    		return false;
    }
    /*
     * this method create a new point adding the x and y values to the point that called the method.
     * @return the new point with the new x and y values.
     */
    public Point2D add(Point2D p) {
    	Point2D a = new Point2D(p.x()+x(),p.y()+y());
    	return a;
    }
    @Override
    public String toString()
    {
        return "Point2D,"+_x+","+_y;
    }
    /*
     * @return the distance of the point for the origin point (0,0)
     */
    public double distance()
    {
        return this.distance(ORIGIN);
    }
    public double distance(Point2D p2)
    {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx*dx+dy*dy);
        return Math.sqrt(t);
    }
/*
 * this method check if the object given is a point2D if he is the method check if he is equals to the point
 * @return true if the object is equal to the point
 */
    public boolean equals(Object p)
    {
        if(p==null || !(p instanceof Point2D)) {return false;}
        Point2D p2 = (Point2D)p;
        return ( (_x==p2._x) && (_y==p2._y));
    }
    
    /*
     * this method check if the point is close to a given eps
     * @return true if the distance is less then the given eps.
     */
    public boolean close2equals(Point2D p2, double eps)
    {
        return ( this.distance(p2) < eps );
    }
    /*
     * this method check if the point is close to eps of the class
     * @return true if the distance is less then the  eps.
     */
    public boolean close2equals(Point2D p2)
    {
        return close2equals(p2, EPS);
    }
    /**
     * This method returns the vector between this point and the target point. The vector is represented as a Point2D.
     * @param target
     * @return a new Point2D(dx,dy)
     */
    public Point2D vector(Point2D target) {
    	double dx = target.x() - this.x();
    	double dy = target.y() - this.y();
    	return new Point2D(dx,dy);
    }
	@Override
	public boolean contains(Point2D ot) {
		return this.equals(ot);
		}
	@Override
	public Point2D centerOfMass() {
		// TODO Auto-generated method stub
		return new Point2D(this);
	}
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void move(Point2D vec) {
		this._x += vec.x();
		this._y += vec.y();
	}
	@Override
	public GeoShape copy() {
		return new Point2D(this);
	}
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[1];
		ans[0] =new Point2D(this);
		return ans;
	}
}

