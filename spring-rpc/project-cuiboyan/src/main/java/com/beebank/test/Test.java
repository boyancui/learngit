package com.beebank.test;


import java.util.Arrays;
import java.util.Set;

import com.google.common.base.CaseFormat;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;



public class Test {
	public static void main(String[] args) {
//		ImmutableSet<String> goole_color=
//				ImmutableSet.of("adgs","sada");
//		System.out.println(goole_color.toString());
		//字符串连接String
		//1.连接器（joiner）,
		//另外，useForNull(String)方法可以给定某个字符串来替换null，
		//而不像skipNulls()方法是直接忽略null。 
		//Joiner也可以用来连接对象类型，在这种情况下，
		//它会把对象的toString()值连接起来。
		
//		Joiner joiner = Joiner.on("; ").skipNulls();
//		System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));

//		Joiner joiner = Joiner.on("; ").useForNull("Harry");
//		System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
		

//		Joiner.on(",").join(Arrays.asList(1, 5, 7)); // returns "1,5,7"
		
//		警告：joiner实例总是不可变的。
//		用来定义joiner目标语义的配置方法总会返回一个新的joiner实例。
//		这使得joiner实例都是线程安全的，你可以将其定义为static final常量。
		
		//2.拆分器[Splitter]
		//String.split悄悄丢弃了尾部的分隔符。 
		//Splitter使用令人放心的、直白的流畅API模式对这些混乱的特性作了完全的掌控。
		
//		System.out.println(Splitter.on(',')
//		        .trimResults()
//		        .omitEmptyStrings()
//		        .split("foo,bar,,   qux"));
		
		//上述代码返回Iterable<String>，其中包含”foo”、”bar”和”qux”。
		//Splitter可以被设置为按照任何模式、字符、字符串或字符匹配器拆分。
		//拆分器工厂
		//方法	描述	范例
		/*
		 * Splitter.on(char)	按单个字符拆分	Splitter.on(‘;’)
			Splitter.on(CharMatcher)	按字符匹配器拆分	Splitter.on(CharMatcher.BREAKING_WHITESPACE)
			Splitter.on(String)	按字符串拆分	Splitter.on(“,   “)
			Splitter.on(Pattern) Splitter.onPattern(String)	按正则表达式拆分	Splitter.onPattern(“\r?\n”)
			Splitter.fixedLength(int)	按固定长度拆分；最后一段可能比给定长度短，但不会为空。	Splitter.fixedLength(3)
		*/
		//拆分器修饰符
		/*
		 * 方法	描述
			omitEmptyStrings()	从结果中自动忽略空字符串
			trimResults()	移除结果字符串的前导空白和尾部空白
			trimResults(CharMatcher)	给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
			limit(int)	限制拆分出的字符串数量
		 * */
		//如果你想要拆分器返回List，
		//只要使用Lists.newArrayList(splitter.split(string))或类似方法。
		//警告：splitter实例总是不可变的。
		//用来定义splitter目标语义的配置方法总会返回一个新的splitter实例。
		//这使得splitter实例都是线程安全的，你可以将其定义为static final常量。
		
		//3.字符匹配器[CharMatcher]
		
//		String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(string); //移除control字符
//		String theDigits = CharMatcher.DIGIT.retainFrom(string); //只保留数字字符
//		String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(string, ' ');
		//去除两端的空格，并把中间的连续空格替换成单个空格
//		String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(string, "*"); //用*号替换所有数字
//		String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string);
		// 只保留数字和小写字母
		
		/*
		 * CharMatcher只处理char类型代表的字符；
		 * 它不能理解0x10000到0x10FFFF的Unicode 增补字符。
		 * 这些逻辑字符以代理对[surrogate pairs]的形式编码进字符串，
		 * 而CharMatcher只能将这种逻辑字符看待成两个独立的字符。
		 */
		/*
		 *获取字符匹配器
			CharMatcher中的常量可以满足大多数字符匹配需求：
			ANY	NONE	WHITESPACE	BREAKING_WHITESPACE
			INVISIBLE	DIGIT	JAVA_LETTER	JAVA_DIGIT
			JAVA_LETTER_OR_DIGIT	JAVA_ISO_CONTROL	JAVA_LOWER_CASE	JAVA_UPPER_CASE
			ASCII	SINGLE_WIDTH
		 */ 
		/*
		 * 其他获取字符匹配器的常见方法包括：
			方法	描述
			anyOf(CharSequence)	枚举匹配字符。如CharMatcher.anyOf(“aeiou”)匹配小写英语元音
			is(char)	给定单一字符匹配。
			inRange(char, char)	给定字符范围匹配，如CharMatcher.inRange(‘a’, ‘z’)
		 */
		
		//4.字符集[Charsets]
		//Charsets针对所有Java平台都要保证支持的六种字符集提供了常量引用。
		//尝试使用这些常量，而不是通过名称获取字符集实例。
//		byte bytes[]= "123".getBytes(Charsets.UTF_8);
//		System.out.println(bytes);
		
		//5.大小写格式[CaseFormat]
		//CaseFormat被用来方便地在各种ASCII大小写规范间转换字符串——比如，
		//编程语言的命名规范。CaseFormat支持的格式如下：
		/*
		 *格式	范例
			LOWER_CAMEL	lowerCamel
			LOWER_HYPHEN	lower-hyphen
			LOWER_UNDERSCORE	lower_underscore
			UPPER_CAMEL	UpperCamel
			UPPER_UNDERSCORE	UPPER_UNDERSCORE
		 *
		 */
		
//		System.out.println(CaseFormat.UPPER_UNDERSCORE.
//				to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME")); // returns "constantName"); // returns "constantName"
		Optional<String> a=Optional.of("String");
		Set<String> set=a.asSet();	
		System.out.println(set);
		String str=null;
		Optional<String> b=Optional.fromNullable(str);
		System.out.println(b.isPresent());
		String str1=a.get();
		String str2=b.or(new String(""));
		System.out.println(str1+str2);
	}
}
