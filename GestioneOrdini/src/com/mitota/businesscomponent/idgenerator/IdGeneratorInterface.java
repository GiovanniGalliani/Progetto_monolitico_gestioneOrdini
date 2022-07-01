package com.mitota.businesscomponent.idgenerator;

import java.io.IOException;

import com.mitota.architecture.dao.DAOException;

public interface IdGeneratorInterface {
	long getNextId() throws ClassNotFoundException, DAOException, IOException;
	//metodo per gestire gli ID da inserire nella tabella
}
