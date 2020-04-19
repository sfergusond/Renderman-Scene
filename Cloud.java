public class Cloud extends Ri {

    public static void main(String[]  args) {
	new Cloud().drawcloud();
    }

    void drawcloud() {
	RiBegin(RI_NULL);
	RiDisplay("temple.tiff", "framebuffer", "rgba", RI_NULL);
	RiLightSource("distantlight", RI_NULL);
	RiLightSource("ambientlight", RI_NULL);
	RiProjection("perspective", RI_NULL);
	RiFormat(860,860,1);
	RiTranslate(0,0,8);

	RiWorldBegin();

	RiAttribute("displacementbound", "sphere", 50, RI_NULL);
	RiDisplacement("roughTX", RI_NULL);
	RiSurface("cloudTX", RI_NULL);
	//RiRotate(45,0,1,0);
	cloud();

	RiWorldEnd();
	RiEnd();
    }

    void cloud() {
	RiAttributeBegin();

	RiAttribute("displacementbound", "sphere", 50, RI_NULL);
	RiDisplacement("roughTX", RI_NULL);
	RiSurface("cloudTX", RI_NULL);

	int[] blobArr = {
	    1001, 0,
	    1001, 16,
	    1001, 32,
	    1001, 48,
	    1001, 64,
	    1001, 80,
	    1001, 96,
	    1001, 112,
	    1001, 128,
	    
	    0,8,0,1,2,3,4,5,6,7, // cloud body
	    4,9,8 // flat bottom
	};

	double[] blobDouble = {
	    15,0,0,0,
	    0,8,0,0,
	    0,0,5,0,
	    0,-1,1,0,

	    2,0,0,0,
	    0,1,0,0,
	    0,0,1,0,
	    0,-.5,-1,0,

	    2,0,0,0,
	    0,1,0,0,
	    0,0,1,0,
	    1,-1,-1,0,

	    1,0,0,0,
	    0,1.5,0,0,
	    0,0,1.2,0,
	    -2,-.5,-1,0,

	    2,0,0,0,
	    0,1,0,0,
	    0,0,1,0,
	    -.75,2,0,0,

	    2.7,0,0,0,
	    0,3.5,0,0,
	    0,0,1,0,
	    -3,.5,-1,0,

	    3,0,0,0,
	    0,3.2,0,0,
	    0,0,1,0,
	    2,-.2,-1,0,

	    7,0,0,0,
	    0,4,0,0,
	    0,0,3,0,
	    3,5.25,0,0,

	    10,0,0,0,
	    0,2,0,0,
	    0,0,5,0,
	    0,-4.75,-1,0
	};

	String[] stringArr = {};

	RiBlobby(9, blobArr.length, blobArr, blobDouble.length, blobDouble, 0, stringArr, RI_NULL);
	
	RiAttributeEnd();
    }
    
}
