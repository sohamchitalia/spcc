#include <stdio.h>
#include <time.h>

int before_optimize()
{
	clock_t start,end;
    double cpuTimeUsed;
	int x,y,z;

	start = clock();

	x = 8;
	y = 14-x/2;
	z = y*(24/x+2);

	end = clock();

    cpuTimeUsed = ((double)(end-start))/CLOCKS_PER_SEC;
    printf("\nResult before optimization: %d\n",z);	
    printf("\nTime taken = %f\n",cpuTimeUsed);

}

int after_optimize()
{
	clock_t start,end;
    double cpuTimeUsed;
	int x,y,z;

	y = 14-8/2;
	z = y*(24/8+2);

	cpuTimeUsed = ((double)(end-start))/CLOCKS_PER_SEC;
    printf("\nResult after optimization: %d\n",z);	
    printf("\nTime taken = %f\n",cpuTimeUsed);
}

void main()
{
	before_optimize();
	after_optimize();
}
