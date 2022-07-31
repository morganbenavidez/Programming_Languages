#include <iostream>
#include <algorithm>
using std::cout; //program uses cout
using std::cin; // program uses cin
using std::endl; // program uses endl

using namespace std;

int main(){
    
    double mpd = 0;
    double cpg = 0;
    double mpg = 0;
    double ppd = 0;
    double tpd = 0;
    double lot = 0;
    double total = 0;
    
    cout << "How many miles will you drive per day? " << endl;
    cin >> mpd;
    
    cout << "What is the average cost per gallon of gasoline? " << endl;
    cin >> cpg;
    
    cout << "What is the average mpg of the vehicle you'll be using? " << endl;
    cin >> mpg;
    
    cout << "How much will you pay for parking everyday? " << endl;
    cin >> ppd;
    
    cout << "How much will you pay in tolls everyday? " << endl;
    cin >> tpd;
    
    cout << "How many days will you be traveling? " << endl;
    cin >> lot;
    
    total = ((((mpd/mpg) * cpg)+ ppd + tpd)*lot);
    
    cout << "The total amount of money you will spend is: " << total << endl;
    
}
