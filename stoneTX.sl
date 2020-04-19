surface
stoneTX (float Ka = 1, Kd = 0.02, freq = 1;) {


	
	color C, stone = color "rgb" (.255,.215,0);
//0.960784 , 0.960784 , 0.862745);
//0.439216 , 0.501961 , 0.564706);
	float freq = 2.5, i, n=0;
 

	for (float i=0;i<6;i+=1) {
	    n += abs(float noise(P*freq)-.2)*1.5/freq;
	    freq*=1.8;
	    }	    
	C = n * stone + (0.65,0.65,0);

	
/*	color C, stone = color "rgb" (0.960784 , 0.960784 , 0.862745);
//0.439216 , 0.501961 , 0.564706);
	float freq = 2.5, i, n=0;

	for (float i=0;i<6;i+=1) {
	    n += abs(float noise(t*freq,s*freq)-.2)*1.5/freq;
	    freq*=1.3;
	    }	    
	C = n * stone * (0.65,0.65,0.65); */

//	float n2 = noise(40*t);
//	C = n2*C;

	Ci = Oi * C * (Ka * ambient() + Kd*diffuse(faceforward(normalize(N),I)));
	

}