/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/
	
		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
		 snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);

		if(n == 0)
			return;

		double x11 = ((x2 - x1) / 3) + x1;
		double y11 = ((y2 - y1) / 3) + y1;
		double x22 = (((x2 - x1) / 3) * 2) + x1;
		double y22 = (((y2 - y1) / 3) * 2) + y1;

        double x3 = (Math.sqrt(3) / 6) * (y1 - y2) + 0.5 * (x1 + x2);
        double y3 = (Math.sqrt(3) / 6) * (x2 - x1) + 0.5 * (y1 + y2);

        StdDraw.line(x11, y11, x3, y3);
		StdDraw.line(x22, y22, x3, y3);
         
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.line(x11, y11, x22, y22);
		StdDraw.setPenColor(StdDraw.BLACK);

		curve(n - 1, x1, y1, x11, y11);
		curve(n - 1, x11, y11, x3, y3);
		curve(n - 1, x3, y3, x22, y22);
		curve(n - 1, x22, y22, x2, y2);

	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		
		double x1 = 0.5;
		double y1 = 0.76;
		double x2 = 0.2;
		double y2 = 0.24;
		double x3 = 0.8;
		double y3 = 0.24;


		curve(n , x2, y2, x1, y1);
		curve(n , x1, y1, x3, y3);
		curve(n , x3, y3, x2, y2);
	}
}	