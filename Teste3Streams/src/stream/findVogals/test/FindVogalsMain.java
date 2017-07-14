package stream.findVogals.test;

import java.util.List;
import java.util.stream.Collectors;

import stream.findVogals.factory.impl.CharStream;
import stream.findVogals.service.FindVogalsService;

public class FindVogalsMain {	
	public static void main(String[] args) {
		testCase1Right();
		testCase2Error();
		testCase3ManyVogalsInConditionals();
		testCase4ManyVogalsInConditionals();
		testCase5ManyVogalsInConditionals();
	}
	
	public static void testCase1Right(){
		String sequence = "aAbBABacafe";
		
		List<Character> chars = sequence.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		CharStream<Character> charsStream = new CharStream<>(chars.stream());
		
		if(FindVogalsService.firstChar(charsStream) == 'e'){
			System.out.println("certo");	
		}else{
			System.out.println("errado");
		}
	}
	
	public static void testCase2Error(){
		String sequence = "aAbBABacafehe";
		
		List<Character> chars = sequence.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		CharStream<Character> charsStream = new CharStream<>(chars.stream());
		
		if(FindVogalsService.firstChar(charsStream) == 'r'){
			System.out.println("certo");	
		}else{
			System.out.println("errado");
		}
	}
	
	public static void testCase3ManyVogalsInConditionals(){
		String sequence = "aAbBABacafehehi";
		
		List<Character> chars = sequence.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		CharStream<Character> charsStream = new CharStream<>(chars.stream());
		
		if(FindVogalsService.firstChar(charsStream) == 'i'){
			System.out.println("certo");	
		}else{
			System.out.println("errado");
		}	
	}
	
	public static void testCase4ManyVogalsInConditionals(){
		String sequence = "aAbBABacafehehijo";
		
		List<Character> chars = sequence.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		CharStream<Character> charsStream = new CharStream<>(chars.stream());
		
		if(FindVogalsService.firstChar(charsStream) == 'i'){
			System.out.println("certo");	
		}else{
			System.out.println("errado");
		}	
	}
	
	public static void testCase5ManyVogalsInConditionals(){
		String sequence = "aAbBABacafeheaijo";
		
		List<Character> chars = sequence.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		CharStream<Character> charsStream = new CharStream<>(chars.stream());
		
		if(FindVogalsService.firstChar(charsStream) == 'o'){
			System.out.println("certo");	
		}else{
			System.out.println("errado");
		}	
	}
}
