package com.bruno.catalagofilmes.service;


import com.bruno.catalagofilmes.model.Filme;
import com.bruno.catalagofilmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> buscarPorId(Long id) {
        return filmeRepository.findById(id);
    }

    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Optional<Filme> atualizar(Long id, Filme filmeAtualizado) {
        return filmeRepository.findById(id).map(filme -> {
            filme.setTitulo(filmeAtualizado.getTitulo());
            filme.setDiretor(filmeAtualizado.getDiretor());
            filme.setAno(filmeAtualizado.getAno());
            filme.setGenero(filmeAtualizado.getGenero());
            return filmeRepository.save(filme);
        });
    }

    public boolean deletar(Long id) {
        if (filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

