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
        // 1. Corrected the syntax for findByEmail and isPresent()
        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Funcionario já cadastrado");
        }

        // 2. Map DTO to Model
        FuncionarioModel novoFuncionario = new FuncionarioModel();
        novoFuncionario.setNome(dto.getNome());
        novoFuncionario.setEmail(dto.getEmail());
        novoFuncionario.setTelefone(dto.getTelefone());

        // 3. Hash the password before saving!
        String senhaCriptografada = passwordEncoder.encode(dto.getSenha());
        novoFuncionario.setSenha(senhaCriptografada);

        // 4. Save to Database
        repository.save(novoFuncionario);

        // 5. Return a ResponseDTO (don't return the Model with the password!)
        return new FuncionarioResponseDTO(
                novoFuncionario.getNome(),
                novoFuncionario.getEmail(),
                novoFuncionario.getTelefone()
        );
    }
}