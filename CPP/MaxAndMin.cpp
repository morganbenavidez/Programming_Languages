// Practice for C++
/*
 Completely Written Array sorting from greatest to least.
 */

#include <iostream> // enables program to perform input and output
#include <algorithm>
using std::cout; //program uses cout
using std::cin; // program uses cin
using std::endl; // program uses endl
using namespace std;
// function main begins program execution

double highest(double,double,double,double,double);
double lowest(double,double,double,double,double);

int main() {
    
    
    double num1 = 0; // first integer to compare (initialized to 0)
    double num2 = 0; // second integer to compare (initialized to 0)
    double num3 = 0;
    double num4 = 0;
    double num5 = 0;
    double H = 0;
    double L = num1;
    
    
    cout << "Enter five integers to compare: "; // prompt user for data
    cin >> num1 >> num2 >> num3 >> num4 >> num5; // read five integers from user
    
    H = highest(num1, num2, num3, num4, num5);
    L = lowest(num1, num2, num3, num4, num5);
    
    cout << "Maximum = " << H << "\n" << "Minimum = " << L << endl;
   
}

double highest(double num1, double num2, double num3, double num4, double num5){
    
    double H = num1;
    
    if (num2 > H){
        H = num2;
    }if (num3 > H){
        H = num3;
    }if (num4 > H){
        H = num4;
    }if (num5 > H){
        H = num5;
    }
    return H;
    
}

double lowest(double num1, double num2, double num3, double num4, double num5){

    double L = num1;
    
    if (num2 < L){
        L = num2;
    }if (num3 < L){
        L = num3;
    }if (num4 < L){
        L = num4;
    }if (num5 < L){
        L = num5;
    }
    return L;
}
