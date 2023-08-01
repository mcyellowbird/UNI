#ifndef LIBRARY_H
#define LIBRARY_H

#include <fstream>
#include <vector>
#include <iostream>
#include <string>
#include <sstream>
#include <fstream>
#include <random>

using namespace std;

void createParties(int n);
void createElectorates(int n);
void createEvents();
void createIssues();

void runCampaign(int n, int m);

void runElection();

int randomUniform(int num1, int num2);

#endif