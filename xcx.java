package xxm;
import java.util.*;
public class xcx {
private float length; //���峤����
private float width; // �����
public xcx(float length,float width){
this.length=length;
this.width=width;
}
public float getGirth(){
return (length+width)*2;
} //���ܳ�����
public float getArea(){
return length*width;
} //���������
public static void main (String[] args) {
Scanner in=new Scanner(System.in);//�������뷽��
System.out.println ("��������εĳ���");
float a=in.nextFloat();
System.out.println ("��������εĿ�");
float b=in.nextFloat();
System.out.println ("�����ܳ�Ϊ��"+new xcx(a,b).getGirth());
System.out.println ("�������Ϊ��"+new xcx(a,b).getArea());
}
}
