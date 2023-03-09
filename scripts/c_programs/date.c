#include <stdio.h>

int main(){
	
	int m1, m2, d1, d2, y1, y2;
	
	do{
	printf("\nEnter date 1 (MM/DD/YY): ");
	scanf("%d/%d/%d", &m1, &d1, &y1);
	if(m1==0 || d1==0 || y1==0){
		break;
	}
	
	printf("\nEnter date  2 (MM/DD/YY): ");
	scanf("%d/%d/%d", &m2, &d2, &y2);

	if(y1 < y2){
		printf("The date 1 comes first on the calander\n");
	}else if(y2 < y1){
		printf("The date 2 comes first on the calander\n");
	}else if(m1 < m2){
		printf("The date 1 comes first on the calander\n");
	}else if(m2 < m1){
		printf("The date 2 comes first on the calander\n");
	}else if(d1 < d2){
		printf("The date 1 comes first on the calander\n");
	}else{
		printf("The date 2 comes first on the calander\n");
	}
	}while(m1>0 && d1>0 && y1>0);
		return 0;
	
}
