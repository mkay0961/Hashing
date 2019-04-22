package edu.cofc.cs.csci230;


public class ClosedHashing {
	
	int tableSize;
	private String[] table;
	int methodNum = 0;

	public ClosedHashing(int size, int method){
		tableSize = size;
		table = new String[ tableSize ];
		methodNum = method;
	}
	
	public boolean isFull(){
		for(int i =0; i< tableSize ; i++){
			if(table[i]==null){
				return false;
			}
		}
		return true;	
	}

	public int getKey(String word){
		int count= 0;
		for(int i =0; i< tableSize ; i++){
			if(table[i] ==(word)){
				count = i;
			}
		}
		return count;	
	}
	
	public String getValue(int index){
		return (String) table[index];
	}
	
	public int hashFunction0(String word){
		int key=0;
		for(int i =0; i<word.length(); i++){
			char c = word.charAt(i);
			key += (int)c;
		}
		key = key%3;
		return key;
	}
	
	public int hashFunction1(String word){
		int key=0;
		for(int i =0; i<word.length(); i++){
			char c = word.charAt(i);
			key += (int)c%3;
		}
		return key; 
	}
	
	public void insert(String word){
		int key = 0;
		if(methodNum == 0){
			key = hashFunction0(word);
		}
		else if(methodNum == 1){
			key = hashFunction1(word);
		}
		String play = "true";
		while(play== "true"){
			if(key == tableSize){
				key = 0;
			}
			if(table[key]!= null){
				key++;			
			}
			else if(table[key] == null){
				table[key] = word;
				play = "false";		
			}
			if(isFull()){
				play = "false";
			}
		}
		}
	
	public double calcLoadFactor(int n){
	double loadFactor;
	loadFactor = (((double)n)/2.0) / (double)tableSize;
	return loadFactor; 
	} 
	
	public double calcSuccessfull(){
		double successfull = 1/(1-calcLoadFactor(tableSize));
		successfull = (successfull+1) * .5; 
		return successfull;
	}
	
	public double calcUnsuccessfull(){
		double unsuccessfull = 1-calcLoadFactor(tableSize);
		unsuccessfull = 1/(Math.pow( unsuccessfull,2 ));
		unsuccessfull = (unsuccessfull+1) * .5; 
		return unsuccessfull;
	}
	
	public boolean search(String word){
		for(int i =0; i< tableSize ; i++){
			if(table[i] == (null)){
				
			}
			else if(table[i].equals( word)){
				return true;
			}
		}
		return false;
	}
	
	public void delete(String word){
		if(search(word) == true){
			table[this.getKey(word)] = null;			
		}	
	}
	
	public String getTests(){
		String rtnString = "";
		rtnString += "-----\n";	
		rtnString += "  Load factor: "+ this.calcLoadFactor(tableSize)+"\n";
		rtnString += "  Successfull: "+ this.calcSuccessfull()+"\n";		
		rtnString += "  Unsuccessfull: "+ this.calcUnsuccessfull()+"\n\n";
		rtnString += "|---------------------------------|";	
		return rtnString;
		
	}
	
	public String toString(){
		String rtnString = "-----\n";
		for(int i =0; i< tableSize ; i++){
			rtnString += getValue(i) + "\n";
		}		
		rtnString += "-----\n";	
		rtnString += "|  Load factor: "+ this.calcLoadFactor(tableSize)+"\n";
		rtnString += "|  Successfull: "+ this.calcSuccessfull()+"\n";		
		rtnString += "|  Unsuccessfull: "+ this.calcUnsuccessfull()+"\n";
		rtnString += "-----\n";		
		return rtnString;
	}

	public static void main( String[] args ){
		String text = "hello who are matthew red bug this "
				+ "static void main string hashfunction baby "
				+ "ted documents Empirical Analysis";
		String[] words = text.split(" ");
		ClosedHashing hashfunc1 = new ClosedHashing(words.length * 2,0);
		for(int i= 0; i < words.length;i++){
			hashfunc1.insert(words[i]);
		}
		
		System.out.println(hashfunc1.search("matthew"));
		

	
	
	}
	
	
	
	
	
}


