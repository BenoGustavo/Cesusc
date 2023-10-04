public class Main {
    public static void main(String[] args) {
        Motor motorDeCarroBom = new Motor(2023, "300 Cavalos graficos", "OpenGL", true);

        Carro carro1 = new Carro(2023, motorDeCarroBom, "Chevrolet");

        System.out.println("Caracteristicas do carro: ");
        System.out.println("Ano do carro: " + carro1.getAnoDoCarro());
        System.out.println("Marca do carro: " + carro1.getMarcaDoCarro());
        System.out.println("Ano do motor: " + carro1.getAnoDoMotor());
        System.out.println("Marca do motor: " + carro1.getMarcaDoMotor());
        System.out.println("Cavalaria do motor: " + carro1.getCavalariaDoMotor());

        System.out.println("\nFunções do carro: ");
        carro1.acelerarCarro();
        carro1.desligarCarro();
        carro1.pararCarro();
        carro1.ligarCarro();
        carro1.pararCarro();
        carro1.acelerarCarro();
        carro1.desligarCarro();
        carro1.pararCarro();
        carro1.ligarCarro();
        carro1.desligarCarro();

    }
}
