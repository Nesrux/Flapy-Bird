package Jogo;

import java.util.Set;

public class FlapyBird implements Jogo {
	public double chao_offset = 0;

	// gvx
	public double chao_vel = 50;

	@Override
	public String getTitulo() {

		return "Flapy Bird";
	}

	@Override
	public int getAltura() {

		return 512;
	}

	@Override
	public int getLargura() {

		return 384;
	}

	@Override
	public void tique(Set<String> teclas, double dt) {
		chao_offset += dt * chao_vel;
		chao_offset = chao_offset % 308;

	}

	@Override
	public void tecla(String tecla) {

	}

	@Override
	public void desenhar(Tela tela) {
		// Desenha o background do jogo
		tela.imagem("flappy.png", 0, 0, 288, 512, 0, 0, 0);
		tela.imagem("flappy.png", 0, 0, 288, 512, 0, 288, 0);
		// tela.imagem("flappy.png", 0, 0, 288, 512, 0, 288 * 2, 0);

		// Desenha o chão do jogo
		tela.imagem("flappy.png", 292, 0, 308, 112, 0, -chao_offset, getAltura() - 112);
		tela.imagem("flappy.png", 292, 0, 308, 112, 0, 308 - chao_offset, getAltura() - 112);
		// tela.imagem("flappy.png", 292, 0, 308, 112, 0, 288 * 2, 400);
	}

	public static void main(String[] args) {
		roda();
	}

	private static void roda() {
		new Motor(new FlapyBird());
	}
}
