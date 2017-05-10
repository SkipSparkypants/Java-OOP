class MyChar extends Element{
	protected char data;
	public MyChar(){
		data = '0';
	}
	public char Get(){
		return data;
	}
	public void Set(char val){
		this.data = val;
	}
	public void Print(){
		System.out.print("'" + data + "'");
	}
	public Sequence flatten(){
		Sequence temp = new Sequence();
		temp.add(this, 0);
		return temp;
	}
	public Sequence copy(){
		Sequence temp = new Sequence();
		MyChar temp2 = new MyChar();
		char i = this.Get();
		temp2.Set(i);
		temp.add(temp2, 0);
		return temp;
	}
	public int getInt(){
		return 0;
	}
	public void setInt(int x){
		return;
	}
}