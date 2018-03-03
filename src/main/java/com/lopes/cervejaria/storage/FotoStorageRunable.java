package com.lopes.cervejaria.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.lopes.cervejaria.dto.FotoDTO;

public class FotoStorageRunable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<FotoDTO> resultado;

	public FotoStorageRunable(MultipartFile[] files, DeferredResult<FotoDTO> resultado) {
		this.files = files;
		this.resultado = resultado;
	}

	@Override
	public void run() {
		System.out.println(files.length);
		// TODO Salvar cerveja no sistema de arquivos.
		String nomeFoto = files[0].getOriginalFilename();
		String contentType = files[0].getContentType();
		resultado.setResult(new FotoDTO(nomeFoto, contentType));
	}

}
