package springTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFrameworkTest {
	
	@Test
	public void testPrimitiveDataType(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springTest/BeanTest.xml");
		SpringDataModelTest objectTest = (SpringDataModelTest)context.getBean("testDataModel");
		assertEquals(objectTest.testDouble, 12.345, 0.00000001);
		assertEquals(objectTest.testInt, 12345);
		assertEquals(objectTest.testString, "stringWorks");
	}
	
	@Test
	public void testReferencedDataType(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springTest/BeanTest.xml");
		SpringDataModelTest objectTest = (SpringDataModelTest)context.getBean("testDataModel");
		ReferencedObjectTest referencedObjectTest = (ReferencedObjectTest)objectTest.getTestObject();
		assertEquals(referencedObjectTest.name, "referencedOjbect");
	}
	
	@Test
	public void testBeanSingletonScope(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springTest/BeanTest.xml");
		SingletoneObject singletonObject1 = (SingletoneObject)context.getBean("singletoneObject");
		singletonObject1.name = "single1";
		SingletoneObject singletonObject2 = (SingletoneObject)context.getBean("singletoneObject");
		singletonObject2.name = "single2";
		assertEquals(singletonObject1.name, "single2");
	}
	
	@Test
	public void testBeanPrototypeScope(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springTest/BeanTest.xml");
		PrototypeObject prototypeObject1 = (PrototypeObject)context.getBean("prototypeObject");
		prototypeObject1.name = "p1";
		PrototypeObject prototypeObject2 = (PrototypeObject)context.getBean("prototypeObject");
		prototypeObject2.name = "p2";
		assertEquals(prototypeObject1.name, "p1");
	}
	
	@Test
	public void testBeanlazyload(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springTest/BeanTest.xml");
		assertEquals(1,1);
	}
	
	@Test
	public void testBeanConstructorInjection(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springTest/BeanTest.xml");
		Constructor constructor = (Constructor)context.getBean("constructorInjection");
		assertEquals(constructor.name, (ReferencedObjectTest)context.getBean("referencedObject"));
	}
	
}