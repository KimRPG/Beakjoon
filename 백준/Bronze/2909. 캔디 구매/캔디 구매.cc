#include <iostream>

#include <math.h>

using namespace std;

int main() {

	int n,k;

	cin >> n >> k;

	

	int tmp = pow(10,k);

	int n1;

	n1 = n % tmp;

	n1 >= pow(10, k) / 2 ? n = n+(pow(10, k)-n1) : n = n - n1;

	cout << n;

	

}

