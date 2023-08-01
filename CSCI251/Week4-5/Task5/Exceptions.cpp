#include <iostream>
#include <exception>

using namespace std;

class MyException : public exception{
    public:
        // this function will be called to output a string when an exception araised.
        // more details can be found:
        // https://www.cplusplus.com/reference/exception/exception/what/
        const char * what() const throw()
        {
            return "Attempted to divide by zero!\n";
        }
};

int main(){
    double x, y;

    try {
        cout << "Enter the numbers of x and y:" << endl;
        cin >> x;
        cin >> y;
        
        if (y == 0){
            throw MyException();
        }

        cout << "x/y = " << x/y;
    }
    catch (exception& e){
        cout << e.what();
    }

    return 0;
}
