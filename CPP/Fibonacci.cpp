#include <iostream>
using namespace std;



int fibonacci(int n)
{
    if ((n==1) || (n==0))
    {
        return(n);
    }
    else
    {
        return(fibonacci(n-1) + fibonacci(n-2));
    }
}

int f(int num)
{

        if (num <= 1)
            return 1;
        else
            return num*f(num-1);
    
}

int main()
{
    int n = 0, i = 0, num = 0;
    
    //int fact = 1;
    
    cout << "Input the number of terms for Fibonacci Series: ";
    cin >> n;
    cout << "\nFibonacci Series is as follows\n";
    
    while (i<n)
    {
        cout << " " << fibonacci(i);
        i++;
    }
    cout << endl;
    
    cout << "Input the number for your factorial: ";
    cin >> num;
    cout << "\nFactorial is as follows:\n" << f(num) << endl;
    

    //cout<<"Factorial of entered number: "<<f(num);

    //system("pause");
    return 0;
}


