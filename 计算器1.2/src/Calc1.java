/*
��δ��������֮ǰ���������������
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
	JFrame frame;// ����
	JTextField result_Jtf;// �ı���
	JPanel panel1, panel2, panel3;// JPanel���
	Stack<Double> stack=new Stack<Double>();//�洢����

	public Calc1() {
		/** ���ô�����Ϣ */
		frame = new JFrame("����������δ��������֮ǰ�����������������");
		frame.setLayout(new BorderLayout());// ���ô���Ĳ��ֹ�����
		frame.setLocation(300, 200);// ���ô�����ʾλ��
		frame.setSize(450, 400);// ���ô��ڳߴ��С
		frame.setResizable(true);// �����޸Ĵ��ڴ�С
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ùرմ���ʱ��Ĭ�ϲ���

		/** �����ı��� */
		result_Jtf = new JTextField("0", 30);// ��ʼ�ı�������
		result_Jtf.setHorizontalAlignment(JTextField.RIGHT);// �����ı�����䷽ʽ
		result_Jtf.setEditable(false);// �ı����ֹ�༭

		/** ���������� */
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setLayout(new GridLayout(4,4, 5, 5));// ����4*4���񲼾ֹ�����
		panel2.setLayout(new BorderLayout());// ���ñ߽粼�ֹ�����
		panel2.add(result_Jtf);// ���ı������panel2�����
		frame.add(panel2,BorderLayout.NORTH);//���ڶ���
		////////////////////////////////
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 2, 5, 5));// ����panel3����Ĳ���Ϊ1*2�����񲼾ֹ�����
		// ���尴ť���
		JButton ce = new JButton("���");// ���
		ce.setForeground(Color.red);
		panel3.add(ce);
		frame.add(panel3, BorderLayout.SOUTH);
		

		/** �¼������� */
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
					String[] comput=str.split(" ");//�ָ������������
					
					stack.push(Double.parseDouble(comput[1]));
					for (int i=2;i<comput.length;i++)
					{
						if (i%2==0)
						{
							if (comput[i].equals("+"))
							{
								stack.push(Double.parseDouble(comput[i+1]));//���ַ���ת������
							}
							if (comput[i].equals("-"))
							{
								stack.push(-Double.parseDouble(comput[i+1]));
							}
							if (comput[i].equals("*"))
							{
								Double m=stack.peek();
								stack.pop();
								Double n=Double.parseDouble(comput[i+1]);//��*ǰ�������������ѹջ
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
					String result=String.valueOf(sum);//ת�����ַ�����
					return result;
				}
			});
			panel1.add(button);
		}
		frame.add(panel1,BorderLayout.CENTER);
		frame.setVisible(true);// ����JFrame�ɼ�
	}

	public static void main(String[] args) {
		new Calc1();
	}
}
	