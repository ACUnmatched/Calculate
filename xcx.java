package xxm;
import java.util.*;
public class xcx {
private float length; //定义长变量
private float width; // 宽变量
public xcx(float length,float width){
this.length=length;
this.width=width;
}
public float getGirth(){
return (length+width)*2;
} //求周长方法
public float getArea(){
return length*width;
} //求面积方法
public static void main (String[] args) {
Scanner in=new Scanner(System.in);//调用输入方法
System.out.println ("请输入矩形的长：");
float a=in.nextFloat();
System.out.println ("请输入矩形的宽：");
float b=in.nextFloat();
System.out.println ("矩形周长为："+new xcx(a,b).getGirth());
System.out.println ("矩形面积为："+new xcx(a,b).getArea());
}
}
