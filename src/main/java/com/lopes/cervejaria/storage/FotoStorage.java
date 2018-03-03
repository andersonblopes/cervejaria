package com.lopes.cervejaria.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {

	public void salvarTemporariamente(MultipartFile[] file);

}
