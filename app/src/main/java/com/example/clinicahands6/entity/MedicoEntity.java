package com.example.clinicahands6.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medicos")
public class MedicoEntity {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "crm_uf")
    private String crm_uf;
    @ColumnInfo(name = "crm_codigo")
    private int crm_codigo;

    public MedicoEntity(String nome, String crm_uf, int crm_codigo) {
        this.nome = nome;
        this.crm_uf = crm_uf;
        this.crm_codigo = crm_codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCrm_uf() {
        return crm_uf;
    }

    public void setCrm_uf(String crm_uf) {
        this.crm_uf = crm_uf;
    }

    public int getCrm_codigo() {
        return crm_codigo;
    }

    public void setCrm_codigo(int crm_codigo) {
        this.crm_codigo = crm_codigo;
    }
}
