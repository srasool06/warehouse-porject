package com.app.dao;

import java.util.List;

import com.app.model.Uom;


public interface IUomDao {

	public Integer saveUom(Uom uom);
	public void updateUom(Uom uom);
	public void deletUom(Integer id);
	public Uom getOne(Integer id);
	public List<Uom> getAll();
	public boolean isUomAlreadyExist(String model);
	public boolean isUomConnectedWithItem(Integer id);

}