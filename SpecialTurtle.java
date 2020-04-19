
public class SpecialTurtle extends Turtle {


	public SpecialTurtle(double width, double shrinkWidth, double length, 
			double shrinkLength, double aX, double aY, double aZ, double[] c) {
		super( width,  shrinkWidth,  length,  shrinkLength,  aX,  aY,  aZ, c);
		double[] lightning = {0.5, 0.5, 1};
		mainColor = lightning;
	}

	public void outputRealLeaf(Point where, char c) {

		super.outputRealLeaf(where,c);
	}

	public boolean doOneStep(StringBuffer spec, Point where, char firstStep) {
		switch (firstStep) {
		    
		case 'P':
		    double branchchance = (int)(3 * Math.random());
		    if (branchchance == 0)
			forward(where);	   
		    else{ 
			RiAttributeBegin();
		   where.width = where.width/1.7;
		   int chance2 = (int)(6 * Math.random());
		   double angle2 = 35.0 * Math.random();
		   if (chance2 >= 3) {
		       if (chance2 == 3)
			   RiRotate(angle2, 0.0, 1.0, 0.0);
		       else if (chance2 == 4)
			   RiRotate(angle2, 1.0, 1.0, 0.0);
		       else
			   RiRotate(angle2, 0.0, 0.0, 1.0);}
		   else {
		       if (chance2 == 2)
			   RiRotate(360.0-angle2, 0.0, 1.0, 0.0);
		       else if (chance2 == 1)
			   RiRotate(360.0-angle2, 1.0, 1.0, 0.0);
		       else
			   RiRotate(260.0-angle2,0.0,0.0,1.0);
			   }
		   forward(where);
		   RiAttributeEnd();
		    }
			break;
		case 'R':
		    int chance = (int)(2 * Math.random());
		    double angle = 10.0 * Math.random();
		    if (chance == 0)
			RiRotate(angle, 0.0, 1.0, 0.0);
		    else
			RiRotate(360.0-angle, 0.0, 1.0, 0.0);
		    break;
		case 'W':
		   where.width = where.width/1.7;
		   int chance2 = (int)(6 * Math.random());
		   double angle2 = 35.0 * Math.random();
		   if (chance2 >= 3) {
		       if (chance2 == 3)
			   RiRotate(angle2, 0.0, 1.0, 0.0);
		       else if (chance2 == 4)
			   RiRotate(angle2, 1.0, 1.0, 0.0);
		       else
			   RiRotate(angle2, 0.0, 0.0, 1.0);}
		   else {
		       if (chance2 == 2)
			   RiRotate(360.0-angle2, 0.0, 1.0, 0.0);
		       else if (chance2 == 1)
			   RiRotate(360.0-angle2, 1.0, 1.0, 0.0);
		       else
			   RiRotate(260.0-angle2,0.0,0.0,1.0);
		       }
		   break;  
		default:super.doOneStep(spec,where,firstStep);
		}
		return false;
	}
}
