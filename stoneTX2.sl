surface
stoneTX2 (float Ka = 1, Kd = 0.7, freq = 1;
 color stone = color "rgb" (.255,.215,0)) {
	
	color C;
	float freq = 2.5, i, n=0;
 

	for (float i=0;i<6;i+=1) {
	    n += abs(float noise(P*freq)-.2)*1.5/freq;
	    freq*=1.8;
	    }	    
	C = n * stone + (0.65,0.65,0);

    vector R = normalize(reflect(I,faceforward(normalize(N),I)));
    color Cr = trace(P,R);

	Ci = Oi * C * (Ka * ambient() + Kd*specular(faceforward(normalize(N),I), -normalize(I), 0.05) +0.1*Cr);
	

}