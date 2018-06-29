package cyrillicLatinTransliteration.model;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;


public class Convert {
	
	 public static String transliterate(String message){
	        // char[] abcCyr =   {" ","а","б","в","г","д","е","ё", "ж","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х", "ц","ч", "ш","щ","ъ","ы","ь","э", "ю","я","А","Б","В","Г","Д","Е","Ё", "Ж","З","И","Й","К","Л","М","Н","О","П","Р","С","Т","У","Ф","Х", "Ц", "Ч","Ш", "Щ","Ъ","Ы","Ь","Э","Ю","Я","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	        // String[] abcLat = {" ","a","b","v","g","d","e","e","zh","z","i","y","k","l","m","n","o","p","r","s","t","u","f","h","ts","ch","sh","sch", "","i", "","e","ju","ja","A","B","V","G","D","E","E","Zh","Z","I","Y","K","L","M","N","O","P","R","S","T","U","F","H","Ts","Ch","Sh","Sch", "","I", "","E","Ju","Ja","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	        Map<String,String> charDict = new HashMap<String, String>(){
	        	
				private static final long serialVersionUID = 1L;

			{
	                put("зг" , "zgh");
	                put("Зг" , "Zgh");
	                put("А","A");
	                put("а","a");
	                put("Б","B");
	                put("б","b");
	                put("В","V");
	                put("в","v");
	                put("Г","G");
	                put("г","g");
	                put("Ґ","G");
	                put("ґ","g");
	                put("Д","D");
	                put("д","d");
	                put("Е","E");
	                put("е","e");
	                put("Ё","E");
	                put("ё","e");
	                put("Є","Ye");
	                put("є","ie");
	                put("Ж","Zh");
	                put("ж","zh");
	                put("З","Z");
	                put("з","z");
	                put("И","Y");
	                put("и","y");
	                put("І","I");
	                put("і","i");
	                put("Ї","Yi");
	                put("ї","i");
	                put("Й","Y");
	                put("й","i");
	                put("К","K");
	                put("к","k");
	                put("Л","L");
	                put("л","l");
	                put("М","M");
	                put("м","m");
	                put("Н","N");
	                put("н","n");
	                put("О","O");
	                put("о","o");
	                put("П","P");
	                put("п","p");
	                put("Р","R");
	                put("р","r");
	                put("С","S");
	                put("с","s");
	                put("Т","T");
	                put("т","t");
	                put("У","U");
	                put("у","u");
	                put("Ф","F");
	                put("ф","f");
	                put("Х","Kh");
	                put("х","kh");
	                put("Ц","Ts");
	                put("ц","ts");
	                put("Ч","Ch");
	                put("ч","ch");
	                put("Ш","Sh");
	                put("ш","sh");
	                put("Щ","Shch");
	                put("щ","shch");
	                put("Ы","Y");
	                put("ы","y");
	                put("Э","E");
	                put("э","e");
	                put("Ю","Yu");
	                put("ю","iu");
	                put("Я","Ya");
	                put("я","ia");
	                put("Ь", "");
	                put("ь", "");
	                put("Ъ", "");
	                put("ъ", "");
	                put("\'", "");
	        }};



	        StringBuilder builder = new StringBuilder();
	        
