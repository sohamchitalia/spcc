#include<stdio.h>

int global;
int before_optimize()
{
 int i;
 i=1;
 global=1;
 global=2;
 return global;
 global=3;
}
int after_optimize()
{
	global=2;
	return global;
}
int main()
{
int a,b;

a=before_optimize();
printf("Value of global variable before optimization %d",a);
b=after_optimize();
printf("\nValue of global variable after optimization %d \n",b);
return 0;
}
