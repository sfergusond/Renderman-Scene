
public class ShadowAim extends Ri {
	
	void AimZ(double[] lightTo, double[] lightFrom)
	{
		double PI =3.14;
		
		double xzlen, yzlen, yrot, xrot;
		double[] direction = new double[3];
		
		direction[0] = -lightFrom[0] + lightTo[0];
		direction[1] = -lightFrom[1] + lightTo[1];
		direction[2] = -lightFrom[2] + lightTo[2];
		
		// aiming direction is 0,0,0, - no good

		if (direction[0]==0 && direction[1]==0 && direction[2]==0)
			return;
		/*
		 * The initial rotation about the y axis is given by the projection of
		 * the direction vector onto the x,z plane: the x and z components
		 * of the direction.
		 */

		xzlen = Math.sqrt(direction[0]*direction[0]+direction[2]*direction[2]);
		if (xzlen == 0)
			yrot = (direction[1] < 0) ? 180 : 0;
		else
			yrot = 180*Math.acos(direction[2]/xzlen)/PI;

		/*
		 * The second rotation, about the x axis, is given by the projection on
		 * the y,z plane of the y-rotated direction vector: the original y
		 * component, and the rotated x,z vector from above.
		 */
		yzlen = Math.sqrt(direction[1]*direction[1]+xzlen*xzlen);
		xrot = 180*Math.acos(xzlen/yzlen)/PI;       /* yzlen should never be 0 */

		if (direction[1] > 0)
			RiRotate(xrot, 1.0, 0.0, 0.0);
		else
			RiRotate(-xrot, 1.0, 0.0, 0.0);
		/* The last rotation declared gets performed first */
		if (direction[0] > 0)
			RiRotate(-yrot, 0.0, 1.0, 0.0);
		else
			RiRotate(yrot, 0.0, 1.0, 0.0);
		
		RiTranslate(-lightFrom[0], -lightFrom[1], -lightFrom[2]);     
	}


}
