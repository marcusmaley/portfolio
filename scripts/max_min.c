#include <stdio.h>
#define N 10

void max_min(int *a, int n, int *max, int *min){
	int *p;
	*max = *min = *a;
	for(p =  a; p < a+n; p++){
		if(*p>*max)
			*max = *p;
		if(*p<*min)
			*min = *p;
	}
}

int main(){
	int b[N], i, largest, smallest;
	printf("Enter %d numbers: ", N);
	for(i=0; i<N; i++){
		scanf("%d", b+i);
	}

	max_min(b, N, &largest, &smallest);
	printf("Largest = %d\n", largest);
	printf("Smallest = %d\n", smallest);
	return 0;
}
