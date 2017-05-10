class MyInteger extends Element{
	protected int data;
	public MyInteger(){
		data = 0;
	}
	public int Get(){
		return data;
	}
	public void Set(int val){
		this.data = val;
	}
	public void Print(){
		System.out.print(data);
	}
	public Sequence flatten(){
		Sequence temp = new Sequence();
		temp.add(this, 0);
		return temp;
	}
	public Sequence copy(){
		Sequence temp = new Sequence();
		MyInteger temp2 = new MyInteger();
		int i = 0;
		i = i + this.Get();
		temp2.Set(i);
		temp.add(temp2, 0);
		return temp;
	}
	public int getInt(){
		return this.data;
	}
	public void setInt(int x){
		this.data = x;
	}
}