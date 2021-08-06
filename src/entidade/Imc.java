package entidade;

public class Imc {

	public float calculoIMC(float altura, float peso) {
		float imc = (peso) / (altura * altura);
		return imc;
	}

}
