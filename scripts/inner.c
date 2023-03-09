#include <stdio.h>
#define N 10


int inner_product(int a[], int b[], int n);
int inner_product_reverse(int a[], int b[], int n);

int main(){

	int a[N], b[N], i;
	printf("Enter the first array of size %d: ", N);//takes in size of first array
	for(i=0; i<N; i++){
		scanf("%d", a+i);
	}

	printf("Enter the second array of size %d: ", N);//takes in size of second array
	for(i=0; i<N; i++){
		scanf("%d", b+i);
	}
		printf("Inner product is: %d\n", inner_product(a,b,N));//prints inner product
		printf("Inner product reverse is: %d\n", inner_product_reverse(a,b,N));//prints inner product in reverse 
		return 0;
}

//declaration of inner product function 
int inner_product(int a[], int b[], int n){
	int sum = 0, i;
	for(i=0; i<n; i++){
		sum+= a[i] * b[i];
	}
	return sum;
}

//declaration of inner product function
int inner_product_reverse(int a[], int b[], int n){
	int sum = 0, i;
	for(i=0; i<n; i++){
		sum+=  a[i] * b[n-i-1];
	}
	return sum;
}
