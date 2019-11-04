/*
在未输入数字之前，不能输入操作符
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Stack;

public class Calc1 {
	String str = " ";
	JFrame frame;// 窗口
	JTextField result_Jtf;// 文本框
	JPanel panel1, panel2, panel3;// JPanel面板
	Stack<Double> stack=new Stack<Double>();//存储数据

	public Calc1() {
		/** 设置窗口信息 */
		frame = new JFrame("计算器（在未输入数字之前，不能输入操作符）");
		frame.setLayout(new BorderLayout());// 设置窗体的布局管理器
		frame.setLocation(300, 200);// 设置窗口显示位置
		frame.setSize(450, 400);// 设置窗口尺寸大小
		frame.setResizable(true);// 允许修改窗口大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭窗口时的默认操作

		/** 设置文本框 */
		result_Jtf = new JTextField("0", 30);// 初始文本框内容
		result_Jtf.setHorizontalAlignment(JTextField.RIGHT);// 设置文本框对其方式
		result_Jtf.setEditable(false);// 文本框禁止编辑

		/** 设置面板组件 */
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setLayout(new GridLayout(4,4, 5, 5));// 设置4*4网格布局管理器
		panel2.setLayout(new BorderLayout());// 设置边界布局管理器
		panel2.add(result_Jtf);// 将文本框放入panel2组件中
		frame.add(panel2,BorderLayout.NORTH);//置于顶部
		////////////////////////////////
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 2, 5, 5));// 设置panel3组件的布局为1*2的网格布局管理器
		// 定义按钮组件
		JButton ce = new JButton("清空");// 清空
		ce.setForeground(Color.red);
		panel3.add(ce);
		frame.add(panel3, BorderLayout.SOUTH);
		

		/** 事件监听器 */
		ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result_Jtf.setText(" ");
				stack.clear();
			}
		});


		String[] butname= {"7","8","9","+","4","5","6","-","1","2","3","*",".","0","=","/"};
		for (int i=0;i<butname.length;i++)
		{
			JButton button=new JButton(butname[i]);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					String actionbut=e.getActionCommand();
					int flag=1;
					if (actionbut.equals("+")||actionbut.equals("-")||actionbut.equals("*")||actionbut.equals("/"))
					{
						str=str+" "+actionbut+" ";
						//System.out.print(str);
					}
					else if (actionbut.equals("="))
					{
						str=str+actionbut+calculate(str);
						result_Jtf.setText(str);
						str=" ";
						flag=0;
					}
					else
					{
						str=str+actionbut;
					}
					if (flag==1)
						{
							result_Jtf.setText(str);
						}
				}
				public String calculate(String str) 
				{
					String[] comput=str.split(" ");//分割操作符与数字
					
					stack.push(Double.parseDouble(comput[1]));
					for (int i=2;i<comput.length;i++)
					{
						if (i%2==0)
						{
							if (comput[i].equals("+"))
							{
								stack.push(Double.parseDouble(comput[i+1]));//把字符串转成数字
							}
							if (comput[i].equals("-"))
							{
								stack.push(-Double.parseDouble(comput[i+1]));
							}
							if (comput[i].equals("*"))
							{
								Double m=stack.peek();
								stack.pop();
								Double n=Double.parseDouble(comput[i+1]);//把*前后两个数相乘再压栈
								stack.push(m*n);
							}
							if (comput[i].equals("/"))
							{
								Double m=stack.peek();
								stack.pop();
								Double n=Double.parseDouble(comput[i+1]);
								stack.push(m/n);
							}
						}
					}
					double sum=0;
					while (!stack.isEmpty())
					{
						sum=sum+stack.peek();
						stack.pop();
					}
					String result=String.valueOf(sum);//转换成字符串型
					return result;
				}
			});
			panel1.add(button);
		}
		frame.add(panel1,BorderLayout.CENTER);
		frame.setVisible(true);// 设置JFrame可见
	}

	public static void main(String[] args) {
		new Calc1();
	}
}
	