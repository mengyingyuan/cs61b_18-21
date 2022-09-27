import java.lang.Math;

public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
                this.xxPos = xP;
                this.yyPos = yP;
                this.xxVel = xV;
                this.yyVel = yV;
                this.mass = m;
                this.imgFileName = img;
              }

    public Planet(Planet p){
                this.xxPos = p.xxPos;
                this.yyPos = p.yyPos;
                this.xxVel = p.xxVel;
                this.yyVel = p.yyVel;
                this.mass = p.mass;
                this.imgFileName = p.imgFileName;
    } 
    
    // recommend simply multiplying a symbol by itself instead of using Math.pow, which will result in slower code.
    public double calcDistance(Planet p){
        return Math.sqrt((this.xxPos - p.xxPos)*(this.xxPos - p.xxPos) + (this.yyPos - p.yyPos)*(this.yyPos - p.yyPos)) ;
    }

    //returns a double describing the force exerted on this planet by the given planet.
    public double calcForceExertedBy(Planet p){
         final double gravG = 6.67e-11;
         double r = calcDistance(p);
         return gravG*p.mass*this.mass/(r*r);
    }

    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p)*(p.xxPos - this.xxPos)/calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p)*(p.yyPos - this.yyPos)/calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] pArray){
        double total = 0;
        for(Planet p: pArray){
            if ( this.equals(p)){
                continue;
            }
            total += calcForceExertedByX(p);
        }
        return total;
    }
    public double calcNetForceExertedByY(Planet[] pArray){
        double total = 0;
        for(Planet p: pArray){
            if ( this.equals(p)){
                continue;
            }
            total += calcForceExertedByY(p);
        }
        return total;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX/this.mass;
        double ay = fY/this.mass;
        this.xxVel += dt * ax ; 
        this.yyVel += dt * ay ; 
        this.xxPos += dt*this.xxVel;
        this.yyPos += dt*this.yyVel;
    }

    public void draw(){
        String imgName = "images/";
        imgName = imgName.concat(this.imgFileName);
        StdDraw.picture(this.xxPos, this.yyPos, imgName);
        StdDraw.show();
    }
}