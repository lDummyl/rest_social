package com.example.demo.Selection;

import com.example.demo.commercial.OfferedEquipment.MixUnitTS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculations {

    public static double getPresLose(double flow, double kvs) {
        //flow m3/h and kvs m3/h, preslose in meters
        double presLose = Math.pow((flow / kvs), 2); // in MPa
        return presLose * 10; //in m
    }

    private static double getX(double[] q, double y){
        double x1,x2,x = -1;
        double discr = Math.pow(q[1], 2) - 4 * q[0] * (q[2]-y);
        if (discr<0) { return x = calculationUsingTheDerivative(q);}
        x1 = ( -q[1] - Math.pow(discr, 0.5)) / (2 * q[0]);
        x2 = ( -q[1] + Math.pow(discr, 0.5)) / (2 * q[0]);
        if (x1 < 0 && x2 >= 0) x = x2;
        if (x2 < 0 && x1 >= 0) x = x1;
        if (x2 < 0 && x1 < 0) x = -1;
        if (x2 >= 0 && x1 >= 0)x = Math.min(x1,x2);
        return x;
    }

    private static double calculationUsingTheDerivative(double[] q) {
        // square function derivative: y = 2ax+b; tangent function y = kx+b
        // lets take a middle point on parabola between x=0 and x - in bottom point.
        // from this point build tangent to intersection with X-axis.
        // x value at this point will be limit of work range of pump.
        double limitX = -1;
        if (q[0]>0){
        //is rising parabola
        double x = -q[1]/(2*q[0]);//in bottom point
        double y,k,b;
            x = x/2;
            k = 2*q[0]*x + q[1];
            y = getY(q,x);
            b = y - k*x;
            limitX = (0-b)/k;
        }
        System.out.println("limitX = " + limitX);
        return limitX;
    }

    private static double getY(double[] q, double x){
        double y = q[0] * Math.pow(x, 2) + q[1]*x + q[2];
        return y;
    }

    private static boolean isInWorkRange(double[] q, double flow){
        double flowLimitations;
        boolean isRisingFunction = (q[0] > 0);
        if (isRisingFunction) {
            flowLimitations = getX(q, q[2]);
        }else{
            flowLimitations = getX(q,0.);
        }
        if (flowLimitations < 0) System.out.println("Flow limit is negative!!");

        return flow < flowLimitations && flowLimitations > 0;
    }
    public static boolean isPumpFits(double flow, double preslose, MixUnitTS unit) {
        //flow m3/h and kvs m3/h, preslose in meters
        Pattern p = Pattern.compile("y =(.*)x2(.*)x(.*)");
        Matcher m = p.matcher(unit.getSpeed_3());
        boolean isPumpFits = false;
        if (m.find()) {
            double[] q = new double[3];
            for(int i = 1; i<4;i++){
                String s = m.group(i).replaceAll("\\s","");
                q [i-1] = Double.parseDouble(s);
            }
            double pumpHead = getY(q,flow);
            boolean inWorkRange = isInWorkRange(q,flow);
            isPumpFits = (pumpHead - preslose) > 0. && inWorkRange;
        }
        return isPumpFits;
    }
}