package source.classes.math;

import source.classes.base_classes.Object;

public class Vectors extends Object {
    public static class Vector2D {
        private double x;
        private double y;
        
        public Vector2D(double x, double y){
            this.x = x;
            this.y = y;
        }

        public double getX(){
            return x;
        }

        public double getY(){
            return y;
        }

        public void setX(double x){
            this.x = x;
        }

        public void setY(double y){
            this.y = y;
        }
    }

    public static class Vector3D {
        private double x;
        private double y;
        private double z;

        public Vector3D(double x, double y, double z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double getX(){
            return x;
        }

        public double getY(){
            return y;
        }

        public double getZ(){
            return z;
        }

        public void setX(double x){
            this.x = x;
        }

        public void setY(double y){
            this.y = y;
        }

        public void setZ(double z){
            this.z = z;
        }
    }

    
}
