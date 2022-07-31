import javax.swing.JOptionPane;
public class testGiftCards
//Morgan Benavidez
{
    public static void main(String[] args)
    {
        GiftCards gc = new GiftCards("", 0.0);
        
        //display opening message
        String message = "welcome";
        JOptionPane.showMessageDialog(null, "Message: " + message, "Message", JOptionPane.PLAIN_MESSAGE);
        
        // set the gift card holder's name
        String str =
        JOptionPane.showInputDialog(null, "gift card holder's name: ");
        gc.setHolder(str);
        
        //obtain the gift card number
        str = JOptionPane.showInputDialog(null, "gift card number: ");
        gc.cardNum = Integer.parseInt(str);
        
        //set the gift card amount
        str =JOptionPane.showInputDialog(null, "gift card amount: ");
        gc.setBalance(Double.parseDouble(str));
        
        //issue the gift card
        gc.IssueGiftCards();
        
        //use the gift card
        //double useCard = 0;
        str = JOptionPane.showInputDialog(null, "deduct amount from card: ");
        gc.setDeduction(Double.parseDouble(str));
        gc.useCard();
        gc.printCurrentGiftCardInfo();
        //System.out.println(" New Balance . . . $" + gc.getBalance());
        //str = JOptionPane.showInputDialog(null, "what year is it? ");
        //verify amount to deduct will not yield negative balance
        
        //print current card balance
        //gc.printCurrentGiftCardInfo();
    }
}