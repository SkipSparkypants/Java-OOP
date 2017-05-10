class Matrix extends Sequence{
	private int rowSz;
	private int colSz;
	private int size;
	private Sequence data;
	public int getRows(){
		return this.rowSz;
	}
	public int getCols(){
		return this.colSz;
	}
	Matrix(int rowsize, int colsize){
		data = new Sequence();
		this.rowSz = rowsize;
		this.colSz = colsize;
		this.size = rowsize * colsize;
		for (int i = 0; i < this.size; i++){
			MyInteger temp = new MyInteger();
			this.data.add(temp, i);
		}
	}
	
	public void Set(int rowsize, int colsize, int value){
		int index = ((rowsize) * this.colSz) + colsize;
		Node N = data.getFirst();
		for (int i = 0; i < this.size; i++){
			if(i == index){
				Element temp = N.getEle();
				temp.setInt(value);
				return;
			}
			N = N.getNext();
		}
		return;
	}
	
	public int Get(int rowsize, int colsize){
		int index = ((rowsize) * this.colSz) + colsize;
		Node N = data.getFirst();
		for (int i = 0; i < this.size; i++){
			if(i == index){
				Element temp = N.getEle();
				return temp.getInt();
			}
			N = N.getNext();
		}
		return -1;
	}
	
	public Matrix Sum(Matrix mat){
		Node N = this.data.getFirst();
		Node N2 = mat.data.getFirst();
		for (int i = 0; i < this.size; i++){
			Element temp = N.getEle();
			Element temp2 = N2.getEle();
			int s = temp.getInt() + temp2.getInt();
			temp.setInt(s);
			N = N.getNext();
			N2 = N2.getNext();
		}
		return this;
	}
	
	public Matrix Product(Matrix mat){
		if (this.colSz != mat.getRows()){
			System.out.println("Matrix dimensions incompatible for Product");
			System.exit(1);
		}
		Matrix temp = new Matrix(this.rowSz, mat.getCols());
		int sum = 0;
		Node N = temp.data.getFirst();
		for (int i = 0; i < this.rowSz; i++){
			for (int k = 0; k < mat.getCols(); k++){
				for (int j = 0; j < mat.getRows(); j++){
					sum += (Get(i, j) * mat.Get(j, k));
				}
				Element E = N.getEle();
				E.setInt(sum);
				sum = 0;
				N = N.getNext();
			}
		}
		return temp;
	}
	
	public void Print(){
		Node N = data.getFirst();
		for (int i = 0; i < rowSz ; i++){
			System.out.print("[ ");
			 for (int j = 0; j < colSz ; j++){
				Element temp = N.getEle();
				temp.Print();
				System.out.print(" ");
				N = N.getNext();
			}
			System.out.println("]");
		}
	}
}