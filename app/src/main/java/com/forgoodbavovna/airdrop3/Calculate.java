package com.forgoodbavovna.airdrop3;

public class Calculate {
    int v0 = 0;
    double r = 0.01;
    double S1 = Math.PI*r*r;
    double C_y = 0.8;
    double C_x = 0.8;
    double p = 1.2041;
    double g = 9.8;

    double F_resist(double speed_of_vind, int h, double m, double S2){
        return C_y*p*(speed_of_vind*speed_of_vind)*S2;
    }

    public double calculate_drift(double speed_of_vind, int h, double m, double S2){
        double a_x = F_resist(speed_of_vind,h,m,S2)/m;
        double a_y_sum = 0;
        double a_y = 0;

        for(int i = 5;i < h;i += 5){
            a_y = m*g/(m + C_x*p*2*i*S1);
            a_y_sum += a_y;
        }
        a_y = a_y_sum/((h - 5)/5);
        int count = 1;
        double v_x = 0;
        double t = Math.sqrt(2*h/a_y);
        for(int i = 1;i < Math.round(t + 1);i++){
            v_x += a_x*i;
            count += 1;
        }
        double drift = t*v_x/count;
        return drift;
    }
    public double calculate_time(double speed_of_vind, int h, double m, double S2){
        double a_y_sum = 0;
        double a_y = 0;

        for(int i = 5;i < h;i += 5){
            a_y = m *g/(m + C_x *p*2*i*S1);
            a_y_sum += a_y;
        }
        a_y = a_y_sum/((h - 5)/5);
        double t = Math.sqrt(2*h/a_y);
        return t;
    }
    public String check_on_dot(String str){
        if(str.contains(",")){
            String[] splitString = str.split(",");
            str = (splitString[0] + '.' + splitString[1]);
        }
        return str;
    }
    public boolean double_dot(String str){
        double count = 0;
        boolean check = true;
        String[] splitString = str.split("");
        for(int i = 0;i < splitString.length;i++){
            if(splitString[i].contains(",") || splitString[i].contains(".")){
                count += 1;
            }
        }
        if(count > 1){
            check = false;
        }
        return check;
    }
    public boolean check_on_letters(String str){
        boolean check = true;
        String[] splitString = str.split("");
        for(int i = 0;i < splitString.length;i++){
            if(!splitString[i].contains("0") && !splitString[i].contains("1") && !splitString[i].contains("2") && !splitString[i].contains("3") && !splitString[i].contains("4") && !splitString[i].contains("5") && !splitString[i].contains("6") && !splitString[i].contains("7") &&!splitString[i].contains("8") &&!splitString[i].contains("9") &&!splitString[i].contains(".") &&!splitString[i].contains(",")){
                check = false;
                break;
            }
        }
        return check;
    }

}
