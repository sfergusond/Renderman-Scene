surface
skyTX (float Ka = 1.4) {
      color C, c1 = color "rgb" (0.098039 , 0.098039 , 0.439216),
      	    c2 = color "rgb" (1.000000 , 0.270588 , 0.000000),
	    c3 = color "rgb" (0.815686 , 0.125490 , 0.564706 ), C1,C2;

      if (t < 0)      {
      float step = smoothstep(-.7,0.2,t);
      C = mix(c2,c3,step); }
      else {
      float step2 = smoothstep(.2,.8,t);
      C = mix(c3,c1,step2);}
      
      float i, n =0, freq = 1;
      
      for (float i=0;i<7;i+=2) {
      	  n += noise(P*freq)-.2/(2*freq);
	  freq *= 2;
	  }
      C = (n+0.8) * C;	  
          
      C = C * noise(0.25,t) + (0.2,0.2,0.2);

      Ci = Oi * C * (Ka * ambient());
}