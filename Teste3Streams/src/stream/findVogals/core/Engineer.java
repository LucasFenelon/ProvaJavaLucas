package stream.findVogals.core;

import java.util.ArrayList;
import java.util.List;

public class Engineer {
	private List<Character> elegibles;
	private List<Character> newSequence;
	private List<Character> vogals;
	
	public Engineer(){
		elegibles = new ArrayList<Character>();
		newSequence = new ArrayList<Character>();
		vogals = new ArrayList<Character>();
	}
	
	public void compareStrings(Character chara) {		
		newSequence.add(chara);
		
		if(newSequence.size() > 2 && getVogal(newSequence.get(newSequence.size() - 3))
				&& !getVogal(newSequence.get(newSequence.size() - 2)) && getVogal(chara) 
				&& !elegibles.stream().filter(v -> v.equals(chara)).findFirst().isPresent()
				&& !vogals.stream().filter(v -> v.equals(chara)).findFirst().isPresent()){
			
			elegibles.add(chara);
		}else if(getVogal(chara)){
			vogals.add(chara);
			
			if(elegibles.stream().filter(v -> v.equals(chara)).findFirst().isPresent()){
				elegibles.remove(elegibles.stream().filter(v -> v.equals(chara)).findFirst().get());
			}
		}
	}
	
	public List<Character> getElegibles(){
		return elegibles;
	}
	
	private boolean getVogal(Character chara) {
		if(chara.equals('A') || chara.equals('E') || chara.equals('I') || chara.equals('O') || chara.equals('U')
				|| chara.equals('a') || chara.equals('e') || chara.equals('i') || chara.equals('o') || chara.equals('u')){
			return true;
		}else{
			return false;
		}
	}
}
