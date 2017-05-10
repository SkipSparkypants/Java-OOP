class Map extends Element{
	private int len;
	private Pair first;
	private Pair last;
	private Sequence list;
	//constructor
	Map(){
		this.first = null;
		this.last = null;
		this.len = 0;
	}
	
	public void add(Pair inval){
		if (this.first == null){
			len++;
			this.first = inval;
			last = first;
			return;
		}
		Pair ptr = this.first;
		for (int i = 0; i < len; i++)
		{
			Pair temp = ptr.getNext();
			if (temp == this.last){
				len++;
				this.last.setNext(inval);
				this.last = inval;
			}
			if (temp.getKey() >= inval.getKey()){
				ptr.setNext(inval);
				inval.setNext(temp);
				break;
			}
			ptr = ptr.getNext();
		}
		len++;
		return;
	}
	
	public MapIterator begin(){
		MapIterator temp = new MapIterator(this.first);
		return temp;
	}
	
	public MapIterator end(){
		MapIterator temp = new MapIterator(null);
		return temp;
	}
	public MapIterator find(MyChar key){
		Pair temp = this.first();
		while(temp.getNext() != null){
			if (temp.getKey == key){
				return temp;
			}
		}
		MapIterator it = end();
		return it;
	}
	
	public void Print(){
		Pair temp = this.first;
		System.out.print("[ ");
		while (temp != null){
			System.out.print("(");
			Element k = temp.getKey();
			k.Print();
			Element in = N.getEle();
			in.Print();
			System.out.print(")");
			temp = temp.getNext();
		}
		System.out.print(" ]");
	}
}