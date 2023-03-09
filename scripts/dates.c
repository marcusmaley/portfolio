#include <stdio.h>

struct date{
	int month, day, year;
};

//Compares the two dates to determine which comes before the other
int compare_dates(struct date d1, struct date d2){
	int result = 0;
	//1 = d1 is earlier than d2
	//-1 = d2 is earlier than d1
	//0 = d1 and d2 are the same date
	if(d1.year<d2.year){
		result = -1;
	}else if(d2.year<d1.year){
		result = 1;
	}else{
		if(d1.month<d2.month){
			result = -1;
		}else if(d2.month<d1.month){
			result = 1;
		}else{
			if(d1.day<d2.day){
				result = -1;
			}else if(d2.day<d1.day){
				result = 1;
			}else{
				result = 0;
			}
		}
	}
	return result;
}

int main(void){
	int answer;

	struct date d1, d2;

	while(1){
		printf("\nEnter the first date (mm/dd/yy): ");
		scanf("%d/%d/%d", &d1.month, &d1.day, &d1.year);

		//When user enters 0/0/0 the program ends
		if(d1.month== 0 && d1.day== 0 && d1.year== 0){
			break;
		}

		printf("Enter the second date (mm/dd/yy): ");
		scanf("%d/%d/%d", &d2.month, &d2.day, &d2.year);

		if(d2.month== 0 && d2.day== 0 && d2.year== 0){
			break;
		}
		
		//calls to the comparre_date function		
		answer = compare_dates(d1,d2);

		if(answer == -1){
			printf("%d/%d/%.2d is earlier than %d/%d/%.2d\n", d1.month, d1.day, d1.year, d2.month, d2.day, d2.year);
		}else if(answer == 1){
			printf("%d/%d/%.2d is earlier than %d/%d/%.2d\n", d2.month, d2.day, d2.year, d1.month, d1.day, d1.year);
		}else{ //if(answer == 0){
			printf("%d/%d/%.2d and %d/%d/%.2d are the same dates\n", d1.month, d1.day, d1.year, d2.month, d2.day, d2.year);
		}
		}
		return 0;	
}
