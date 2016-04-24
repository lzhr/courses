package com.cjw.curricula.test;

	import org.junit.runner.RunWith;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
	import org.springframework.test.context.transaction.TransactionConfiguration;
	import org.springframework.transaction.annotation.Transactional;

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations={"classpath:com/cjw/curricula/config/spring_test.xml",
		"classpath:hibernate.cfg.xml"})
//	@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)//事务Rollback
	@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
	@Transactional
	public class BaseTest {
		void p(Object... os){
			for(Object o:os){
				System.out.println(o);
			}
		}
	}