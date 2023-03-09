#include <stdio.h>

#define MAX 80
#define UPPER_ENCRYPT ((ch - 'A') + key) % 26 + 'A' //Calculates the encryption of upper case
#define LOWER_ENCRYPT ((ch - 'a') + key) % 26 + 'a' //Calculates the encryption of lower case


int main(void)
{
	int n, key, i;
	char message[MAX], c;

	printf("Enter message to be encrypted: ");
	for (n = 0; (c = getchar()) != '\n'; n++) { //Read characters and ignores the new line
		message[n] = c;
	}

	printf("Enter shift amount: "); //Shifts the the amount
	scanf("%d", &key);

	printf("Encrypted message: ");
	for (i = 0; i < n; i++) {
		char ch = message[i]; //stores the encrypted message

		if (message[i] >= 'a' && message[i] <= 'z') {
			ch = LOWER_ENCRYPT; //uses the #define above
		} else if (message[i] >= 'A' && message[i] <= 'Z') {
			ch = UPPER_ENCRYPT; //uses the #define above
		}
		printf("%c", ch); //prints the encryption
	}
	printf("\n");

	return 0;
}
