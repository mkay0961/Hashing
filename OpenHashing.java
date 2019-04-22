package edu.cofc.cs.csci230;



public class OpenHashing {

	int tableSize;
	private ArrayList[] hashtable;
	int methodNum = 0;	
	
	public OpenHashing(int size, int method){
		tableSize = size;
		methodNum = method;
		hashtable = new ArrayList[tableSize];
		for ( int i=0; i<tableSize; i++ )
			hashtable[i] = new ArrayList();		
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
	
	public double calcLoadFactor(int n){
		double a;
		double m = 0;
		
		for(int i=0; i< tableSize; i++){
			if(hashtable[i].isEmpty()){		
			}
			else{
				m += 1;	
			}
		}
		a = n/m;
		return a; 
	} 
	
	public double calcSuccessfull(){
		double successfull = (calcLoadFactor(tableSize)/2)+1;
		return successfull;
	}
	
	public double calcUnsuccessfull(){
		double unsuccessfull = calcLoadFactor(tableSize);
		return unsuccessfull;
	} 
	
	public void insert(String word){
		int key = 0;
		if(methodNum == 0){
			key = hashFunction0(word);
		}
		else if(methodNum == 1){
			key = hashFunction1(word);
		} 	
	 	hashtable[key].add(word);	
	}
	
	public boolean search(String word){
		int key = 0;
		if(methodNum == 0){
			key = hashFunction0(word);
		}
		else if(methodNum == 1){
			key = hashFunction1(word);
		}
	
		for(int i =0; i<hashtable[key].size();i++){
			if(hashtable[key].get(i).equals( word)){
				return true;
			}
		}
		return false;
	}
		
	public void delete(String word){
		int key = 0;
		if(methodNum == 0){
			key = hashFunction0(word);
		}
		else if(methodNum == 1){
			key = hashFunction1(word);
		}
		if(search(word)== true){
			for(int i =0; i<hashtable[key].size();i++){
				if(hashtable[key].get(i).equals( word)){
					hashtable[key].remove(i);
				}
			}
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
			rtnString+= "Key:" + i + "||";
			for(int k = 0; k<hashtable[i].size(); k++){
				rtnString+= hashtable[i].get(k) + " --> ";
			}
			rtnString +=  "\n";
		}		
		rtnString += "-----\n";	
		rtnString += "Load factor: "+ this.calcLoadFactor(tableSize)+"\n";
		rtnString += "Unsuccessfull: "+ this.calcUnsuccessfull()+"\n";
		rtnString += "Successfull: "+ this.calcSuccessfull()+"\n";		
		rtnString += "-----\n";	
		return rtnString;
	}
	
	public static void main( String[] args ){
		String text = "hello who are matthew red bug this "
				+ "static void main string hashfunction baby "
				+ "ted documents Empirical Analysis";
		String[] words = text.split(" ");
		OpenHashing hashfunc1 = new OpenHashing(words.length,0);
		for(int i= 0; i < words.length;i++){
			hashfunc1.insert(words[i]);
		}
		
		
		
		
	}
	
}





// search, insert, and delete

