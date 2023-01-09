package javaspace.com.example.demo;


import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.baomidou.mybatisplus.core.conditions.interfaces.Compare;

import com.example.demo.esayExcel.EasyExcelLesner;
import com.example.demo.esayExcel.EsayExcelEntity;
import com.example.demo.test.BillsNums;
import com.example.demo.test.LambadDefine;
import com.example.demo.test.LambdaFunction;
import com.example.demo.testDao.StudentMapper;
import com.example.demo.testModels.Person2;
import com.example.demo.testModels.Student;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class Demo3ApplicationTests {
	@Resource
	StudentMapper studentMapper;
	static ThreadLocal threadLocal = new ThreadLocal<>();
	@Test
	public void contextLoads() {
		m1();
		m2();
	}

	public void m1 (){
		threadLocal.set("ssss");
	}
	public void m2 (){
		System.out.println(threadLocal.get());
		threadLocal.remove();
	}

	@Test
	public void test01(){
		String hander = Hander("im,Dd", (x) -> {
			String s =
					x.toUpperCase().substring(1,3);
			return s;
		});

		System.out.println(hander);
	}

	public String Hander(String str, LambadDefine lambadDefine){
		return lambadDefine.getValue(str);
	}

 	@Test
	public void test02(){
		add(10L,20L, (x) ->{
			return String.valueOf(x+9);
		});
	}

	public void add(Long a, long b , Function<Long,String> lambdaFunction){
		System.out.println(lambdaFunction.apply(a));
	}



	//supplier
	@Test
	void test03(){
		List<Integer> integers = integerList(10, () -> {
			Integer a = 1;
			return a;
		});
		for (Integer integer : integers) {
			System.out.println(integer);
		}
	}

	public 	List<Integer> integerList(int len, Supplier<Integer> supplier){
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= len; i++) {
			Integer integer = supplier.get();
			list.add(integer);
		}
		return list;
	}

	@Test
	public void test04(){
		Comparator<Integer> comparator = Integer::compare;
		System.out.println(comparator.compare(10,20));

	}

	List<Student> list = Arrays.asList(
			new Student(1,10,"A"),
			new Student(2,101,"A"),
			new Student(1,10,"A"),
			new Student(4,10,"C"),
			new Student(5,120,"D"),
			new Student(6,10,"F"),
			new Student(7,120,"Z"),
			new Student(4,10,"E"),
			new Student(4,110,"Q"));
	Map<String,Student> map = new HashMap<>();


	
	List<BillsNums> list2 = Arrays.asList(
			new BillsNums("A",1,101),
			new BillsNums("B",1,120),
			new BillsNums("C",1,14530),
			new BillsNums("A",1,120),
			new BillsNums("A",1,1450),
			new BillsNums("D",1,14230),
			new BillsNums("Q",1,7140),
			new BillsNums("E",1,140),
			new BillsNums("X",1,1422340));

	@Test
	void  test05(){
		list.stream().distinct().forEach(System.out::println);
	}

	@Test
	void test08(){
		
	}




	@Test
	void test06(){
		Person2 p1 = new Person2("张三", new BigDecimal("10.0"));
		Person2 p2 = new Person2("王五", new BigDecimal("10.0"));
		Person2 p3 = new Person2("张三", new BigDecimal("10.0"));
		Person2 p4 = new Person2("李明", new BigDecimal("10.0"));
		Person2 p5 = new Person2("李明", new BigDecimal("10.0"));
		/**
		 * 求薪资总和，名字相同的只加一次
		 */
		List<Person2> pList = new ArrayList<Person2>();
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		pList.add(p4);
		pList.add(p5);

		StringBuilder stringBuilder = new StringBuilder();
		BigDecimal sum = pList.stream().filter(v -> {
			boolean flag = !stringBuilder.toString().contains(v.getName());
			stringBuilder.append("_").append(v.getName());
			return flag;
		}).map(Person2::getSalary).reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println(sum);

	}

	@Test
	void test07(){
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
		try {
			Date endDate = dft.parse(dft.format(date.getTime()));
			System.out.println(endDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}


	public static void main(String[] args) {

		


	}
	@Test
	public void test099(){
		//使用easyExcel进行读操作
		String fileName = "C:\\Users\\Hidou\\Desktop\\demo.xlsx";
		EasyExcel.read(fileName, EsayExcelEntity.class,new EasyExcelLesner())
				.sheet().doRead();
		//sheet() 方法中也可以加入要读的具体的sheet数据单
		EasyExcelLesner easyExcelLesner = new EasyExcelLesner();
		EasyExcel.write("C:\\Users\\Hidou\\Desktop\\test.xlsx", EsayExcelEntity.class).sheet("写入方法一").doWrite(easyExcelLesner.data());
	}



	@Test
	public void MakeJWT(){
//        使用Java.uitil设置时间
		Calendar instance =Calendar.getInstance();
		instance.add(Calendar.MINUTE,3);
		HashMap map = new HashMap();
		map.put("name","joy");
		map.put("id","6656");
		map.put("age","15");
		JSONObject jsonObject = new JSONObject(map);
		String Token = JWT.create().withAudience(jsonObject.toString())
				/*.withExpiresAt(instance.getTime())//设置过期时间*/
				.sign(Algorithm.HMAC256("QWERT@"));//指定加密算法以及签名
		System.out.println(Token);

	}


	@Test
	public void JWT_Is_True() {
		//创建验证对象  并指定 加密算法 以及签名
		JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("QWERT@")).build();
		DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ7XCJuYW1lXCI6XCJqb3lcIixcImlkXCI6XCI2NjU2XCIsXCJhZ2VcIjpcIjE1XCJ9In0.Acx6XG99GRE3-1r4wKljy9k2LtfU4JurGQMrKOdsCxM");
		System.out.println(verify.getAudience().get(0));


	}


}
