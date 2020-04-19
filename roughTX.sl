displacement
roughTX (float freq = 1.3) {


	point newP = transform("shader", P);
	vector newV = transform("shader", N);
	
	float amp = noise(t*freq,s*freq);
	newP += amp * normalize(newV)*0.3;
	N = calculatenormal(newP); 

}