	        // to replace the Cyrillic chars to Ltin chars
	        for (int i = 0; i < message.length(); i++) {
	            // System.out.println(message.charAt(i));
	        	
	        	// for "зг"
	        	if((message.charAt(i) == 'з') & i < message.length()-1) {
//	        		System.out.println("зг");
	        		if(message.charAt(i+1) == 'г') {
	        			builder.append("zgh");
	        			i = i+1;
	        		}
	        		else {
	        			builder.append("z");
	        		}
	        		
	        		
	        	}
	        	// for "3г" 
	        	else if (message.charAt(i) == 'З' && i < message.length()-1) {
	        		if(message.charAt(i+1) == 'г') {
	        			builder.append("Zgh");
	        			i = i+1;
	        		}
	        		else {
	        			builder.append("Z");
	        		}
	        		
	        	}
	            // If they are in our dict.
	        	else if(charDict.containsKey(Character.toString(message.charAt(i)))){

	                // String ch = message.charAt(i);
	                String tmp = charDict.get(Character.toString(message.charAt(i)));
	                builder.append(tmp);
	            }
	            // If not in the dict. then appens ad it is as they are already in Latin.
	            else{
	                builder.append(message.charAt(i));
	            }            

	        }
	        System.out.println("Transliterated Strig: "+builder.toString());
	        return builder.toString();
	    }

	    public static void main(String[] args) {
	        
	        Scanner scanner = new Scanner(System.in);
	        new Convert().test();
	        System.out.print("Enter a new Cyrillic string for custom test: ");
	        String inpString = scanner.next();
	        scanner.close();
	        String latinString = transliterate(inpString);
	        System.out.println("Transliterated Strig: "+latinString);
	    }
	    
	    public void test() {
//	    	assertEquals(transliterate('Алушта'), 'Alushta');
	    	
	    	assertEquals(transliterate("Алушта"), "Alushta");
	    	assertEquals(transliterate("Андрій"), "Andrii");
	    	    
	    	    
	    	assertEquals(transliterate("Борщагівка"), "Borshchagivka");
	    	assertEquals(transliterate("Борисенко"), "Borysenko");
	    	    
	    	assertEquals(transliterate("згaзг"), "zghazgh");
	    	
	    	assertEquals(transliterate("Вінниця"), "Vinnytsia");
	    	assertEquals(transliterate("Володимир"), "Volodymyr");
	    	    
	    	    
	    	assertEquals(transliterate("Гадяч"), "Gadiach");
	    	assertEquals(transliterate("Богдан"), "Bogdan");
	    	assertEquals(transliterate("Згурський"), "Zghurskyi");
	    	    
	    	    
	    	assertEquals(transliterate("Ґалаґан"), "Galagan");
	    	assertEquals(transliterate("Ґорґани"), "Gorgany");
	    	    
	    	    
	    	assertEquals(transliterate("Донецьк"), "Donetsk");
	    	assertEquals(transliterate("Дмитро"), "Dmytro");
	    	    
	    	    
	    	assertEquals(transliterate("Рівне"), "Rivne");
	    	assertEquals(transliterate("Олег"), "Oleg");
	    	assertEquals(transliterate("Есмань"), "Esman");
	    	    
	    	    
	    	assertEquals(transliterate("Ёж"), "Ezh");
	    	assertEquals(transliterate("Течёт"), "Techet");
	    	    
	    	    
	    	assertEquals(transliterate("Єнакієве"), "Yenakiieve");
	    	assertEquals(transliterate("Гаєвич"), "Gaievych");
	    	assertEquals(transliterate("Короп\'є"), "Koropie");
	    	    
	    	    
	    	assertEquals(transliterate("Житомир"), "Zhytomyr");
	    	assertEquals(transliterate("Жанна"), "Zhanna");
	    	assertEquals(transliterate("Жежелів"), "Zhezheliv");
	    	    
	    	    
	    	assertEquals(transliterate("Закарпаття"), "Zakarpattia");
	    	assertEquals(transliterate("Казимирчук"), "Kazymyrchuk");
	    	    
	    	    
	    	assertEquals(transliterate("Медвин"), "Medvyn");
	    	assertEquals(transliterate("Михайленко"), "Mykhailenko");
	    	    
	    	    
	    	assertEquals(transliterate("Іванків"), "Ivankiv");
	    	assertEquals(transliterate("Іващенко"), "Ivashchenko");
	    	    
	    	    
	    	assertEquals(transliterate("Їжакевич"), "Yizhakevych");
	    	assertEquals(transliterate("Кадиївка"), "Kadyivka");
	    	assertEquals(transliterate("Мар\'їне"), "Marine");
	    	    
	    	    
	    	assertEquals(transliterate("Йосипівка"), "Yosypivka");
	    	assertEquals(transliterate("Стрий"), "Stryi");
	    	assertEquals(transliterate("Олексій"), "Oleksii");
	    	    
	    	    
	    	assertEquals(transliterate("Київ"), "Kyiv");
	    	assertEquals(transliterate("Коваленко"), "Kovalenko");
	    	    
	    	    
	    	assertEquals(transliterate("Лебедин"), "Lebedyn");
	    	assertEquals(transliterate("Леонід"), "Leonid");
	    	    
	    	    
	    	assertEquals(transliterate("Миколаїв"), "Mykolaiv");
	    	assertEquals(transliterate("Маринич"), "Marynych");
	    	    
	    	    
	    	assertEquals(transliterate("Ніжин"), "Nizhyn");
	    	assertEquals(transliterate("Наталія"), "Nataliia");
	    	    
	    	    
	    	assertEquals(transliterate("Одеса"), "Odesa");
	    	assertEquals(transliterate("Онищенко"), "Onyshchenko");
	    	    
	    	    
	    	assertEquals(transliterate("Полтава"), "Poltava");
	    	assertEquals(transliterate("Петро"), "Petro");
	    	    
	    	    
	    	assertEquals(transliterate("Решетилівка"), "Reshetylivka");
	    	assertEquals(transliterate("Рибчинський"), "Rybchynskyi");
	    	    
	    	    
	    	assertEquals(transliterate("Суми"), "Sumy");
	    	assertEquals(transliterate("Соломія"), "Solomiia");
	    	    
	    	    
	    	assertEquals(transliterate("Тернопіль"), "Ternopil");
	    	assertEquals(transliterate("Троць"), "Trots");
	    	    
	    	    
	    	assertEquals(transliterate("Ужгород"), "Uzhgorod");
	    	assertEquals(transliterate("Уляна"), "Uliana");
	    	    
	    	    
	    	assertEquals(transliterate("Фастів"), "Fastiv");
	    	assertEquals(transliterate("Філіпчук"), "Filipchuk");
	    	    
	    	    
	    	assertEquals(transliterate("Харків"), "Kharkiv");
	    	assertEquals(transliterate("Христина"), "Khrystyna");
	    	    
	    	    
	    	assertEquals(transliterate("Біла Церква"), "Bila Tserkva");
	    	assertEquals(transliterate("Стеценко"), "Stetsenko");
	    	    
	    	    
	    	assertEquals(transliterate("Чернівці"), "Chernivtsi");
	    	assertEquals(transliterate("Шевченко"), "Shevchenko");
	    	    
	    	    
	    	assertEquals(transliterate("Шостка"), "Shostka");
	    	assertEquals(transliterate("Кишеньки"), "Kyshenky");
	    	    
	    	    
	    	assertEquals(transliterate("Щербухи"), "Shcherbukhy");
	    	assertEquals(transliterate("Гоща"), "Goshcha");
	    	assertEquals(transliterate("Гаращенко"), "Garashchenko");
	    	    
	    	    
	    	assertEquals(transliterate("Ынха"), "Ynkha");
	    	assertEquals(transliterate("Рыба"), "Ryba");
	    	    
	    	    
	    	assertEquals(transliterate("Эмульсия"), "Emulsyia");
	    	assertEquals(transliterate("это"), "eto");
	    	    
	    	    
	    	assertEquals(transliterate("Юрій"), "Yurii");
	    	assertEquals(transliterate("Корюківка"), "Koriukivka");
	    	    
	    	    
	    	assertEquals(transliterate("Яготин"), "Yagotyn");
	    	assertEquals(transliterate("Ярошенко"), "Yaroshenko");
	    	assertEquals(transliterate("Костянтин"), "Kostiantyn");
	    	assertEquals(transliterate("Знам\'янка"), "Znamianka");
	    	assertEquals(transliterate("Феодосія"), "Feodosiia");
	    	    
	    	    
	    	    
	    	    
	    	assertEquals(transliterate("Володимир-Волинський"), "Volodymyr-Volynskyi");
	    	    
	    	    
	    	assertEquals(transliterate("Володимир_Волинський"), "Volodymyr_Volynskyi");
	    	System.out.println("All test Passed");
	    }

}
