package ex4.geometry;

public interface GeoShape {
	/** This interface represents a geometric (2D) shape in the plane. The methods includes: moving a shape by a vector, testing if a shape contains a point, centerOfMass, area, perimeter, toString and a method (getPoints) for getting the points representing this
	 /** Computes if the point (ot) falls inside this (closed) shape. */
	public boolean contains(Point2D ot);
	/** Computes the center of mass of this shape. */
	public Point2D centerOfMass();
	/** Computes the area of this shape, in case of point or segment return 0. */
	public double area();
	/** Computes the perimeter of this shape, return 0 in case of a Point and the 2*length in the case of a segment. */
	public double perimeter();
	/** Moves this shape by the vector 0,0-->vec. Note: this method changes the inner state of the object. */
	public void move(Point2D vec);
	/** This method computes a new (deep) copy of this GeoShape. */
	public GeoShape copy();
	/** This method returns a String representing this shape, such that one can use this string for saving the shape into a text file. */
	public String toString();
	/** This method return the dominant point of the shape: Point2D, a copy of it. Segment: the two end points. Circle: center and a point on the boundary (in this order). Rectangle: min,max 2 points (left-low,right-up). Triangle: all 3 points.*/
	public Point2D[] getPoints(); 
	
	}

