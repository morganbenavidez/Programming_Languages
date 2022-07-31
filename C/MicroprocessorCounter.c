//***********************************************************************
//***********************************************************************
//******** CDA3331 Intro to Micro class, updated on November 17, 2020
//******** Dr. Bassem Alhalabi, FAU EE512, Boca Raton, Florida
//******** Contributors: Pablo Pastran 2015, David Wilson 2019
//******** Skeleton Program for Lab 5, in C
//******** Run this program as is to show you have correct hardware connections
//******** Explore the program and see the effect of Switches on pins P2. 5/4/3
//******** Lab5 Grade --> Make the appropriate changes to build the desired effects of input switches
// SW-321 = 000: Counter resets to 00
// SW-321 = 001: Right digit cycles 0-9
// SW-321 = 010: Left digit cycles 0-9
// SW-321 = 011: Right and left digits both hold values (preset value),for now they have a segment rotating pattern
// SW-321 = 101: See lab manual for required actions
// SW-321 = 110: See lab manual for required actions
// SW-321 = 100: See lab manual for required actions
// SW-321 = 111: See lab manual for required actions


#include <msp430.h> 

//Digit configuration, make sure segments h-a are connected to PORT1 pins 7-0
//also besides digits 0-9, you have single segments a/b/c/d/e/f/g/ for the rotating pattern
int LEDS[] = {0x3F,0x06,0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x67,0x01,0x02,0x04,0x08,0x10,0x20,0x40,0x80};

int switches=0;
int leftdigit=0,  rightdigit=0;
int pleftdigit=0, prightdigit=0;    //preset values
int flag=0;

