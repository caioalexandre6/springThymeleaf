package com.threeway.curso.boot.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threeway.curso.boot.dao.CargoDao;
import com.threeway.curso.boot.domain.Cargo;

//anotação que torna a classe um Bean gereciado pelo spring 
@Service
@Transactional
public class CargosServiceImpl implements CargoService {

	@Autowired
	private CargoDao dao;

	@Override
	public void salvar(Cargo cargo) {
		dao.save(cargo);

	}

	@Override
	public void editar(Cargo cargo) {
		dao.update(cargo);

	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);

	}
    
	@Override
	@Transactional (readOnly = true) //Não abrir uma nova transação
	public Cargo buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true) //Não abrir uma nova transação
	public List<Cargo> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean cargoTemFuncionario(Long id) {
		if(buscarPorId(id).getFuncionarios().isEmpty()) {
		return false;
	}
		return true;
	}

}
