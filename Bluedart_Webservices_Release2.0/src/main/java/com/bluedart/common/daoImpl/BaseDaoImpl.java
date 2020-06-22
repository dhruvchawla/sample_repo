package com.bluedart.common.daoImpl;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@PropertySource("classpath:feature.properties")
public class BaseDaoImpl extends HibernateDaoSupport {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	Environment env;
	
	@PostConstruct
	public void init() {
		setHibernateTemplate(hibernateTemplate);
	}
	
	@Transactional
	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
}
