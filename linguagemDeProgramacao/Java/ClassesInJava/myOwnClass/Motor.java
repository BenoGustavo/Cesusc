import java.time.LocalDate;

public class Motor {
    private int anoDoMotor;
    private String cavalariaDoMotor;
    private String marcaDoMotor;
    private boolean isMotorTurbo;

    Motor(int anoDoMotor, String cavalariaDoMotor, String marcaDoMotor, boolean isMotorTurbo) {
        this.anoDoMotor = anoDoMotor;
        this.cavalariaDoMotor = cavalariaDoMotor;
        this.marcaDoMotor = marcaDoMotor;
        this.isMotorTurbo = isMotorTurbo;
    }

    Motor() {
        LocalDate dataAtual = LocalDate.now();

        this.anoDoMotor = dataAtual.getYear();
        this.cavalariaDoMotor = "Nenhuma cavalaria foi setada";
        this.marcaDoMotor = "Nenhuma marca foi setada";
        this.isMotorTurbo = false;
    }

    public int getAnoDoMotor() {
        return this.anoDoMotor;
    }

    public String getMarcaDoMotor() {
        return this.marcaDoMotor;
    }

    public String getCavalariaDoMotor() {
        return this.cavalariaDoMotor;
    }

    public boolean getIsMotorTurbo() {
        return this.isMotorTurbo;
    }

    public void setAnoDoMotor(int anoDoMotor) {
        this.anoDoMotor = anoDoMotor;
    }

    public void setMarcaDoMotor(String marcaDoMotor) {
        if (this.marcaDoMotor.equals("Nenhuma marca foi setada")) {
            this.marcaDoMotor = marcaDoMotor;
        }
        throw new IllegalArgumentException("A marca do motor não pode ser alterada");
    }

    public void setCavalariaDoMotor(String cavalariaDoMotor) {
        this.cavalariaDoMotor = cavalariaDoMotor;
    }

    public void turbinarMotor() {
        if (this.isMotorTurbo == false) {
            this.isMotorTurbo = true;
        } else {
            System.out.println("O motor já está turbinado");
        }
    }

    public void desturbinarMotor() {
        if (this.isMotorTurbo == true) {
            this.isMotorTurbo = false;
        } else {
            System.out.println("O motor não tem turbo");
        }
    }

}
