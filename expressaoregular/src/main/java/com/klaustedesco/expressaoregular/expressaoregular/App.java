package com.klaustedesco.expressaoregular.expressaoregular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main( String[] args ) {
    	// Todos tem como resultado TRUE nestes exemplos de REGEX
    
    	String padrao = "Java";
    	String texto = "Java";
    	
    	boolean textoPossuiPadrao = texto.matches(padrao);
    	    
    	/* MODIFICADORES
    	(?i), Ignora maiúscula e minúscula
    	(?m), Multilinhas
    	(?x), Comentários
    	(?s), Dottal -> 
    	*/
    	
    	textoPossuiPadrao = "Java".matches("(?im)java");
    	
    	/* METACARACTERES 
    	 .		Qualquer caracter
    	 \d		Dígitos			[0-9]
    	 \D 	Não é dígito	[^0-9]
    	 \s 	Espaços 		[ \t \n \x0B \f \r ]
    	 \S 	Não é espaço 	[^\s]
    	 \w		Letras e números[a-zA-Z_0-9]
    	 \W 	Não é letra		
    	 */
    	
    	textoPossuiPadrao = "@".matches(".");
    	textoPossuiPadrao = "2".matches("\\d");
    	textoPossuiPadrao = "a".matches("\\D");
    	textoPossuiPadrao = "1a".matches("\\w");
    	textoPossuiPadrao = " ".matches("\\s");
    	
    	textoPossuiPadrao = "P".matches(".");
    	textoPossuiPadrao = "Pi".matches("..");
    	textoPossuiPadrao = "Pig".matches("...");

    	// Validação de CEP
    	textoPossuiPadrao = "88080-251".matches("\\d\\d\\d\\d\\d-\\d\\d\\d");

    	/* QUANTIFICADOR 
    	X{n}		X, exatamente n vezes 
    	X{n,}		X, pelo menos n vezes 
    	X{n,m}		X, pelo menos n vezes, mas não mais do que m vezes 
    	X?			X, 0 ou 1 vez 
    	X*			X, 0 ou + vezes 
    	X+			X, 1 ou + vezes 
    	 */
    	
    	textoPossuiPadrao = "92".matches("\\d{2}");
    	textoPossuiPadrao = "123".matches("\\d{2,}");
    	textoPossuiPadrao = "12345".matches("\\d{2,5}");
    	textoPossuiPadrao = "".matches(".?");
    	textoPossuiPadrao = "".matches(".*");
    	textoPossuiPadrao = "abc".matches(".*");
    	textoPossuiPadrao = "abc".matches(".+");
    	
    	// Validação de CEP com Quantificador
    	textoPossuiPadrao = "88080-251".matches("\\d{5}-\\d{3}");

    	// Validar data
    	textoPossuiPadrao = "13/01/1992".matches("\\d{2}/\\d{2}/\\d{4}");
    	
    	
    	/* METACARACTERE DE FRONTEIRA
    	 ^		Inicia 
    	 $ 		Finaliza
    	 | 		Ou 
    	 */
    	
    	// Começa com a palavra "Pier"
    	textoPossuiPadrao = "Pier21".matches("^Pier.*");
    	
    	// Termina com "21" 
    	textoPossuiPadrao = "Pier21".matches(".*21$");

    	// Tem no texto "procurada"
    	textoPossuiPadrao = "Qual palavra foi procurada no texto?".matches(".*procurada.*");

    	// Validar inicio "Qual" e fim "?"
    	textoPossuiPadrao = "Qual palavra foi procurada no texto?".matches("^Qual.*?$");

    	// Validar se é "verdadeiro" ou "falso", resultado da String textoPossuiPadrao será TRUE para ambos casos
    	textoPossuiPadrao = "verdadeiro".matches("verdadeiro|falso");
    	textoPossuiPadrao = "falso".matches("verdadeiro|falso");

    	
    	/* AGRUPADORES 
    	[...]			Agrupamento
    	[a-z]			Alcance
    	[a-e][i-u]		União
    	[a-z&&[aeiou]]	Interseção
    	[^abc]			Exceção
    	[a-z&&[^m-p]]	Subtração
    	\x				Fuga literal
    	*/
    	
    	textoPossuiPadrao = "3".matches("[0-5]"); // o número "3" está entre "0" e "5"
    	textoPossuiPadrao = "true".matches("[tT]rue");
    	textoPossuiPadrao = "True".matches("[tT]rue");
    	textoPossuiPadrao = "true".matches("[tT]rue|[yY]es");
    	textoPossuiPadrao = "True".matches("[tT]rue|[yY]es");
    	textoPossuiPadrao = "yes".matches("[tT]rue|[yY]es");
    	textoPossuiPadrao = "Yes".matches("[tT]rue|[yY]es");
    	textoPossuiPadrao = "Klaus".matches("[A-Z][a-z]*"); // Primeira letra maiuscula
    	textoPossuiPadrao = "olho".matches("[^aA]lho"); // Validação excluindo a letra "a" ou "A"
    	textoPossuiPadrao = "crau".matches("cr[ae]u"); // Validando "crau" e "creu"

    	// Validando email
    	textoPossuiPadrao = "klaus@mail.com".matches("\\w+@\\w+\\.\\w{2,3}");
    	
    	System.out.println("Texto possui padrao? " + textoPossuiPadrao);
    	
    	
// Encontrar todas palavras "doce" na frase
    	
    	String frase = "Qual é o Doce mais dOce que o doCe de batata docE?";
    	System.out.println(frase);
    	// Pattern.compile(regex)  -> Compila deixando mais performatico caso utilize varias vezes
    	// Matcher pode ser utilizado para anexar o "texto" e fazer a validação junto ao Pattern.compile(regex) 
    	
    	Matcher matcher = Pattern.compile("(?i)doce").matcher(frase);
    	while(matcher.find()) {
    		System.out.println(matcher.group());
    	}
    	
    	/* SUBSTITUIÇÕES */
    	
    	// Trocar palavras "doce" no texto por "DOCINHO"
    	String trocaFrase = frase.replaceAll("(?i)doce", "DOCINHO");
    	System.out.println(trocaFrase);
    	
    	// Trocar palavras variaveis no texto
    	
    	String url = "www.tedesco.com/clientes-2010.html";
    	System.out.println("url original: " + url);
    	String padraoRegex = "(www.tedesco.com)/(\\w{2,})-(\\d{4}).html"; // o parenteses separa as variaveis
    	
    	trocaFrase = url.replaceAll(padraoRegex, "http://$1/$3/$2.jsp"); // o "$" seguido da posição da variavel
    	System.out.println("url alterada: " + trocaFrase);
    }
}
