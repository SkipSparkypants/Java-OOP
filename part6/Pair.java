class Pair{
	private MyChar key;
	private Element data;
	private Pair link;
	Pair(MyChar key, Element val){
		this.key = key;
		this.data = val;
		this.link = null;
	}
	public char getKey(){
		return this.key;
	}
	public Pair getNext(){
		return this.link;
	}
	public Element getEle(){
		return this.data;
	}
}