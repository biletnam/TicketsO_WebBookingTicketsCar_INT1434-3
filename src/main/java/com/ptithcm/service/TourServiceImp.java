package com.ptithcm.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptithcm.entities.Tour;

@Transactional
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TourServiceImp implements ServicesBase<Tour>{

	@Override
	public List<Tour> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tour findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Tour entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Tour entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tour entity) {
		// TODO Auto-generated method stub
		
	}

}