
/*
在未输入数字之前，不能输入操作符
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;
public class Calc1 
{
	String str=" ";//文本框的内容
	JFrame frame;
	JTextField result_Jtf;
	JPanel panel1,panel2,panel3;
	
	
	public Calc1 ()
	{
		frame=new JFrame("计算器（在未输入数字之前，不能输入操作符）");
		frame.setLayout(new BorderLayout());
		frame.setLocation(300,200);
		frame.setSize(450,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		result_Jtf=new JTextField(30);
		result_Jtf.setHorizontalAlignment(JTextField.RIGHT);//右对齐
		result_Jtf.setEditable(false);//文本框禁止编辑
		
		panel3=new JPanel();
		panel3.setLayout(new GridLayout(1,1,5,5));
		JButton CE=new JButton("清空");
		
		panel3.add(CE);
	
		frame.add(panel3, BorderLayout.SOUTH);
		
		panel1=new JPanel();
		panel2=new JPanel();
		panel1.setLayout(new GridLayout(4,4,5,5));//4*4网格布局
		panel2.setLayout(new BorderLayout());//边界布局
		panel2.add(result_Jtf);//文本框置于panel2组件中
		
		CE.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e)
		        {
		                str=" ";
		                result_Jtf.setText(str);
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
					Stack<Double> stack=new Stack<Double>();//存储数据
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
		frame.add(panel2,BorderLayout.NORTH);//置于顶部
		frame.add(panel1,BorderLayout.CENTER);
	}
	public static void main (String[] args)
	{
		new Calc1();
	}
}
	