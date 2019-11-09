package test_929;

public class HumanBeings {
	static HumanBeings humans;
	private String id;
	private String name;
	private String sex;
	private float height;
	private float weight;
	
	public void chifan()
    { 
		System.out.println(name+"在吃饭");
    } 
    public void shuijiao()
    {
    	System.out.println(name+"在睡觉");
    }
    public HumanBeings(String name,String sex,String id,float height,float weight) throws Exception {
    	this.name=name;
    	this.setsex(sex);
    	this.setid(id);
    	this.setheight(height);
    	this.setweight(weight);
    }
	public void setsex(String sex)
    { if((sex.equals("男"))||(sex.equals("女")))
    	this.sex=sex;
    else
    	System.out.println("年龄不符合要求");
    }
    String getsex()
    {
    	return sex;
    	}
    public void setname(String name)
    {
    	this.name=name;
    }
    public String getname()
    {
    	return name;
    	}
    public void setheight(float height)
    {
    	if(height>2.5||height<0)
    	System.out.println(height+"m的身高不符合常人，姚明都没这么秀");
    else
    	this.height=height;
    }
    public float getheight()
    {
    	return height;
    	}
    public void setweight(float weight)
    {
    	if(weight<0||weight>500) {
    	System.out.println(weight+"斤不符合常人，曼努埃尔.乌里韦都没你这么秀");
    	return;
    	}
    	else { 
    	this.weight=weight;
    	}
    }
    public float getweight()
    {
    	return weight;
    	}
	public String setid(String id) 
    {
		if(id.length()!=18) {
			try {
				throw new Exception("身份证号无效");
			} 
			catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		char id1=id.charAt(16);
		if((id1%2==1)&&(this.sex.equals("男")))
			this.id=id;
		else if((id.charAt(16)%2==0)&&(sex.equals("女"))){
			this.id=id;
		}
		else {
			System.out.println("性别不匹配");
	 		return "error";
		}
		return "true";
    }
    public String getid(){
    	return id;
    	}
    }


    	
    	
    	
    
    
    	
    
    
    