package com.example.clinicahands6.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medicos_especialidades")
public class MedicoEspecialidadeEntity {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "idMedico")
    private int idMedico;
    @ColumnInfo(name = "idEspecialidade")
    private int idEspecialidade;

    public MedicoEspecialidadeEntity(int id, int idMedico, int idEspecialidade) {
        this.id = id;
        this.idMedico = idMedico;
        this.idEspecialidade = idEspecialidade;
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

    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }
}
