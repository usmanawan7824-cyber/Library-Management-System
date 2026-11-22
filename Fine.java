package model;
public class Fine {
 private double amount,ratePerDay; private int lateDays;
 public Fine(double rate){ratePerDay=rate;amount=0;lateDays=0;}
 public double calculateFine(int days){lateDays=days;double converted=(double)days;amount=converted*ratePerDay;return amount;}
 public double getAmount(){return amount;} public void setAmount(double v){amount=v;}
 public int getLateDays(){return lateDays;} public void setLateDays(int v){lateDays=v;}
 public double getRatePerDay(){return ratePerDay;} public void setRatePerDay(double v){ratePerDay=v;}
}
