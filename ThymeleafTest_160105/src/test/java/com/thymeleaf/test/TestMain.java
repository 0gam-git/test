package com.thymeleaf.test;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.thymeleaf.daoex.JobDefine;
import com.thymeleaf.daoex.JobInfo;
import com.thymeleaf.daoex.Person;
import com.thymeleaf.model.unitTest;
import com.thymeleaf.repository.JobDefineRepository;
import com.thymeleaf.repository.JobInfoRepository;
import com.thymeleaf.repository.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class) // test시 같이 구동하라
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" }) // 내 설정파일 읽어라
@WebAppConfiguration // 웹에서 제공해주는 도구를 쓸것이다.
public class TestMain {
//
//	@Autowired
//	public unitTest test;
//
//	@Autowired
//	private JobDefineRepository jobDefineRepository;
//
//	@Autowired
//	private PersonRepository personRepository;
//
//	@Autowired
//	private JobInfoRepository jobInfoRepository;
//
//	// @Autowired
//	// private EntityManagerFactory entityManagerFactory;
//
//	JobInfo jobInfo = null;
//	JobDefine define = null;
//	
//	@Before
//	public void jobDefineTest() {
//		Person person = new Person("이름", "dudwns519@daum.net", "1234");
//		personRepository.save(person);
//
//		for (int i = 1; i < 10; i++) {
//			jobInfo = new JobInfo("농부" + i, "씨 뿌리기" + i);
//			define = new JobDefine(person, jobInfo);
//
//			jobInfo.getJobDefines().add(define);
//
//			jobInfoRepository.save(jobInfo);
//		}
//	}
//
//	@Test
//	public void findJobInfo() {
//		
//		List<JobInfo> infos = (List<JobInfo>) jobInfoRepository.findAll();
//		for (JobInfo jobInfo : infos) {
//			System.out.println(jobInfo.toString());
//		}
//		System.out.println("getTest autowired== " +test.getTest());
//	}
//	
//	@Test
//	public void findPerson(){
//		
//		List<Person> persons =  (List<Person>) personRepository.findAll();
//		for (Person person : persons) {
//			
//			System.out.println(person.toString());
//		}
//	}
	
	@Autowired
	private com.thymeleaf.aop.TestMain testMain;
	
	@Test
	public void aopTest(){
		testMain.test();
	}
	
}
