package br.edu.unicid.bean;

public class Disciplina {
	
	private int idDisciplina;
	private String nomeDisciplina;
	private int idCurso;
	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", idCurso="
				+ idCurso + ", nomeCurso=" + nomeCurso + "]";
	}

	private String nomeCurso;
	
	public Disciplina(int idDisciplina, String nomeDisciplina, int idCurso, String nomeCurso) {
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
	}
	
	public Disciplina() {
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	
	
	
	
}
