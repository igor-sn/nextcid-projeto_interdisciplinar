package br.edu.unicid.bean;

public class Questao {
	
	private int idQuestao;
	private String anoQuestao;
	private String nQuestao;
	private String tpQuestao;
	private String enunciado;
	private String img;
	private String altA;
	private String altB;
	private String altC;
	private String altD;
	private String altE; 
	private String respAlt;
	private String respDiss; 
	private int idDisciplina1;
	private String nomeDisciplina1; 
	private int idDisciplina2;
	private String nomeDisciplina2; 
	private int idDisciplina3;
	private String nomeDisciplina3; 
	private int idDisciplina4;
	private String nomeDisciplina4; 
	private String nomeCurso;
	
	public Questao(int idQuestao, String anoQuestao, String nQuestao, String tpQuestao, String enunciado, String img,
			String altA, String altB, String altC, String altD, String altE, String respAlt, int idDisciplina1,
			String nomeDisciplina1, int idDisciplina2, String nomeDisciplina2, int idDisciplina3,
			String nomeDisciplina3, int idDisciplina4, String nomeDisciplina4, String nomeCurso) {
		this.idQuestao = idQuestao;
		this.anoQuestao = anoQuestao;
		this.nQuestao = nQuestao;
		this.tpQuestao = tpQuestao;
		this.enunciado = enunciado;
		this.img = img;
		this.altA = altA;
		this.altB = altB;
		this.altC = altC;
		this.altD = altD;
		this.altE = altE;
		this.respAlt = respAlt;
		this.idDisciplina1 = idDisciplina1;
		this.nomeDisciplina1 = nomeDisciplina1;
		this.idDisciplina2 = idDisciplina2;
		this.nomeDisciplina2 = nomeDisciplina2;
		this.idDisciplina3 = idDisciplina3;
		this.nomeDisciplina3 = nomeDisciplina3;
		this.idDisciplina4 = idDisciplina4;
		this.nomeDisciplina4 = nomeDisciplina4;
		this.nomeCurso = nomeCurso;
	}

	public Questao(int idQuestao, String anoQuestao, String nQuestao, String tpQuestao, String enunciado, String img,
			String respDiss, int idDisciplina1, String nomeDisciplina1, int idDisciplina2, String nomeDisciplina2,
			int idDisciplina3, String nomeDisciplina3, int idDisciplina4, String nomeDisciplina4, String nomeCurso) {
		this.idQuestao = idQuestao;
		this.anoQuestao = anoQuestao;
		this.nQuestao = nQuestao;
		this.tpQuestao = tpQuestao;
		this.enunciado = enunciado;
		this.img = img;
		this.respDiss = respDiss;
		this.idDisciplina1 = idDisciplina1;
		this.nomeDisciplina1 = nomeDisciplina1;
		this.idDisciplina2 = idDisciplina2;
		this.nomeDisciplina2 = nomeDisciplina2;
		this.idDisciplina3 = idDisciplina3;
		this.nomeDisciplina3 = nomeDisciplina3;
		this.idDisciplina4 = idDisciplina4;
		this.nomeDisciplina4 = nomeDisciplina4;
		this.nomeCurso = nomeCurso;
	}
	

	public Questao(int idQuestao, String anoQuestao, String nQuestao, String tpQuestao, String enunciado, String img,
			String altA, String altB, String altC, String altD, String altE, String respAlt, String respDiss,
			int idDisciplina1, String nomeDisciplina1, int idDisciplina2, String nomeDisciplina2, int idDisciplina3,
			String nomeDisciplina3, int idDisciplina4, String nomeDisciplina4, String nomeCurso) {
		super();
		this.idQuestao = idQuestao;
		this.anoQuestao = anoQuestao;
		this.nQuestao = nQuestao;
		this.tpQuestao = tpQuestao;
		this.enunciado = enunciado;
		this.img = img;
		this.altA = altA;
		this.altB = altB;
		this.altC = altC;
		this.altD = altD;
		this.altE = altE;
		this.respAlt = respAlt;
		this.respDiss = respDiss;
		this.idDisciplina1 = idDisciplina1;
		this.nomeDisciplina1 = nomeDisciplina1;
		this.idDisciplina2 = idDisciplina2;
		this.nomeDisciplina2 = nomeDisciplina2;
		this.idDisciplina3 = idDisciplina3;
		this.nomeDisciplina3 = nomeDisciplina3;
		this.idDisciplina4 = idDisciplina4;
		this.nomeDisciplina4 = nomeDisciplina4;
		this.nomeCurso = nomeCurso;
	}

	public Questao() {
	}

	public int getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getAnoQuestao() {
		return anoQuestao;
	}

	public void setAnoQuestao(String anoQuestao) {
		this.anoQuestao = anoQuestao;
	}

	public String getnQuestao() {
		return nQuestao;
	}

	public void setnQuestao(String nQuestao) {
		this.nQuestao = nQuestao;
	}

	public String getTpQuestao() {
		return tpQuestao;
	}

	public void setTpQuestao(String tpQuestao) {
		this.tpQuestao = tpQuestao;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAltA() {
		return altA;
	}

	public void setAltA(String altA) {
		this.altA = altA;
	}

	public String getAltB() {
		return altB;
	}

	public void setAltB(String altB) {
		this.altB = altB;
	}

	public String getAltC() {
		return altC;
	}

	public void setAltC(String altC) {
		this.altC = altC;
	}

	public String getAltD() {
		return altD;
	}

	public void setAltD(String altD) {
		this.altD = altD;
	}

	public String getAltE() {
		return altE;
	}

	public void setAltE(String altE) {
		this.altE = altE;
	}

	public String getRespAlt() {
		return respAlt;
	}

	public void setRespAlt(String respAlt) {
		this.respAlt = respAlt;
	}

	public String getRespDiss() {
		return respDiss;
	}

	public void setRespDiss(String respDiss) {
		this.respDiss = respDiss;
	}

	public int getIdDisciplina1() {
		return idDisciplina1;
	}

	public void setIdDisciplina1(int idDisciplina1) {
		this.idDisciplina1 = idDisciplina1;
	}

	public String getNomeDisciplina1() {
		return nomeDisciplina1;
	}

	public void setNomeDisciplina1(String nomeDisciplina1) {
		this.nomeDisciplina1 = nomeDisciplina1;
	}

	public int getIdDisciplina2() {
		return idDisciplina2;
	}

	public void setIdDisciplina2(int idDisciplina2) {
		this.idDisciplina2 = idDisciplina2;
	}

	public String getNomeDisciplina2() {
		return nomeDisciplina2;
	}

	public void setNomeDisciplina2(String nomeDisciplina2) {
		this.nomeDisciplina2 = nomeDisciplina2;
	}

	public int getIdDisciplina3() {
		return idDisciplina3;
	}

	public void setIdDisciplina3(int idDisciplina3) {
		this.idDisciplina3 = idDisciplina3;
	}

	public String getNomeDisciplina3() {
		return nomeDisciplina3;
	}

	public void setNomeDisciplina3(String nomeDisciplina3) {
		this.nomeDisciplina3 = nomeDisciplina3;
	}

	public int getIdDisciplina4() {
		return idDisciplina4;
	}

	public void setIdDisciplina4(int idDisciplina4) {
		this.idDisciplina4 = idDisciplina4;
	}

	public String getNomeDisciplina4() {
		return nomeDisciplina4;
	}

	public void setNomeDisciplina4(String nomeDisciplina4) {
		this.nomeDisciplina4 = nomeDisciplina4;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	

	


	
	
	
	
	
}