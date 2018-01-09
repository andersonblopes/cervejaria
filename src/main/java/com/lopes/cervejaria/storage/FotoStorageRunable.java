package com.lopes.cervejaria.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotoStorageRunable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<String> resultado;

	public FotoStorageRunable(MultipartFile[] files, DeferredResult<String> resultado) {
		this.files = files;
		this.resultado = resultado;
	}

	@Override
	public void run() {
		System.out.println(files.length);

		// TODO Salvar a foto no sistema de arquivos...
		resultado.setResult("Ok! Foto recebida com sucesso.");
	}

}
