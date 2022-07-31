#include <iostream>
#include <stdio.h>
#include <string>
using namespace std;

class Time {
    
private:
    int hour;
    int min;
    int sec;
    int militaryTime;
    
public:
    Time(); //constructor
    void printTime();
    void printMilTime();
    
    void setHour(int);
    void setMinute(int);
    void setSecond(int);
    int getHour();
    int getMilitaryTime();
    int getMinute();
    int getSecond();
    
    ~Time(); //destructor
};


#include "setupTime.hpp"
#include <iostream>
#include <string>
using namespace std;

int main()
{
    int hour, minute, second;
    
    Time military = Time();
    
    cout << "Please enter the time in Military Time." << endl;
    cout << "Please enter the hour: " << endl;
    cin >> hour;
    military.setHour(hour);
    
    cout << "Please enter the minute: " << endl;
    cin >> minute;
    military.setMinute(minute);
    
    cout << "Please enter the second: " << endl;
    cin >> second;
    military.setSecond(second);
    
    //Time military = Time(hour, minute, second);
    military.printTime();
    military.printMilTime();
    
}



#include <iostream>
#include "setupTime.hpp"
#include <string>
using namespace std;

Time::Time()//int hour, int minute, int second
{

}
void Time::setHour(int militaryTime)
{
    
    if (militaryTime == 0)
    {
        hour = 12;
    }
    else if (militaryTime == 13)
    {
        hour = 1;
    }
    else if (militaryTime == 14)
    {
        hour = 2;
    }
    else if (militaryTime == 15)
    {
        hour = 3;
    }
    else if (militaryTime == 16)
    {
        hour = 4;
    }
    else if (militaryTime == 17)
    {
        hour = 5;
    }
    else if (militaryTime == 18)
    {
        hour = 6;
    }
    else if (militaryTime == 19)
    {
        hour = 7;
    }
    else if (militaryTime == 20)
    {
        hour = 8;
    }
    else if (militaryTime == 21)
    {
        hour = 9;
    }
    else if (militaryTime == 22)
    {
        hour = 10;
    }
    else if (militaryTime == 23)
    {
        hour = 11;
    }
    else
    {
        militaryTime = hour;
    }
}

int Time::getHour()
{
    return hour;
}
void Time::setMinute(int minute)
{
    min = minute;
}
int Time::getMinute()
{
    return min;
}
void Time::setSecond(int second)
{
    sec = second;
}
int Time::getSecond()
{
    return sec;
}
void Time::printTime()
{
    cout << "HH: " << getHour() << " MM: " << getMinute() << " SS: " << getSecond() << endl;
}
void Time::printMilTime()
{
    cout << "HH: " << getHour() << " MM: " << getMinute() << " SS: " << getSecond() << endl;
}

Time::~Time()
{
    
}



