package com.example.Revisao7.service;

import com.example.Revisao7.dto.FuncionarioRequestDTO;
import com.example.Revisao7.dto.FuncionarioResponseDTO;
import com.example.Revisao7.model.FuncionarioModel;
import com.example.Revisao7.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<FuncionarioResponseDTO> listarTodos() {
        return repository
                .findAll()
                .stream()
                .map(f -> new FuncionarioResponseDTO(
                        f.getNome(),
                        f.getEmail(),
                        f.getTelefone()))
                .toList();
    }

    public FuncionarioResponseDTO salvarFuncionario(FuncionarioRequestDTO dto) {
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Funcionario já cadastrado");
        }

        FuncionarioModel novoFuncionario = new FuncionarioModel();
        novoFuncionario.setNome(dto.getNome());
        novoFuncionario.setEmail(dto.getEmail());
        novoFuncionario.setTelefone(dto.getTelefone());

        
        String senhaCriptografada = passwordEncoder.encode(dto.getSenha());
        novoFuncionario.setSenha(senhaCriptografada);

        
        repository.save(novoFuncionario);

   
        return new FuncionarioResponseDTO(
                novoFuncionario.getNome(),
                novoFuncionario.getEmail(),
                novoFuncionario.getTelefone()
        );
    }
}
