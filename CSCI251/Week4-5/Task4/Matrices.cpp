#include <iostream>
#include <cmath>

void multiplyMatrices(float M1[][10], float M2[][10], int M1_rows, int M1_cols, int M2_rows, int M2_cols);

using namespace std;

int main(){
    float M1[10][10] = {{0.1067, 0.7749},{0.9619, 0.8173},{0.0046, 0.8687}};
    float M2[10][10] = {{0.0844, 0.2599},{0.3998, 0.8001}};
    multiplyMatrices(M1,M2,3,2,2,2);
}

void multiplyMatrices(float M1[][10], float M2[][10], int M1_rows, int M1_cols, int M2_rows, int M2_cols){
    float M3[10][10];
    
    /*if (input NOT valid){

    }
    else {*/    
    for (int i = 0; i < M1_rows; ++i){
        for (int j = 0; i < M2_cols; ++j){
            for(int k = 0; k < M1_cols; ++k)
            {
                M3[i][j] += M1[i][k] * M2[k][j];
                cout << M3[i][j];
            }
        }
    }

    cout << "SGDGGDSFGSD" << endl;
    for(int i = 0; i < M1_rows; ++i)
    {
        cout << "SGDGGDSFGSD" << endl;
        for(int j = 0; j < M2_cols; ++j)
        {
            cout << "" << M3[i][j];
            if(j == M2_cols-1)
            {
                cout << endl;
            }
            else
                cout << "GSDREFGDGHSDGG" << endl;
        }
    }

    // for (int i = 0; i < M1_rows; ++i){
    //     for (int j = 0; i < M1_cols; ++j){
    //         M3[i][j] += M1[i][j] * M2[i][j];
    //         cout << M3[i][j] << endl;
    //     }
    // }
    //}
}