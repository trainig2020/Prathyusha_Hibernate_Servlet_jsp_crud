package com.abc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.model.Department;
import com.hibernate.connection.HibernateConnection;


public class DepartmentDaoImpl implements DepartmentDao {
	
	

	@Override
	public void insertDepartment(Department dept) {

		
		Transaction transaction = null;
        try {
        	Session session = HibernateConnection.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();
            session.save(dept);
            System.out.println("Datas Inserted");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepartments() {
		List < Department > lstOfDept = null;
        Session session = HibernateConnection.getSessionFactory().openSession();
        session.beginTransaction();
     
        lstOfDept = session.createQuery("from Department").list();
            
        for(Department d:lstOfDept){
        	System.out.println("DeptID is : "+ d.getDeptId()+" DeptName is :"+d.getDeptName());
        }
        
        return lstOfDept;
    

	}



	
	@Override
	public String updateDepartment(Department dept) {
		
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(dept);
		String rs ="Record Updated Successfully";
		session.getTransaction().commit();
		session.close();
		return rs;
	}

	public void deleteDepartment(int deptId) {

		Transaction transaction = null;
        Department dept1 = null;
        try {
        	Session session = HibernateConnection.getSessionFactory().openSession();
        
            
            transaction = session.beginTransaction();

            dept1 = (Department) session.get(Department.class, deptId);
            
            session.delete(dept1);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

	}

	@Override
	public Department getDeptById(int deptId) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		Department dept = (Department) session.get(Department.class, deptId);
		System.out.println("DeptID is : "+ dept.getDeptId()+" DeptName is :"+dept.getDeptName());
		return dept;
	}

}
