#include "GeoCalc.hpp"
#include <iostream>
using namespace std;

int main(){

double length;
double width;
double height;
double base;
double base1;
double base2;
GeoCalc A;

    
    cout << "Geometric Calculations" << endl;
    
    cout << "======================" << endl;
    
    
    
    cout << "\nCalculating Rectangle Area" << endl;
    
    cout << "======================" << endl;
    
    
    
    cout << "Enter the Length of the Rectangle ==> ";
    
    cin >> length;
    
    //A.CalcRect(length, width);
    
    cout << "Enter the Width of the Rectangle ==> ";
    
    cin >> width;
    
    A.CalcRect(length, width);
    
    cout << "The Rectangle Area is ==> " << A.getRectArea() << endl;
    
    
    
    
    
    cout << "\nCalculating Triangle Area" << endl;
    
    cout << "===========================" << endl;
    
    
    cout << "Enter the height of the Triangle ==> ";
    
    cin >> height;
    
    //A.CalcTri(height, base);
    
    cout << "Enter the base of the Triangle ==> ";
    
    cin >> base;
    
    A.CalcTri(height, base);
    
    cout << "The Triangle Area is ==> " << A.getTriArea() << endl;
    
    
    cout << "Enter the height of the Trapezoid ==> ";
    
    cin >> height;
    
    //A.CalcTri(height, base);
    
    cout << "Enter base one of the Trapezoid ==> ";
    
    cin >> base1;
    
    cout << "Enter base two of the Trapezoid ==> ";
    
    cin >> base2;
    
    A.CalcTrap(height, base1, base2);
    
    cout << "The Trapezoid Area is ==> " << A.getTrapArea() << endl;
    
    cout << "========Thanks========" << endl;

    
    system("pause");
    
    return 0;

#include "GeoCalc.hpp"
//#include "main.cpp"
#include <iostream>
using namespace std;

GeoCalc::GeoCalc()
{
    
};

GeoCalc::~GeoCalc()
{
    
};

void GeoCalc::CalcRect(double length, double width)

{
    
    RectArea = length * width;
    
}

void GeoCalc::CalcTri(double height, double base)

{
    
    TriArea = (height * base) / 2;
    
}

void GeoCalc::CalcTrap(double a, double b, double h)

{
    TrapArea = ((a + b)/2) * h;
}

double GeoCalc::getRectArea()

{
    
    return RectArea;
    
}

double GeoCalc::getTriArea()

{
    
    return TriArea;
    
}

double GeoCalc::getTrapArea()
{
    return TrapArea;
}


//#include "GeoCalc.hpp"
#include <iostream>
//#include <stdio.h>
using namespace std;

class GeoCalc
{
private:
    double RectArea;
    double TriArea;
    double TrapArea;
    
public:
    GeoCalc();
    ~GeoCalc();
    void CalcRect(double, double);
    void CalcTri(double, double);
    void CalcTrap(double,double,double);
    double getRectArea();
    double getTriArea();
    double getTrapArea();
    
};


    
};
