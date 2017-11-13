package br.com.flf.models;

import java.util.Calendar;

public class Filme {
    private long id;
    private String titulo;
    private String genero;
    private Calendar lancamento;
    private float imdb;
    private int duracao;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Calendar getLancamento() {
		return lancamento;
	}
	public void setLancamento(Calendar lancamento) {
		this.lancamento = lancamento;
	}
	public float getImdb() {
		return imdb;
	}
	public void setImdb(float imdb) {
		this.imdb = imdb;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}

