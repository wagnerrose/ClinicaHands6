package com.example.clinicahands6.entity;

public class RetornoEntity {
    private boolean mSucesso = true;
    public String mMensagem = "";

    public RetornoEntity(String mMensagem) {
        this.mMensagem = mMensagem;
    }
    public RetornoEntity(String mMensagem, boolean mSucesso) {
        this.mSucesso = mSucesso;
        this.mMensagem = mMensagem;

    }
    public boolean deuCerto() {
        return this.mSucesso;
    }

    public String pegaMensagem() {
        return this.mMensagem;
    }
}