int main(void)
{
    //Ports set up, simple and direct
    P1DIR = 0xff;                   // port 1 all output
    P2DIR = 0x03;                   // port 2 all inputs, except BIT0 and BIT1

    //Sub Master clock dividers: DIVS_0 (/1 for 1000 Hz), DIVS_1 (/2 for 500 Hz), DIVS_2 (/4 for 250 Hz), DIVS_3 (/8 for 125 Hz)
    //DIVS_0 means divide by 1, so the SMCLK = MCLK/1, that 1M Hz or 1 millisecond for period
    //You can change DIVS_0 to DIVS_2 to divide the frequency by 4, and see how the digits will start flickering
    BCSCTL2 |= DIVS_0;

    // WDT set up, normally we turn it off, but here we using it to generate a constant interrupt to display multiplexing
    // we chose to generate an interrupt interval every 8*1000 pulses from the SMCLK; other values: WDT_MDLY_32, WDT_MDLY_0_5, etc.
    // so the interrupt frequency is 1,000,000 Hz/(8,000+8,000) = 62.5 Hz, meaning the display is refreshed about 62 times every second
    // if you divide the SMCLK frequency by 4, as suggested above, the digit display multiplexing will drop to 15, which will make flickering easy to see
    WDTCTL = WDT_MDLY_8;

    IE1 |= WDTIE;                   // WDT Interrupt Enable
    __enable_interrupt();           // enable general interrupt

for (;;)
{
    // read the switches status for the port 2, and then look at the various combinations of switches mounted on bits 5/4/3
    //switches =  P2IN; //if wired as active low
    switches = ~P2IN; //if wired as active high

    // SW-321 = 000: left and right digits reset to 00
    if (((switches & BIT5) != BIT5) && ((switches & BIT4) != BIT4) && ((switches & BIT3) != BIT3))
    {leftdigit=0; rightdigit=0; }

    // SW-321 = 001: right digit counts up
    if (((switches & BIT5) != BIT5) && ((switches & BIT4) != BIT4) && ((switches & BIT3) == BIT3))
    {rightdigit++; if (rightdigit >=10) {rightdigit=0;} }

    // SW-321 = 010: left digit counts up
    if (((switches & BIT5) != BIT5) && ((switches & BIT4) == BIT4) && ((switches & BIT3) != BIT3))
    {leftdigit++ ; if (leftdigit >=10) {leftdigit=0;} }

    // SW-321 = 011: right and left digits both hold values (preset value)
    if (((switches & BIT5) != BIT5) && ((switches & BIT4) == BIT4) && ((switches & BIT3) == BIT3))
    {pleftdigit=leftdigit; prightdigit=rightdigit; }

    // SW-321 = 101:
    if (((switches & BIT5) == BIT5) && ((switches & BIT4) != BIT4) && ((switches & BIT3) == BIT3))
    // *** modify this section according to the lab manual requirement
    // for now you have a rotating pattern, LasVegas style
    {

        leftdigit=pleftdigit; rightdigit=prightdigit;
        //if (rightdigit <=9) {rightdigit=10;}
        //if (leftdigit  <=9) {leftdigit =10;}

        //rightdigit++; if (rightdigit >=16) {rightdigit=10;}
        //leftdigit--;  if (leftdigit  ==9 ) {leftdigit =15;}
    }

    // SW-321 = 110:
    if (((switches & BIT5) == BIT5) && ((switches & BIT4) == BIT4) && ((switches & BIT3) != BIT3))
    // *** modify this section according to the lab manual requirement
    { leftdigit=pleftdigit; rightdigit=prightdigit;}

    // SW-321 = 100:
    if (((switches & BIT5) == BIT5) && ((switches & BIT4) != BIT4)&& ((switches & BIT3) != BIT3)){
    // *** modify this section according to the lab manual requirement

        if (leftdigit >=10) {leftdigit=pleftdigit;}
        rightdigit++; if (rightdigit >=10) {rightdigit=0;}
        if (rightdigit==0) {leftdigit++;}
        __delay_cycles (500000);
        if (leftdigit ==9) {leftdigit=pleftdigit; rightdigit=prightdigit;}

    }

    // SW-321 = 111:
    if (((switches & BIT5) == BIT5) && ((switches & BIT4) == BIT4)&& ((switches & BIT3) == BIT3))
    // *** modify this section according to the lab manual requirement
    {
        //rightdigit--; if (rightdigit == 0) {rightdigit=9; leftdigit--;}
        //if ((leftdigit == 1) && (rightdigit == 0)) {leftdigit=pleftdigit; rightdigit=prightdigit;}


        rightdigit--; if(rightdigit<0) {rightdigit=9; leftdigit--;}
        //if (rightdigit<=0) {leftdigit--;}

        //if ((rightdigit<=0) && (leftdigit<1)){leftdigit=pleftdigit; rightdigit=prightdigit;}
        if (leftdigit<1) {leftdigit=pleftdigit; rightdigit=prightdigit;}

        //if ((rightdigit<=0) && (leftdigit==1)){leftdigit=pleftdigit; rightdigit=prightdigit;}
        //if ((rightdigit<0) && (leftdigit!=1)){rightdigit=9; leftdigit--;}


        //rightdigit--; if ((rightdigit==0) && (leftdigit==1)){leftdigit=pleftdigit; rightdigit=prightdigit;}
        //if (rightdigit==9){leftdigit--;}
        //leftdigit--;  //if (leftdigit  ==9 ) {leftdigit =15;}

        //leftdigit=pleftdigit;
    }

    // this delay determines the speed of changing the numbers being displayed
    // 500,000 microseconds for half a second, you can change it to 100,000 for example to make the numbers change 10 times faster
    // remember, this is the delay of the man loop, and it has no effect on the interrupt frequency
    __delay_cycles (500000);

} // end of for loop
} // end of main


// WDT interrupt service routine
#pragma vector=WDT_VECTOR
__interrupt void WDT(void)
{
    //This executes every time there is an interrupt from WDT
    //The frequency of this interrupt is about 62.5 Hz which is enough to eliminate the flickering of display
    //The right and left digits are displayed alternatively
    //Note that both digits must be turned off to avoid aliasing

    //Display code for Common-Cathode display
    P1OUT= 0; P2OUT=0;
    __delay_cycles (100);
    if (flag == 0) {P2OUT= BIT0; P1OUT= LEDS[leftdigit];  flag=1;}  // display left  digit and change flag to 1
    else           {P2OUT= BIT1; P1OUT= LEDS[rightdigit]; flag=0;}  // display right digit and change flag to 0
    __delay_cycles (100);

/*
    //Display code for Common-Anode display
    P1OUT= 0xFF; P2OUT=0xFF;
    __delay_cycles (100);
    if (flag == 0) {P2OUT &= ~BIT0; P1OUT= ~LEDS[leftdigit];  flag=1;}
    else           {P2OUT &= ~BIT1; P1OUT= ~LEDS[rightdigit]; flag=0;}
    __delay_cycles (100);
*/

}
