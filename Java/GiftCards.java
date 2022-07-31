import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//Morgan Benavidez the Head Programmer In Charge

public class GiftCards

{
    static NumberFormat nf = NumberFormat.getCurrencyInstance();
    Date myDate = new Date();
    String myDateFormat = "MM/DD/YYYY";
    SimpleDateFormat dtToday = new SimpleDateFormat(myDateFormat);
    
    Calendar calendar = Calendar.getInstance();
    
    
    //define the class data members
    public boolean expires;
    private double balance;
    public double deduction;
    public int cardNum;
    private char cardType;
    public String issueDate;
    private String holder;
    public Object c;
    //private Object cal;
    
    //define the member methods;
    //default constructor;
    public GiftCards() {}
    //overloaded contructor
    public GiftCards(String n, double amt)
    {
        holder = n;
        balance = amt;
    }
    public void IssueGiftCards()
    {
        System.out.println("");
        System.out.println(" Card Issued");
        System.out.println(" Today's Date is: " + dtToday.format(myDate));
        System.out.println(" Card Number is: " + cardNum);
        System.out.println(" Card Holder . . . " + holder);
        System.out.println(" Card Amount . . . $" + String.format("%.2f", balance));
        System.out.println(" Expires . . . " +  (calendar.get(Calendar.YEAR)) + 3);
    }
    public double getBalance()
    {
        useCard();
        return balance;
    }
    public double getDeduction()
    {
        return deduction;
    }
    public void useCard()
    {
 
        if (deduction <= balance)
        {
            balance -= deduction;
        }
        else 
        {
            System.out.println("Insufficient Funds.");
        }
    }
    
    public void cal()
    {
        Calendar c = Calendar.getInstance();
        c.get(Calendar.YEAR);
        c.set(Calendar.YEAR, (Calendar.YEAR + 3));
        //cal.add(Calendar.YEAR, 3);
    }
    
    public Object getCal()
    {
        
        return c;
    }
    
    public void setDeduction(double d)
    {
        deduction = d;
    }
    public void setBalance(double b)
    {
        balance = b;
    }
    /*(public boolean getExpiration()
    {
        if()
    }*/
    public String getHolder()
    {
        return holder;
    }
    public void setHolder(String h)
    {
        holder = h;
    }
    public void printCurrentGiftCardInfo()
    {
        System.out.println("");
        System.out.println(" Card Balance");
        System.out.println(" Today's Date is: " + dtToday.format(myDate));
        System.out.println(" Amount Deducted . . . $" + String.format("%.2f", deduction));
        System.out.println(" Card Balance . . . $" + String.format("%.2f", balance));
    }
}