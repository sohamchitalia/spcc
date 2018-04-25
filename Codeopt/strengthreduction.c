#include<stdio.h>
#include<stdlib.h>

#include<string.h>
int main()
{
    char ope,op1[5],op2[5],op[2],res[10], eql;
    int i,opr2;
    //clrscr();
    //printf("\nInput in the form example: a 7 * 7 otherwise gives an error \nEnter the algebric expression:\n");
    printf("for(i=0;i<50;i++) \n Enter expresstion withing for loop:");
    scanf("%s",&res);
    scanf("%s", &eql);
    scanf("%s",&op1);
    scanf("%s",&op);
    scanf("%s",&op2);
    ope=op[0];
    opr2=atoi(op2);         //atoi- String to int
    switch(ope)
    {
	case '*':
	printf("%s ->",res);
	for(i=0;i<opr2-1;i++)
	    printf("%s + ",op1);
	printf("%s",op1);
	break;

	case '^':
	printf("%s ->",res);
	for(i=0;i<opr2-1;i++)
	    printf("%s * ",op1);
	printf("%s",op1);
	break;

    }
    return 0;
}
