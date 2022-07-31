#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
    
    char x;
    double num1, num2;
    bool n = true;

    
while (n)
    {

        cout << "Enter #1= ";
        cin >> num1;
        
        cout << "Enter #2= ";
        cin >> num2;
        
        cout << "Enter an Operator (+, -, *, /) or & to quit= ";
        cin >> x;

    switch(x)
    {
        case '+':
            cout << "The addition is = " << num1 + num2 << endl;
            break;
        case '-':
            cout << "The subtraction is = " << num1 - num2 << endl;
            break;
        case '*':
            cout << "The product is = " << num1 * num2 << endl;
            break;
        case '/':
            cout << "The Division is = " << num1/num2 << endl;
            break;
        case '&':
            cout << "Thanks for using the App!" << endl;
            n = false;
            break;
        default:
            cout << "You entered the wrong operator!!!" << endl;
            break;
    };
    system("pause");
    return 0;
    }
};

