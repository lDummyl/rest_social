package com.example.demo.Selection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculations {

    public static double getPresLose(double flow, double kvs) {
        //flow m3/h and kvs m3/h, preslose in meters
        double presLose = Math.pow((flow / kvs), 2); // in MPa
        return presLose * 10; //in m
    }

    private static double solutionOfquadraticEquation(double[] q){
        
        double x;
        double discr = Math.pow(q[1], 2) - 4 * q[0] * q[2];
        x = ( -q[1] - Math.pow(discr, 0.5)) / (2 * q[0]);
        return x;
        
    }
    public static boolean isPumpFits(double flow, double preslose, String speedFunction) {
        //flow m3/h and kvs m3/h, preslose in meters
        Pattern p = Pattern.compile("y =(.*)x2(.*)x(.*)");
        Matcher m = p.matcher(speedFunction);
        boolean isPumpFits = false;
        if (m.find()) {
            double[] q = new double[3];
            for(int i = 1; i<4;i++){
                String s = m.group(i).replaceAll("\\s","");
                q [i-1] = Double.parseDouble(s);
            }
            double pumpHead = solutionOfquadraticEquation(q);
            isPumpFits = (pumpHead - preslose > 0.)? true : false;
        }
        return isPumpFits;
    }
}

