#include<stdio.h>
int main()
{
    //num为数字，conversion为需转换进制
    int num,conversion;
    //a[]数组记录转换后的数，i记录转换的位数
    int n,m,a[1000],i=0,N;
    printf("请输入转换十进制数: ");
    scanf("%d",&num);
    printf("请输入待转换进制: ");
    scanf("%d",&conversion);
    // N为临时数字保存num
    N=num;
    //十进制转n进制
    do
    {
        if(conversion<=10)
        {

            n=N/conversion;
            m=N%conversion;
            a[i]=m;
            N=n;
            i++;
        }
        else
        {
            n=N/conversion;
            m=N%conversion;
            if(m>=10)
            {
                a[i]=m-10+'A';
            }
            else
            {
                a[i]=m;
            }
            N=n;
            i++;
        }
    }
    while(N!=0);
    //输出
    printf("\n执行结果: ");
    for(i=i-1; i>=0; i--)
    {
        if(a[i]<10)
            printf("%d ",a[i]);
        else
            printf("%c ",a[i]);
    }
    printf("\n");
    return 0;
}
