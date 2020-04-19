import java.io.IOException; 
public class SFDFinal extends Ri {

	public static void main (String args [])throws IOException, InterruptedException { 
		SFDFinal sm = new SFDFinal();  //decides what to do depending on the argument 
		for (String s: args) 
		{ s=s.toLowerCase();  //if "setup": perspective is switched to the light source. If "display" is off, a shadow map is made. 
		if (s.equals("setup")) sm.mapping=true; //if"display": the current scene from the current perspective is displayed 
		if (s.equals("display")) sm.display=true; //if"ship": the rocket-style spaceship is placed in the scene above the ground 
		if (s.equals("ship")) sm.ship=true; 
		//if "ship2": the flying-saucer-style spaceship is placed in the scene above the ground 
		if (s.equals("ship2")) sm.ship2=true; 
		sm.main(); 
		}

	}
	boolean mapping=false; 
	boolean display=false; 
	boolean ship=false; 
	boolean ship2=false; 


	void main(){ 
		double[] antiquewhite= { 0.48, 0.42, 0.34}; 
		//name of shadow map that will be generated (to be used later) 
		String smap = "shadow.sm"; 
		//sheet which shadows are projected onto 
		double[] screen[] = { 
				{-200,0,200}, 
				{200,0,200}, 
				{200,0,0}, 
				{-200,0,0} 

		}; 
		//the light source is placed above the center of the sheet and facing directly downwards 
		double[] lightSource={ -10, 15, 80}; 
		double[] lightTarget={ 0,-10, 0}; 
		//the beginning of the actual scene construction 
		RiBegin(RI_NULL ); 
		RiDeclare("shadowname","uniform string"); 

		//a little ambient light so we can see what we are doing 
		RiLightSource("ambientlight", "intensity", 0.175,RI_NULL); 
		RiProjection("perspective" ,RI_NULL); 
		//the code that makes the shadow map (if "setup" is on)--! have tried to interpret each line, but am not completely sure 
		if (mapping) { 
			RiPixelSamples(1, 1 ); //sets the pixel density ofthe shadow map made 
			RiDeclare("jitter","uniform int"); //declares some variables that are necessary for the mapping 
			RiHider("hidden","jitter",0,RI_NULL); //The actual line that determines if a pixel is hidden behind another object
			RiShadingRate( 4); //determines how how often the shadow-map-shader is drawn (i.e. 1/4 pixels on the image are used to convert to a map) 
			RiDisplay("shadow.z","zfile","z", RI_NULL); //d1splays the shadow map that was made 
			RiFormat(860,860, 1 ); //defines the resolution of the shadow map displayed above 
		} 
		//displays the image ifthe display argument is on 
		if(display) { 
			RiDisplay("temple.tiff", "file", "rgba" ,RI_NULL);
			RiFormat(860,860,1);

		} 
		//ifthe shadow map is being made, this light source is used. It is light that passes through objects in the direction from the source to the target 
		if	(mapping) { 
			new ShadowAim().AimZ(lightTarget,lightSource ); 

		} 
		//after here objects are starting to be put in the world 
		RiWorldBegin(); 
		//ifthe shadow map isn't being made, this light source is used. It uses the shadow map to determine where shadows are, regardless of where objects are 
		if(!mapping){ 
		    double[] lightningColor = {0,.8,1};
		    RiLightSource("shadowdistant", "from", lightSource, "to", lightTarget, "intensity", 10, "shadowname", smap, "lightcolor", lightningColor, RI_NULL);

		    RiAttributeBegin();
		    RiSurface("grassTX", RI_NULL);
		    RiTranslate(100,-19,0);
		    new Scene().grass();
		    RiTranslate(-100,-1,52);
		    new Scene().grass();
		    RiAttributeEnd();
		} 
		
		new Scene().scene();

		RiWorldEnd(); 
		RiEnd(); 

	}  




}
