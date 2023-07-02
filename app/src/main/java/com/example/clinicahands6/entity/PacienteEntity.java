package com.example.clinicahands6.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pacientes")
public class PacienteEntity {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "cpf")
    private String cpf;
    @ColumnInfo(name = "dataNascimento")
    private String dataNascimento;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "endereco")
    private String endereco;
    @ColumnInfo(name = "telefone")
    private String telefone;

    public PacienteEntity(int id, String nome, String cpf, String dataNascimento, String email, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() { return dataNascimento; }

    public void setDatNascimento(String dataNascimento) { this.dataNascimento = dataNascimento;}

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }
}
