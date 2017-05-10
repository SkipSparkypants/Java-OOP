class Sequence extends Element{
	private int len;
	protected Node first;
	protected Node last;
	public SequenceIterator begin(){
		SequenceIterator temp = new SequenceIterator(this.first);
		return temp;
	}
	
	public SequenceIterator end(){
		SequenceIterator temp = new SequenceIterator(null);
		return temp;
	}
	
	public Node getFirst(){
		return this.first;
	}
	
	public void setFirst(Node N){
		this.first = N;
	}
	
	public Node getLast(){
		return this.last;
	}
	
	public void setLast(Node N){
		this.last = N;
	}
	
	public void setLength(int i ){
		this.len = i;
	}
	
	public Element index(int pos){
		if (pos <0 || pos > len){
			System.err.println("index error");
			System.exit(1);	
		}
		Node temp = this.getFirst();
		for (int i = 0; i < pos; i++){
			temp = temp.getNext();
		}
		return temp.getEle();
	}
	//flatten
	public Sequence flatten(){
		Sequence temp = new Sequence();
		this.reverse();
		Node N = this.getFirst();
		while (N != null){
			Element E = N.getEle();
			Sequence temp2 = E.flatten();
			Node N2 = temp2.getFirst();
			for (int i = 0; i < temp2.length(); i++){
				Element temp3 = N2.getEle();
				temp.add(temp3, i);
				N2 = N2.getNext();
			}
			N = N.getNext();
		}
		this.reverse();
		return temp;
	}
	//copy
	public Sequence copy(){
		Sequence temp = new Sequence();
		Node N = this.getFirst();
		int count = 0;
		while(N != null){
			Element temp2 = N.getEle();
			Sequence temp3 = temp2.copy();
			if (temp3.length() > 1)
				temp.add(temp2, count);
			else{
				Node N2 = temp3.getFirst();
				temp.add(N2.getEle(), count);
			}
			N = N.getNext();
			count++;
		}
		return temp;
	}
	//reverse
	public void reverse(){
		Node N = this.getFirst();
		Node prev = null;
		Node prev1 = null;
		while (N.getNext() != null){
			if(N==first)
            {
                prev=N;
                N = N.getNext();
                prev.setNext(null);
            }
			else{
				prev1 = N;
				N = N.getNext();
				prev1.setNext(prev);
				prev = prev1;
			}
		}
		N.setNext(prev);
		first = N;
	}
	
	//isEmpty
	public boolean isEmpty(){
		return first == null;
	}
	//constructor
	public Sequence(){
		this.len = 0;
		this.first = null;
		this.last = null;
	}
	//first
	public Element first(){
		Node temp = this.getFirst();
		return temp.getEle();
	}
	//rest
	public Sequence rest(){
		Node temp = this.getFirst();
		temp = temp.getNext();
		Sequence temp2 = new Sequence();
		Node temp3 = this.getLast();
		temp2.setFirst(temp);
		temp2.setLength(this.length() - 1);
		temp2.setLast(temp3);
		return temp2;
	}
	//length
	public int length(){
		Node N = first;
		int count = 0;
		while (N != null){
			count++;
			N = N.getNext();
		}
		this.setLength(count);
		return len;
	}
	//add
	public void add(Element elm, int pos){
		if (pos < 0 || pos > len){
			System.err.println("add error");
			System.exit(1);
		}
		if (pos == 0){
			Node temp = new Node(elm, null);
			len++;
			if (isEmpty()){
				this.first = temp;
				last = temp;
			}
			else{
				temp.setNext(this.first);
				this.first = temp;
			}
			return;
		}
		if (pos == len){
			Node temp = new Node(elm, null);
			len++;
			if (isEmpty()){
				this.first = temp;
				last = this.first;
			}
			else{
				this.last.setNext(temp);
				this.last = temp;
			}
			return;
		}
		Node temp = new Node(elm, null);
		Node ptr = this.first;
		for (int i = 0; i < len; i++)
		{
			if (i == pos - 1){
				Node temp2 = ptr.getNext();
				ptr.setNext(temp);
				temp.setNext(temp2);
				break;
			}
			ptr = ptr.getNext();
		}
		len++;
		return;
	}
	//delete
	public void delete(int pos){
		if (pos == 0){
			first = first.getNext();
			len--;
			return;
		}
		if (pos == len){
			Node temp = first;
			Node temp2 = first;
			while (temp != last){
				temp2 = temp;
				temp = temp.getNext();
			}
			last = temp2;
			last.setNext(null);
			len--;
			return;
		}
		Node temp = first;
		for (int i = 0; i < len; i++){
			if (i == pos - 1){
				Node temp2 = temp.getNext();
				temp2 = temp2.getNext();
				temp.setNext(temp2);
				break;
			}
			temp = temp.getNext();
		}
		len--;
	}
	//print
	public void Print(){
		Node N = first;
		System.out.print("[ ");
		while (N != null){
			Element temp = N.getEle();
			temp.Print();
			System.out.print(" ");
			N = N.getNext();
		}
		System.out.print("]");
		return;
	}
	public int getInt(){
		return 0;
	}
	public void setInt(int x){
		return;
	}
	
}