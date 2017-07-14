package stream.findVogals.service;

import java.util.Optional;

import stream.findVogals.core.Engineer;
import stream.findVogals.factory.Stream;
import stream.findVogals.factory.impl.CharStream;

public class FindVogalsService{
	
	public static char firstChar(Stream input) {
		Engineer enginee = new Engineer();
		CharStream<Character> inputCharStream = (CharStream<Character>) input; 
		
		inputCharStream.forEach(c -> enginee.compareStrings(c));
		Optional<Character> foundVogal = enginee.getElegibles().stream().findFirst();
		
		if(!foundVogal.isPresent()){
			System.out.println("Não existe vogal nas consições solicitadas");
			return 'r';
		}
		
		return foundVogal.orElse(null);
	}
}
