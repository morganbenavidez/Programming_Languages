//#include "stdafx.h"
#include <iostream>
using namespace std;

int main()
{
    int a;
    int b;
    int c;
    int n = 15;
    
    cout << "                  *" << endl;
    cout << "                 ^*^"<< endl;
    cout << "                ^.*.^" << endl;
    cout << "               ^.*|*.^"<< endl;
    for (a=1; a<=(n-10); a++){
       
        for (b=a; b<n; b++){
        cout << " ";
        } cout << "^.*/";
        for(c=1; c<=a; c++){
            
            cout << "*";
            if (c != a){
                cout << " ";
            }
        }
       cout << "\\*.^";
        cout << endl;
    }
    for (a=1; a<=(n-5); a++){
        
        for (b=a; b<n; b++){
            cout << " ";
        } cout << "^.*/";
        for(c=1; c<=a; c++){
            
            cout << "*";
            if (c != a){
                cout << " ";
            }
        }
        cout << "\\*.^";
        cout << endl;
    }
    for (a=1; a<=(n); a++){
        
        for (b=a; b<n; b++){
            cout << " ";
        } cout << "^.*/";
        for(c=1; c<=a; c++){
            
            cout << "*";
            if (c != a){
                cout << " ";
            }
        }
        cout << "\\*.^";
        cout << endl;
    }
    for (a=4; a<=(n-11); a++){
        for(b=a; b<n; b++){
            cout << " ";
        }
        for (c=1; c<=a; c++){
            cout << "  |";
        }
    } cout << endl;
        
};
 /*   int n = 5;
    int a;
    int b;
    int c;
    
    for (a=1; a<=n; a++){
        for (b=a; b< n; b++){
            cout << " ";
        }
        for (c=1; c<=a; c++){
            cout << "* ";
        }
        
        
        cout << endl;
    }
  
    int n = 7;
    int a;
    int b;
    int c;
    
    
    for (a=1; a<=(n-2); a++){
        for (b=a; b< n; b++){
            cout << " ";
        }
        for (c=1; c<=a; c++){
            cout << "* ";
        }
        cout << endl;
    }
    
    
    for (a=1; a<=(n); a++){
        for (b=a; b<n; b++){
            cout << " ";
        }
        for (c=1; c<=a; c++){
            cout << "* ";
        }
        cout << endl;
    }
    for (a=3; a<=(n-4); a++){
        for (b=a; b< n; b++){
            cout << " ";
        }
        for (c=1; c<=a; c++){
            cout << "* ";
        }
        cout << endl;
    }
    
};
    
*/
