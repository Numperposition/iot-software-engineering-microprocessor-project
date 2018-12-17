/**
 * Title      : Film.java
 * Description: This class contains the definition of Film. 
 * Copyright  : Copyright (c) 2905-2017 All rights reserved
 * @author      Group 78
 * @version     1.8
 */
public class Film {
   private String filmName;
   private int totalAdultTicketNum = 0;
   private int totalChildTicketNum = 0;
   private int totalSeniorTicketNum = 0;
   private int totalStudTicketNum = 0;
   private double filmPrice = 0.0;
   private final double childDiscount = 0.5;
   private final double seniorDiscount = 0.8;
   private final double studDiscount = 0.85;
    /**This method is to get getFilmPrice
     * @return double
     */
   public double getFilmPrice()
   {
	   return filmPrice;
   }
    /**
     * This method is to set TotalStudTicketNum
     * @param n the number of student ticket number
     */
   public void setTotalStudTicketNum(int n)
   {
   	   totalStudTicketNum = n;
   }
    /**This method is to set TotalSeniorTicketNum
     * @param n the number of senior ticket number
     */
    public void setTotalSeniorTicketNum(int n)
    {
    	totalSeniorTicketNum = n;
    }
    /**This method is to set TotalAdultTicketNum
     * @param n the number of adult ticket number
     */
    public void setTotalAdultTicketNum(int n)
    {
    	totalAdultTicketNum = n;
    }
    /**This method is to set TotalChildTicketNum
     * @param n the number of child ticket number
     */
    public void setTotalChildTicketNum(int n)
    {
    	totalChildTicketNum = n;
    }
    /**This method is to set FilmPrice
     * @param price the price of film
     */
   public void setFilmPrice(double price)
   {
	   filmPrice = price;
   }
    /**This method is to set Filmname
     * @param name the name of film
     */
    public void setFilmName(String name)
    {
    	filmName = name;
    }
    /**This method is to get FilmName
     * @return String 
     */
    public String getFilmName()
    {
    	return filmName;
    }
    /**This method is to get TotalAdultTicketNum
     * @return int
     */
    public int getTotalAdultTicketNum()
    {
    	return totalAdultTicketNum;
    }
    /**This method is to get TotalChildTicketNum
     * @return int
     */
    public int getTotalChildTicketNum()
    {
    	return totalChildTicketNum;
    }
    /**This method is to get TotalSeniorTicketNum
     * @return int
     */
    public int getTotalSeniorTicketNum()
    {
    	return totalSeniorTicketNum;
    }
    /**This method is to get TotalStudTicketNum
     * @return int
     */
    public int getTotalStudTicketNum()
    {
    	return totalStudTicketNum;
    }
    /**This method is to get TotalTicketNum
     * @return int
     */
    public int getTotalTicketNum()
    {
    	return totalAdultTicketNum + totalChildTicketNum + totalSeniorTicketNum + totalStudTicketNum;
    }
    /**This method is to get totalAdultPrice
     * @return double
     */
    
    public double totalAdultPrice()
    {
    	return totalAdultTicketNum * filmPrice;
    }
    /**This method is to get totalChildPrice
     * @return double
     */
    public double totalChildPrice()
    {
    	return totalChildTicketNum * childDiscount * filmPrice;
    }
    /**This method is to get totalSeniorPrice
     * @return double
     */
    public double totalSeniorPrice()
    {
    	return totalSeniorTicketNum * seniorDiscount * filmPrice;
    }
    /**This method is to get total Student Price
     * @return double
     */
    public double totalStudPrice()
    {
    	return totalStudTicketNum * studDiscount * filmPrice;
    }
    /**This method is to calculate and return total price of a film
     * @return double
     */
    public double totalPrice()
    {
    	return totalAdultPrice() + totalChildPrice() + totalSeniorPrice() + totalStudPrice();
    }
}
