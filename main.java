
import java.util.*;

public class main {
  
  static Scanner input = new Scanner(System.in);

  static String inputValidDay() {
    String day = input.next();
    while(!(day.length()==3 && ("mon%tue%wed%thu%fri%sat%sun".contains(day.toLowerCase())))){
      System.out.println("Invalid day! Enter today's day? (Mon, Tue, Wed, Thu, Fri, Sat, Sun)");
      day = input.next();
    } return day;
  }

  static int[] inputValidTime() {
    String time = input.next();
    while(true){
      try{
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        if((time.length()>5) || (time.charAt(2)!=':') || (hour < 0 || hour > 23) || (min < 0 || min > 59) ) throw new Exception();
        return new int[]{hour, min};
      }
      catch(Exception e){
        System.out.println("Invalid time! What time is it? (hh:mm)");
        time = input.next();
      }
    }
  }

  static int inputValidParking() {
    String parkingSign = input.next();
    while(true){
      try{
        int num = Integer.parseInt(parkingSign.substring(0));
        if((parkingSign.length()>2) || (num < 0 || num > 8)) throw new Exception();
        return num;
      }
      catch(Exception e){
        System.out.println("Invalid Parking Sign! Pick between (1-8)");
        parkingSign = input.next();
      }
    }
  }


  static void ParkingSign0(String day, int hour, int mins) {
    if (day.equals("Fri") && hour >= 10 && hour <= 11) System.out.println("No parking");
    else {
      int h1 = 10 - hour;
      int h2 = 23 - hour;
      int min = 59 - mins;
      if (day.equals("Fri") && hour < 10) System.out.println("Free parking up to: " + h1 + "hour(s) " + min + "mins");
      else System.out.println("Free parking up to: " + h2 + "hour(s) " + min + "mins");
    }
  }

  static void ParkingSign1(String day, int hour, int mins) {
    if (!day.equalsIgnoreCase("thu")) System.out.println("Free parking all day!");
    else {
      if(hour<2) System.out.println("Free parking up to: " + (1-hour) + "hour(s) " + (60-mins) + "min(s)");
      else if (hour <= 6) System.out.println("No parking");
      else System.out.println("Free parking for the rest of the day!");
    }
  }

  static void ParkingSign2(String day, int hour, int mins) {
    if (!"mon%wed%fri%sun".contains(day)) System.out.println("Free parking all day!");
    else {
      if(hour<2) System.out.println("Free parking up to: " + (1-hour) + "hour(s) " + (60-mins) + "min(s)");
      else if (hour <= 5) System.out.println("No parking");
      else System.out.println("Free parking for the rest of the day!");
    }
  }

  static void ParkingSign3(String day, int hour, int mins) {
    boolean parkAtSign1=true;
    boolean parkAtSign2=true;
    if (!(6<hour && hour<22)) parkAtSign1=false;
    if (day.equals("sun")) parkAtSign2=true;
    else if (8<=hour && hour<=18) parkAtSign2=false;
    if(true== (parkAtSign1==parkAtSign2)) System.out.println("No parking");
    else System.out.println("You can park here! Dont for forget to");
  }

  static void ParkingSign4(String day, int hour, int mins) {
    boolean parkAtSign1=true;
    boolean parkAtSign2=true;
    if (!(6<hour && hour<22)) parkAtSign1=false;
    if (day.equals("sun")) parkAtSign2=true;
    else if (8<=hour && hour<=18) parkAtSign2=false;
    if(true== (parkAtSign1==parkAtSign2)) System.out.println("No parking");
    else System.out.println("You can park here! Dont for forget to");
  }



  public static void main(String[] args) {

    System.out.println("Enter today's day? (Mon, Tue, Wed, Thu, Fri, Sat, Sun)");
    String day = inputValidDay();
    
    System.out.println("What time is it? (hh:mm)");
    int[] time = inputValidTime();
    int hour = time[0];
    int min = time[1];

    System.out.println("Where would you like to park? Parking Sign (0-8)");
    int parkingSignNum= inputValidParking();
    if (parkingSignNum == 0) ParkingSign0(day, hour, min);
    else if (parkingSignNum == 1) ParkingSign1(day, hour, min);
    else if (parkingSignNum == 2) ParkingSign2(day, hour, min);
    else if (parkingSignNum == 3) ParkingSign3(day, hour, min);
    else if (parkingSignNum == 4) ParkingSign0(day, hour, min);
    else if (parkingSignNum == 5) ParkingSign0(day, hour, min);
    else if (parkingSignNum == 6) ParkingSign0(day, hour, min);
    else if (parkingSignNum == 7) ParkingSign0(day, hour, min);
    else if (parkingSignNum == 8) ParkingSign0(day, hour, min);

  } 
}