package 练习;

/**
 系内有A,B,C,D,E,F,G共7位辅导员，在一星期内（星期一至星期天）每人要轮流值班一天，现在已知：
1、	A比C晚一天值班；	c=a-1
2、	D比E晚2天值班；   e=d-2
3、	B比G早3天值班；  g=b+3
4、	F的值班日在B和C的中间，且是星期四。
请确定每天究竟是哪位辅导员在值班。

 */
public class 教师值班问题 {
	public static void main(String[] args)
	{
		int a=1,b=1,c=1,d=1,e=1,f=4,g=1,count=0;
		for(int i1=1;i1<8;i1++)
		{
			if(i1==4)continue;
			for(int i2=1;i2<8;i2++)
			{
				if(i2==i1||i2==4)continue;
				for(int i3=1;i3<8;i3++)
				{
					if(i3==i2||i3==i1||i3==4)continue;
					for(int i4=1;i4<8;i4++)
					{
						if(i4==i3||i4==i2||i4==i1||i4==4)continue;
						for(int i5=1;i5<8;i5++)
						{
							if(i5==i4||i5==i3||i5==i2||i5==i1||i5==4)continue;
							for(int i6=1;i6<8;i6++)
							{
								if(i6==i5||i6==i4||i6==i3||i6==i2||i6==i1||i6==4)continue;
								if(i1+i2+i3+i4+i5+i6==24)
								{
									a=i1;b=i2;c=i3;d=i4;e=i5;g=i6;
									count++;
									if(c==a-1&&e==d-2&&g==b+3&&b+c==8)
									{
										System.out.print(a);
										System.out.print(b);
										System.out.print(c);
										System.out.print(d);
										System.out.print(e);
										System.out.print(f);
										System.out.println(g);
									}
								}
								
							}
						}
					}
				}
			}
		}
	}
}





