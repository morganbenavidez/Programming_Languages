//***********************************************************************
//******** CDA3331 Intro to Micro class, updated on April 3, 2018
//******** Dr. Bassem Alhalabi, FAU EE512, Boca Raton, Florida
//******** Contributors: Pablo Pastran 2015,
//******** Skeleton Program for Lab 4, in C
//******** This program is a transition form assembly to C, so you see in
//the comments the equivalent code in assembly
//******** Run this program as is to make sure you have correct hardware
//connections
//******** Explore the program and see the effect of Switches on pins P2.3-5
//******** Lab4 Grade --> Make the appropriate changes to the program per lab manual

#include <msp430.h>
int main(void)
{
WDTCTL = WDTPW | WDTHOLD;    //Stop watch dog timer
int R5_SW=0, R6_LED=0;
P1OUT = 0b00000000;     //mov.b    #00000000b,&P1OUT
P1DIR = 0b11111111;     //mov.b    #11111111b,&P1DIR
P2DIR = 0b00000000;     //mov.b    #00000000b,&P2DIR
P2REN = 0xFF;           //enable all resistors on port 2
P2OUT = 0xFF;           //make them all of them pull ups
while (1)
{
//read the states of the switches
R5_SW = P2IN;       //mov.b    &P2IN, R5
//checking P2.0 for read mode
if (R5_SW & BIT0)
{
R6_LED = R5_SW & (BIT3 | BIT4 | BIT5);  // mask the pattern bits
P1OUT = R6_LED;                         // display the pattern
}
//else, it is the rotate and display mode
else
{
    if(R5_SW & BIT1){

        // ROTATE RIGHT
        R6_LED = (R6_LED >> 7 | R6_LED << 1);


    }
    else {

        // ROTATE LEFT

        R6_LED = (R6_LED << 7 | R6_LED >> 1);

    }
    if(R5_SW & BIT2){

        // SLOW DOWN
        __delay_cycles(200000);             //delay 50,000 micro seconds

    }
    else {

        // SPEED UP
        __delay_cycles(50000);             //delay 50,000 micro seconds

    }

    //R6_LED ^= 0xFF;     //toggle pattern
    R6_LED &= 0xFF;     //mask any excessive bits
    P1OUT = R6_LED;     //pattern out - display it

//The following code (3 lines) only toggles the pattern of the 8 LEDs
//This is to show you got all your switches and LEDs working properly
//Modify the code so that the last pattern (3 bits) read during the
//reading mode is now rotating on the 8 LEDs left to right base on P2.1

}
//replace the simple delay line below with slow/fast delay based on P2.2

//__delay_cycles( 400000);    //fast


} //end while
}// end main
//Annotations
