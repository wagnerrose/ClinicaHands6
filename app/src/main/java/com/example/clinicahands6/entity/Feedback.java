package com.example.clinicahands6.entity;

public class Feedback {

    /**
     * Construtor - Recebendo somente a mensagem, assume-se sucesso
     */
    public Feedback(String mensagem) {
        this.mMensagem = mensagem;
    }

    public Feedback(String mensagem, boolean sucesso) {
        this.mMensagem = mensagem;
        this.mSucesso = sucesso;
    }

    public boolean isSucesso() {
        return this.mSucesso;
    }

    public String getMensagem() {
        return this.mMensagem;
    }

    private boolean mSucesso = true;
    private String mMensagem = "";

}