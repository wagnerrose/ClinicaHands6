package com.example.clinicahands6.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pacientes")
public class PacienteEntity {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "cpf")
    private String cpf;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "data_nascimento")
    private String data_nascimento;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "endereco")
    private String endereco;
    @ColumnInfo(name = "telefone")
    private String telefone;

    public PacienteEntity(String cpf, String nome, String data_nascimento, String email, String endereco, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() { return data_nascimento; }

    public void setData_nascimento(String data_nascimento) { this.data_nascimento = data_nascimento;}

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }
}
