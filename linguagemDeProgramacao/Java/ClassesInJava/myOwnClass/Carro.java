import java.time.LocalDate;

public class Carro {
    private int anoDoCarro;
    private Motor motorDoCarro;
    private String marcaDoCarro;
    private Boolean isCarroLigado;
    private boolean isCarroAcelerando;

    Carro(int anoDoCarro, Motor motorDoCarro, String marcaDoCarro) {
        this.anoDoCarro = anoDoCarro;
        this.motorDoCarro = motorDoCarro;
        this.marcaDoCarro = marcaDoCarro;
        this.isCarroLigado = false;
        this.isCarroAcelerando = false;
    }

    Carro() {
        LocalDate dataAtual = LocalDate.now();

        this.anoDoCarro = dataAtual.getYear();
        this.marcaDoCarro = "Nenhuma marca foi setada";
        this.motorDoCarro = new Motor();
        this.isCarroLigado = false;
        this.isCarroAcelerando = false;
    }

    public void ligarCarro() {
        if (this.isCarroLigado == false) {
            System.out.println("*Sons de motor* // O carro está ligado");
            this.isCarroLigado = true;
        } else {
            System.out.println("O carro já esta ligado...");
        }
    }

    public void desligarCarro() {
        if (this.isCarroLigado && this.isCarroAcelerando == false) {
            System.out.println("Desligando o carro...");
            this.isCarroLigado = false;
        } else if (this.isCarroAcelerando && this.isCarroLigado) {
            System.out.println("O carro não pode ser desligado enquanto estiver acelerando");
        } else if (this.isCarroLigado == false) {
            System.out.println("O carro já está desligado");
        }
    }

    public void acelerarCarro() {
        if (this.isCarroAcelerando == false && this.isCarroLigado) {
            System.out.println("Vruuuuuuum! ");
            this.isCarroAcelerando = true;
        }

        if (this.isCarroAcelerando == true) {
            System.out.println("O carro já está acelerando");
        }

        if (this.isCarroLigado == false) {
            System.out.println("Ligue o carro primeiro...");
        }
    }

    public void pararCarro() {
        if (this.isCarroAcelerando == true) {
            System.out.println("Carro está parando...");
            this.isCarroAcelerando = false;
        } else if (this.isCarroAcelerando == false && this.isCarroLigado == false) {
            System.out.println("O carro já está desligado e por isso se encontra parado");
        } else {
            System.out.println("O carro já esta parado");
        }
    }

    public int getAnoDoMotor() {
        return motorDoCarro.getAnoDoMotor();
    }

    public String getMarcaDoMotor() {
        return motorDoCarro.getMarcaDoMotor();
    }

    public String getCavalariaDoMotor() {
        return motorDoCarro.getCavalariaDoMotor();
    }

    public String getMarcaDoCarro() {
        return this.marcaDoCarro;
    }

    public String getAnoDoCarro() {
        return Integer.toString(this.anoDoCarro);
    }

    public void setAnoDoCarro(int anoDoCarro) {
        this.anoDoCarro = anoDoCarro;
    }

    public void setMarcaDoCarro(String marcaDoCarro) {
        this.marcaDoCarro = marcaDoCarro;
    }

    public void setMotorDoCarro(Motor motorDoCarro) {
        this.motorDoCarro = motorDoCarro;
    }
}
