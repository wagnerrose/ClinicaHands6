package com.example.clinicahands6.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "agendas")
public class AgendaEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;
    @ColumnInfo(name="idMedico")
    private int idMedico;
    @ColumnInfo(name="idPaciente")
    private int idPaciente;
    @ColumnInfo(name="dataHora")
    private String dataHora;

    public AgendaEntity(int id, int idMedico, int idPaciente, String dataHora) {
        this.id = id;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.dataHora = dataHora;
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

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}
