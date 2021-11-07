package ex4;
import java.awt.Color;
import ex4.geometry.*;
/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * @author Ilan Gold ID:315804583
 *
 */
public class Ex4 implements Ex4_GUI{
	GUI_Shape_Collection shapescol;
	Shape_Collection x;
	public static void main(String[] args)
	{
		String filepath=args[0];
		int sortnum=Integer.parseInt(args[1]);
		Ex4 win = new Ex4();
		GUI_Shape_Collection sc = win.getShape_Collection();
		sc.load(filepath);
		 Shape_Comp comp = new Shape_Comp(sortnum);
		 sc.sort(comp);
		 System.out.println("**** Sorting accurding to flag="+sortnum+" ****");
			System.out.println(sc);
			System.out.println();
			StdDraw.setCanvasSize(Ex4_Const.Width, Ex4_Const.Height);
			StdDraw.setScale(0, 0.9);
			Rect2D bb = sc.getBoundingBox();
			Point2D min = bb.getPoints()[0], max = bb.getPoints()[1];
			double m0 = Math.min(min.x(), min.y());
			double m1 = Math.max(max.x(), max.y());
			StdDraw.setScale(m0-0.1,m1+0.1);
			win.show();
	}
	
	public Ex4()
	{
		x=new Shape_Collection();
		shapescol=x;
	}

	@Override
	public void init(GUI_Shape_Collection g) {
		this.shapescol=g.copy();
	}
	
	@Override
	public GUI_Shape_Collection getShape_Collection() {
		return shapescol;
	}

	/*
	 * This method presents the GUI shapes in this collection in a GUI window.
	 * it check the kind of the shape form the array and create the shape according to the color and if the shape need to be filled or not.
	 */
	@Override
	public void show() {
		StdDraw.setPenRadius(0.0065);
		for (int i = 0; i < shapescol.size(); i++) {
			if(shapescol.get(i).getShape() instanceof Circle2D)
			{
			Circle2D c1=(Circle2D) shapescol.get(i).getShape();
			StdDraw.setPenColor(shapescol.get(i).getColor());
			if(shapescol.get(i).isFilled()==true)
			{
				StdDraw.filledCircle(c1.centerOfMass().x(),c1.centerOfMass().y(),c1.getRadius());
			}
			else {
			StdDraw.circle(c1.centerOfMass().x(),c1.centerOfMass().y(),c1.getRadius());
			}
			}
			else if (shapescol.get(i).getShape() instanceof Rect2D)
			{
				Rect2D r1=(Rect2D) shapescol.get(i).getShape();
				StdDraw.setPenColor(shapescol.get(i).getColor());
				if(shapescol.get(i).isFilled()==true)
				{
					
					StdDraw.filledRectangle(r1.centerOfMass().x(), r1.centerOfMass().y(), r1.gethalfWidth(), r1.gethalfHeight());
				}
				else {
					StdDraw.rectangle(r1.centerOfMass().x(), r1.centerOfMass().y(), r1.gethalfWidth(), r1.gethalfHeight());
				}
				
			}
			else if (shapescol.get(i).getShape() instanceof Segment2D)
			{
				StdDraw.setPenColor(shapescol.get(i).getColor());
				Point2D[] xy=shapescol.get(i).getShape().getPoints();
				
				
					StdDraw.line(xy[0].x(), xy[0].y(), xy[1].x(), xy[1].y());			
			}
			else if (shapescol.get(i).getShape() instanceof Triangle2D)
			{
				
				StdDraw.setPenColor(shapescol.get(i).getColor());
				Point2D[] xy=shapescol.get(i).getShape().getPoints();
				double[] x=new double[3];
				x[0]=xy[0].x();
				x[1]=xy[1].x();
				x[2]=xy[2].x();
				double[] y=new double[3];
				y[0]=xy[0].y();
				y[1]=xy[1].y();
				y[2]=xy[2].y();
				if(shapescol.get(i).isFilled()==true) {StdDraw.filledPolygon(x, y);}
				else
					StdDraw.polygon(x, y);
			}
			else if (shapescol.get(i).getShape() instanceof Point2D)
			{
				Point2D p1=(Point2D) shapescol.get(i).getShape();
				StdDraw.setPenColor(shapescol.get(i).getColor());
				StdDraw.point(p1.x(), p1.y());
			}
		}
		
	}
	/*
	 * return the to string of the shape collection
	 */
	@Override
	public String getInfo() {
		return shapescol.toString();
	}
}
