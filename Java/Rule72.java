
package rule72;

public class Rule72 {

    public static void main(String[] args) {
    
        double rate =1;
        double years = 0;
        double ruleValue = 72;
        
//heading        
        System.out.println("Rate \t     Rule Amt \t    Actual Years");
//loop 10x for chart outcome;
        
        for(int i =1; i<=100; i++)
        {
            System.out.printf("%d \t %d \t %.2f %n ", i , ruleValue, years);
            rate = rate + 1.0;
            ruleValue = 72/ (rate;
            years = 72/rate;
        }
        
    }//end main
    
}//end class
