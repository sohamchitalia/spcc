#include <stdio.h>
#include <time.h>

void before_movement(int b,int c)
{
    int i,a,z;

    printf("\nBefore Code movement Optimization\n");

    clock_t start, end;
    double cpu_time_used;
     
    start = clock();

    i = 0;
    while(i<10000)
    {
		a = b*c;
		z = a+34;
		i++;
    }

    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

    printf("Time taken = \n%f",cpu_time_used);
}

void after_movement(int b,int c)
{
    int temp,i,z;
    printf("\nAfter code movement optimization\n");


    clock_t start, end;
    double cpu_time_used;
     
    start = clock();

    temp = b*c;
    while(i<10000)
    {
		z = temp + 34;
		i++;
    }

    end = clock();
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

    printf("Time taken = \n%f",cpu_time_used);
    //printf("z= \n%d",z);
}

void main()
{
    int b,c;
    printf("\n Enter the values of b and c:");
    scanf("%d %d",&b,&c);
    before_movement(b,c);
    after_movement(b,c);
}

     
     
