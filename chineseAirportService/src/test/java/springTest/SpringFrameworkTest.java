package springTest;

import static org.junit.Assert.assertEquals;

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
		SingletoneObjectTest singletonObject1 = (SingletoneObjectTest)context.getBean("singletoneObject");
		singletonObject1.name = "single1";
		SingletoneObjectTest singletonObject2 = (SingletoneObjectTest)context.getBean("singletoneObject");
		singletonObject2.name = "single2";
		assertEquals(singletonObject1.name, "single2");
	}
	
	@Test
	public void testBeanPrototypeScope(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springTest/BeanTest.xml");
		PrototypeScopeTest prototypeObject1 = (PrototypeScopeTest)context.getBean("prototypeObject");
		prototypeObject1.name = "p1";
		PrototypeScopeTest prototypeObject2 = (PrototypeScopeTest)context.getBean("prototypeObject");
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
		ConstructorArgTest constructor = (ConstructorArgTest)context.getBean("constructorInjection");
		assertEquals(constructor.name, (ReferencedObjectTest)context.getBean("referencedObject"));
	}
	
}