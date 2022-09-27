public class NBody{
    public static double readRadius(String urlName){
        In in = new In(urlName);
        in.readDouble();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String urlName){
        In in = new In(urlName);
        int N = in.readInt();
        in.readDouble();
        Planet[] pArray = new Planet[N];
        for (int i=0; i<N; i+=1) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planet p = new Planet(xP,yP,xV,yV,m,img);
            pArray[i] = p;
        }
        return pArray;
    }
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double r = readRadius(filename);
        Planet[] pArray = readPlanets(filename);
        int N = pArray.length;
        final String imageToDraw = "images/starfield.jpg";

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-r, r);
		StdDraw.picture(0, 0, imageToDraw);
        for (Planet planet : pArray) {
            planet.draw();
        }
        StdDraw.show();
        StdDraw.pause(100);
        double t = 0.0;

        while(t<=T){
            Double[] xForces=new Double[N];
            Double[] yForces=new Double[N];
            for(int i=0; i<N; i+=1) {
                xForces[i]=pArray[i].calcNetForceExertedByX(pArray);
                yForces[i]=pArray[i].calcNetForceExertedByY(pArray);
            }

		    StdDraw.clear();
		    StdDraw.picture(0, 0, imageToDraw);
            for(int i=0; i<N; i+=1){
                pArray[i].update(dt, xForces[i], yForces[i]);
                pArray[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt; 
        
        }	
       
    }
}
