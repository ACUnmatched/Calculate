#include<stdio.h>
int main()
{
    //numΪ���֣�conversionΪ��ת������
    int num,conversion;
    //a[]�����¼ת���������i��¼ת����λ��
    int n,m,a[1000],i=0,N;
    printf("������ת��ʮ������: ");
    scanf("%d",&num);
    printf("�������ת������: ");
    scanf("%d",&conversion);
    // NΪ��ʱ���ֱ���num
    N=num;
    //ʮ����תn����
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
    //���
    printf("\nִ�н��: ");
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
