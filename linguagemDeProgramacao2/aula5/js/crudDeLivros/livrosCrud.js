import { LivroController } from "./livrosClass.js";

const livroController = new LivroController();
livroController.carregarLivros();

let adicionarLivroButton = document.getElementById("adicionarLivro");

adicionarLivroButton.addEventListener("click", () => {
    document.getElementById("criarLivro").style.display = "flex";
});