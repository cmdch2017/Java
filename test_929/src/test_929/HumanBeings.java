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
		System.out.println(name+"�ڳԷ�");
    } 
    public void shuijiao()
    {
    	System.out.println(name+"��˯��");
    }
    public HumanBeings(String name,String sex,String id,float height,float weight) throws Exception {
    	this.name=name;
    	this.setsex(sex);
    	this.setid(id);
    	this.setheight(height);
    	this.setweight(weight);
    }
	public void setsex(String sex)
    { if((sex.equals("��"))||(sex.equals("Ů")))
    	this.sex=sex;
    else
    	System.out.println("���䲻����Ҫ��");
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
    	System.out.println(height+"m����߲����ϳ��ˣ�Ҧ����û��ô��");
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
    	System.out.println(weight+"�ﲻ���ϳ��ˣ���Ŭ����.����Τ��û����ô��");
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
				throw new Exception("���֤����Ч");
			} 
			catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		char id1=id.charAt(16);
		if((id1%2==1)&&(this.sex.equals("��")))
			this.id=id;
		else if((id.charAt(16)%2==0)&&(sex.equals("Ů"))){
			this.id=id;
		}
		else {
			System.out.println("�Ա�ƥ��");
	 		return "error";
		}
		return "true";
    }
    public String getid(){
    	return id;
    	}
    }


    	
    	
    	
    
    
    	
    
    
    