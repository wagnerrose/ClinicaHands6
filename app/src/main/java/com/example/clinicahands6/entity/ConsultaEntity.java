package com.example.clinicahands6.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "consultas")
public class ConsultaEntity {


    @ColumnInfo(name="id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="idMedico")
    private int idMedico;
    @ColumnInfo(name="idPaciente")
    private int idPaciente;
    @ColumnInfo(name = "idAgenda")
    private int idAgenda;
    @ColumnInfo(name = "anotacao")
    private String anotacao;

    public ConsultaEntity(int id, int idMedico, int idPaciente, int idAgenda, String anotacao) {
        this.id = id;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.idAgenda = idAgenda;
        this.anotacao = anotacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }
}
