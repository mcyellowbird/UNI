Name: Idries Eagle-Masuak
Student ID: 6868288
Email: iem651@uowmail.edu.au

Compiler: GNU c++ compiler

Code to compile: g++ file.cpp -o file
Code to run: ./file



Task 3-2: It calculates the fibonacci number relative to the input value. If a double value is used, it rounds to the nearest whole number (int)

Task 3-3: a) The values that are being added to the list are in a different order
	  b)
	  $ ./One
	  33
	  23
	  13
	  15
	  3
	  9
	  13
	  12

	  $ ./Two
	  33
	  23
	  12
	  13
	  9
	  15
	  13
	  3

	  c) The program is sorting the list when the current value in the list is greater than the next number but only when there's a difference of 6 between them

Task 4-1: b) The functionality required for a type in order to work with the method is it must overload the '+' operator

Task 4-3: If I attempt to instantiate the template class where one of the operations doesn't make sense, i.e. attempting to use the add() operation for a string and an int, a compiler error will be displayed.

Task 5: This function takes an array and its size and calculates values for x and y, where x is the minimum value in the first half of the array, 
	and y is the maximum value in the second half. The function returns x + y
	
	
	funcExp(list, 8)
	  x = 9
	  y = 8
 	  9 + 8 = 17

	funcExp(strlist, 8)
	  x = "two"
	  y = "blue"
	  "two" + "blue" = twoblue

	output: 17 :: twoblue
	