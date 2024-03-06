package com.danggialoc.learn.Springboot.tutorial.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danggialoc.learn.Springboot.tutorial.Entity.Department;
import com.danggialoc.learn.Springboot.tutorial.Repository.DepartmentRepository;
import com.danggialoc.learn.Springboot.tutorial.error.DepartmentNotFoundExceoption;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return repository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long id) throws DepartmentNotFoundExceoption {
		// TODO Auto-generated method stub
		Optional<Department> lstDepartment =  repository.findById(id);
		if(!lstDepartment.isPresent()) {
			throw new DepartmentNotFoundExceoption("Deparment Not Available");
		}
		return lstDepartment.get();
	}

	@Override
	public void deleteDepartmentById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Department updateDepartmentById(Long id, Department department) {
		// TODO Auto-generated method stub
		Department departFindById = repository.findById(id).get();
		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			departFindById.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(department.getDepartmentAddress())
				&& !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			departFindById.setDepartmentAddress(department.getDepartmentAddress());
		}
		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			departFindById.setDepartmentCode(department.getDepartmentCode());
		}
		return repository.save(departFindById);
	}

	@Override
	public Department fetchDepartmentByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByDepartmentNameLike(name);
	}

}
